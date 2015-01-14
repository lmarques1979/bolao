import bolao.Bolao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_bolao_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bolao/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: bolaoInstance, field: 'campeonato', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("campeonato.label")],-1)
printHtmlPart(2)
invokeTag('select','g',8,['id':("campeonato"),'name':("campeonato.id"),'from':(bolao.Campeonato.list()),'optionValue':("descricao"),'optionKey':("id"),'required':(""),'value':(bolaoInstance?.campeonato?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: bolaoInstance, field: 'descricao', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("bolao.descricao.label")],-1)
printHtmlPart(2)
invokeTag('textField','g',17,['name':("descricao"),'maxlength':("50"),'required':(""),'value':(bolaoInstance?.descricao)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: bolaoInstance, field: 'informacao', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("bolao.informacao.label")],-1)
printHtmlPart(6)
invokeTag('textArea','g',25,['name':("informacao"),'maxlength':("1000"),'rows':("5"),'cols':("70"),'required':(""),'value':(bolaoInstance?.informacao)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: bolaoInstance, field: 'imagem', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("bolao.imagem.label")],-1)
printHtmlPart(8)
expressionOut.print(bolaoInstance?.imagem)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: bolaoInstance, field: 'autorizacao', 'error'))
printHtmlPart(4)
invokeTag('message','g',40,['code':("bolao.autorizacao.label")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',43,['name':("autorizacao"),'value':(bolaoInstance?.autorizacao)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: bolaoInstance, field: 'enabled', 'error'))
printHtmlPart(4)
invokeTag('message','g',49,['code':("bolao.enabled.label")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',52,['name':("enabled"),'value':(bolaoInstance?.enabled)],-1)
printHtmlPart(10)
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
