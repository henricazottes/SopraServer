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

/**
 *
 * @author Henri
 */
@Embeddable
public class IsinvitedPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "RF_RESERVATION")
    private int rfReservation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RF_EMPLOYEE")
    private int rfEmployee;

    public IsinvitedPK() {
    }

    public IsinvitedPK(int rfReservation, int rfEmployee) {
        this.rfReservation = rfReservation;
        this.rfEmployee = rfEmployee;
    }

    public int getRfReservation() {
        return rfReservation;
    }

    public void setRfReservation(int rfReservation) {
        this.rfReservation = rfReservation;
    }

    public int getRfEmployee() {
        return rfEmployee;
    }

    public void setRfEmployee(int rfEmployee) {
        this.rfEmployee = rfEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rfReservation;
        hash += (int) rfEmployee;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IsinvitedPK)) {
            return false;
        }
        IsinvitedPK other = (IsinvitedPK) object;
        if (this.rfReservation != other.rfReservation) {
            return false;
        }
        if (this.rfEmployee != other.rfEmployee) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sopra_project.entity.IsinvitedPK[ rfReservation=" + rfReservation + ", rfEmployee=" + rfEmployee + " ]";
    }
    
}
