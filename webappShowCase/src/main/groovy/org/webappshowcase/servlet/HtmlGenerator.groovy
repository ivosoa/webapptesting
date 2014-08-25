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
        link(href: 'css/main.css', type:'text/css', rel:'stylesheet')
        script (src: 'js/angular.min.js', type: 'text/javascript')
        script (src: 'js/module/angularModule.js', type: 'text/javascript')
        script (src: 'js/module/controller/listController.js', type: 'text/javascript')
        script (src: 'js/module/controller/contentController.js', type: 'text/javascript')
        script (src: 'js/module/factory/ajaxService.js', type: 'text/javascript')
        script (src: 'js/module/factory/broadcastService.js', type: 'text/javascript')
      }
      body('ng-app':'mainModule'){
        h1 'Page generated with Groovy'
        div(id:'list', 'ng-controller':'listController'){
          table('class':'listElems', 'border':'1'){
            tr('ng-repeat':'elem in userList', 'ng-click':'selectUser(elem)', 'ng-class':'{active : isSelected(elem.id)}'){
              td '{{elem.firstName}}'
              td '{{elem.lastName}}'
              td '{{elem.email}}'
              td{
                input(type:'button', 'ng-click':'delete(elem.id)', 'value':'delete')
              }
            }
          }
        }
        div(id:'content', 'ng-controller':'contentController'){
          form('ng-submit':'addUser()'){
            div(id:'box'){
              label{
                span 'First Name: '
                input(type:'text', 'class':'textInput' , name:'firstName', 'ng-model':'userForm.firstName')
              }
              label{
                span 'Last Name: '
                input(type:'text', 'class':'textInput', name:'lastName', 'ng-model':'userForm.lastName')
              }
              label{
                span 'Email: '
                input(type:'text', 'class':'textInput', name:'email', 'ng-model':'userForm.email')
              }
              input(type:'submit', 'class':'buttonInput', value:'add')
            }
          }
        }
      }
    }
    return writer.toString()
  }
	
}

