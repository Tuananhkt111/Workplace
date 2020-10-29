
package anhht.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the anhht.dto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Vegetable_QNAME = new QName("http://xml.netbeans.org/schema/vegetables", "vegetable");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: anhht.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Vegetable }
     * 
     */
    public Vegetable createVegetable() {
        return new Vegetable();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Vegetable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/vegetables", name = "vegetable")
    public JAXBElement<Vegetable> createVegetable(Vegetable value) {
        return new JAXBElement<Vegetable>(_Vegetable_QNAME, Vegetable.class, null, value);
    }

}
