package hibernate.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "FOOT_CONTENT", schema = "public", catalog = "realty")
public class FootContent
{
    @Id
    @SequenceGenerator(name = "foot_content_id_generator", sequenceName = "foot_content_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "foot_content_id_generator")
    @Column(name = "FOOT_CONTENT_ID", nullable=false)
    private Integer footContentId;



    @Column(name = "RECIPIENT", nullable=false)
    private String recipient;

    @Column(name = "EXTRACT_DATE", nullable=false)
    private LocalDate extractDate;


    @Column(name = "CONTENT", nullable=false)
    private String content;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "footContentId")
    private List<ExtractObjectRight> extractObjectRightList = new ArrayList<ExtractObjectRight>();


    public FootContent() {
    }

    public Integer getFootContentId() {
        return footContentId;
    }

    public void setFootContentId(Integer footContentId) {
        this.footContentId = footContentId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public LocalDate getExtractDate() {
        return extractDate;
    }

    public void setExtractDate(LocalDate extractDate) {
        this.extractDate = extractDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
