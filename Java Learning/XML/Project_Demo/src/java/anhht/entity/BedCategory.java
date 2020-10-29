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
 * <p>
 * Java class for BedCategory complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="BedCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bedCatId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@Table(name = "TblBedCategory")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BedCategory", propOrder = {
    "bedCatId",
    "name",
    "link"
})
@XmlRootElement
public class BedCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BedCatId", nullable = false)
    protected int bedCatId;

    @XmlElement(required = true)
    @Column(name = "Name", length = 100)
    protected String name;

    @XmlElement(required = true)
    @Column(name = "Link", length = 200)
    protected String link;

    @OneToMany(mappedBy = "bedCategory")
    private Collection<Bed> bedCollection;

    /**
     * Gets the value of the bedCatId property.
     *
     * @return
     */
    public int getBedCatId() {
        return bedCatId;
    }

    /**
     * Sets the value of the bedCatId property.
     *
     * @param value
     */
    public void setBedCatId(int value) {
        this.bedCatId = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the link property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setLink(String value) {
        this.link = value;
    }

    @XmlTransient
    public Collection<Bed> getBedCollection() {
        return bedCollection;
    }

    public void setBedCollection(Collection<Bed> bedCollection) {
        this.bedCollection = bedCollection;
    }
}
