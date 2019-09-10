package xml.contractor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Contractor")
public class ContractorClass
{

    private String familyName;
    private String firstName;
    private String patronymic;
    private String ncertificate;
    private OrganizationClass organizationClass;

    public ContractorClass() {
    }

    @XmlElement(name = "FamilyName")
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @XmlElement(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "Patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @XmlElement(name = "NCertificate")
    public String getNcertificate() {
        return ncertificate;
    }

    public void setNcertificate(String ncertificate) {
        this.ncertificate = ncertificate;
    }

    @XmlElement(name = "Organization")
    public OrganizationClass getOrganizationClass() {
        return organizationClass;
    }

    public void setOrganizationClass(OrganizationClass organizationClass) {
        this.organizationClass = organizationClass;
    }
}
