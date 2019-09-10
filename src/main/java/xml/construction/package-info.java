@XmlSchema(
        namespace="urn://x-artefacts-rosreestr-ru/outgoing/kvoks/3.0.1",

        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns={
                @XmlNs(prefix="smev", namespaceURI="urn://x-artefacts-smev-gov-ru/supplementary/commons/1.0.1"),
                @XmlNs(prefix="num", namespaceURI="urn://x-artefacts-rosreestr-ru/commons/complex-types/numbers/1.0"),
                @XmlNs(prefix="adrs", namespaceURI="urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1"),
                @XmlNs(prefix="spa", namespaceURI="urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1"),
                @XmlNs(prefix="param", namespaceURI="urn://x-artefacts-rosreestr-ru/commons/complex-types/parameters-oks/2.0.1"),
                @XmlNs(prefix="cer", namespaceURI="urn://x-artefacts-rosreestr-ru/commons/complex-types/certification-doc/1.0"),
                @XmlNs(prefix="doc", namespaceURI="urn://x-artefacts-rosreestr-ru/commons/complex-types/document-output/4.0.1"),
                @XmlNs(prefix="ch", namespaceURI="urn://x-artefacts-rosreestr-ru/commons/complex-types/cultural-heritage/2.0.1")
        } 
)
package xml.construction;

import utilities.ClassicDateAdapter;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.time.LocalDateTime;