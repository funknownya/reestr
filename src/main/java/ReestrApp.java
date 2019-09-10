
import hibernate.initialize.DatabaseConnectionTask;
import hibernate.initialize.DatabaseExecutorStorage;
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


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.*;
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
            KvokClass kvokClass = (KvokClass) unmarshaller.unmarshal(inputStream);
            logger.info("getCadastralNumber: " + kvokClass.getReestrExtractClass().getExtractObjectRightClass().getFootContentClass().getExtractDate());


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
