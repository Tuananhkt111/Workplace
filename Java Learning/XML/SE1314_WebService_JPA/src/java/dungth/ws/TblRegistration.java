/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.ws;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tranh
 */
@Entity
@Table(name = "tbl_Registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRegistration.findAll", query = "SELECT t FROM TblRegistration t")
    , @NamedQuery(name = "TblRegistration.findByUsername", query = "SELECT t FROM TblRegistration t WHERE t.username = :username")
    , @NamedQuery(name = "TblRegistration.findByPassword", query = "SELECT t FROM TblRegistration t WHERE t.password = :password")
    , @NamedQuery(name = "TblRegistration.findByFullname", query = "SELECT t FROM TblRegistration t WHERE t.fullname = :fullname")
    , @NamedQuery(name = "TblRegistration.findByRole", query = "SELECT t FROM TblRegistration t WHERE t.role = :role")})
public class TblRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Username")
    private String username;
    @Size(max = 50)
    @Column(name = "Password")
    private String password;
    @Size(max = 50)
    @Column(name = "Fullname")
    private String fullname;
    @Size(max = 50)
    @Column(name = "Role")
    private String role;

    public TblRegistration() {
    }

    public TblRegistration(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRegistration)) {
            return false;
        }
        TblRegistration other = (TblRegistration) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dungth.ws.TblRegistration[ username=" + username + " ]";
    }
    
}
