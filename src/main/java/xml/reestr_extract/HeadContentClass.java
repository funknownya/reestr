package xml.reestr_extract;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="HeadContent")
public class HeadContentClass
{
    private String idRecKuvi;
    private String title;
    private String deptName;
    private String extractTitle;
    private String content;

    public HeadContentClass() {
    }

    @XmlElement(name = "ID_REC_KUVI")
    public String getIdRecKuvi() {
        return idRecKuvi;
    }

    public void setIdRecKuvi(String idRecKuvi) {
        this.idRecKuvi = idRecKuvi;
    }

    @XmlElement(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "DeptName")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @XmlElement(name = "ExtractTitle")
    public String getExtractTitle() {
        return extractTitle;
    }

    public void setExtractTitle(String extractTitle) {
        this.extractTitle = extractTitle;
    }

    @XmlElement(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
