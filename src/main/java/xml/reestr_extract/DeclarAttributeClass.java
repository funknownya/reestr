package xml.reestr_extract;

import utilities.ExtractDateAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name="DeclarAttribute")
public class DeclarAttributeClass
{
    private Integer idKuvi;
    private String extractTypeCode;
    private String extractTypeText;
    private String extractNumber;
    private LocalDate extractDate;
    private String requeryNumber;
    private LocalDate requeryDate;
    private Integer extractCount;
    private Integer noticeCount;
    private Integer refuseCount;
    private String registrator;


    private String receivName;
    private String receivAdress;

    public DeclarAttributeClass() {
    }

    @XmlAttribute(name = "ID_KUVI")
    public Integer getIdKuvi() {
        return idKuvi;
    }

    public void setIdKuvi(Integer idKuvi) {
        this.idKuvi = idKuvi;
    }

    @XmlAttribute(name = "ExtractTypeCode")
    public String getExtractTypeCode() {
        return extractTypeCode;
    }

    public void setExtractTypeCode(String extractTypeCode) {
        this.extractTypeCode = extractTypeCode;
    }

    @XmlAttribute(name = "ExtractTypeText")
    public String getExtractTypeText() {
        return extractTypeText;
    }

    public void setExtractTypeText(String extractTypeText) {
        this.extractTypeText = extractTypeText;
    }

    @XmlAttribute(name = "ExtractNumber")
    public String getExtractNumber() {
        return extractNumber;
    }

    public void setExtractNumber(String extractNumber) {
        this.extractNumber = extractNumber;
    }

    @XmlJavaTypeAdapter(value = ExtractDateAdapter.class)
    @XmlAttribute(name = "ExtractDate", required = true)
    public LocalDate getExtractDate() {
        return extractDate;
    }

    public void setExtractDate(LocalDate extractDate) {
        this.extractDate = extractDate;
    }

    @XmlAttribute(name = "RequeryNumber")
    public String getRequeryNumber() {
        return requeryNumber;
    }

    public void setRequeryNumber(String requeryNumber) {
        this.requeryNumber = requeryNumber;
    }

    @XmlJavaTypeAdapter(value = ExtractDateAdapter.class)
    @XmlAttribute(name = "RequeryDate", required = true)
    public LocalDate getRequeryDate() {
        return requeryDate;
    }

    public void setRequeryDate(LocalDate requeryDate) {
        this.requeryDate = requeryDate;
    }

    @XmlAttribute(name = "ExtractCount")
    public Integer getExtractCount() {
        return extractCount;
    }

    public void setExtractCount(Integer extractCount) {
        this.extractCount = extractCount;
    }

    @XmlAttribute(name = "NoticeCount")
    public Integer getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(Integer noticeCount) {
        this.noticeCount = noticeCount;
    }

    @XmlAttribute(name = "RefuseCount")
    public Integer getRefuseCount() {
        return refuseCount;
    }

    public void setRefuseCount(Integer refuseCount) {
        this.refuseCount = refuseCount;
    }

    @XmlAttribute(name = "Registrator")
    public String getRegistrator() {
        return registrator;
    }

    public void setRegistrator(String registrator) {
        this.registrator = registrator;
    }

    @XmlElement(name = "ReceivName")
    public String getReceivName() {
        return receivName;
    }

    public void setReceivName(String receivName) {
        this.receivName = receivName;
    }

    @XmlElement(name = "ReceivAdress")
    public String getReceivAdress() {
        return receivAdress;
    }

    public void setReceivAdress(String receivAdress) {
        this.receivAdress = receivAdress;
    }
}
