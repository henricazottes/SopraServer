/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.entity;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henri
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SlotIds {
    @XmlElement(name = "slot")
    private List<Integer> ids;
    // JAXB really requires a no-argument constructor...
    public SlotIds() {}
    // Convenience constructor to make the code cleaner...
    public SlotIds(List<Integer> input) {
        this.ids = input;
    }

    /**
     * @return the ids
     */
    public List<Integer> getIds() {
        return ids;
    }

    /**
     * @param ids the ids to set
     */
    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }  
}