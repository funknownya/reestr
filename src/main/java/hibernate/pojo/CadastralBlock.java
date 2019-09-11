package hibernate.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "CADASTRALBLOCK", schema = "public", catalog = "realty")
public class CadastralBlock
{
    @Id
    @SequenceGenerator(name = "cadastralblock_id_generator", sequenceName = "cadastralblock_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cadastralblock_id_generator")
    @Column(name = "CADASTRALBLOCK_ID", nullable=false)
    private Integer cadastralBlockId;


    @Column(name = "CADASTRALBLOCK", nullable=false)
    private String cadastralBlock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONSTRUCTION_ID", referencedColumnName = "CONSTRUCTION_ID", nullable=false)
    private Construction constructionId;




    public CadastralBlock() {
    }

    public Integer getCadastralBlockId() {
        return cadastralBlockId;
    }

    public void setCadastralBlockId(Integer cadastralBlockId) {
        this.cadastralBlockId = cadastralBlockId;
    }

    public String getCadastralBlock() {
        return cadastralBlock;
    }

    public void setCadastralBlock(String cadastralBlock) {
        this.cadastralBlock = cadastralBlock;
    }

    public Construction getConstructionId() {
        return constructionId;
    }

    public void setConstructionId(Construction constructionId) {
        this.constructionId = constructionId;
    }
}
