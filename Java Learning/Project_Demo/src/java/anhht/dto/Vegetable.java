
package anhht.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Vegetable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
public class Vegetable {

    protected int vegId;
    protected int vegCatId;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String imgLink;
    @XmlElement(required = true)
    protected String detailLink;
    protected int price;
    protected int spread;
    protected int thin;
    protected int height;
    protected int dayOfMaturity;

    /**
     * Gets the value of the vegId property.
     * 
     */
    public int getVegId() {
        return vegId;
    }

    /**
     * Sets the value of the vegId property.
     * 
     */
    public void setVegId(int value) {
        this.vegId = value;
    }

    /**
     * Gets the value of the vegCatId property.
     * 
     */
    public int getVegCatId() {
        return vegCatId;
    }

    /**
     * Sets the value of the vegCatId property.
     * 
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
     * Gets the value of the detailLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetailLink() {
        return detailLink;
    }

    /**
     * Sets the value of the detailLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetailLink(String value) {
        this.detailLink = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(int value) {
        this.price = value;
    }

    /**
     * Gets the value of the spread property.
     * 
     */
    public int getSpread() {
        return spread;
    }

    /**
     * Sets the value of the spread property.
     * 
     */
    public void setSpread(int value) {
        this.spread = value;
    }

    /**
     * Gets the value of the thin property.
     * 
     */
    public int getThin() {
        return thin;
    }

    /**
     * Sets the value of the thin property.
     * 
     */
    public void setThin(int value) {
        this.thin = value;
    }

    /**
     * Gets the value of the height property.
     * 
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     */
    public void setHeight(int value) {
        this.height = value;
    }

    /**
     * Gets the value of the dayOfMaturity property.
     * 
     */
    public int getDayOfMaturity() {
        return dayOfMaturity;
    }

    /**
     * Sets the value of the dayOfMaturity property.
     * 
     */
    public void setDayOfMaturity(int value) {
        this.dayOfMaturity = value;
    }

}
