/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Henri
 */
@Entity
@Table(name = "SITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s"),
    @NamedQuery(name = "Site.findByRfName", query = "SELECT s FROM Site s WHERE s.rfName = :rfName")})
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "RF_NAME")
    private String rfName;
    @OneToMany(mappedBy = "rfFavoritesite")
    private Collection<Employee> employeeCollection;
    @OneToMany(mappedBy = "rfSite")
    private Collection<Room> roomCollection;

    public Site() {
    }

    public Site(String rfName) {
        this.rfName = rfName;
    }

    public String getRfName() {
        return rfName;
    }

    public void setRfName(String rfName) {
        this.rfName = rfName;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @XmlTransient
    public Collection<Room> getRoomCollection() {
        return roomCollection;
    }

    public void setRoomCollection(Collection<Room> roomCollection) {
        this.roomCollection = roomCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rfName != null ? rfName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.rfName == null && other.rfName != null) || (this.rfName != null && !this.rfName.equals(other.rfName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sopra_project.entity.Site[ rfName=" + rfName + " ]";
    }
    
}
