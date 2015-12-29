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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henri
 */
@Entity
@Table(name = "ISINVITED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Isinvited.findAll", query = "SELECT i FROM Isinvited i"),
    @NamedQuery(name = "Isinvited.findByRfReservation", query = "SELECT i FROM Isinvited i WHERE i.isinvitedPK.rfReservation = :rfReservation"),
    @NamedQuery(name = "Isinvited.findByRfEmployee", query = "SELECT i FROM Isinvited i WHERE i.isinvitedPK.rfEmployee = :rfEmployee")})
public class Isinvited implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IsinvitedPK isinvitedPK;
    @JoinColumn(name = "RF_EMPLOYEE", referencedColumnName = "RF_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumns({
        @JoinColumn(name="RF_SLOT", referencedColumnName="RF_ID"),
        @JoinColumn(name="RF_DAY", referencedColumnName="RF_DAY"),
        @JoinColumn(name="RF_ROOM", referencedColumnName="RF_ID")       
    })
    
    @OneToOne(optional = false)
    private Reservation reservation;

    public Isinvited() {
    }

    public Isinvited(IsinvitedPK isinvitedPK) {
        this.isinvitedPK = isinvitedPK;
    }

    public Isinvited(int rfReservation, int rfEmployee) {
        this.isinvitedPK = new IsinvitedPK(rfReservation, rfEmployee);
    }

    public IsinvitedPK getIsinvitedPK() {
        return isinvitedPK;
    }

    public void setIsinvitedPK(IsinvitedPK isinvitedPK) {
        this.isinvitedPK = isinvitedPK;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isinvitedPK != null ? isinvitedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Isinvited)) {
            return false;
        }
        Isinvited other = (Isinvited) object;
        if ((this.isinvitedPK == null && other.isinvitedPK != null) || (this.isinvitedPK != null && !this.isinvitedPK.equals(other.isinvitedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sopra_project.entity.Isinvited[ isinvitedPK=" + isinvitedPK + " ]";
    }
    
}
