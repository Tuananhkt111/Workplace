/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.entities.service;

import datdvt.entities.Product;
import datdvt.entities.WebsiteCategory;
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
@Path("datdvt.entities.product")
public class ProductFacadeREST extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "PROJECT_DATDVTSE62865_Web_ServicePU")
    private EntityManager em;

    public ProductFacadeREST() {
        super(Product.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Product entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Product entity) {
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
    public Product find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Product> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Product> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("product-name/{url}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Product getProductByUrl(@PathParam("url") String url) {
        String sql = "SELECT b FROM Product b WHERE b.url = :url";
        String converturl = url.replace("*slash*", "/");
        List<Product> list = getEntityManager().createQuery(sql, Product.class).setParameter("url", converturl)
                .getResultList();
        if (list != null && list.size() != 0 && list.get(0) != null) {
            return list.get(0);
        }
        return null;
    }

    @GET
    @Path("product-count")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getCount() {
        String sql = "SELECT MAX(p.id) FROM Product p";
        Object countObject = getEntityManager().createNativeQuery(sql).getSingleResult();
        if (countObject == null) {
            return String.valueOf(0);
        }
        return String.valueOf((int) countObject);
    }

    @GET
    @Path("product/website-category/{categoryid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Product> getProductsByCategoryId(@PathParam("categoryid") int categoryid) {
        String sql = "SELECT b FROM Product b WHERE b.websiteCategory = :id";
        List<Product> list = getEntityManager().createQuery(sql, Product.class).setParameter("id", new WebsiteCategory(categoryid))
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
