/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sas.stic.javaee7demo.business.customers.boundary;

import java.util.List;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.sas.stic.javaee7demo.business.customers.entity.Customer;

/**
 *
 * @author angelmiralles
 */
@WebService(endpointInterface = "org.sas.stic.javaee7demo.business.customers.boundary.CustomersSOAP",
            targetNamespace = "org.sas.stic.javaee7demo",
            serviceName = "CustomersService")
public class CustomersSOAP {
    
    @Inject
    Customers customers;
    
    public List<Customer> findAll(){
        return customers.findAll();
    }
}