import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_jogocreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/jogo/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'jogo.label', default: 'Jogo'))],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',6,['src':("datepicker.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',7,['src':("jquery.timepicker.css")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("jogo.create.label")],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
invokeTag('message','g',14,['code':("jogo.create.label")],-1)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(11)
expressionOut.print(error.field)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('message','g',21,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',22,['bean':(jogoInstance),'var':("error")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',24,['bean':(jogoInstance)],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('render','g',27,['template':("form")],-1)
printHtmlPart(17)
invokeTag('submitButton','g',30,['name':("create"),'class':("save"),'value':(message(code: 'button.create.label', default: 'Create'))],-1)
printHtmlPart(18)
})
invokeTag('form','g',37,['url':([resource:jogoInstance, action:'save']),'id':("formjogo")],2)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',39,[:],1)
printHtmlPart(20)
invokeTag('javascript','asset',41,['src':("datepicker.js")],-1)
printHtmlPart(21)
invokeTag('javascript','asset',42,['src':("jquery.timepicker.js")],-1)
printHtmlPart(21)
invokeTag('javascript','asset',1,['src':("timepickerinit.js")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405193534000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}