/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sas.stic.javaee7demo.presentation;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import org.sas.stic.javaee7demo.business.customers.boundary.Customers;
import org.sas.stic.javaee7demo.business.customers.entity.Customer;

/**
 *
 * @author angelmiralles
 */
@ManagedBean
public class CustomersBean extends BaseBean{
    
    @Inject
    Customers cu;
    
    private Customer selectedCustomer;

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }
    
    @PostConstruct
    public void initCustomer(){
        this.selectedCustomer = new Customer();
    }
    
    /**
     * Method for listing customers
     * @return 
     */
    public List<Customer> getCustomers(){
        return cu.findAll();
    }
    
    public void onRowSelect(SelectEvent event) {
        this.selectedCustomer = (Customer) event.getObject();
    }
    
    public String showCustomer(){
        return "customer";
    }
    
    public void register() throws Exception {
        try{
            this.cu.add(this.selectedCustomer);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Regitrado", "Regitro con exito");
            getFacesContext().addMessage(null, m);
            initCustomer();
        } catch(Exception e){
            e.printStackTrace();
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Regitro no realizado");
            getFacesContext().addMessage(null, m);
        }
        
    }
}
