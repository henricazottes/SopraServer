/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.entity;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henri
 */
@XmlRootElement(name = "roomids")
public class RoomIds {
    @XmlElement
    public ArrayList<String> ids;
    // JAXB really requires a no-argument constructor...
    public RoomIds() {}
    // Convenience constructor to make the code cleaner...
    public RoomIds(ArrayList<String> ids) {
        this.ids = ids;
    }
}