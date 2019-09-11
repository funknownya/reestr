package hibernate.pojo;

import javax.persistence.*;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "KEYPARAMETER", schema = "public", catalog = "realty")
public class KeyParameter
{
    @Id
    @SequenceGenerator(name = "keyParameter_id_generator", sequenceName = "keyParameter_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "keyParameter_id_generator")
    @Column(name = "KEYPARAMETER_ID", nullable=false)
    private Integer keyParameterId;


    @Column(name = "TYPE", nullable=false)
    private String type;

    @Column(name = "VALUE", nullable=false)
    private Integer value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONSTRUCTION_ID", referencedColumnName = "CONSTRUCTION_ID", nullable=false)
    private Construction constructionId;




    public KeyParameter() {
    }

    public Integer getKeyParameterId() {
        return keyParameterId;
    }

    public void setKeyParameterId(Integer keyParameterId) {
        this.keyParameterId = keyParameterId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Construction getConstructionId() {
        return constructionId;
    }

    public void setConstructionId(Construction constructionId) {
        this.constructionId = constructionId;
    }
}
