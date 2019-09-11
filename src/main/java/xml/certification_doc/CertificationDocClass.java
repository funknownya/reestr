package xml.certification_doc;

import utilities.ClassicDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;


@XmlRootElement(name = "CertificationDoc")
public class CertificationDocClass
{
    private String organization;
    private LocalDate date;
    private String number;


    public CertificationDocClass() {
    }


    @XmlElement(name="Organization", namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/certification-doc/1.0")
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @XmlJavaTypeAdapter(value = ClassicDateAdapter.class)
    @XmlElement(name="Date", required = true, namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/certification-doc/1.0")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @XmlElement(name="Number", namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/certification-doc/1.0")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }




}
