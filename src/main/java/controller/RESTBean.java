package controller;

import domain.Profile;
import service.DemoService;
import util.JsonConverter;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by sguldemond on 15/02/2018.
 */
@Stateless
@Path("/")
public class RESTBean {

    private DemoService demoService;

    public RESTBean() {
        demoService = new DemoService();
        demoService.addProfile(new Profile("stan", "nieuw profiel"));
        demoService.addProfile(new Profile("gera", "ook een nieuw profiel"));
    }

    @GET
    @Produces("text/plain")
    public String getDemoText() {
        return "This is a REST service using JAX-RS by Stan Guldemond";
    }

    @GET
    @Path("/echo/{param}")
    public Response getMessage(@PathParam("param") String msg) {
        String output = "Echo: " + msg;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/add/{username}/{description}")
    @Produces(MediaType.APPLICATION_JSON)
    public String create(@PathParam("username") String username, @PathParam("description") String description) {
        return createProfile(username, description);
    }

    /**
     * e.g. .../add;username=doerak;desc=hond
     */
    @GET
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public String create2(@MatrixParam("username") String username, @MatrixParam("desc") String description) {
        return createProfile(username, description);
    }

    private String createProfile(String username, String description) {
        Profile newProfile = new Profile(username, description);
        demoService.addProfile(newProfile);
        return "{\"status\": \"new profile added\"}";
    }

    @GET
    @Path("/find/{username}")
    public String findProfile(@PathParam("username") String input) {
        String jsonResponse = JsonConverter.convertToJson(demoService.find(input));
        return jsonResponse;
    }

    @GET
    @Path("/get/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile getProfile(@PathParam("username") String input) {
        return demoService.find(input);
    }

    @GET
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getAllProfiles() {
        return demoService.getProfiles();
    }

    @POST
    @Consumes("text/plain")
    public void postMessage(String message) {
        System.out.println("Message: " + message);
    }


}
