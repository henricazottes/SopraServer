/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Henri
 */
@Embeddable
public class RoomEquipmentPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "RF_ROOM")
    private int rfRoom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RF_EQUIPMENT")
    private String rfEquipment;

    public RoomEquipmentPK() {
    }

    public RoomEquipmentPK(int rfRoom, String rfEquipment) {
        this.rfRoom = rfRoom;
        this.rfEquipment = rfEquipment;
    }

    public int getRfRoom() {
        return rfRoom;
    }

    public void setRfRoom(int rfRoom) {
        this.rfRoom = rfRoom;
    }

    public String getRfEquipment() {
        return rfEquipment;
    }

    public void setRfEquipment(String rfEquipment) {
        this.rfEquipment = rfEquipment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rfRoom;
        hash += (rfEquipment != null ? rfEquipment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomEquipmentPK)) {
            return false;
        }
        RoomEquipmentPK other = (RoomEquipmentPK) object;
        if (this.rfRoom != other.rfRoom) {
            return false;
        }
        if ((this.rfEquipment == null && other.rfEquipment != null) || (this.rfEquipment != null && !this.rfEquipment.equals(other.rfEquipment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sopra_project.entity.RoomEquipmentPK[ rfRoom=" + rfRoom + ", rfEquipment=" + rfEquipment + " ]";
    }
    
}
