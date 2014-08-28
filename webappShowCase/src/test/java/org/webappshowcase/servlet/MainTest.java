/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.webappshowcase.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import static org.easymock.MockType.NICE;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Ivo
 */
@RunWith(EasyMockRunner.class)
public class MainTest {
  
  @Mock
  HttpServletRequest req;
  @Mock(type = NICE)
  HttpServletResponse res;

  public MainTest() {
  }

  @Test
  public void testResponse() throws IOException, ServletException {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    EasyMock.expect(res.getWriter()).andReturn(pw);
    EasyMock.replay(res);
    Main mainServlet = new Main();
    mainServlet.doGet(req, res);
    EasyMock.verify(res);
    
    String result = sw.getBuffer().toString().trim();
    assert(result.startsWith("<!DOCTYPE html>"));
    assert(result.endsWith("</html>"));
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

    // TODO add test methods here.
  // The methods must be annotated with annotation @Test. For example:
  //
  // @Test
  // public void hello() {}
}
