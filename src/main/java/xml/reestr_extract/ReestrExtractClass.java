package xml.reestr_extract;

import xml.reestr_extract.DeclarAttributeClass;
import xml.reestr_extract.ExtractObjectRightClass;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ReestrExtract")
public class ReestrExtractClass
{
    private DeclarAttributeClass declarAttributeClass;
    private ExtractObjectRightClass extractObjectRightClass;



    public ReestrExtractClass() {
    }

    @XmlElement(name="DeclarAttribute")
    public DeclarAttributeClass getDeclarAttributeClass() {
        return declarAttributeClass;
    }

    public void setDeclarAttributeClass(DeclarAttributeClass declarAttributeClass) {
        this.declarAttributeClass = declarAttributeClass;
    }

    @XmlElement(name="ExtractObjectRight")
    public ExtractObjectRightClass getExtractObjectRightClass() {
        return extractObjectRightClass;
    }

    public void setExtractObjectRightClass(ExtractObjectRightClass extractObjectRightClass) {
        this.extractObjectRightClass = extractObjectRightClass;
    }
}
