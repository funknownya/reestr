package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Address")
public class AddressClass
{
    private String okato;
    private String kladr;
    private String region;
    private CityClass cityClass;
    private String note;


    public AddressClass() {
    }

    @XmlElement(name="OKATO", namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1")
    public String getOkato() {
        return okato;
    }

    public void setOkato(String okato) {
        this.okato = okato;
    }

    @XmlElement(name="KLADR", namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1")
    public String getKladr() {
        return kladr;
    }

    public void setKladr(String kladr) {
        this.kladr = kladr;
    }

    @XmlElement(name="Region", namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @XmlElement(name="City", namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1")
    public CityClass getCityClass() {
        return cityClass;
    }

    public void setCityClass(CityClass cityClass) {
        this.cityClass = cityClass;
    }

    @XmlElement(name="Note", namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
