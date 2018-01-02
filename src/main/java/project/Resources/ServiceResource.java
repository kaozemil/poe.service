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

@Path("service")
@Stateless
public class ServiceResource {

    @EJB
    private DBManager dbManager;

    @Path("boosting")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getBoosting() {
        if(!dbManager.em.createQuery("SELECT s FROM Service s", Service.class).getResultList().isEmpty()){
            return Response.status(Response.Status.OK).entity(dbManager.em.createQuery("")).build();
        } else {
            return Response.status(Response.Status.OK).entity("No boosting services listed").build();
        }
    }

    @Path("boosting")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createBoosting(JsonObject boosting){
        Service service = new Service();
        //TODO Set service property from Json object
        return null;
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
        if(!dbManager.em.createQuery("").getResultList().isEmpty()){
            return Response.status(Response.Status.OK).entity(dbManager.em.createQuery("")).build();
        } else {
            return Response.status(Response.Status.OK).entity("No teaming services listed").build();
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
        if(!dbManager.em.createQuery("").getResultList().isEmpty()){
            return Response.status(Response.Status.OK).entity(dbManager.em.createQuery("")).build();
        } else {
            return Response.status(Response.Status.OK).entity("No crafting services listed").build();
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
        if(!dbManager.em.createQuery("").getResultList().isEmpty()){
            return Response.status(Response.Status.OK).entity(dbManager.em.createQuery("")).build();
        } else {
            return Response.status(Response.Status.OK).entity("No rotation services listed").build();
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