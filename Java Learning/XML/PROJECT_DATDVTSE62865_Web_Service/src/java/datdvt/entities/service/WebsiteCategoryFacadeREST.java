/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.entities.service;

import datdvt.entities.Category;
import datdvt.entities.WebsiteCategory;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path("datdvt.entities.websitecategory")
public class WebsiteCategoryFacadeREST extends AbstractFacade<WebsiteCategory> {

    @PersistenceContext(unitName = "PROJECT_DATDVTSE62865_Web_ServicePU")
    private EntityManager em;

    public WebsiteCategoryFacadeREST() {
        super(WebsiteCategory.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(WebsiteCategory entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, WebsiteCategory entity) {
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
    public WebsiteCategory find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<WebsiteCategory> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<WebsiteCategory> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("category-combination-url/{url}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public WebsiteCategory getWebsiteCategoryByUrl(@PathParam("url") String url) {
        String converturl = url.replace("*slash*", "/");
//                System.out.println("valueCa "+valueCategory);

//        try {
//            String value = new String(converturl.getBytes(), "UTF-8");
//            System.out.println("Value"+value);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(WebsiteCategoryFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
//        }
        String sql = "SELECT b FROM WebsiteCategory b WHERE b.url = :url";
        List<WebsiteCategory> list = getEntityManager().createQuery(sql, WebsiteCategory.class).setParameter("url", converturl)
                .getResultList();
        if (list != null && list.size() != 0 && list.get(0) != null) {
            return list.get(0);
        }
        return null;
    }

    @GET
    @Path("category-website/{website}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<WebsiteCategory> getWebsiteCategoryByWebsite(@PathParam("website") String website) {
        String sql = "SELECT b FROM WebsiteCategory b WHERE b.website like :website";
        List<WebsiteCategory> list = getEntityManager().createQuery(sql, WebsiteCategory.class).setParameter("website", "%" + website + "%")
                .getResultList();
        if (list != null && list.size() != 0) {
            return list;
        }
        return null;
    }


    @GET
    @Path("website-category-count")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getCount() {
        String sql = "SELECT MAX(p.id) FROM WebsiteCategory p";
        Object countObject = getEntityManager().createNativeQuery(sql).getSingleResult();
        if (countObject == null) {
            return String.valueOf(0);
        }
        return String.valueOf((int) countObject);
    }

    @GET
    @Path("website-category/category/{categoryid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<WebsiteCategory> getWebsiteCategoryByCategoryId(@PathParam("categoryid") int categoryid) {
        String sql = "SELECT b FROM WebsiteCategory b WHERE b.category = :id";
        List<WebsiteCategory> list = getEntityManager().createQuery(sql, WebsiteCategory.class).setParameter("id", new Category(categoryid))
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
