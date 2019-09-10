package xml.entity_spatial;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SpelementUnit")
public class SpelementUnitClass
{
    private String typeUnit;
    private Integer suNmb;
    private OrdinateClass ordinateClass;

    public SpelementUnitClass() {
    }

    @XmlAttribute(name = "TypeUnit")
    public String getTypeUnit() {
        return typeUnit;
    }

    public void setTypeUnit(String typeUnit) {
        this.typeUnit = typeUnit;
    }

    @XmlAttribute(name = "SuNmb")
    public Integer getSuNmb() {
        return suNmb;
    }

    public void setSuNmb(Integer suNmb) {
        this.suNmb = suNmb;
    }

    @XmlElement(name = "Ordinate", namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1")
    public OrdinateClass getOrdinateClass() {
        return ordinateClass;
    }

    public void setOrdinateClass(OrdinateClass ordinateClass) {
        this.ordinateClass = ordinateClass;
    }
}
