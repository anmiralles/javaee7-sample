///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.sas.stic.javaee7demo.business.customers.boundary;
//
//import com.eviware.soapui.tools.SoapUITestCaseRunner;
//import java.net.URL;
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.container.test.api.RunAsClient;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.arquillian.test.api.ArquillianResource;
//import org.jboss.shrinkwrap.api.Archive;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.sas.stic.javaee7demo.business.customers.entity.Customer;
//
//
//
///**
// *
// * @author angelmiralles
// */
//@RunWith(Arquillian.class)
//public class CustomersSOAPIT {
//    
////    private static final String CU_SERVICE_NAME = "CustomersSOAPService";
////    
////    @Deployment(testable = false)
////    public static WebArchive createDeployment() {
////        WebAppDescriptor webXml = Descriptors.create(WebAppDescriptor.class);
////        
////        return ShrinkWrap.create(WebArchive.class, "javaee7-jaxws-test.war")
////                .addClasses(CustomersSOAP.class, Customers.class, Customer.class)
////                .setWebXML(new StringAsset(webXml.servlet("http://localhost:7001/javaee7-sample/CustomersSOAPService?WSLD",CU_SERVICE_NAME).exportAsString()));                        
////    }
////
////    @Test
////    public void testSimpleStatelessWebServiceEndpoint(@ArquillianResource URL deploymentUrl) throws Exception {
////        final QName serviceName = new QName("org.sas.stic.javaee7demo", CU_SERVICE_NAME);
////        final URL wsdlURL = new URL(deploymentUrl, CU_SERVICE_NAME + "?wsdl");
////        final Service service = Service.create(wsdlURL, serviceName);
////        final CustomersSOAP port = service.getPort(CustomersSOAP.class);
////        final List<Customer> result = port.findAll();
////        Assert.assertNotNull(result);
////        Assert.assertThat(result.size(), Is.is(3));
////    }
//    
//    @Deployment//(testable = false)
//    public static Archive<?> createTestArchive() {
//            return ShrinkWrap.create(JavaArchive.class, "javaee7-jaxws-test.jar")
//                            .addClasses(Customers.class,CustomersSOAP.class, Customer.class);
//    }
//    
////    @Deployment(testable = false)
////    public static WebArchive createDeployment() {
////        WebAppDescriptor webXml = Descriptors.create(WebAppDescriptor.class);
////        
////        return ShrinkWrap.create(WebArchive.class, "javaee7-jaxws-test.war")
////                .addClasses(CustomersSOAP.class, Customers.class, Customer.class)
////                .setWebXML(new StringAsset(webXml.servlet("http://localhost:7001/javaee7-sample/CustomersSOAPService?WSLD",CU_SERVICE_NAME).exportAsString()));                        
////    }
//    
//    @ArquillianResource
//    private URL serverUrl;
//    
//    @Test
//    @RunAsClient
//    public void testConvertUsingSoapUI() throws Exception {
//            SoapUITestCaseRunner runner = new SoapUITestCaseRunner();
//            runner.setProjectFile("src/test/resources/javaee7-soapui-project.xml");
//            runner.setHost(String.format("%s:%s",serverUrl.getHost(),serverUrl.getPort()));
//            runner.setOutputFolder("target/surefire-reports");
//            runner.setJUnitReport(true);
//            runner.setPrintReport(true);
//            runner.run();
//    }
//    
//}
