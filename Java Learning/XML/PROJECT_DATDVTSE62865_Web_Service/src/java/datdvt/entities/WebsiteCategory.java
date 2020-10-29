/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "WebsiteCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebsiteCategory.findAll", query = "SELECT w FROM WebsiteCategory w")
    , @NamedQuery(name = "WebsiteCategory.findById", query = "SELECT w FROM WebsiteCategory w WHERE w.id = :id")
    , @NamedQuery(name = "WebsiteCategory.findByName", query = "SELECT w FROM WebsiteCategory w WHERE w.name = :name")
    , @NamedQuery(name = "WebsiteCategory.findByUrl", query = "SELECT w FROM WebsiteCategory w WHERE w.url = :url")
    , @NamedQuery(name = "WebsiteCategory.findByWebsite", query = "SELECT w FROM WebsiteCategory w WHERE w.website = :website")})
public class WebsiteCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 1073741823)
    @Column(name = "url")
    private String url;
    @Size(max = 100)
    @Column(name = "website")
    private String website;
    @JoinColumn(name = "category", referencedColumnName = "id")
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "websiteCategory")
    private Collection<Product> productCollection;

    public WebsiteCategory() {
    }

    public WebsiteCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebsiteCategory)) {
            return false;
        }
        WebsiteCategory other = (WebsiteCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datdvt.entities.WebsiteCategory[ id=" + id + " ]";
    }
    
}
