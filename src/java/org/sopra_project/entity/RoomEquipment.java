/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henri
 */
@Entity
@Table(name = "ROOM_EQUIPMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomEquipment.findAll", query = "SELECT r FROM RoomEquipment r"),
    @NamedQuery(name = "RoomEquipment.findByRfRoom", query = "SELECT r FROM RoomEquipment r WHERE r.roomEquipmentPK.rfRoom = :rfRoom"),
    @NamedQuery(name = "RoomEquipment.findByRfEquipment", query = "SELECT r FROM RoomEquipment r WHERE r.roomEquipmentPK.rfEquipment = :rfEquipment")})
public class RoomEquipment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoomEquipmentPK roomEquipmentPK;
    @JoinColumn(name = "RF_EQUIPMENT", referencedColumnName = "RF_NAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipment equipment;
    public RoomEquipment() {
    }

    public RoomEquipment(RoomEquipmentPK roomEquipmentPK) {
        this.roomEquipmentPK = roomEquipmentPK;
    }

    public RoomEquipment(int rfRoom, String rfEquipment) {
        this.roomEquipmentPK = new RoomEquipmentPK(rfRoom, rfEquipment);
    }

    public RoomEquipmentPK getRoomEquipmentPK() {
        return roomEquipmentPK;
    }

    public void setRoomEquipmentPK(RoomEquipmentPK roomEquipmentPK) {
        this.roomEquipmentPK = roomEquipmentPK;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomEquipmentPK != null ? roomEquipmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomEquipment)) {
            return false;
        }
        RoomEquipment other = (RoomEquipment) object;
        if ((this.roomEquipmentPK == null && other.roomEquipmentPK != null) || (this.roomEquipmentPK != null && !this.roomEquipmentPK.equals(other.roomEquipmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sopra_project.entity.RoomEquipment[ roomEquipmentPK=" + roomEquipmentPK + " ]";
    }
    
}
