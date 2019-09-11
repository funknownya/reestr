package hibernate.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "EXTRACT_OBJECT_RIGHT", schema = "public", catalog = "realty")
public class ExtractObjectRight
{
    @Id
    @SequenceGenerator(name = "extract_object_right_id_generator", sequenceName = "extract_object_right_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "extract_object_right_id_generator")
    @Column(name = "EXTRACT_OBJECT_RIGHT_ID", nullable=false)
    private Integer extractObjectRightId;


    @Column(name = "INFO_ENK")
    private String infoEnk;

    @Column(name = "INFO_PIK")
    private String infoPik;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HEAD_CONTENT_ID", referencedColumnName = "HEAD_CONTENT_ID", nullable=false)
    private HeadContent headContentId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOOT_CONTENT_ID", referencedColumnName = "FOOT_CONTENT_ID", nullable=false)
    private FootContent footContentId;


    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "extractObjectRightId")
    private List<ReestrExtract> reestrExtractList = new ArrayList<ReestrExtract>();

    public ExtractObjectRight() {
    }

    public Integer getExtractObjectRightId() {
        return extractObjectRightId;
    }

    public void setExtractObjectRightId(Integer extractObjectRightId) {
        this.extractObjectRightId = extractObjectRightId;
    }

    public String getInfoEnk() {
        return infoEnk;
    }

    public void setInfoEnk(String infoEnk) {
        this.infoEnk = infoEnk;
    }

    public String getInfoPik() {
        return infoPik;
    }

    public void setInfoPik(String infoPik) {
        this.infoPik = infoPik;
    }

    public HeadContent getHeadContentId() {
        return headContentId;
    }

    public void setHeadContentId(HeadContent headContentId) {
        this.headContentId = headContentId;
    }

    public FootContent getFootContentId() {
        return footContentId;
    }

    public void setFootContentId(FootContent footContentId) {
        this.footContentId = footContentId;
    }
}
