/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.sopra_project.entity.RoomIds;
import org.sopra_project.entity.Slot;
import org.sopra_project.entity.SlotIds;

/**
 *
 * @author Henri
 */
@Stateless
@Path("slot")
public class SlotFacadeREST extends AbstractFacade<Slot> {

    @PersistenceContext(unitName = "Sopra_ServerPU")
    private EntityManager em;

    public SlotFacadeREST() {
        super(Slot.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Slot entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Slot entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Slot find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("find")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    
    // Url look like http://appname/webresources/find?room=X&day=Y
    
    public SlotIds findBis(@QueryParam("room") Integer room, @QueryParam("day") String day) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
        Date date = new Date();
        try {
            date = format.parse(day);
        } catch (ParseException ex) {
            Logger.getLogger(SlotFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(date);
        
        Query myQuery = em.createQuery("SELECT s.rfId FROM Slot s WHERE s.rfId IN ("
                + "SELECT r.reservationPK.rfSlot FROM Reservation r WHERE "
                + "r.reservationPK.rfDay = :day "
                + "AND r.reservationPK.rfRoom = :room)")
                .setParameter("room", room)
                .setParameter("day", date);
        
        /***
         * Run and return the result as a XML list of Room IDs
         */
        return new SlotIds(myQuery.getResultList());
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Slot> findAll() {
        return super.findAll();
    }

    @GET
    @Path("range/{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Slot> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
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
