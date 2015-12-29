/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Henri
 */
@Embeddable
public class ReservationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "RF_ROOM")
    private int rfRoom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RF_DAY")
    @Temporal(TemporalType.DATE)
    private Date rfDay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RF_SLOT")
    private int rfSlot;

    public ReservationPK() {
    }

    public ReservationPK(int rfRoom, Date rfDay, int rfSlot) {
        this.rfRoom = rfRoom;
        this.rfDay = rfDay;
        this.rfSlot = rfSlot;
    }

    public int getRfRoom() {
        return rfRoom;
    }

    public void setRfRoom(int rfRoom) {
        this.rfRoom = rfRoom;
    }

    public Date getRfDay() {
        return rfDay;
    }

    public void setRfDay(Date rfDay) {
        this.rfDay = rfDay;
    }

    public int getRfSlot() {
        return rfSlot;
    }

    public void setRfSlot(int rfSlot) {
        this.rfSlot = rfSlot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rfRoom;
        hash += (rfDay != null ? rfDay.hashCode() : 0);
        hash += (int) rfSlot;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationPK)) {
            return false;
        }
        ReservationPK other = (ReservationPK) object;
        if (this.rfRoom != other.rfRoom) {
            return false;
        }
        if ((this.rfDay == null && other.rfDay != null) || (this.rfDay != null && !this.rfDay.equals(other.rfDay))) {
            return false;
        }
        if (this.rfSlot != other.rfSlot) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sopra_project.entity.ReservationPK[ rfRoom=" + rfRoom + ", rfDay=" + rfDay + ", rfSlot=" + rfSlot + " ]";
    }
    
}
