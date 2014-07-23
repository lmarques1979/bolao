import bolao.UsuarioBolao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_usuarioBolao_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuarioBolao/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: usuarioBolaoInstance, field: 'bolao', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("usuarioBolao.bolao.label"),'default':("Bolao")],-1)
printHtmlPart(2)
invokeTag('select','g',8,['id':("bolao"),'name':("bolao.id"),'optionValue':("descricao"),'from':(bolao.Bolao.list()),'optionKey':("id"),'required':(""),'value':(usuarioBolaoInstance?.bolao?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
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
