/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.iso.restserviceexample.rest;

import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ivo
 */
public class HelloServiceTest {
  
  public HelloServiceTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of getMsg method, of class HelloService.
   */
  @Test
  public void testGetMsg() {
    String message = "Testname";
    HelloService instance = new HelloService();
    Response expResult = Response.status(200).entity("Hello "+message).build();
    Response result = instance.getMsg(message);
    assertEquals(expResult.getStatus(), result.getStatus());
    assertEquals(expResult.getEntity(), result.getEntity());
  }
  
}
