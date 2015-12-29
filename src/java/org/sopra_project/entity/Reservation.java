/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henri
 */
@Entity
@Table(name = "RESERVATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findByRfId", query = "SELECT r FROM Reservation r WHERE r.rfId = :rfId"),
    @NamedQuery(name = "Reservation.findByRfEmployeeowner", query = "SELECT r FROM Reservation r WHERE r.rfEmployeeowner = :rfEmployeeowner"),
    @NamedQuery(name = "Reservation.findByRfRoom", query = "SELECT r FROM Reservation r WHERE r.reservationPK.rfRoom = :rfRoom"),
    @NamedQuery(name = "Reservation.findByRfDay", query = "SELECT r FROM Reservation r WHERE r.reservationPK.rfDay = :rfDay"),
    @NamedQuery(name = "Reservation.findByRfSlot", query = "SELECT r FROM Reservation r WHERE r.reservationPK.rfSlot = :rfSlot")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservationPK reservationPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RF_ID")
    private int rfId;
    @Column(name = "RF_EMPLOYEEOWNER")
    private Integer rfEmployeeowner;
    @JoinColumn(name = "RF_SLOT", referencedColumnName = "RF_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Slot slot;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "reservation")
    private Isinvited isinvited;

    public Reservation() {
    }

    public Reservation(ReservationPK reservationPK) {
        this.reservationPK = reservationPK;
    }

    public Reservation(ReservationPK reservationPK, int rfId) {
        this.reservationPK = reservationPK;
        this.rfId = rfId;
    }

    public Reservation(int rfRoom, Date rfDay, int rfSlot) {
        this.reservationPK = new ReservationPK(rfRoom, rfDay, rfSlot);
    }

    public ReservationPK getReservationPK() {
        return reservationPK;
    }

    public void setReservationPK(ReservationPK reservationPK) {
        this.reservationPK = reservationPK;
    }

    public int getRfId() {
        return rfId;
    }

    public void setRfId(int rfId) {
        this.rfId = rfId;
    }

    public Integer getRfEmployeeowner() {
        return rfEmployeeowner;
    }

    public void setRfEmployeeowner(Integer rfEmployeeowner) {
        this.rfEmployeeowner = rfEmployeeowner;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Isinvited getIsinvited() {
        return isinvited;
    }

    public void setIsinvited(Isinvited isinvited) {
        this.isinvited = isinvited;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationPK != null ? reservationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.reservationPK == null && other.reservationPK != null) || (this.reservationPK != null && !this.reservationPK.equals(other.reservationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sopra_project.entity.Reservation[ reservationPK=" + reservationPK + " ]";
    }
    
}
