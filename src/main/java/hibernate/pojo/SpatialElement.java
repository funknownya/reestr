package hibernate.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "SPATIAL_ELEMENT", schema = "public", catalog = "realty")
public class SpatialElement
{
    @Id
    @SequenceGenerator(name = "spatial_element_id_generator", sequenceName = "spatial_element_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spatial_element_id_generator")
    @Column(name = "SPATIAL_ELEMENT_ID", nullable = false)
    private Integer spatialElementId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENTITY_SPATIAL_ID", referencedColumnName = "ENTITY_SPATIAL_ID", nullable=false)
    private EntitySpatial entitySpatialId;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "spatialElementId")
    private List<SpelementUnit> spelementUnitList = new ArrayList<SpelementUnit>();


    public SpatialElement() {
    }

    public Integer getSpatialElementId() {
        return spatialElementId;
    }

    public void setSpatialElementId(Integer spatialElementId) {
        this.spatialElementId = spatialElementId;
    }

    public EntitySpatial getEntitySpatialId() {
        return entitySpatialId;
    }

    public void setEntitySpatialId(EntitySpatial entitySpatialId) {
        this.entitySpatialId = entitySpatialId;
    }
}
