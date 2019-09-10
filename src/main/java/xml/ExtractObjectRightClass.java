package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ExtractObjectRight")
public class ExtractObjectRightClass
{

    private HeadContentClass headContentClass;
    private String infoEnk;
    private String infoPik;

    private FootContentClass footContentClass;

    public ExtractObjectRightClass() {
    }


    @XmlElement(name = "HeadContent")
    public HeadContentClass getHeadContentClass() {
        return headContentClass;
    }

    public void setHeadContentClass(HeadContentClass headContentClass) {
        this.headContentClass = headContentClass;
    }

    @XmlElement(name = "InfoENK")
    public String getInfoEnk() {
        return infoEnk;
    }

    public void setInfoEnk(String infoEnk) {
        this.infoEnk = infoEnk;
    }
    

    @XmlElement(name = "InfoPIK")
    public String getInfoPik() {
        return infoPik;
    }

    public void setInfoPik(String infoPik) {
        this.infoPik = infoPik;
    }

    @XmlElement(name = "FootContent")
    public FootContentClass getFootContentClass() {
        return footContentClass;
    }

    public void setFootContentClass(FootContentClass footContentClass) {
        this.footContentClass = footContentClass;
    }
}
