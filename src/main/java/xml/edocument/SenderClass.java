package xml.edocument;

import utilities.ClassicDateAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name="Sender")
public class SenderClass
{
    private String kod;
    private String name;
    private String region;
    private LocalDate dateUpload;
    private String appointment;

    public SenderClass() {
    }


    @XmlAttribute(name = "Kod")
    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    @XmlAttribute(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "Region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @XmlJavaTypeAdapter(value = ClassicDateAdapter.class)
    @XmlAttribute(name = "Date_Upload", required = true)
    public LocalDate getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(LocalDate dateUpload) {
        this.dateUpload = dateUpload;
    }

    @XmlAttribute(name = "Appointment")
    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }
}
