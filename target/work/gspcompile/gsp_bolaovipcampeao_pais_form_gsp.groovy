import bolao.Pais
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_pais_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pais/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: paisInstance, field: 'codigo', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("pais.codigo.label"),'default':("Codigo")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['name':("codigo"),'size':("2"),'maxlength':("2"),'required':(""),'value':(paisInstance?.codigo)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: paisInstance, field: 'descricao', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("pais.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(2)
invokeTag('textField','g',17,['name':("descricao"),'size':("35"),'maxlength':("50"),'required':(""),'value':(paisInstance?.descricao)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: paisInstance, field: 'imagem', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("pais.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(6)
invokeTag('textField','g',26,['name':("imagem"),'size':("35"),'maxlength':("50"),'value':(paisInstance?.imagem)],-1)
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
