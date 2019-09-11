package hibernate.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "RECIPIENT", schema = "public", catalog = "realty")
public class Recipient
{
    @Id
    @SequenceGenerator(name = "recipient_id_generator", sequenceName = "recipient_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipient_id_generator")
    @Column(name = "RECIPIENT_ID", nullable=false)
    private Integer recipientId;


    @Column(name = "KOD", nullable=false)
    private String kod;

    @Column(name = "NAME", nullable=true)
    private String name;


    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "recipientId")
    private List<EDocument> edocumentList = new ArrayList<EDocument>();


    public Recipient() {
    }

    public Integer getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
