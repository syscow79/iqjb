/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu;

import java.net.URI;
import java.util.List;
import javax.ws.rs.core.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

import oracle.iqjb.hu.pm.dm.Department;
import service.DepartmentServiceCDI;

/**
 * REST Web Service
 *
 * @author oracle
 */
@Path("/departmentservices")
@RequestScoped
public class DepartmentServicesResource {

    @Context
    private UriInfo context;
    
    @Inject
    private DepartmentServiceCDI departmentServiceCDI;

    public DepartmentServicesResource() {
    }

    @GET
    @Path(value = "/get/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getById(@PathParam("id") String id) {
        return Response.ok(departmentServiceCDI.getById(Long.parseLong(id))).build();
    }

    @GET
    @Path(value = "/get")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll() {
        GenericEntity entity = new GenericEntity<List<Department>>(departmentServiceCDI.getAll()){};
        return Response.ok(entity).build();
    }

    @POST
    @Path(value = "/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Department department) {
        department = departmentServiceCDI.add(department);
        URI uri = context.getAbsolutePathBuilder().path(department.getId().toString()).build();
        return  Response.created(uri).build();
    }

    @PUT
    @Path(value = "/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, Department department) {
        departmentServiceCDI.update(Long.parseLong(id), department);
        return Response.noContent().build();
    }
    
    
    @DELETE
    @Path(value = "/delete/{id}")
    public Response delete(@PathParam("id") String id) {
        departmentServiceCDI.delete(Long.parseLong(id));
        return Response.noContent().build();
    }
}
