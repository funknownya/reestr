package hibernate.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "CERTIFICATIONDOC", schema = "public", catalog = "realty")
public class CertificationDoc
{
    @Id
    @SequenceGenerator(name = "certificationDoc_id_generator", sequenceName = "certificationDoc_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificationDoc_id_generator")
    @Column(name = "CERTIFICATIONDOC_ID", nullable=false)
    private Integer certificationDocId;


    @Column(name = "ORGANIZATION", nullable=false)
    private String organization;

    @Column(name = "DATE", nullable=true)
    private LocalDate date;

    @Column(name = "NUMBER", nullable=true)
    private String number;


    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "certificationDocId")
    private List<Kvoks> kvokList = new ArrayList<Kvoks>();




    public CertificationDoc() {
    }

    public Integer getCertificationDocId() {
        return certificationDocId;
    }

    public void setCertificationDocId(Integer certificationDocId) {
        this.certificationDocId = certificationDocId;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
