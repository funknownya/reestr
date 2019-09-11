package hibernate.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "CITY", schema = "public", catalog = "realty")
public class City
{
    @Id
    @SequenceGenerator(name = "city_id_generator", sequenceName = "city_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_id_generator")
    @Column(name = "CITY_ID", nullable=false)
    private Integer cityId;


    @Column(name = "NAME", nullable=false)
    private String name;

    @Column(name = "TYPE", nullable=false)
    private String type;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "cityId")
    private List<Construction> constructionList = new ArrayList<Construction>();


    public City() {
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
