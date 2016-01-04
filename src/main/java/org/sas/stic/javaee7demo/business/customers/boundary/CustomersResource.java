package org.sas.stic.javaee7demo.business.customers.boundary;

import org.sas.stic.javaee7demo.business.customers.entity.Customer;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Created by lucho on 13/11/15.
 */
@Stateless
public class CustomersResource implements ICustomersResource {
    
    @Inject
    Customers customers;

    @Override
    public List<Customer> findAll() {
        return customers.findAll();
    }

    @Override
    public Customer find(@PathParam("id") int customerId) {
        return customers.find(customerId);
    }

    @Override
    public Customer add(Customer request) {
        return customers.add(request);
    }

    @Override
    public void update(@PathParam("id") int customerId, Customer cu) {
        customers.update(cu);
    }

    @Override
    public void delete(@PathParam("id") int customerId) {
        Customer customer = customers.find(customerId);
        customers.delete(customer);
    }
}