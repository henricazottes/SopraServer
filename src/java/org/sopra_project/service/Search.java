/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.service;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import org.sopra_project.entity.Request;
import org.sopra_project.entity.Room;
import org.sopra_project.entity.RoomIds;

/**
 *
 * @author Henri
 */
@Stateless
@Path("search")
public class Search{

    @PersistenceContext(unitName = "Sopra_ServerPU")
    private EntityManager em;

    @POST   
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Room> returnRequest(Request input) { 
        
        /****
         * Set the SQL conditions for each attribute of the search
         ***/
        
        String nameCond = "r.rfName LIKE :name";
        String siteCond = "r.rfSite.rfName LIKE :site";
        String sizeCond = "r.rfSize >= :size";
        String reservationCond = "r.rfId NOT IN (SELECT r.reservationPK.rfRoom FROM Reservation r WHERE r.reservationPK.rfDay = :day AND r.reservationPK.rfSlot BETWEEN :startSlot AND :endSlot)";
        
        // Parse the equipment list to format ('eq1', 'eq2', 'eq3', ...)
        String eqList = "('')";
        if(input.getEquipments().size() > 0){
            eqList = "(";
            for(String eq : input.getEquipments()){
                eqList += "'" + eq + "',";            
            }        
            eqList = eqList.substring(0, eqList.length()-1) + ")";
        }
        
        String equipmentsCond = "((SELECT COUNT(re.roomEquipmentPK.rfRoom) From RoomEquipment re WHERE re.roomEquipmentPK.rfRoom = r.rfId AND re.roomEquipmentPK.rfEquipment IN " + eqList + ") = " + input.getEquipments().size();
                     
             
        /***
         * Create the JDB query to retrieve all room IDs passing all conditions
         ***/
        
        Query myQuery = em.createQuery("SELECT r FROM Room r WHERE "
                + nameCond
                + " AND " + siteCond
                + " AND " + sizeCond
                + " AND " + reservationCond
                + " AND " + equipmentsCond
                + ")")
                .setParameter("name", input.getName())
                .setParameter("site", input.getSite())
                .setParameter("size", input.getSize())
                .setParameter("day", input.getDay())
                .setParameter("startSlot", input.getStartSlot())
                .setParameter("endSlot", input.getEndSlot());
        
        /***
         * Run and return the result as a XML list of Room IDs
         */
        return myQuery.getResultList();        
    }
    
    
    @GET
    @Path("roomByName/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Room> findByName(@PathParam("name") String name) {
        return em.createNamedQuery("Room.findByRfName")
            .setParameter("rfName", name)
            .getResultList(); 
    }  
    
    // use LIKE '%' to match any string
      
}
