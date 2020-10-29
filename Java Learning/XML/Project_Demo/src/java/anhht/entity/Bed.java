
package anhht.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Bed complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Bed">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bedId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bedCatId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="imgLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Entity
@Table(name = "TblBed")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bed", propOrder = {
    "bedId",
    "bedCatId",
    "name",
    "imgLink",
    "lengthMeasure",
    "widthMeasure",
    "heightMeasure"
})
@XmlRootElement
public class Bed implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BedId", nullable = false)
    protected int bedId;
    
    @XmlElement(required = true)
    @Column(name = "Name", length = 100)
    protected String name;
    
    @XmlElement(required = true)
    @Column(name = "ImgLink", length = 200)
    protected String imgLink;
    
    @Column(name = "LengthMeasure")
    protected int lengthMeasure;
    
    @Column(name = "WidthMeasure")
    protected int widthMeasure;
    
    @Column(name = "HeightMeasure")
    protected int heightMeasure;
    
    @JoinColumn(name = "BedCatId", referencedColumnName = "BedCatId")
    @ManyToOne
    private BedCategory bedCategory;

    /**
     * Gets the value of the bedId property.
     * 
     */
    public int getBedId() {
        return bedId;
    }

    /**
     * Sets the value of the bedId property.
     * 
     * @param value
     */
    public void setBedId(int value) {
        this.bedId = value;
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
     * Gets the value of the imgLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImgLink() {
        return imgLink;
    }

    /**
     * Sets the value of the imgLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImgLink(String value) {
        this.imgLink = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return 
     */
    public int getLengthMeasure() {
        return lengthMeasure;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     */
    public void setLengthMeasure(int value) {
        this.lengthMeasure = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return 
     */
    public int getWidthMeasure() {
        return widthMeasure;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     */
    public void setWidthMeasure(int value) {
        this.widthMeasure = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return 
     */
    public int getHeightMeasure() {
        return heightMeasure;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     */
    public void setHeightMeasure(int value) {
        this.heightMeasure = value;
    }

    public BedCategory getBedCategory() {
        return bedCategory;
    }

    public void setBedCategory(BedCategory bedCategory) {
        this.bedCategory = bedCategory;
    }
}
