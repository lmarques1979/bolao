import bolao.Estadio
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_estadioshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/estadio/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'estadio.label', default: 'Estadio'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("estadio.list.label")],-1)
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
invokeTag('message','g',14,['code':("estadio.list.label")],-1)
})
invokeTag('link','g',14,['class':("list"),'action':("index")],2)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',15,['code':("estadio.create.label")],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(7)
invokeTag('message','g',19,['code':("estadio.list.label")],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (estadioInstance?.descricao)) {
printHtmlPart(12)
invokeTag('message','g',27,['code':("estadio.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',29,['bean':(estadioInstance),'field':("descricao")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (estadioInstance?.cidade)) {
printHtmlPart(16)
invokeTag('message','g',36,['code':("estadio.cidade.label"),'default':("Cidade")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',38,['bean':(estadioInstance),'field':("cidade")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (estadioInstance?.estado)) {
printHtmlPart(18)
invokeTag('message','g',45,['code':("estadio.estado.label"),'default':("Estado")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',47,['bean':(estadioInstance),'field':("estado")],-1)
printHtmlPart(14)
}
printHtmlPart(20)
if(true && (estadioInstance?.pais)) {
printHtmlPart(21)
invokeTag('message','g',55,['code':("estadio.pais.label"),'default':("Pais")],-1)
printHtmlPart(22)
createTagBody(3, {->
expressionOut.print(estadioInstance?.pais?.descricao)
})
invokeTag('link','g',57,['controller':("pais"),'action':("show"),'id':(estadioInstance?.pais?.id)],3)
printHtmlPart(14)
}
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
createTagBody(3, {->
invokeTag('message','g',65,['code':("button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',65,['class':("edit"),'action':("edit"),'resource':(estadioInstance)],3)
printHtmlPart(25)
invokeTag('actionSubmit','g',66,['class':("delete"),'action':("delete"),'value':(message(code: 'button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(26)
})
invokeTag('form','g',68,['url':([resource:estadioInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',70,[:],1)
printHtmlPart(28)
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
