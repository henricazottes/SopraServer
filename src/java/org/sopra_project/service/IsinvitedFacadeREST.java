/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.service;

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
import org.sopra_project.entity.Isinvited;
import org.sopra_project.entity.IsinvitedPK;

/**
 *
 * @author Henri
 */
@Stateless
@Path("org.sopra_project.entity.isinvited")
public class IsinvitedFacadeREST extends AbstractFacade<Isinvited> {

    @PersistenceContext(unitName = "Sopra_ServerPU")
    private EntityManager em;

    private IsinvitedPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;rfReservation=rfReservationValue;rfEmployee=rfEmployeeValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        org.sopra_project.entity.IsinvitedPK key = new org.sopra_project.entity.IsinvitedPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> rfReservation = map.get("rfReservation");
        if (rfReservation != null && !rfReservation.isEmpty()) {
            key.setRfReservation(new java.lang.Integer(rfReservation.get(0)));
        }
        java.util.List<String> rfEmployee = map.get("rfEmployee");
        if (rfEmployee != null && !rfEmployee.isEmpty()) {
            key.setRfEmployee(new java.lang.Integer(rfEmployee.get(0)));
        }
        return key;
    }

    public IsinvitedFacadeREST() {
        super(Isinvited.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Isinvited entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Isinvited entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        org.sopra_project.entity.IsinvitedPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Isinvited find(@PathParam("id") PathSegment id) {
        org.sopra_project.entity.IsinvitedPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Isinvited> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Isinvited> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
