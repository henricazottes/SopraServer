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
@Table(name = "SLOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Slot.findAll", query = "SELECT s FROM Slot s"),
    @NamedQuery(name = "Slot.findByRfId", query = "SELECT s FROM Slot s WHERE s.rfId = :rfId"),
    @NamedQuery(name = "Slot.findByRfName", query = "SELECT s FROM Slot s WHERE s.rfName = :rfName")})
public class Slot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RF_ID")
    private Integer rfId;
    @Size(max = 15)
    @Column(name = "RF_NAME")
    private String rfName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "slot")
    private Collection<Reservation> reservationCollection;

    public Slot() {
    }

    public Slot(Integer rfId) {
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

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
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
        if (!(object instanceof Slot)) {
            return false;
        }
        Slot other = (Slot) object;
        if ((this.rfId == null && other.rfId != null) || (this.rfId != null && !this.rfId.equals(other.rfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sopra_project.entity.Slot[ rfId=" + rfId + " ]";
    }
    
}
