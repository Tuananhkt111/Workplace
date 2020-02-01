/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanhpc.models;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import thanhpc.demo.Registration;

/**
 *
 * @author NaNoPham
 */
public class RegistrationDAO implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Seminar_JPA_WebPU");
    EntityManager em = emf.createEntityManager();

    public RegistrationDAO() {
    }

    public void persist(Object object) {
        //EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public String checkLogin(String username, String password) throws Exception {
        String role = "failed";
        try {
            Registration regis = em.find(Registration.class, username);
            if (regis.getPassword().equals(password)) {
                role = regis.getRole();
            }
        } finally {
            em.close();
        }
        return role;
    }

    public List<Registration> findByLikeName(String search) throws Exception {
        List<Registration> result = null;
        try {
            String jpql = "SELECT r FROM Registration r WHERE r.fullname LIKE :searchName";
            result = em.createQuery(jpql)
                    .setParameter("searchName", "%" + search + "%")
                    .getResultList();
        } finally {
            em.close();
        }
        return result;
    }

    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            em.getTransaction().begin();
            Registration regis = em.find(Registration.class, id);
            em.remove(regis);
            em.getTransaction().commit();
            check = true;
        } finally {
            em.close();
        }
        return check;
    }

    public boolean insert(Registration dto) throws Exception {
        persist(dto);
        return true;
    }
    
    public boolean update(Registration dto) throws Exception {
        boolean check = false;
        try {
            em.getTransaction().begin();
            Registration regis = em.find(Registration.class, dto.getUsername());
            regis.setFullname(dto.getFullname());
            regis.setRole(dto.getRole());
            em.merge(regis);
            em.getTransaction().commit();
            check = true;
        } finally {
            em.close();
        }
        return check;
    }

}
