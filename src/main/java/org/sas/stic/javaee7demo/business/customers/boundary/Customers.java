/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sas.stic.javaee7demo.business.customers.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.sas.stic.javaee7demo.business.customers.entity.Customer;

/**
 *
 * @author angelmiralles
 */
@Stateless
public class Customers {
    
    @PersistenceContext
    EntityManager em;
        
    public Customer find(int customerId){
        return this.em.find(Customer.class, customerId);
    }
    
    public List<Customer> findAll(){
        return this.em.createNamedQuery("Customer.findAll").getResultList();
    }
    
    public Customer add(Customer request){
        return this.em.merge(request);
    }

    public void update(Customer request){
        this.em.merge(request);
    }
    
    public void delete(Customer request){
        this.em.remove(this.em.merge(request));
    }
    
}
