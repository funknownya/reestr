package xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DeclarAttribute")
public class DeclarAttributeClass
{
    private String idKuvi;
    private String extractTypeCode;
    private String extractTypeText;
    private String extractNumber;
    private String extractDate;
    private String requeryNumber;
    private String requeryDate;
    private String extractCount;
    private String noticeCount;
    private String refuseCount;
    private String registrator;


    private String receivName;
    private String receivAdress;

    public DeclarAttributeClass() {
    }

    @XmlAttribute(name = "ID_KUVI")
    public String getIdKuvi() {
        return idKuvi;
    }

    public void setIdKuvi(String idKuvi) {
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

    @XmlAttribute(name = "ExtractDate")
    public String getExtractDate() {
        return extractDate;
    }

    public void setExtractDate(String extractDate) {
        this.extractDate = extractDate;
    }

    @XmlAttribute(name = "RequeryNumber")
    public String getRequeryNumber() {
        return requeryNumber;
    }

    public void setRequeryNumber(String requeryNumber) {
        this.requeryNumber = requeryNumber;
    }

    @XmlAttribute(name = "RequeryDate")
    public String getRequeryDate() {
        return requeryDate;
    }

    public void setRequeryDate(String requeryDate) {
        this.requeryDate = requeryDate;
    }

    @XmlAttribute(name = "ExtractCount")
    public String getExtractCount() {
        return extractCount;
    }

    public void setExtractCount(String extractCount) {
        this.extractCount = extractCount;
    }

    @XmlAttribute(name = "NoticeCount")
    public String getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(String noticeCount) {
        this.noticeCount = noticeCount;
    }

    @XmlAttribute(name = "RefuseCount")
    public String getRefuseCount() {
        return refuseCount;
    }

    public void setRefuseCount(String refuseCount) {
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
