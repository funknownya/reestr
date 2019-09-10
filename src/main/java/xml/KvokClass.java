package xml;


import xml.certification_doc.CertificationDocClass;
import xml.contractor.ContractorClass;
import xml.coord_system.CoordSystemClass;
import xml.edocument.EDocumentClass;
import xml.reestr_extract.ReestrExtractClass;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "KVOKS", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kvoks/3.0.1")
@XmlType(propOrder={"realtyClass",
        "certificationDocClass",
        "contractorClassList",
        "coordSystemClassList",
        "eDocumentClass",
        "reestrExtractClass"})
public class KvokClass
{
    private RealtyClass realtyClass;
    private CertificationDocClass certificationDocClass;
    private List<ContractorClass> contractorClassList = new ArrayList<ContractorClass>();
    private List<CoordSystemClass> coordSystemClassList = new ArrayList<CoordSystemClass>();
    private EDocumentClass eDocumentClass;
    private ReestrExtractClass reestrExtractClass;




    public KvokClass() {
    }


    public void setRealtyClass(RealtyClass realtyClass) {
        this.realtyClass = realtyClass;
    }

    @XmlElement(name = "Realty")
    public RealtyClass getRealtyClass() {
        return realtyClass;
    }


    @XmlElement(name = "CertificationDoc")
    public CertificationDocClass getCertificationDocClass() {
        return certificationDocClass;
    }

    public void setCertificationDocClass(CertificationDocClass certificationDocClass) {
        this.certificationDocClass = certificationDocClass;
    }

    @XmlElementWrapper(name = "Contractors")
    @XmlElement(name = "Contractor")
    public List<ContractorClass> getContractorClassList() {
        return contractorClassList;
    }

    public void setContractorClassList(List<ContractorClass> contractorClassList) {
        this.contractorClassList = contractorClassList;
    }

    @XmlElementWrapper(name = "CoordSystems")
    @XmlElement(name = "CoordSystem", namespace="urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1")
    public List<CoordSystemClass> getCoordSystemClassList() {
        return coordSystemClassList;
    }

    public void setCoordSystemClassList(List<CoordSystemClass> coordSystemClassList) {
        this.coordSystemClassList = coordSystemClassList;
    }

    @XmlElement(name = "eDocument")
    public EDocumentClass geteDocumentClass() {
        return eDocumentClass;
    }

    public void seteDocumentClass(EDocumentClass eDocumentClass) {
        this.eDocumentClass = eDocumentClass;
    }

    @XmlElement(name = "ReestrExtract")
    public ReestrExtractClass getReestrExtractClass() {
        return reestrExtractClass;
    }

    public void setReestrExtractClass(ReestrExtractClass reestrExtractClass) {
        this.reestrExtractClass = reestrExtractClass;
    }
}
