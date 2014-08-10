/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.webappshowcase.groovy

/**
 *
 * @author ivo
 */
class HtmlGenerator {
  
  String getHtmlPage(){
    def writer = new StringWriter()

    def builder = new groovy.xml.MarkupBuilder(writer)
    builder.html (xmlns:"http://www.w3.org/1999/xhtml",lang:"de",'xml:lang':"de") {
      head { title "Hello-World" }
      body {
        h1 "Die Hello-World-Seite"
        p "Die aktuelle Zeit ist: ${new Date()}"
      }
    }
    
    return writer
    
  }
  
}

