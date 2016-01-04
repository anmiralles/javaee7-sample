/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sas.stic.javaee7demo.business.security.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.sas.stic.javaee7demo.business.security.entity.User;

/**
 *
 * @author angelmiralles
 */
@Stateless
public class Users {
    
    @PersistenceContext
    EntityManager em;
    
    public User find(int userId){
        return this.em.find(User.class, userId);
    }
    
    public List<User> findAll(){
        return this.em.createNamedQuery("User.findAll").getResultList();
    }
    
    public User findByUser(String username){
        return (User)this.em.createNamedQuery("User.findByUser").setParameter("user", username).getSingleResult();
    }
    
    public void add(User user){
        this.em.merge(user);
    }
    
    public void delete(User user){
        user = this.em.merge(user);
        this.em.remove(user);
    }
    
}
