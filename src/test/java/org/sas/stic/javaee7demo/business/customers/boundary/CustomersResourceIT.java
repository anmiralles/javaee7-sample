/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sas.stic.javaee7demo.business.customers.boundary;

import java.net.URL;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.sas.stic.javaee7demo.business.JAXRSConfiguration;
import org.sas.stic.javaee7demo.business.customers.entity.Customer;

/**
 *
 * @author angelmiralles
 */
@RunWith(Arquillian.class)
public class CustomersResourceIT {
    
    private static int customerId;
    
    @ArquillianResource
    private URL deployementURL;
     
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap
                .create(WebArchive.class, "javaee7-rest-test.war")
                .addClasses(ICustomersResource.class,CustomersResource.class, JAXRSConfiguration.class,Customers.class, Customer.class)
                .addAsWebInfResource("test-beans.xml", "beans.xml")
                .addAsWebInfResource("test-persistence-web.xml", "web.xml")
                .addAsWebInfResource("weblogic.xml", "weblogic.xml")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
    }
    
    @Test
    @InSequence(1)
    @RunAsClient
    public void testAdd(@ArquillianResteasyResource("resources") ICustomersResource customerResource) {

        // Customer definition for insert
        Customer cu = new Customer(Integer.SIZE, "Angel", "anmiralles@gmail.com", "676776360"
                , "Nuestra Senora de Regla", "SV", "41510");

        // Insert
        cu=customerResource.add(cu);
        customerId = cu.getId();

        // Get customer
        cu=customerResource.find(customerId);
        
        // Check customer inserted
        assertEquals("Angel", cu.getName());
        assertEquals("anmiralles@gmail.com", cu.getEmail());
        assertEquals("676776360", cu.getPhone());
    }

    @Test
    @InSequence(2)
    @RunAsClient
    public void testUpdate(@ArquillianResteasyResource("resources") ICustomersResource customerResource) {
        
        // Get customer object
        Customer cu=customerResource.find(customerId);
        
        // Update customer
        cu.setName("Lucho");
        customerResource.update(customerId,cu);
        
        // Check update
        cu=customerResource.find(customerId);
        assertEquals("Lucho",cu.getName());

    }

    @Test
    @InSequence(3)
    @RunAsClient
    public void testDelete(@ArquillianResteasyResource("resources") ICustomersResource customerResource) {

        // Delete customer
        customerResource.delete(customerId);
        
        // Check deletion
        assertNull(customerResource.find(customerId));
    }
}
