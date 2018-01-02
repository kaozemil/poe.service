package project.Resources;

/**
 * Created by Emil on 2017-12-05.
 */

import project.entities.Service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("service")
@Stateless
public class ServiceResource {

    @EJB
    private DBManager dbManager;

    @Path("boosting")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getBoosting() {
        List<Service> serviceList = dbManager.getBoosting();
        if(!serviceList.isEmpty()){
            return Response.status(Response.Status.OK).entity(serviceList).build();
        }else {
            return Response.status(Response.Status.OK).entity("No boosting service found.").build();
        }
    }

    @Path("boosting")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response createBoosting(JsonObject boosting){
        Service service = new Service();
        service.setTitle(boosting.getString("title"));
        service.setServiceType("Boosting");
        service.setInGameName(boosting.getString("inGameName"));
        dbManager.em.persist(service);
        dbManager.em.flush();
        return Response.status(Response.Status.OK).build();
    }

    @Path("boosting")
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    public Response editBoosting(){

        return null;
    }

    @Path("boosting")
    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public Response deleteBoosting() {

        return null;
    }

    @Path("teaming")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getTeaming() {
        List<Service> serviceList = dbManager.getTeaming();
        if(!serviceList.isEmpty()){
            return Response.status(Response.Status.OK).entity(serviceList).build();
        }else {
            return Response.status(Response.Status.OK).entity("No teaming service found.").build();
        }
    }

    @Path("teaming")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createTeaming(JsonObject teaming){

        return null;
    }

    @Path("teaming")
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    public Response editTeaming(){

        return null;
    }

    @Path("teaming")
    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public Response deleteTeaming() {

        return null;
    }

    @Path("crafting")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getCrafting() {
        List<Service> serviceList = dbManager.getCrafting();
        if(!serviceList.isEmpty()){
            return Response.status(Response.Status.OK).entity(serviceList).build();
        }else {
            return Response.status(Response.Status.OK).entity("No crafting service found.").build();
        }
    }

    @Path("crafting")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createCrafting(JsonObject crafting){

        return null;
    }

    @Path("crafting")
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    public Response editCrafting(){

        return null;
    }

    @Path("crafting")
    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public Response deleteCrafting() {

        return null;
    }

    @Path("rotation")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getRotation() {
        List<Service> serviceList = dbManager.getRotation();
        if(!serviceList.isEmpty()){
            return Response.status(Response.Status.OK).entity(serviceList).build();
        }else {
            return Response.status(Response.Status.OK).entity("No rotation service found.").build();
        }
    }

    @Path("rotation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createRotation(JsonObject rotation){

        return null;
    }

    @Path("rotation")
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    public Response editRotation(){

        return null;
    }

    @Path("rotation")
    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public Response deleteRotation() {

        return null;
    }

}
