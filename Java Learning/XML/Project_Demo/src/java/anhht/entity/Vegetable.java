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
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Vegetable complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="Vegetable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vegId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="vegCatId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="imgLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="detailLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="spread" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="thin" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dayOfMaturity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@Entity
@Table(name = "TblVegetable")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vegetable", propOrder = {
    "vegId",
    "vegCatId",
    "name",
    "imgLink",
    "detailLink",
    "price",
    "spread",
    "thin",
    "height",
    "dayOfMaturity"
})
@XmlRootElement
public class Vegetable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VegId", nullable = false)
    protected int vegId;

    @XmlElement(required = true)
    @Column(name = "Name", length = 100)
    protected String name;

    @XmlElement(required = true)
    @Column(name = "ImgLink", length = 200)
    protected String imgLink;

    @XmlElement(required = true)
    @Column(name = "DetailLink", length = 200)
    protected String detailLink;

    @Column(name = "Price")
    protected int price;

    @Column(name = "Spread")
    protected int spread;

    @Column(name = "Thin")
    protected int thin;

    @Column(name = "Height")
    protected int height;

    @Column(name = "DayOfMaturity")
    protected int dayOfMaturity;

    @JoinColumn(name = "VegCatId", referencedColumnName = "VegCatId")
    @ManyToOne
    protected VegetableCategory vegetableCategory;

    /**
     * Gets the value of the vegId property.
     *
     * @return
     */
    public int getVegId() {
        return vegId;
    }

    /**
     * Sets the value of the vegId property.
     *
     * @param value
     */
    public void setVegId(int value) {
        this.vegId = value;
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
     * Gets the value of the imgLink property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getImgLink() {
        return imgLink;
    }

    /**
     * Sets the value of the imgLink property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setImgLink(String value) {
        this.imgLink = value;
    }

    /**
     * Gets the value of the detailLink property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getDetailLink() {
        return detailLink;
    }

    /**
     * Sets the value of the detailLink property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setDetailLink(String value) {
        this.detailLink = value;
    }

    /**
     * Gets the value of the price property.
     *
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     * @param value
     */
    public void setPrice(int value) {
        this.price = value;
    }

    /**
     * Gets the value of the spread property.
     *
     * @return
     */
    public int getSpread() {
        return spread;
    }

    /**
     * Sets the value of the spread property.
     *
     * @param value
     */
    public void setSpread(int value) {
        this.spread = value;
    }

    /**
     * Gets the value of the thin property.
     *
     * @return
     */
    public int getThin() {
        return thin;
    }

    /**
     * Sets the value of the thin property.
     *
     * @param value
     */
    public void setThin(int value) {
        this.thin = value;
    }

    /**
     * Gets the value of the height property.
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     *
     * @param value
     */
    public void setHeight(int value) {
        this.height = value;
    }

    /**
     * Gets the value of the dayOfMaturity property.
     *
     * @return
     */
    public int getDayOfMaturity() {
        return dayOfMaturity;
    }

    /**
     * Sets the value of the dayOfMaturity property.
     *
     * @param value
     */
    public void setDayOfMaturity(int value) {
        this.dayOfMaturity = value;
    }

    @XmlTransient
    public VegetableCategory getVegetableCategory() {
        return vegetableCategory;
    }

    public void setVegetableCategory(VegetableCategory vegetableCategory) {
        this.vegetableCategory = vegetableCategory;
    }
}
