import bolao.Resenha
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_resenha_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/resenha/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: resenhaInstance, field: 'resenha', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("resenha.resenha.label"),'default':("Resenha")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("resenha"),'value':(resenhaInstance?.resenha)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: resenhaInstance, field: 'autorizacao', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("resenha.autorizacao.label"),'default':("Autorizacao")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',19,['name':("autorizacao"),'value':(resenhaInstance?.autorizacao)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: resenhaInstance, field: 'usuariobolao', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("resenha.usuariobolao.label"),'default':("Usuariobolao")],-1)
printHtmlPart(6)
invokeTag('select','g',28,['id':("usuariobolao"),'name':("usuariobolao.id"),'from':(bolao.UsuarioBolao.list()),'optionKey':("id"),'required':(""),'value':(resenhaInstance?.usuariobolao?.id),'class':("many-to-one")],-1)
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
