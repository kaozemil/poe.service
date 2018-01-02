package project.Resources;

/**
 * Created by Emil on 2017-12-05.
 */

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("service")
@Stateless
public class UserService {

    @EJB
    private DBManager dbManager;


    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String isServerActingUp(){
        return "Test works";
    }

}
