/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.webappshowcase.servlet

/**
 *
 * @author Ivo
 */
class HtmlGenerator {
  
  def getHtmlPage(){
    def writer = new StringWriter()  
    def builder = new groovy.xml.MarkupBuilder(writer)
    builder.html{
      head{
        title 'Page generated with Groovy'
      }
      body{
        h1 'Page generated with Groovy'
      }
    }
    return writer.toString()
  }
	
}

