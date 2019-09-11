package hibernate.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "KVOKS", schema = "public", catalog = "realty")
public class Kvoks
{
    @Id
    @SequenceGenerator(name = "kvok_id_generator", sequenceName = "kvok_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kvok_id_generator")
    @Column(name = "KVOK_ID", nullable=false)
    private Integer kvokId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONSTRUCTION_ID", referencedColumnName = "CONSTRUCTION_ID", nullable=false)
    private Construction constructionId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CERTIFICATIONDOC_ID", referencedColumnName = "CERTIFICATIONDOC_ID", nullable=false)
    private CertificationDoc certificationDocId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDOCUMENT_ID", referencedColumnName = "EDOCUMENT_ID", nullable=false)
    private EDocument edocumentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REESTR_EXTRACT_ID", referencedColumnName = "REESTR_EXTRACT_ID", nullable=false)
    private ReestrExtract reestrExtractId;




    public Kvoks() {
    }

    public Integer getKvokId() {
        return kvokId;
    }

    public void setKvokId(Integer kvokId) {
        this.kvokId = kvokId;
    }

    public Construction getConstructionId() {
        return constructionId;
    }

    public void setConstructionId(Construction constructionId) {
        this.constructionId = constructionId;
    }

    public CertificationDoc getCertificationDocId() {
        return certificationDocId;
    }

    public void setCertificationDocId(CertificationDoc certificationDocId) {
        this.certificationDocId = certificationDocId;
    }

    public EDocument getEdocumentId() {
        return edocumentId;
    }

    public void setEdocumentId(EDocument edocumentId) {
        this.edocumentId = edocumentId;
    }

    public ReestrExtract getReestrExtractId() {
        return reestrExtractId;
    }

    public void setReestrExtractId(ReestrExtract reestrExtractId) {
        this.reestrExtractId = reestrExtractId;
    }
}
