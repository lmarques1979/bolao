import bolao.Estadio
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_estadio_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/estadio/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: estadioInstance, field: 'descricao', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("estadio.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['name':("descricao"),'maxlength':("50"),'required':(""),'value':(estadioInstance?.descricao)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: estadioInstance, field: 'cidade', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("estadio.cidade.label"),'default':("Cidade")],-1)
printHtmlPart(2)
invokeTag('textField','g',17,['name':("cidade"),'maxlength':("50"),'required':(""),'value':(estadioInstance?.cidade)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: estadioInstance, field: 'estado', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("estadio.estado.label"),'default':("Estado")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['name':("estado"),'maxlength':("50"),'required':(""),'value':(estadioInstance?.estado)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: estadioInstance, field: 'pais', 'error'))
printHtmlPart(6)
invokeTag('message','g',32,['code':("estadio.pais.label"),'default':("Pais")],-1)
printHtmlPart(2)
invokeTag('select','g',35,['id':("pais"),'name':("pais.id"),'from':(bolao.Pais.list()),'optionKey':("id"),'required':(""),'optionValue':("descricao"),'value':(estadioInstance?.pais?.id),'class':("many-to-one")],-1)
printHtmlPart(7)
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
