package hibernate.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "DECLAR_ATTRIBUTE", schema = "public", catalog = "realty")
public class DeclarAttribute
{
    @Id
    @SequenceGenerator(name = "declar_attribute_id_generator", sequenceName = "declar_attribute_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "declar_attribute_id_generator")
    @Column(name = "DECLAR_ATTRIBUTE_ID", nullable=false)
    private Integer declarAttributeId;


    @Column(name = "ID_KUVI", nullable=false)
    private Integer idKuvi;

    @Column(name = "EXTRACT_TYPE_CODE", nullable=false)
    private String extractTypeCode;

    @Column(name = "EXTRACT_TYPE_TEXT", nullable=false)
    private String extractTypeText;

    @Column(name = "EXTRACT_NUMBER", nullable=false)
    private String extractNumber;

    @Column(name = "EXTRACT_DATE", nullable=false)
    private LocalDate extractDate;

    @Column(name = "REQUERY_NUMBER", nullable=false)
    private String requeryNumber;

    @Column(name = "REQUERY_DATE", nullable=false)
    private LocalDate requeryDate;

    @Column(name = "EXTRACT_COUNT", nullable=false)
    private Integer extractCount;

    @Column(name = "NOTICE_COUNT", nullable=false)
    private Integer noticeCount;

    @Column(name = "REFUSE_COUNT", nullable=false)
    private Integer refuseCount;

    @Column(name = "REGISTRATOR", nullable=false)
    private String registrator;

    @Column(name = "RECEIV_NAME", nullable=false)
    private String receivName;

    @Column(name = "RECEIV_ADDRESS", nullable=false)
    private String receivAddress;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "declarAttributeId")
    private List<ReestrExtract> reestrExtractList = new ArrayList<ReestrExtract>();


    public DeclarAttribute() {
    }

    public Integer getDeclarAttributeId() {
        return declarAttributeId;
    }

    public void setDeclarAttributeId(Integer declarAttributeId) {
        this.declarAttributeId = declarAttributeId;
    }

    public Integer getIdKuvi() {
        return idKuvi;
    }

    public void setIdKuvi(Integer idKuvi) {
        this.idKuvi = idKuvi;
    }

    public String getExtractTypeCode() {
        return extractTypeCode;
    }

    public void setExtractTypeCode(String extractTypeCode) {
        this.extractTypeCode = extractTypeCode;
    }

    public String getExtractTypeText() {
        return extractTypeText;
    }

    public void setExtractTypeText(String extractTypeText) {
        this.extractTypeText = extractTypeText;
    }

    public String getExtractNumber() {
        return extractNumber;
    }

    public void setExtractNumber(String extractNumber) {
        this.extractNumber = extractNumber;
    }

    public LocalDate getExtractDate() {
        return extractDate;
    }

    public void setExtractDate(LocalDate extractDate) {
        this.extractDate = extractDate;
    }

    public String getRequeryNumber() {
        return requeryNumber;
    }

    public void setRequeryNumber(String requeryNumber) {
        this.requeryNumber = requeryNumber;
    }

    public LocalDate getRequeryDate() {
        return requeryDate;
    }

    public void setRequeryDate(LocalDate requeryDate) {
        this.requeryDate = requeryDate;
    }

    public Integer getExtractCount() {
        return extractCount;
    }

    public void setExtractCount(Integer extractCount) {
        this.extractCount = extractCount;
    }

    public Integer getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(Integer noticeCount) {
        this.noticeCount = noticeCount;
    }

    public Integer getRefuseCount() {
        return refuseCount;
    }

    public void setRefuseCount(Integer refuseCount) {
        this.refuseCount = refuseCount;
    }

    public String getRegistrator() {
        return registrator;
    }

    public void setRegistrator(String registrator) {
        this.registrator = registrator;
    }

    public String getReceivName() {
        return receivName;
    }

    public void setReceivName(String receivName) {
        this.receivName = receivName;
    }

    public String getReceivAddress() {
        return receivAddress;
    }

    public void setReceivAddress(String receivAddress) {
        this.receivAddress = receivAddress;
    }
}
