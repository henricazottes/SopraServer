/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.xml.bind.annotation.XmlRootElement;
import org.sopra_project.entity.Equipment;
import org.sopra_project.entity.Room;
import org.sopra_project.entity.RoomEquipment;
import org.sopra_project.entity.RoomEquipmentPK;
import org.sopra_project.entity.RoomIds;

/**
 *
 * @author Henri
 */
@Stateless
@Path("roomequipment")
public class RoomEquipmentFacadeREST extends AbstractFacade<RoomEquipment> {

    @PersistenceContext(unitName = "Sopra_ServerPU")
    private EntityManager em;

    private RoomEquipmentPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;rfRoom=rfRoomValue;rfEquipment=rfEquipmentValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        org.sopra_project.entity.RoomEquipmentPK key = new org.sopra_project.entity.RoomEquipmentPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> rfRoom = map.get("rfRoom");
        if (rfRoom != null && !rfRoom.isEmpty()) {
            key.setRfRoom(new java.lang.Integer(rfRoom.get(0)));
        }
        java.util.List<String> rfEquipment = map.get("rfEquipment");
        if (rfEquipment != null && !rfEquipment.isEmpty()) {
            key.setRfEquipment(rfEquipment.get(0));
        }
        return key;
    }

    public RoomEquipmentFacadeREST() {
        super(RoomEquipment.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(RoomEquipment entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, RoomEquipment entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        org.sopra_project.entity.RoomEquipmentPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public RoomEquipment find(@PathParam("id") PathSegment id) {
        org.sopra_project.entity.RoomEquipmentPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RoomEquipment> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RoomEquipment> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @GET
    @Path("byRoom/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RoomEquipment> findByRoomId(@PathParam("id") int id) {
        return em.createNamedQuery("RoomEquipment.findByRfRoom")
            .setParameter("rfRoom", id)
            .getResultList();            
    }
    
    @GET
    @Path("byEquipment/{equipment}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
    public List<Room> findByEquipmentName(@PathParam("equipment") String equipment) {
        return em.createNamedQuery("RoomEquipment.findByRfEquipment")
            .setParameter("rfEquipment", equipment)
            .getResultList();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
