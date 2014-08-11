package org.webappshowcase.servlet

/**
 *
 * @author Ivo
 */
class HtmlGenerator {
  
  def getHtmlPage(){
    def writer = new StringWriter()  
    writer.write('<!DOCTYPE html>\n')
    
    def builder = new groovy.xml.MarkupBuilder(writer)
    
    builder.doubleQuotes = true
    builder.expandEmptyElements = true
    builder.omitEmptyAttributes = false
    builder.omitNullAttributes = false
    builder.html{
      head{
        meta(charset:'utf-8')
        title 'Page Title'
        script (src: 'js/angular.min.js', type: 'text/javascript')
        script (src: 'js/module/angularModule.js', type: 'text/javascript')
        script (src: 'js/module/controller/listController.js', type: 'text/javascript')
        script (src: 'js/module/controller/contentController.js', type: 'text/javascript')
        script (src: 'js/module/factory/ajaxService.js', type: 'text/javascript')
      }
      body('ng-app':'mainModule'){
        h1 'Page generated with Groovy'
        div(id:'list', 'ng-controller':'listController'){
          ul('class':'listElems'){
            li('ng-repeat':'elem in userList', '{{elem.firstName}}')
          }
        }
        div(id:'content', 'ng-controller':'contentController'){
          form('ng-submit':'addUser()'){
            input(type:'text', name:'firstName', 'ng-model':'userForm.firstName')
            input(type:'text', name:'lastName', 'ng-model':'userForm.lastName')
            input(type:'text', name:'email', 'ng-model':'userForm.email')
            input(type:'submit', value:'add')
          }
        }
      }
    }
    return writer.toString()
  }
	
}

