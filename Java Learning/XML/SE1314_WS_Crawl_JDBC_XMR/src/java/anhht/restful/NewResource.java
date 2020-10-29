/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhht.restful;

import anhht.daos.NewDAO;
import anhht.dtos.NewDTO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author tuana
 */
@Path("generic")
public class NewResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NewResource
     */
    public NewResource() {
    }

    /**
     * Retrieves representation of an instance of anhht.restful.NewResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of NewResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @GET
    @Path("/findByLikeTitle")
    @Produces(MediaType.APPLICATION_XML)
    public List<NewDTO> findByLikeTitle(@QueryParam("title") String search) {
        List<NewDTO> list = null;
        try {
            NewDAO dao = new NewDAO();
            list = dao.findByLikeTitle(search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
