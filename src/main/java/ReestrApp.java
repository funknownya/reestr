

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
import xml.certification_doc.CertificationDocClass;
import xml.construction.ConstructionClass;
import xml.construction.ExploitationCharClass;
import xml.construction.KeyParameterClass;
import xml.edocument.EDocumentClass;
import xml.edocument.RecipientClass;
import xml.edocument.SenderClass;
import xml.entity_spatial.EntitySpatialClass;
import xml.entity_spatial.OrdinateClass;
import xml.entity_spatial.SpelementUnitClass;
import xml.reestr_extract.*;


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
                ExploitationCharClass exploitationCharClass = constructionClass.getExploitationCharClass();
                String yearBuilt = exploitationCharClass.getYearBuilt();
                AddressClass addressClass = constructionClass.getAddressClass();
                String addressOkato = addressClass.getOkato();
                String addressKladr = addressClass.getKladr();
                String addressRegion = addressClass.getRegion();
                String addressNote = addressClass.getNote();
                CityClass cityClass = addressClass.getCityClass();
                String cityName = cityClass.getName();
                String cityType = cityClass.getType();
                String objectType = constructionClass.getObjectType();
                String name = constructionClass.getName();
                String assignationName = constructionClass.getAssignationName();
                EntitySpatialClass entitySpatialClass = constructionClass.getEntitySpatialClass();
                List<String> cadastralBlockList = constructionClass.getCadastralBlockList();
                List<KeyParameterClass> keyParameterClassList = constructionClass.getKeyParameterClassList();

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

                // insert KeyParameterClass
                for(KeyParameterClass keyParameterClass : keyParameterClassList)
                {
                    String type = keyParameterClass.getType();
                    Integer value = keyParameterClass.getValue();

                    KeyParameter keyParameterObject = new KeyParameter();
                    keyParameterObject.setType(type);
                    keyParameterObject.setValue(value);
                    keyParameterObject.setConstructionId(constructionObject);
                    IKeyParameterService keyParameterService = new KeyParameterService();
                    keyParameterService.insertKeyParameter(keyParameterObject);
                }


                CertificationDocClass certificationDocClass = kvokClassObject.getCertificationDocClass();
                String certificationDocOrganization = certificationDocClass.getOrganization();
                LocalDate certificationDocDate = certificationDocClass.getDate();
                String certificationDocNumber = certificationDocClass.getNumber();

                // insert CertificationDoc
                CertificationDoc certificationDocObject = new CertificationDoc();
                certificationDocObject.setOrganization(certificationDocOrganization);
                certificationDocObject.setDate(certificationDocDate);
                certificationDocObject.setNumber(certificationDocNumber);
                ICertificationDocService certificationDocService = new CertificationDocService();
                certificationDocService.insertCertificationDoc(certificationDocObject);


                EDocumentClass eDocumentClass = kvokClassObject.getEdocumentClass();
                String edocumentCodeType = eDocumentClass.getCodeType();
                String edocumentVersion = eDocumentClass.getVersion();
                String edocumentScope = eDocumentClass.getScope();
                SenderClass senderClass = eDocumentClass.getSenderClass();
                String senderKod = senderClass.getKod();
                String senderName = senderClass.getName();
                String senderRegion = senderClass.getRegion();
                LocalDate senderDateUpload = senderClass.getDateUpload();
                String senderAppointment = senderClass.getAppointment();
                RecipientClass recipientClass = eDocumentClass.getRecipientClass();
                String recipientKod = recipientClass.getKod();
                String recipientName = recipientClass.getName();

                // insert Sender
                Sender senderObject = new Sender();
                senderObject.setKod(senderKod);
                senderObject.setName(senderName);
                senderObject.setRegion(senderRegion);
                senderObject.setDateUpload(senderDateUpload);
                senderObject.setAppointment(senderAppointment);
                ISenderService senderService = new SenderService();
                senderService.insertSender(senderObject);

                // insert Recipient
                Recipient recipientObject = new Recipient();
                recipientObject.setKod(recipientKod);
                recipientObject.setName(recipientName);
                IRecipientService recipientService = new RecipientService();
                recipientService.insertRecipient(recipientObject);

                // insert EDocument
                EDocument edocumentObject = new EDocument();
                edocumentObject.setCodeType(edocumentCodeType);
                edocumentObject.setVersion(edocumentVersion);
                edocumentObject.setScope(edocumentScope);
                edocumentObject.setSenderId(senderObject);
                edocumentObject.setRecipientId(recipientObject);
                IEDocumentService edocumentService = new EDocumentService();
                edocumentService.insertEDocument(edocumentObject);


                ReestrExtractClass reestrExtractClass = kvokClassObject.getReestrExtractClass();
                DeclarAttributeClass declarAttributeClass = reestrExtractClass.getDeclarAttributeClass();
                Integer idKuvi = declarAttributeClass.getIdKuvi();
                String extractTypeCode = declarAttributeClass.getExtractTypeCode();
                String extractTypeText = declarAttributeClass.getExtractTypeText();
                String extractNumber = declarAttributeClass.getExtractNumber();
                LocalDate extractDate = declarAttributeClass.getExtractDate();
                String requeryNumber = declarAttributeClass.getRequeryNumber();
                LocalDate requeryDate = declarAttributeClass.getRequeryDate();
                Integer extractCount = declarAttributeClass.getExtractCount();
                Integer noticeCount = declarAttributeClass.getNoticeCount();
                Integer refuseCount = declarAttributeClass.getRefuseCount();
                String registrator = declarAttributeClass.getRegistrator();
                String receivName = declarAttributeClass.getReceivName();
                String receivAddress = declarAttributeClass.getReceivAdress();

                // insert DeclarAttribute
                DeclarAttribute declarAttributeObject = new DeclarAttribute();
                declarAttributeObject.setIdKuvi(idKuvi);
                declarAttributeObject.setExtractTypeCode(extractTypeCode);
                declarAttributeObject.setExtractTypeText(extractTypeText);
                declarAttributeObject.setExtractNumber(extractNumber);
                declarAttributeObject.setExtractDate(extractDate);
                declarAttributeObject.setRequeryNumber(requeryNumber);
                declarAttributeObject.setRequeryDate(requeryDate);
                declarAttributeObject.setExtractCount(extractCount);
                declarAttributeObject.setNoticeCount(noticeCount);
                declarAttributeObject.setRefuseCount(refuseCount);
                declarAttributeObject.setRegistrator(registrator);
                declarAttributeObject.setReceivName(receivName);
                declarAttributeObject.setReceivAddress(receivAddress);
                IDeclarAttributeService declarAttributeService = new DeclarAttributeService();
                declarAttributeService.insertDeclarAttribute(declarAttributeObject);


                ExtractObjectRightClass extractObjectRightClass = reestrExtractClass.getExtractObjectRightClass();
                String infoEnk = extractObjectRightClass.getInfoEnk();
                String infoPik = extractObjectRightClass.getInfoPik();
                HeadContentClass headContentClass = extractObjectRightClass.getHeadContentClass();
                Integer headIdRecKuvi = headContentClass.getIdRecKuvi();
                String headTitle = headContentClass.getTitle();
                String headDeptName = headContentClass.getDeptName();
                String headExtractTitle = headContentClass.getExtractTitle();
                String headContent = headContentClass.getContent();
                FootContentClass footContentClass = extractObjectRightClass.getFootContentClass();
                String footRecipient = footContentClass.getRecipient();
                LocalDate footExtractDate = footContentClass.getExtractDate();
                String footContent = footContentClass.getContent();

                // insert HeadContent
                HeadContent headContentObject = new HeadContent();
                headContentObject.setIdRecKuvi(headIdRecKuvi);
                headContentObject.setTitle(headTitle);
                headContentObject.setDeptName(headDeptName);
                headContentObject.setExtractTitle(headExtractTitle);
                headContentObject.setContent(headContent);
                IHeadContentService headContentService = new HeadContentService();
                headContentService.insertHeadContent(headContentObject);

                // insert FootContent
                FootContent footContentObject = new FootContent();
                footContentObject.setRecipient(footRecipient);
                footContentObject.setExtractDate(footExtractDate);
                footContentObject.setContent(headContent);
                IFootContentService footContentService = new FootContentService();
                footContentService.insertFootContent(footContentObject);

                // insert FootContent
                ExtractObjectRight extractObjectRightObject = new ExtractObjectRight();
                extractObjectRightObject.setInfoEnk(infoEnk);
                extractObjectRightObject.setInfoPik(infoPik);
                extractObjectRightObject.setHeadContentId(headContentObject);
                extractObjectRightObject.setFootContentId(footContentObject);
                IExtractObjectRightService extractObjectRightService = new ExtractObjectRightService();
                extractObjectRightService.insertExtractObjectRight(extractObjectRightObject);


                // insert ReestrExtract
                ReestrExtract reestrExtractObject = new ReestrExtract();
                reestrExtractObject.setDeclarAttributeId(declarAttributeObject);
                reestrExtractObject.setExtractObjectRightId(extractObjectRightObject);
                IReestrExtractService reestrExtractService = new ReestrExtractService();
                reestrExtractService.insertReestrExtract(reestrExtractObject);


                Kvoks kvokObject = new Kvoks();
                kvokObject.setConstructionId(constructionObject);
                kvokObject.setEdocumentId(edocumentObject);
                kvokObject.setCertificationDocId(certificationDocObject);
                kvokObject.setReestrExtractId(reestrExtractObject);
                IKvoksService kvoksService = new KvoksService();
                kvoksService.insertKvok(kvokObject);
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
