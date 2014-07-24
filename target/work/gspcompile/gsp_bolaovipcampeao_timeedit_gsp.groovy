import bolao.Time
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_timeedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/time/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'time.label', default: 'Time'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("time.edit.label")],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',13,['code':("time.create.label")],-1)
})
invokeTag('link','g',13,['class':("create"),'action':("create")],2)
printHtmlPart(5)
invokeTag('message','g',17,['code':("time.edit.label")],-1)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(12)
expressionOut.print(error.field)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('message','g',24,['error':(error)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',25,['bean':(timeInstance),'var':("error")],3)
printHtmlPart(16)
})
invokeTag('hasErrors','g',27,['bean':(timeInstance)],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('hiddenField','g',29,['name':("version"),'value':(timeInstance?.version)],-1)
printHtmlPart(18)
invokeTag('render','g',31,['template':("form")],-1)
printHtmlPart(19)
invokeTag('actionSubmit','g',34,['class':("save"),'action':("update"),'value':(message(code: 'button.update.label', default: 'Update'))],-1)
printHtmlPart(20)
})
invokeTag('form','g',36,['url':([resource:timeInstance, action:'update']),'method':("PUT")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',38,[:],1)
printHtmlPart(22)
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