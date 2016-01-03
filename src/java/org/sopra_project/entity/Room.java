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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Henri
 */
@Entity
@Table(name = "ROOM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findByRfId", query = "SELECT r FROM Room r WHERE r.rfId = :rfId"),
    @NamedQuery(name = "Room.findByRfName", query = "SELECT r FROM Room r WHERE r.rfName = :rfName"),
    @NamedQuery(name = "Room.findByRfSize", query = "SELECT r FROM Room r WHERE r.rfSize = :rfSize")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RF_ID")
    private Integer rfId;
    @Size(max = 15)
    @Column(name = "RF_NAME")
    private String rfName;
    @Column(name = "RF_SIZE")
    private Integer rfSize;
    @OneToMany(mappedBy = "rfFavoriteroom")
    private Collection<Employee> employeeCollection;
    @JoinColumn(name = "RF_SITE", referencedColumnName = "RF_NAME")
    @ManyToOne
    private Site rfSite;

    public Room() {
    }

    public Room(Integer rfId) {
        this.rfId = rfId;
    }

    public Integer getRfId() {
        return rfId;
    }

    public void setRfId(Integer rfId) {
        this.rfId = rfId;
    }

    public String getRfName() {
        return rfName;
    }

    public void setRfName(String rfName) {
        this.rfName = rfName;
    }

    public Integer getRfSize() {
        return rfSize;
    }

    public void setRfSize(Integer rfSize) {
        this.rfSize = rfSize;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    public Site getRfSite() {
        return rfSite;
    }

    public void setRfSite(Site rfSite) {
        this.rfSite = rfSite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rfId != null ? rfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.rfId == null && other.rfId != null) || (this.rfId != null && !this.rfId.equals(other.rfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sopra_project.entity.Room[ rfId=" + rfId + " ]";
    }
    
}
