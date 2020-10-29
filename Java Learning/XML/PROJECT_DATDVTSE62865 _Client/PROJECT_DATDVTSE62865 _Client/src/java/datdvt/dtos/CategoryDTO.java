
package datdvt.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CategoryDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CategoryDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="levelAuth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name="category")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoryDTO", propOrder = {
    "id",
    "name",
    "levelAuth"
})
public class CategoryDTO {

    protected int id;
    @XmlElement(required = true)
    protected String name;
    protected int levelAuth;

    public CategoryDTO(int id, String name, int levelAuth) {
        this.id = id;
        this.name = name;
        this.levelAuth = levelAuth;
    }

    public CategoryDTO() {
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
     * Gets the value of the levelAuth property.
     * 
     */
    public int getLevelAuth() {
        return levelAuth;
    }

    /**
     * Sets the value of the levelAuth property.
     * 
     */
    public void setLevelAuth(int value) {
        this.levelAuth = value;
    }

}
