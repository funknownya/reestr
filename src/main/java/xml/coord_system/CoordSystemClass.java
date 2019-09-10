package xml.coord_system;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CoordSystem")
public class CoordSystemClass
{
    private String name;
    private String csId;

    public CoordSystemClass() {
    }

    @XmlAttribute(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "CsId")
    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId;
    }
}
