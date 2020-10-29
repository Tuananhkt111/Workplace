/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.entities.service;

import datdvt.entities.Color;
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
@Path("datdvt.entities.color")
public class ColorFacadeREST extends AbstractFacade<Color> {

    @PersistenceContext(unitName = "PROJECT_DATDVTSE62865_Web_ServicePU")
    private EntityManager em;

    public ColorFacadeREST() {
        super(Color.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Color entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Color entity) {
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
    public Color find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Color> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Color> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("color/{r}/{g}/{b}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Color getColorByRGB(@PathParam("r") int r, @PathParam("g") int g, @PathParam("b") int b) {
        String sql = "SELECT k FROM Color k WHERE k.r = :r AND k.g = :g AND k.b = :b";
        List<Color> list = getEntityManager().createQuery(sql, Color.class).setParameter("r", r).setParameter("g", g).setParameter("b", b)
                .getResultList();
        if (list != null && list.size() != 0 && list.get(0) != null) {
            return list.get(0);
        }
        return null;
    }

    @GET
    @Path("color/{r}/{g}/{b}/{deviation}/{accurate}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Color> getNearestColor(@PathParam("r") int r, @PathParam("g") int g, @PathParam("b") int b, @PathParam("deviation") int deviation, @PathParam("accurate") int accurate) {
        int valueRSubG1 = r - g + deviation;
        int valueRSubG2 = r - g - deviation;
        int valueRSubB1 = r - b + deviation;
        int valueRSubB2 = r - b - deviation;
        String sql = "SELECT k FROM Color k WHERE k.r-k.g<= :value1 AND k.r-k.g>=:value2 AND k.r-k.b<=:value3 AND k.r-k.b>=:value4";
        List<Color> list = getEntityManager().createQuery(sql, Color.class).setParameter("value1", valueRSubG1).setParameter("value2", valueRSubG2).setParameter("value3", valueRSubB1).setParameter("value4", valueRSubB2)
                .getResultList();
        String sql2 = "SELECT k FROM Color k WHERE (ABS(k.r-:r)<=:accurate AND ABS(k.g-:g)<=:deviration AND ABS(k.b-:b)<=:deviration) OR (ABS(k.r-:r)<=:deviration AND ABS(k.g-:g)<=:accurate AND ABS(k.b-:b)<=:deviration) OR (ABS(k.r-:r)<=:deviration AND ABS(k.g-:g)<=:deviration AND ABS(k.b-:b)<=:accurate)";
        List<Color> list2 = getEntityManager().createQuery(sql2, Color.class).setParameter("r", r).setParameter("g", g).setParameter("b", b).setParameter("accurate", accurate).setParameter("deviration", deviation)
                .getResultList();
        if (list2 != null){
            for (int i = 0; i < list2.size(); i++) {
                boolean flag=true;
                for (int j = 0; j < list.size(); j++) {
                    if (list2.get(i).getId()==list.get(j).getId()){
                        flag=false;
                    }
                }
                if (flag){
                    list.add(list2.get(i));
                }
            }
        }
        return list;
    }

    @GET
    @Path("color-count")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getCount() {
        String sql = "SELECT MAX(p.id) FROM Color p";
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
