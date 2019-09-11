package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExtractDateAdapter extends XmlAdapter<String, LocalDate>
{
    private static Logger logger = LogManager.getLogger(ExtractDateAdapter.class.getName());

    // 2014-11-19
    private static DateTimeFormatter extractDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public String marshal(LocalDate v) throws Exception
    {
        return v.format(extractDateFormatter);
    }

    @Override
    public LocalDate unmarshal(String v) throws Exception
    {
        return LocalDate.parse(v, extractDateFormatter);
    }
}