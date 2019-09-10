package xml.construction;

import xml.address.AddressClass;
import xml.entity_spatial.EntitySpatialClass;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Construction")
@XmlType(propOrder={"cadastralBlockList",
        "objectType",
        "name",
        "assignationName",
        "exploitationCharClass",
        "keyParameterClassList",
        "addressClass",
        "entitySpatialClass"})
public class ConstructionClass
{
    private String cadastralNumber;
    private String state;
    private String dateCreated;

    private List<String> cadastralBlockList = new ArrayList<String>();
    private String objectType;
    private String name;
    private String assignationName;
    private ExploitationCharClass exploitationCharClass;
    private List<KeyParameterClass> keyParameterClassList = new ArrayList<KeyParameterClass>();
    private AddressClass addressClass;
    private EntitySpatialClass entitySpatialClass;



    public ConstructionClass() {
    }

    @XmlAttribute(name = "CadastralNumber")
    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }

    @XmlAttribute(name = "State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @XmlAttribute(name = "DateCreated")
    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @XmlElementWrapper(name = "CadastralBlocks")
    @XmlElement(name = "CadastralBlock")
    public List<String> getCadastralBlockList() {
        return cadastralBlockList;
    }

    public void setCadastralBlockList(List<String> cadastralBlockList) {
        this.cadastralBlockList = cadastralBlockList;
    }


    public String getObjectType() {
        return objectType;
    }

    @XmlElement(name = "ObjectType")
    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    @XmlElement(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "AssignationName")
    public String getAssignationName() {
        return assignationName;
    }

    public void setAssignationName(String assignationName) {
        this.assignationName = assignationName;
    }

    @XmlElement(name = "ExploitationChar")
    public ExploitationCharClass getExploitationCharClass() {
        return exploitationCharClass;
    }

    public void setExploitationCharClass(ExploitationCharClass exploitationCharClass) {
        this.exploitationCharClass = exploitationCharClass;
    }

    @XmlElementWrapper(name = "KeyParameters")
    @XmlElement(name="KeyParameter", namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/parameters-oks/2.0.1")
    public List<KeyParameterClass> getKeyParameterClassList() {
        return keyParameterClassList;
    }

    public void setKeyParameterClassList(List<KeyParameterClass> keyParameterClassList) {
        keyParameterClassList = keyParameterClassList;
    }

    @XmlElement(name = "Address")
    public AddressClass getAddressClass() {
        return addressClass;
    }

    public void setAddressClass(AddressClass addressClass) {
        this.addressClass = addressClass;
    }

    @XmlElement(name = "EntitySpatial")
    public EntitySpatialClass getEntitySpatialClass() {
        return entitySpatialClass;
    }

    public void setEntitySpatialClass(EntitySpatialClass entitySpatialClass) {
        this.entitySpatialClass = entitySpatialClass;
    }


}
