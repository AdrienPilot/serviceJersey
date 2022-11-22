package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.Map;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
    static Map<String, Integer> nameOccurence = new HashMap<>();
    @Context
    UriInfo uriInfo;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("name") String name) {
        if (name == null) {
            return "Aucun paramètre";
        }
        if (nameOccurence.containsKey(name)) {
            nameOccurence.put(name, nameOccurence.get(name) + 1);
            String str =  name + " " + nameOccurence.get(name) + " occurence(s)";
            return str;
        } else {
            nameOccurence.put(name, 1);
            return name;
        }
    }
}
