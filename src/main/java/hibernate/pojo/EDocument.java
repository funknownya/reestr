package hibernate.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "EDOCUMENT", schema = "public", catalog = "realty")
public class EDocument
{
    @Id
    @SequenceGenerator(name = "edocument_id_generator", sequenceName = "edocument_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edocument_id_generator")
    @Column(name = "EDOCUMENT_ID", nullable=false)
    private Integer edocumentId;


    @Column(name = "CODETYPE", nullable=false)
    private String codeType;

    @Column(name = "VERSION", nullable=false)
    private String version;

    @Column(name = "SCOPE", nullable=true)
    private String scope;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SENDER_ID", referencedColumnName = "SENDER_ID", nullable=false)
    private Sender senderId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPIENT_ID", referencedColumnName = "RECIPIENT_ID", nullable=false)
    private Recipient recipientId;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "edocumentId")
    private List<Kvoks> kvokList = new ArrayList<Kvoks>();

    public EDocument() {
    }

    public Integer getEdocumentId() {
        return edocumentId;
    }

    public void setEdocumentId(Integer edocumentId) {
        this.edocumentId = edocumentId;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Sender getSenderId() {
        return senderId;
    }

    public void setSenderId(Sender senderId) {
        this.senderId = senderId;
    }

    public Recipient getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Recipient recipientId) {
        this.recipientId = recipientId;
    }
}
