package org.webappshowcase.servlet

import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import static org.junit.Assert.*

/**
 *
 * @author Ivo
 */
class HtmlGeneratorTest {

  public HtmlGeneratorTest() {
  }
  
  @Test
  public void 'check_if_response_is_Html'(){
    HtmlGenerator html = new HtmlGenerator()
    assertTrue(html.getHtmlPage().startsWith('<!DOCTYPE html'))
    assertTrue(html.getHtmlPage().endsWith("</html>"))
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
}
