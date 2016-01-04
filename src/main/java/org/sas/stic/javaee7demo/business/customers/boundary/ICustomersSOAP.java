/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sas.stic.javaee7demo.business.customers.boundary;

import java.util.List;
import javax.jws.WebService;
import org.sas.stic.javaee7demo.business.customers.entity.Customer;

/**
 *
 * @author angelmiralles
 */
@WebService
public interface ICustomersSOAP {
    public List<Customer> findAll();
}
