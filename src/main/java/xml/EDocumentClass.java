package xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="eDocument")
@XmlType(propOrder={"senderClass","recipientClass"})
public class EDocumentClass
{
    private String codeType;
    private String version;
    private String scope;


    private SenderClass senderClass;
    private RecipientClass recipientClass;

    public EDocumentClass() {
    }

    @XmlAttribute(name = "CodeType")
    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    @XmlAttribute(name = "Version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlAttribute(name = "Scope")
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @XmlElement(name = "Sender")
    public SenderClass getSenderClass() {
        return senderClass;
    }

    public void setSenderClass(SenderClass senderClass) {
        this.senderClass = senderClass;
    }

    @XmlElement(name = "Recipient")
    public RecipientClass getRecipientClass() {
        return recipientClass;
    }

    public void setRecipientClass(RecipientClass recipientClass) {
        this.recipientClass = recipientClass;
    }
}
