package hibernate.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "REESTR_EXTRACT", schema = "public", catalog = "realty")
public class ReestrExtract
{
    @Id
    @SequenceGenerator(name = "reestr_extract_id_generator", sequenceName = "reestr_extract_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reestr_extract_id_generator")
    @Column(name = "REESTR_EXTRACT_ID", nullable=false)
    private Integer reestrExtractId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DECLAR_ATTRIBUTE_ID", referencedColumnName = "DECLAR_ATTRIBUTE_ID", nullable=false)
    private DeclarAttribute declarAttributeId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXTRACT_OBJECT_RIGHT_ID", referencedColumnName = "EXTRACT_OBJECT_RIGHT_ID", nullable=false)
    private ExtractObjectRight extractObjectRightId;


    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "reestrExtractId")
    private List<Kvoks> kvokList = new ArrayList<Kvoks>();

    public ReestrExtract() {
    }

    public Integer getReestrExtractId() {
        return reestrExtractId;
    }

    public void setReestrExtractId(Integer reestrExtractId) {
        this.reestrExtractId = reestrExtractId;
    }

    public DeclarAttribute getDeclarAttributeId() {
        return declarAttributeId;
    }

    public void setDeclarAttributeId(DeclarAttribute declarAttributeId) {
        this.declarAttributeId = declarAttributeId;
    }

    public ExtractObjectRight getExtractObjectRightId() {
        return extractObjectRightId;
    }

    public void setExtractObjectRightId(ExtractObjectRight extractObjectRightId) {
        this.extractObjectRightId = extractObjectRightId;
    }
}
