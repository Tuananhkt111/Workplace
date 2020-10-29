
package datdvt.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="brand" type="{http://xml.netbean.org/schema/category}BrandDTO"/>
 *         &lt;element name="websiteCategory" type="{http://xml.netbean.org/schema/category}WebsiteCategoryDTO"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="depth" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="material" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductDTO", propOrder = {
    "id",
    "name",
    "url",
    "brand",
    "websiteCategory",
    "price",
    "width",
    "height",
    "depth",
    "material"
})
public class ProductDTO {

    protected int id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String url;
    @XmlElement(required = true)
    protected BrandDTO brand;
    @XmlElement(required = true)
    protected WebsiteCategoryDTO websiteCategory;
    protected int price;
    protected float width;
    protected float height;
    protected float depth;
    @XmlElement(required = true)
    protected String material;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, String url, BrandDTO brand, WebsiteCategoryDTO websiteCategory, int price, float width, float height, float depth, String material) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.brand = brand;
        this.websiteCategory = websiteCategory;
        this.price = price;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.material = material;
    }

    
    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
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
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the brand property.
     * 
     * @return
     *     possible object is
     *     {@link BrandDTO }
     *     
     */
    public BrandDTO getBrand() {
        return brand;
    }

    /**
     * Sets the value of the brand property.
     * 
     * @param value
     *     allowed object is
     *     {@link BrandDTO }
     *     
     */
    public void setBrand(BrandDTO value) {
        this.brand = value;
    }

    /**
     * Gets the value of the websiteCategory property.
     * 
     * @return
     *     possible object is
     *     {@link WebsiteCategoryDTO }
     *     
     */
    public WebsiteCategoryDTO getWebsiteCategory() {
        return websiteCategory;
    }

    /**
     * Sets the value of the websiteCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebsiteCategoryDTO }
     *     
     */
    public void setWebsiteCategory(WebsiteCategoryDTO value) {
        this.websiteCategory = value;
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
     * Gets the value of the width property.
     * 
     */
    public float getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     */
    public void setWidth(float value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     * 
     */
    public float getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     */
    public void setHeight(float value) {
        this.height = value;
    }

    /**
     * Gets the value of the depth property.
     * 
     */
    public float getDepth() {
        return depth;
    }

    /**
     * Sets the value of the depth property.
     * 
     */
    public void setDepth(float value) {
        this.depth = value;
    }

    /**
     * Gets the value of the material property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets the value of the material property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterial(String value) {
        this.material = value;
    }

}
