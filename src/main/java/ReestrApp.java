
import javafx.application.Application;
import javafx.stage.Stage;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xml.KvokClass;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.Charset;

public class ReestrApp extends Application
{

    private static Logger logger = LogManager.getLogger(ReestrApp.class.getName());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

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

    }


    public String inputStreamToString(InputStream is) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
