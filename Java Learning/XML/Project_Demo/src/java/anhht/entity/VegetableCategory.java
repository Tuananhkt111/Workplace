
package anhht.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VegetableCategory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VegetableCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vegCatId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="link" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Entity
@Table(name = "TblVegetableCategory")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VegetableCategory", propOrder = {
    "vegCatId",
    "name",
    "link"
})
@XmlRootElement
public class VegetableCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VegCatId", nullable = false)
    protected int vegCatId;
    
    @Column(name = "Name")
    @XmlElement(required = true)
    protected String name;
    
    @Column(name = "Link")
    @XmlElement(required = true)
    protected String link;
    
    @OneToMany(mappedBy = "vegetableCategory")
    protected Collection<Vegetable> vegetableCollection;

    /**
     * Gets the value of the vegCatId property.
     * 
     * @return 
     */
    public int getVegCatId() {
        return vegCatId;
    }

    /**
     * Sets the value of the vegCatId property.
     * 
     * @param value
     */
    public void setVegCatId(int value) {
        this.vegCatId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the link property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLink(String value) {
        this.link = value;
    }

    @XmlTransient
    public Collection<Vegetable> getVegetableCollection() {
        return vegetableCollection;
    }

    public void setVegetableCollection(Collection<Vegetable> vegetableCollection) {
        this.vegetableCollection = vegetableCollection;
    }
}
