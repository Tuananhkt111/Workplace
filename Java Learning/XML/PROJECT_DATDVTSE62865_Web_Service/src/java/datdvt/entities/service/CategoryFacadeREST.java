/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.entities.service;

import datdvt.entities.Category;
import datdvt.entities.Product;
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
@Path("datdvt.entities.category")
public class CategoryFacadeREST extends AbstractFacade<Category> {

    @PersistenceContext(unitName = "PROJECT_DATDVTSE62865_Web_ServicePU")
    private EntityManager em;

    public CategoryFacadeREST() {
        super(Category.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Category entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Category entity) {
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
    public Category find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Category> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Category> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("category-name/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Category getCategoryByName(@PathParam("name") String name) {
        String sql = "SELECT b FROM Category b WHERE b.name = :name";
        List<Category> list = getEntityManager().createQuery(sql, Category.class).setParameter("name", name)
                .getResultList();
        if (list != null && list.size() != 0 && list.get(0) != null) {
            return list.get(0);
        }
        return null;
    }

    @GET
    @Path("product-name/{priority}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Category> getCategoryByPriority(@PathParam("priority") int priority) {
        String sql = "SELECT b FROM Category b WHERE b.levelAuth = :priority";
        List<Category> list = getEntityManager().createQuery(sql, Category.class).setParameter("priority", priority)
                .getResultList();
        if (list != null && list.size() != 0 && list.get(0) != null) {
            return list;
        }
        return null;
    }

    @GET
    @Path("category-count")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getCount() {
        String sql = "SELECT MAX(p.id) FROM Category p";
        int count = (int) getEntityManager().createNativeQuery(sql).getSingleResult();
        System.out.println("Count" + count);
        return String.valueOf(count);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
