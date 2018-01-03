package project.Resources;

/**
 * Created by Emil on 2017-12-05.
 */

import project.entities.Service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.JsonObject;
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
    public Response createBoosting(JsonObject service){
        createService(service);
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
        return Response.status(Response.Status.OK).build();
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
    public Response createTeaming(JsonObject service){
        createService(service);
        return Response.status(Response.Status.OK).build();
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
    public Response createCrafting(JsonObject service){
        createService(service);
        return Response.status(Response.Status.OK).build();
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
    public Response createRotation(JsonObject service){
        createService(service);
        return Response.status(Response.Status.OK).build();
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
    
    public void createService(JsonObject payload){
        Service service = new Service();
        service.setTitle(payload.getString("title"));
        service.setServiceType(payload.getString("serviceType"));
        service.setInGameName(payload.getString("inGameName"));
        service.setCreatedDate(payload.getString("createdDate"));
        dbManager.persistService(service);
    }
}
