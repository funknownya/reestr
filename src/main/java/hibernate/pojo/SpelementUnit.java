package hibernate.pojo;

import javax.persistence.*;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "SPELEMENT_UNIT", schema = "public", catalog = "realty")
public class SpelementUnit
{
    @Id
    @SequenceGenerator(name = "spelement_unit_id_generator", sequenceName = "spelement_unit_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spelement_unit_id_generator")
    @Column(name = "SPELEMENT_UNIT_ID", nullable = false)
    private Integer spelementUnitId;

    @Column(name = "TYPEUNIT", nullable = false)
    private String typeUnit;

    @Column(name = "SUNUMB", nullable = false)
    private Integer subNumb;

    @Column(name = "ORDNUMB", nullable = false)
    private Integer ordNumb;

    @Column(name = "X", nullable = false)
    private Double x;

    @Column(name = "Y", nullable = false)
    private Double y;

    @Column(name = "DELTAGEOPOINT", nullable = false)
    private Double deltaGeoPoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SPATIAL_ELEMENT_ID", referencedColumnName = "SPATIAL_ELEMENT_ID", nullable=false)
    private SpatialElement spatialElementId;

    public SpelementUnit() {
    }

    public Integer getSpelementUnitId() {
        return spelementUnitId;
    }

    public void setSpelementUnitId(Integer spelementUnitId) {
        this.spelementUnitId = spelementUnitId;
    }

    public String getTypeUnit() {
        return typeUnit;
    }

    public void setTypeUnit(String typeUnit) {
        this.typeUnit = typeUnit;
    }

    public Integer getSubNumb() {
        return subNumb;
    }

    public void setSubNumb(Integer subNumb) {
        this.subNumb = subNumb;
    }

    public Integer getOrdNumb() {
        return ordNumb;
    }

    public void setOrdNumb(Integer ordNumb) {
        this.ordNumb = ordNumb;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getDeltaGeoPoint() {
        return deltaGeoPoint;
    }

    public void setDeltaGeoPoint(Double deltaGeoPoint) {
        this.deltaGeoPoint = deltaGeoPoint;
    }

    public SpatialElement getSpatialElementId() {
        return spatialElementId;
    }

    public void setSpatialElementId(SpatialElement spatialElementId) {
        this.spatialElementId = spatialElementId;
    }
}
