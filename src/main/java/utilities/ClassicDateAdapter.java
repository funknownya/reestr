package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClassicDateAdapter extends XmlAdapter<String, LocalDate>
{
    private static Logger logger = LogManager.getLogger(ClassicDateAdapter.class.getName());

    // 2014-11-19
    private static DateTimeFormatter classicDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String marshal(LocalDate v) throws Exception
    {
        return v.format(classicDateFormatter);
    }

    @Override
    public LocalDate unmarshal(String v) throws Exception
    {
        return LocalDate.parse(v, classicDateFormatter);
    }
}