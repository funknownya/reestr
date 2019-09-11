package hibernate.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "HEAD_CONTENT", schema = "public", catalog = "realty")
public class HeadContent
{
    @Id
    @SequenceGenerator(name = "head_content_id_generator", sequenceName = "head_content_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "head_content_id_generator")
    @Column(name = "HEAD_CONTENT_ID", nullable=false)
    private Integer headContentId;


    @Column(name = "ID_REC_KUVI", nullable=false)
    private Integer idRecKuvi;

    @Column(name = "TITLE", nullable=false)
    private String title;

    @Column(name = "DEPT_NAME", nullable=false)
    private String deptName;

    @Column(name = "EXTRACT_TITLE", nullable=false)
    private String extractTitle;

    @Column(name = "CONTENT", nullable=false)
    private String content;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "headContentId")
    private List<ExtractObjectRight> extractObjectRightList = new ArrayList<ExtractObjectRight>();


    public HeadContent() {
    }

    public Integer getHeadContentId() {
        return headContentId;
    }

    public void setHeadContentId(Integer headContentId) {
        this.headContentId = headContentId;
    }

    public Integer getIdRecKuvi() {
        return idRecKuvi;
    }

    public void setIdRecKuvi(Integer idRecKuvi) {
        this.idRecKuvi = idRecKuvi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getExtractTitle() {
        return extractTitle;
    }

    public void setExtractTitle(String extractTitle) {
        this.extractTitle = extractTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
