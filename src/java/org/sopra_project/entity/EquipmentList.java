/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henri
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EquipmentList {
    @XmlElement(name = "equipment")
    private List<String> equipments;
    
    public EquipmentList(){}
    
    public EquipmentList(List<String> equipments){
        this.equipments = equipments;
    }

    /**
     * @return the equipments
     */
    public List<String> getEquipments() {
        return equipments;
    }

    /**
     * @param equipments the equipments to set
     */
    public void setEquipments(List<String> equipments) {
        this.equipments = equipments;
    }
    
    
}
