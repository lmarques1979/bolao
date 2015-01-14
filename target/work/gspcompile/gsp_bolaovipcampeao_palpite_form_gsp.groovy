import bolao.Palpite
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_palpite_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/palpite/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: palpiteInstance, field: 'scoretime1', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("palpite.scoretime1.label"),'default':("Scoretime1")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("scoretime1"),'type':("number"),'value':(palpiteInstance.scoretime1),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: palpiteInstance, field: 'scoretime2', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("palpite.scoretime2.label"),'default':("Scoretime2")],-1)
printHtmlPart(2)
invokeTag('field','g',19,['name':("scoretime2"),'type':("number"),'value':(palpiteInstance.scoretime2),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: palpiteInstance, field: 'jogo', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("palpite.jogo.label"),'default':("Jogo")],-1)
printHtmlPart(2)
invokeTag('select','g',28,['id':("jogo"),'name':("jogo.id"),'from':(bolao.Jogo.list()),'optionKey':("id"),'required':(""),'value':(palpiteInstance?.jogo?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: palpiteInstance, field: 'finalizado', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("palpite.finalizado.label"),'default':("Finalizado")],-1)
printHtmlPart(7)
invokeTag('checkBox','g',37,['name':("finalizado"),'value':(palpiteInstance?.finalizado)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: palpiteInstance, field: 'usuariobolao', 'error'))
printHtmlPart(8)
invokeTag('message','g',43,['code':("palpite.usuariobolao.label"),'default':("Usuariobolao")],-1)
printHtmlPart(2)
invokeTag('select','g',46,['id':("usuariobolao"),'name':("usuariobolao.id"),'from':(bolao.UsuarioBolao.list()),'optionKey':("id"),'required':(""),'value':(palpiteInstance?.usuariobolao?.id),'class':("many-to-one")],-1)
printHtmlPart(9)
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
