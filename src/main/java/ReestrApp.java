

import hibernate.initialize.DatabaseConnectionTask;
import hibernate.initialize.DatabaseExecutorStorage;
import hibernate.pojo.*;
import hibernate.service.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xml.KvokClass;
import xml.address.AddressClass;
import xml.address.CityClass;
import xml.construction.ConstructionClass;
import xml.construction.ExploitationCharClass;
import xml.construction.KeyParameterClass;
import xml.entity_spatial.EntitySpatialClass;
import xml.entity_spatial.OrdinateClass;
import xml.entity_spatial.SpelementUnitClass;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class ReestrApp extends Application
{

    private static Logger logger = LogManager.getLogger(ReestrApp.class.getName());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

        // Инициализируем базу данных
        Boolean isSuccessConnect = Boolean.FALSE;
        try
        {
            DatabaseConnectionTask databaseConnectionTask = new DatabaseConnectionTask();
            Future<Boolean> databaseConnectionFutureResult = DatabaseExecutorStorage.getInstance().getExecutor().submit(databaseConnectionTask);
            isSuccessConnect = databaseConnectionFutureResult.get();
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        logger.info("Receive isSuccessConnect: " + isSuccessConnect);
        if(isSuccessConnect.equals(Boolean.FALSE))
        {
            logger.info("Receive isSuccessConnect is FALSE");
            return;
        }


        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(KvokClass.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            InputStream inputStream = new FileInputStream("2.xml");
            //String xmlString = inputStreamToString(inputStream);
            //xmlString = xmlString.replaceAll("[^\\x20-\\x7e]", "");
            //logger.info("xmlString: " + xmlString);
            //StringReader reader = new StringReader(xmlString);
            //logger.info("reader: " + reader);
            //StringReader stringReader = new StringReader(xmlString);
            //logger.info("stringReader: " + stringReader);
            KvokClass kvokClassObject = (KvokClass) unmarshaller.unmarshal(inputStream);
            logger.info("getCadastralNumber: " + kvokClassObject.getReestrExtractClass().getExtractObjectRightClass().getFootContentClass().getExtractDate());

            if(kvokClassObject != null)
            {
                // insert EntitySpatial
                ConstructionClass constructionClass = kvokClassObject.getRealtyClass().getConstructionClass();
                String cadastralNumber = constructionClass.getCadastralNumber();
                String state = constructionClass.getState();
                LocalDate dateCreated = constructionClass.getDateCreated();
                String yearBuilt = constructionClass.getExploitationCharClass().getYearBuilt();
                String addressOkato = constructionClass.getAddressClass().getOkato();
                String addressKladr = constructionClass.getAddressClass().getKladr();
                String addressRegion = constructionClass.getAddressClass().getRegion();
                String addressNote = constructionClass.getAddressClass().getNote();
                CityClass cityClass = constructionClass.getAddressClass().getCityClass();
                String cityName = cityClass.getName();
                String cityType = cityClass.getType();
                List<String> cadastralBlockList = constructionClass.getCadastralBlockList();
                String objectType = constructionClass.getObjectType();
                String name = constructionClass.getName();
                String assignationName = constructionClass.getAssignationName();
                ExploitationCharClass exploitationCharClass= constructionClass.getExploitationCharClass();
                List<KeyParameterClass> keyParameterClassList = constructionClass.getKeyParameterClassList();
                AddressClass addressClass = constructionClass.getAddressClass();
                EntitySpatialClass entitySpatialClass = constructionClass.getEntitySpatialClass();

                String entSys = entitySpatialClass.getEntSys();
                List<SpelementUnitClass> spelementUnitClassList = entitySpatialClass.getSpelementUnitClassList();

                EntitySpatial entitySpatialObject = new EntitySpatial();
                entitySpatialObject.setEntSys(entSys);

                IEntitySpatialService entitySpatialService = new EntitySpatialService();
                entitySpatialService.insertEntitySpatial(entitySpatialObject);

                // insert SpatialElement
                SpatialElement spatialElementObject = new SpatialElement();
                spatialElementObject.setEntitySpatialId(entitySpatialObject);
                ISpatialElementService spatialElementService = new SpatialElementService();
                spatialElementService.insertSpatialElement(spatialElementObject);

                for(SpelementUnitClass spelementUnitClass : spelementUnitClassList)
                {
                    String typeUnit = spelementUnitClass.getTypeUnit();
                    Integer suNmb = spelementUnitClass.getSuNmb();
                    Double x = spelementUnitClass.getOrdinateClass().getX();
                    Double y = spelementUnitClass.getOrdinateClass().getY();
                    Integer ordNumb = spelementUnitClass.getOrdinateClass().getOrdNumb();
                    Double deltaGeopoint = spelementUnitClass.getOrdinateClass().getDeltaGeopoint();

                    SpelementUnit spelementUnitObject = new SpelementUnit();
                    spelementUnitObject.setTypeUnit(typeUnit);
                    spelementUnitObject.setSubNumb(suNmb);
                    spelementUnitObject.setX(x);
                    spelementUnitObject.setY(y);
                    spelementUnitObject.setOrdNumb(ordNumb);
                    spelementUnitObject.setDeltaGeoPoint(deltaGeopoint);
                    spelementUnitObject.setSpatialElementId(spatialElementObject);

                    ISpelementUnitService spelementUnitService = new SpelementUnitService();
                    spelementUnitService.insertSpelementUnit(spelementUnitObject);
                }

                // insert City
                City cityObject = new City();
                cityObject.setName(cityName);
                cityObject.setType(cityType);
                ICityService cityService = new CityService();
                cityService.insertCity(cityObject);

                // insert Construction
                Construction constructionObject = new Construction();
                constructionObject.setCadastralNumber(cadastralNumber);
                constructionObject.setState(state);
                constructionObject.setDateCreated(dateCreated);
                constructionObject.setObjectType(objectType);
                constructionObject.setName(name);
                constructionObject.setAssignationName(assignationName);
                constructionObject.setYearBuilt(yearBuilt);
                constructionObject.setAddressOkato(addressOkato);
                constructionObject.setAddressKladr(addressKladr);
                constructionObject.setAddressRegion(addressRegion);
                constructionObject.setAddressNote(addressNote);
                constructionObject.setCityId(cityObject);
                constructionObject.setEntitySpatialId(entitySpatialObject);
                IConstructionService constructionService = new ConstructionService();
                constructionService.insertConstruction(constructionObject);

                // insert CadastralBlock
                for(String cadastralBlock : cadastralBlockList)
                {
                    CadastralBlock cadastralBlockObject = new CadastralBlock();
                    cadastralBlockObject.setCadastralBlock(cadastralBlock);
                    cadastralBlockObject.setConstructionId(constructionObject);
                    ICadastralBlockService cadastralBlockService = new CadastralBlockService();
                    cadastralBlockService.insertCadastralBlock(cadastralBlockObject);
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());
        }


        try
        {
            AnchorPane mainAnchorPane = new AnchorPane();


            AnchorPane.setBottomAnchor(mainAnchorPane, 0.0);
            AnchorPane.setTopAnchor(mainAnchorPane, 0.0);
            AnchorPane.setLeftAnchor(mainAnchorPane, 0.0);
            AnchorPane.setRightAnchor(mainAnchorPane, 0.0);


            // размеры экрана
            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            Scene scene = new Scene(mainAnchorPane,
                    primaryScreenBounds.getWidth(),
                    primaryScreenBounds.getHeight());
            primaryStage.setTitle("Reestr");
            primaryStage.setScene(scene);


        }
        catch (Exception e)
        {
            logger.info("Cant load main_view.fxml");
            logger.error(e.getMessage());
        }

    }


}
