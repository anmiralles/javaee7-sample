/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sas.stic.javaee7demo.business.customers.entity;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author angelmiralles
 */
@Stateless
public class MockCustomers {
    
    private static final Logger logger = Logger
            .getLogger(MockCustomers.class.getName());
    
    public Customer find(int customerId){
        logger.log(Level.INFO, "Mock get customer.");
        
        Customer customer = new Customer(Integer.SIZE, "Angel", "anmiralles@gmail.com", "676776360"
                , "Nuestra Senora de Regla", "SV", "41510");
        
        return customer;
    }
    
    public Customer add(Customer request){
        logger.log(Level.INFO, "Mock add customer.");
        
        return request;
    }

    public void update(Customer request){
        logger.log(Level.INFO, "Mock update customer.");
    }
    
    public void delete(Customer request){
        logger.log(Level.INFO, "Mock delete customer.");
    }
}
