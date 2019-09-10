package xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Ordinate")
public class OrdinateClass
{
    private Double x;
    private Double y;
    private Integer ordNumb;
    private Double deltaGeopoint;

    public OrdinateClass() {
    }

    @XmlAttribute(name="X")
    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    @XmlAttribute(name="Y")
    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @XmlAttribute(name="OrdNmb")
    public Integer getOrdNumb() {
        return ordNumb;
    }

    public void setOrdNumb(Integer ordNumb) {
        this.ordNumb = ordNumb;
    }

    @XmlAttribute(name="DeltaGeopoint")
    public Double getDeltaGeopoint() {
        return deltaGeopoint;
    }

    public void setDeltaGeopoint(Double deltaGeopoint) {
        this.deltaGeopoint = deltaGeopoint;
    }
}
