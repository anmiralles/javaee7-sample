/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sas.stic.javaee7demo.business.security.boundary;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sas.stic.javaee7demo.business.security.entity.User;

/**
 *
 * @author angelmiralles
 */
//@RunWith(Arquillian.class)
public class UsersIT {
    
    @Inject
    Users us;
    
    @Deployment
    public static JavaArchive createArchiveAndDeploy() {
            return ShrinkWrap.create(JavaArchive.class)
                            .addPackage(Users.class.getPackage())
                            .addPackage(User.class.getPackage())
                            .addAsResource("META-INF/persistence.xml")
                            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
//    @Test
//    public void testUsers() {
//            User u1 = new User(Integer.SIZE, "angel");
//            User u2 = new User(Integer.SIZE, "pepe");
//            this.us.register(u1);
//            this.us.register(u2);
//            Assert.assertEquals(3, this.us.findAll().size());
//            this.us.delete(u1);
//            Assert.assertEquals(2, this.us.findAll().size());
//            this.us.delete(u2);
//            us.delete(u1);
//    }
}
