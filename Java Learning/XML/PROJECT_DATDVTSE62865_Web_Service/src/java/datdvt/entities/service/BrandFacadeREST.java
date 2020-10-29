/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.entities.service;

import datdvt.entities.Brand;
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
@Path("datdvt.entities.brand")
public class BrandFacadeREST extends AbstractFacade<Brand> {

    @PersistenceContext(unitName = "PROJECT_DATDVTSE62865_Web_ServicePU")
    private EntityManager em;

    public BrandFacadeREST() {
        super(Brand.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Brand entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Brand entity) {
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
    public Brand find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Brand> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Brand> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
 @GET
    @Path("brand-name/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Brand getBrandByName(@PathParam("name") String name) {
        String sql = "SELECT b FROM Brand b WHERE b.name = :name";
        List<Brand> list = getEntityManager().createQuery(sql, Brand.class).setParameter("name", name)
                .getResultList();
        if (list != null && list.size() != 0 && list.get(0) != null) {
            return list.get(0);
        }
        return null;
    }

    @GET
    @Path("brand-count")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getCount() {
        String sql = "SELECT MAX(p.id) FROM Brand p";
        Object countObject = getEntityManager().createNativeQuery(sql).getSingleResult();
        if (countObject == null) {
            return String.valueOf(0);
        }
        return String.valueOf((int) countObject);
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
