package hibernate.pojo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "ENTITY_SPATIAL", schema = "public", catalog = "realty")
public class EntitySpatial
{
    @Id
    @SequenceGenerator(name = "entity_spatial_id_generator", sequenceName = "entity_spatial_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_spatial_id_generator")
    @Column(name = "ENTITY_SPATIAL_ID", nullable=false)
    private Integer entitySpatialId;


    @Column(name = "ENT_SYS", nullable=false)
    private String entSys;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "entitySpatialId")
    private List<SpatialElement> spatialElementList = new ArrayList<SpatialElement>();

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "entitySpatialId")
    private List<Construction> constructionList = new ArrayList<Construction>();

    public EntitySpatial() {
    }

    public Integer getEntitySpatialId() {
        return entitySpatialId;
    }

    public void setEntitySpatialId(Integer entitySpatialId) {
        this.entitySpatialId = entitySpatialId;
    }

    public String getEntSys() {
        return entSys;
    }

    public void setEntSys(String entSys) {
        this.entSys = entSys;
    }
}
