import bolao.Time
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_timeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/time/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'time.label', default: 'Time'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("time.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',14,['code':("time.create.label")],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(6)
invokeTag('message','g',18,['code':("time.list.label")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (timeInstance?.descricao)) {
printHtmlPart(11)
invokeTag('message','g',26,['code':("time.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',28,['bean':(timeInstance),'field':("descricao")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (timeInstance?.imagem)) {
printHtmlPart(15)
invokeTag('message','g',35,['code':("time.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',37,['bean':(timeInstance),'field':("imagem")],-1)
printHtmlPart(13)
}
printHtmlPart(17)
if(true && (timeInstance?.campeonato?.descricao)) {
printHtmlPart(15)
invokeTag('message','g',43,['code':("time.campeonato.label"),'default':("Campeonato")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',45,['bean':(timeInstance?.campeonato),'field':("descricao")],-1)
printHtmlPart(13)
}
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
createTagBody(3, {->
invokeTag('message','g',54,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',54,['class':("edit"),'action':("edit"),'resource':(timeInstance)],3)
printHtmlPart(20)
invokeTag('actionSubmit','g',55,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(21)
})
invokeTag('form','g',57,['url':([resource:timeInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',59,[:],1)
printHtmlPart(23)
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
