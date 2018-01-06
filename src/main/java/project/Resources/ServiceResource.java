package project.Resources;

import java.time.LocalDateTime;
import project.entities.Service;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("service")
@Stateless
public class ServiceResource {

    @EJB
    private DBManager dbManager;

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getService(@QueryParam("serviceType") String serviceType, @QueryParam("league") String league) {
        List<Service> serviceList = dbManager.getServiceList(serviceType, league);
        return getServiceResponse(serviceList);
    }
    
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createService(JsonObject service){
        createServiceResponse(service);
        return Response.status(Response.Status.OK).build();
    }
    
    public void createServiceResponse(JsonObject payload){
        Service service = new Service();
        service.setTitle(payload.getString("title"));
        service.setServiceType(payload.getString("serviceType"));
        service.setInGameName(payload.getString("inGameName"));
        service.setLeague(payload.getString("league"));
        service.setremoveDate(LocalDateTime.now().plusMinutes(payload.getInt("removeDate")));
        dbManager.persistService(service);
    }
    
    public Response getServiceResponse(List<Service> serviceList){
        if(!serviceList.isEmpty()){
            return Response.status(Response.Status.OK).entity(serviceList).build();
        }else {
            return Response.status(Response.Status.OK).entity("No service found.").build();
        }
    }
}
