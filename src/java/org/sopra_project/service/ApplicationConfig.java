/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sopra_project.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Henri
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.sopra_project.service.EmployeeFacadeREST.class);
        resources.add(org.sopra_project.service.EquipmentFacadeREST.class);
        resources.add(org.sopra_project.service.IsinvitedFacadeREST.class);
        resources.add(org.sopra_project.service.ReservationFacadeREST.class);
        resources.add(org.sopra_project.service.RoomEquipmentFacadeREST.class);
        resources.add(org.sopra_project.service.RoomFacadeREST.class);
        resources.add(org.sopra_project.service.Search.class);
        resources.add(org.sopra_project.service.SiteFacadeREST.class);
        resources.add(org.sopra_project.service.SlotFacadeREST.class);
    }
    
}
