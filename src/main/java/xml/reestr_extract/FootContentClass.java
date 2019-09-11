package xml.reestr_extract;

import utilities.ExtractDateAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name="FootContent")
public class FootContentClass {

    private String recipient;
    private LocalDate extractDate;
    private String content;

    public FootContentClass() {
    }


    @XmlElement(name = "Recipient")
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @XmlJavaTypeAdapter(value = ExtractDateAdapter.class)
    @XmlElement(name = "ExtractDate", required = true)
    public LocalDate getExtractDate() {
        return extractDate;
    }

    public void setExtractDate(LocalDate extractDate) {
        this.extractDate = extractDate;
    }

    @XmlElement(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
