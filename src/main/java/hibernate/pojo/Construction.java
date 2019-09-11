package hibernate.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "CONSTRUCTION", schema = "public", catalog = "realty")
public class Construction
{
    @Id
    @SequenceGenerator(name = "construction_id_generator", sequenceName = "construction_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "construction_id_generator")
    @Column(name = "CONSTRUCTION_ID", nullable=false)
    private Integer constructionId;


    @Column(name = "CADASTRALNUMBER", nullable=false)
    private String cadastralNumber;

    @Column(name = "STATE", nullable=false)
    private String state;

    @Column(name = "DATECREATED", nullable=true)
    private LocalDate dateCreated;

    @Column(name = "OBJECTTYPE", nullable=false)
    private String objectType;

    @Column(name = "NAME", nullable=false)
    private String name;

    @Column(name = "ASSIGNATIONNAME", nullable=false)
    private String assignationName;

    @Column(name = "YEARBUILT", nullable=false)
    private String yearBuilt;

    @Column(name = "ADDRESS_OKATO", nullable=false)
    private String addressOkato;

    @Column(name = "ADDRESS_KLADR", nullable=false)
    private String addressKladr;

    @Column(name = "ADDRESS_REGION", nullable=false)
    private String addressRegion;


    @Column(name = "ADDRESS_NOTE", nullable=false)
    private String addressNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID", nullable=false)
    private City cityId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENTITY_SPATIAL_ID", referencedColumnName = "ENTITY_SPATIAL_ID", nullable=false)
    private EntitySpatial entitySpatialId;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "constructionId")
    private List<CadastralBlock> cadastralBlockList = new ArrayList<CadastralBlock>();

    public Construction() {
    }

    public Integer getConstructionId() {
        return constructionId;
    }

    public void setConstructionId(Integer constructionId) {
        this.constructionId = constructionId;
    }

    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignationName() {
        return assignationName;
    }

    public void setAssignationName(String assignationName) {
        this.assignationName = assignationName;
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getAddressOkato() {
        return addressOkato;
    }

    public void setAddressOkato(String addressOkato) {
        this.addressOkato = addressOkato;
    }

    public String getAddressKladr() {
        return addressKladr;
    }

    public void setAddressKladr(String addressKladr) {
        this.addressKladr = addressKladr;
    }

    public String getAddressRegion() {
        return addressRegion;
    }

    public void setAddressRegion(String addressRegion) {
        this.addressRegion = addressRegion;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public String getAddressNote() {
        return addressNote;
    }

    public void setAddressNote(String addressNote) {
        this.addressNote = addressNote;
    }

    public EntitySpatial getEntitySpatialId() {
        return entitySpatialId;
    }

    public void setEntitySpatialId(EntitySpatial entitySpatialId) {
        this.entitySpatialId = entitySpatialId;
    }
}
