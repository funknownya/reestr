package xml;


import xml.construction.ConstructionClass;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Realty")
@XmlType(propOrder={"constructionClass"})
public class RealtyClass
{

    private ConstructionClass constructionClass;


    public RealtyClass() {
    }


    @XmlElement(name = "Construction")
    public ConstructionClass getConstructionClass() {
        return constructionClass;
    }

    public void setConstructionClass(ConstructionClass constructionClass) {
        this.constructionClass = constructionClass;
    }



}
