
package anhht.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the anhht.entity package. 
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

    private final static QName _VegetableCategory_QNAME = new QName("http://xml.netbeans.org/schema/vegetableCategories", "vegetableCategory");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: anhht.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VegetableCategory }
     * 
     */
    public VegetableCategory createVegetableCategory() {
        return new VegetableCategory();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VegetableCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/vegetableCategories", name = "vegetableCategory")
    public JAXBElement<VegetableCategory> createVegetableCategory(VegetableCategory value) {
        return new JAXBElement<VegetableCategory>(_VegetableCategory_QNAME, VegetableCategory.class, null, value);
    }

}
