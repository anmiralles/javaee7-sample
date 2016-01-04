/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sas.stic.javaee7demo.business.security.boundary;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.sas.stic.javaee7demo.business.security.entity.User;

/**
 *
 * @author angelmiralles
 */
public class UsersTest {
    
    public UsersTest() {
    }
    
    @Inject
    Users us;
    
    private static User user;
    
    @Before
    public void init(){
        user = new User(Integer.SIZE, "amiralles");
        this.us = new Users();
        this.us.em = Mockito.mock(EntityManager.class);
    }
    
    void mockQuery(String name, List<User> results) {
        Query mockedQuery = Mockito.mock(Query.class);
        Mockito.when(mockedQuery.getResultList()).thenReturn(results);
        Mockito.when(this.us.em.createNamedQuery(name)).thenReturn(mockedQuery);
    }

    @Test
    public void testFind() throws Exception {
        Mockito.when(this.us.em.find(User.class, 1)).thenReturn(user);
        User result = this.us.find(1);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> lstUsers = new ArrayList<>();
        User expected = Mockito.mock(User.class);
        lstUsers.add(expected);
        mockQuery("User.findAll", lstUsers);
        
        List<User> result = this.us.findAll();
        
        Assert.assertNotNull(result);
        Assert.assertThat(result.size(), Is.is(1));
    }
    
    @Test
    public void testFindByUser() throws Exception{
        Query mockedQuery = Mockito.mock(Query.class);
        Mockito.when(mockedQuery.getSingleResult()).thenReturn(user);
        Mockito.when(mockedQuery.setParameter(Matchers.anyString(), Matchers.anyObject())).thenReturn(mockedQuery);
        Mockito.when(this.us.em.createNamedQuery("User.findByUser")).thenReturn(mockedQuery);
        
        User result = this.us.findByUser("amiralles");
        
        Assert.assertNotNull(result);
        Assert.assertThat(result.getUsername(), Is.is("amiralles"));
    }
    
}
