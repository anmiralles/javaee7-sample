/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sas.stic.javaee7demo.business.customers.boundary;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.sas.stic.javaee7demo.business.customers.entity.Customer;
import org.sas.stic.javaee7demo.business.customers.entity.MockCustomers;

/**
 *
 * @author angelmiralles
 */
@RunWith(Arquillian.class)
public class CustomersTest {
    
    @Inject
    MockCustomers cus;
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap
                .create(WebArchive.class, "customers-unit-test.war")
                .addClasses(MockCustomers.class, Customer.class)
                .addAsWebInfResource("test-beans.xml", "beans.xml");
    }
    
    @Test
    @InSequence(1)
    public void testAdd() {
        
        Customer customer = new Customer(Integer.SIZE, "Angel", "anmiralles@gmail.com", "676776360"
                , "Nuestra Senora de Regla", "SV", "41510");
        
        customer = this.cus.add(customer);
        
        customer = this.cus.find(1);
                
        assertEquals("Angel", customer.getName());
        assertEquals("anmiralles@gmail.com", customer.getEmail());
        assertEquals("676776360", customer.getPhone());
    }
    
    @Test
    @InSequence(2)
    public void testUpdate() {
        Customer customer = this.cus.find(1);
        customer.setName("Javi");
        this.cus.update(customer);
        
        customer = this.cus.find(1);

        assertEquals("Angel", customer.getName());
    }
    
    @Test
    @InSequence(3)
    public void testDelete() {
        Customer customer = this.cus.find(1);
        this.cus.delete(customer);
        
        //assertNull(this.cus.find(1));
    }
    
}
