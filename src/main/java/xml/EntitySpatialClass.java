package xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="EntitySpatial")
public class EntitySpatialClass
{
    private String entSys;
    private List<SpelementUnitClass> spelementUnitClassList = new ArrayList<SpelementUnitClass>();


    public EntitySpatialClass() {
    }

    @XmlAttribute(name = "EntSys")
    public String getEntSys() {
        return entSys;
    }

    public void setEntSys(String entSys) {
        this.entSys = entSys;
    }

    @XmlElementWrapper(name = "SpatialElement", namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1")
    @XmlElement(name="SpelementUnit", namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1")
    public List<SpelementUnitClass> getSpelementUnitClassList() {
        return spelementUnitClassList;
    }

    public void setSpelementUnitClassList(List<SpelementUnitClass> spelementUnitClassList) {
        this.spelementUnitClassList = spelementUnitClassList;
    }
}
