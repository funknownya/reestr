package hibernate.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Farid Mukhametshin
 */

@Entity
@Table(name = "SENDER", schema = "public", catalog = "realty")
public class Sender
{
    @Id
    @SequenceGenerator(name = "sender_id_generator", sequenceName = "sender_id_sq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sender_id_generator")
    @Column(name = "SENDER_ID", nullable=false)
    private Integer senderId;


    @Column(name = "KOD", nullable=false)
    private String kod;

    @Column(name = "NAME", nullable=true)
    private String name;

    @Column(name = "REGION", nullable=true)
    private String region;

    @Column(name = "DATE_UPLOAD", nullable=true)
    private LocalDate dateUpload;

    @Column(name = "APPOINTMENT", nullable=true)
    private String appointment;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "senderId")
    private List<EDocument> edocumentList = new ArrayList<EDocument>();



    public Sender() {
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public LocalDate getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(LocalDate dateUpload) {
        this.dateUpload = dateUpload;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }
}
