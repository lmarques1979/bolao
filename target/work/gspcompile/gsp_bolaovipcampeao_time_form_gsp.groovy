import bolao.Time
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_time_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/time/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: timeInstance, field: 'descricao', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("time.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("descricao"),'maxlength':("50"),'required':(""),'value':(timeInstance?.descricao)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: timeInstance, field: 'imagem', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("time.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(5)
invokeTag('textField','g',19,['name':("imagem"),'maxlength':("50"),'value':(timeInstance?.imagem)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: timeInstance, field: 'campeonato', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("time.campeonato.label")],-1)
printHtmlPart(2)
invokeTag('select','g',28,['id':("campeonato"),'name':("campeonato.id"),'from':(bolao.Campeonato.list()),'optionKey':("id"),'optionValue':("descricao"),'required':(""),'value':(timeInstance?.campeonato?.id),'class':("many-to-one")],-1)
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
