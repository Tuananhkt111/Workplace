/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungth.ws.service;

import dungth.ws.TblRegistration;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tranh
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public TblRegistration checkLogin(String username, String password) {
        String jpql = "SELECT r FROM TblRegistration r WHERE r.username = :user "
                + "and r.password = :pass";
        TblRegistration regis = (TblRegistration) getEntityManager().createQuery(jpql).
                setParameter("user", username).
                setParameter("pass", password).
                getSingleResult();
        return regis;
    }

    public List<TblRegistration> findByLikeName(String search) {
        String jpql = "SELECT r FROM TblRegistration r WHERE r.fullname LIKE :fname";
        List<TblRegistration> list = getEntityManager().createQuery(jpql)
                .setParameter("fname", "%" + search + "%")
                .getResultList();
        return list;
    }
}
