/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Henri
 */
@Entity
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByRfId", query = "SELECT e FROM Employee e WHERE e.rfId = :rfId"),
    @NamedQuery(name = "Employee.findByRfName", query = "SELECT e FROM Employee e WHERE e.rfName = :rfName"),
    @NamedQuery(name = "Employee.findByRfPhonenumber", query = "SELECT e FROM Employee e WHERE e.rfPhonenumber = :rfPhonenumber"),
    @NamedQuery(name = "Employee.findByRfMailaddress", query = "SELECT e FROM Employee e WHERE e.rfMailaddress = :rfMailaddress")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RF_ID")
    private Integer rfId;
    @Size(max = 40)
    @Column(name = "RF_NAME")
    private String rfName;
    @Size(max = 14)
    @Column(name = "RF_PHONENUMBER")
    private String rfPhonenumber;
    @Size(max = 40)
    @Column(name = "RF_MAILADDRESS")
    private String rfMailaddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<Isinvited> isinvitedCollection;
    @JoinColumn(name = "RF_FAVORITEROOM", referencedColumnName = "RF_ID")
    @ManyToOne
    private Room rfFavoriteroom;
    @JoinColumn(name = "RF_FAVORITESITE", referencedColumnName = "RF_NAME")
    @ManyToOne
    private Site rfFavoritesite;

    public Employee() {
    }

    public Employee(Integer rfId) {
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

    public String getRfPhonenumber() {
        return rfPhonenumber;
    }

    public void setRfPhonenumber(String rfPhonenumber) {
        this.rfPhonenumber = rfPhonenumber;
    }

    public String getRfMailaddress() {
        return rfMailaddress;
    }

    public void setRfMailaddress(String rfMailaddress) {
        this.rfMailaddress = rfMailaddress;
    }

    @XmlTransient
    public Collection<Isinvited> getIsinvitedCollection() {
        return isinvitedCollection;
    }

    public void setIsinvitedCollection(Collection<Isinvited> isinvitedCollection) {
        this.isinvitedCollection = isinvitedCollection;
    }

    public Room getRfFavoriteroom() {
        return rfFavoriteroom;
    }

    public void setRfFavoriteroom(Room rfFavoriteroom) {
        this.rfFavoriteroom = rfFavoriteroom;
    }

    public Site getRfFavoritesite() {
        return rfFavoritesite;
    }

    public void setRfFavoritesite(Site rfFavoritesite) {
        this.rfFavoritesite = rfFavoritesite;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.rfId == null && other.rfId != null) || (this.rfId != null && !this.rfId.equals(other.rfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sopra_project.entity.Employee[ rfId=" + rfId + " ]";
    }
    
}
