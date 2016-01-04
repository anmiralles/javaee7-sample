package org.sas.stic.javaee7demo.business.customers.boundary;

import org.sas.stic.javaee7demo.business.customers.entity.Customer;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customers")
public interface ICustomersResource {

    @GET
    @Produces( MediaType.APPLICATION_JSON)
    List<Customer> findAll();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id:[1-9][0-9]*}")
    Customer find(@PathParam("id") int id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    Customer add(Customer customer);

    @PUT
    @Path("/{id:[1-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    void update(@PathParam("id") int customerId, Customer cu);


    @DELETE
    @Path("/{id:[1-9][0-9]*}")
    void delete(@PathParam("id") int customerId) ;
}