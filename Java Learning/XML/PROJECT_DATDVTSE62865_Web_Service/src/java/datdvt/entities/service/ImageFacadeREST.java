/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.entities.service;

import datdvt.entities.Color;
import datdvt.entities.Image;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Admin
 */
@Stateless
@Path("datdvt.entities.image")
public class ImageFacadeREST extends AbstractFacade<Image> {

    @PersistenceContext(unitName = "PROJECT_DATDVTSE62865_Web_ServicePU")
    private EntityManager em;

    public ImageFacadeREST() {
        super(Image.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Image entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Image entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Image find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Image> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Image> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("image-count")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getCount() {
        String sql = "SELECT MAX(p.id) FROM Image p";
        Object countObject = getEntityManager().createNativeQuery(sql).getSingleResult();
        if (countObject == null) {
            return String.valueOf(0);
        }
        return String.valueOf((int) countObject);
    }

    @GET
    @Path("image/color/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Image> getImagesByColorId(@PathParam("id") int id) {
        String sql = "SELECT b FROM Image b WHERE b.color = :id";
        List<Image> list = getEntityManager().createQuery(sql, Image.class).setParameter("id", new Color(id))
                .getResultList();
        if (list != null && list.size() != 0) {
            return list;
        }
        return null;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
