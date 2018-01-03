package project.Resources;

import java.time.LocalDateTime;
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
        return getServiceResponse(serviceList);
    }

    @Path("boosting")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response createBoosting(JsonObject service){
        createServiceResponse(service);
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
        return getServiceResponse(serviceList);
    }

    @Path("teaming")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createTeaming(JsonObject service){
        createServiceResponse(service);
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
        return getServiceResponse(serviceList);
    }

    @Path("crafting")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createCrafting(JsonObject service){
        createServiceResponse(service);
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
        return getServiceResponse(serviceList);
    }

    @Path("rotation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createRotation(JsonObject service){
        createServiceResponse(service);
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
    
    public void createServiceResponse(JsonObject payload){
        Service service = new Service();
        service.setTitle(payload.getString("title"));
        service.setServiceType(payload.getString("serviceType"));
        service.setInGameName(payload.getString("inGameName"));
        service.setCreatedDate(payload.getString("createdDate"));
        dbManager.persistService(service);
    }
    
    public Response getServiceResponse(List<Service> serviceList){
        if(!serviceList.isEmpty()){
            return Response.status(Response.Status.OK).entity(serviceList).build();
        }else {
            return Response.status(Response.Status.OK).entity("No service found.").build();
        }
    }
    
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createTest(JsonObject payload) {
        Service service = new Service();
        service.setTitle(payload.getString("title"));
        service.setServiceType(payload.getString("serviceType"));
        service.setInGameName(payload.getString("inGameName"));
        service.setCreatedDate("2");
        service.setDate(LocalDateTime.now());
        dbManager.persistService(service);
        return Response.status(Response.Status.OK).entity(service).build();
    }
}
