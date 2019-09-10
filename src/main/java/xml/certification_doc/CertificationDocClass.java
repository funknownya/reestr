package xml.certification_doc;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "CertificationDoc")
public class CertificationDocClass
{
    private String organization;
    private String date;
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

    @XmlElement(name="Date", namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/certification-doc/1.0")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
