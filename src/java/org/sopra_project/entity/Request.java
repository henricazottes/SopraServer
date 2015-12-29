/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Henri
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
/*@XmlType(propOrder = {
    "name",
    "equipmentList",
    "startSlot",
    "endSlot",
    "size",
    "site"
})*/
public class Request {
    @XmlElement(name = "name")
    private String name;
    @XmlElementWrapper(name="equipmentList")
    @XmlElement(name = "equipment")
    private List<String> equipments;
    @XmlElement(name = "day")
    private Date day;
    @XmlElement(name = "startSlot")
    private int startSlot;
    @XmlElement(name = "endSlot")
    private int endSlot;
    @XmlElement(name = "size")
    private int size;
    @XmlElement(name = "site")
    private String site;
    
    public Request(){
        this.name = "%";
        this.equipments = new ArrayList<String>();
        Calendar now = Calendar.getInstance();
        this.day = new Date();
        this.startSlot =  now.get(Calendar.HOUR_OF_DAY)*2 + (int) Math.floor(now.get(Calendar.MINUTE)/30) + 1;
        this.endSlot = startSlot + 1;
        this.size = 0;
        this.site = "%";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
    public void setEquipments(ArrayList<String> equipments) {
        for(String eq : equipments){
            this.equipments.add(eq);
        }
    }

    /**
     * @return the startSlot
     */
    public int getStartSlot() {
        return startSlot;
    }

    /**
     * @param startSlot the startSlot to set
     */
    public void setStartSlot(int startSlot) {
        this.startSlot = startSlot;
    }

    /**
     * @return the endSlot
     */
    public int getEndSlot() {
        return endSlot;
    }

    /**
     * @param endSlot the endSlot to set
     */
    public void setEndSlot(int endSlot) {
        this.endSlot = endSlot;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the site
     */
    public String getSite() {
        return site;
    }

    /**
     * @param site the site to set
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * @return the day
     */
    public Date getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(Date day) {
        this.day = day;
    }
    
    
}
