import bolao.Configuracao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_configuracao_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/configuracao/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'alturaimagens', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("configuracao.alturaimagens.label"),'default':("Altura Imagens")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['name':("alturaimagens"),'required':(""),'value':(configuracaoInstance?.alturaimagens)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'larguraimagens', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("configuracao.larguraimagens.label"),'default':("Largura Imagens")],-1)
printHtmlPart(2)
invokeTag('textField','g',17,['name':("larguraimagens"),'required':(""),'value':(configuracaoInstance?.larguraimagens)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'alturaimagensthumbs', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("configuracao.alturaimagensthumbs.label"),'default':("Altura Imagens Thumb")],-1)
printHtmlPart(6)
invokeTag('textField','g',25,['name':("alturaimagensthumbs"),'required':(""),'value':(configuracaoInstance?.alturaimagensthumbs)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'larguraimagensthumbs', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("configuracao.larguraimagensthumbs.label"),'default':("Largura Imagens Thumb")],-1)
printHtmlPart(6)
invokeTag('textField','g',33,['name':("larguraimagensthumbs"),'required':(""),'value':(configuracaoInstance?.larguraimagensthumbs)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'tamanhoiconetimes', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("configuracao.tamanhoiconetimes.label"),'default':("Tamanho Icone Times")],-1)
printHtmlPart(2)
invokeTag('textField','g',42,['name':("tamanhoiconetimes"),'required':(""),'value':(configuracaoInstance?.tamanhoiconetimes)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'itensporpagina', 'error'))
printHtmlPart(8)
invokeTag('message','g',48,['code':("configuracao.itensporpagina.label"),'default':("Itens por Página")],-1)
printHtmlPart(2)
invokeTag('textField','g',51,['name':("itensporpagina"),'required':(""),'value':(configuracaoInstance?.itensporpagina)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'minutosparapalpite', 'error'))
printHtmlPart(8)
invokeTag('message','g',57,['code':("configuracao.minutosparapalpite.label"),'default':("Minutos para Palpite")],-1)
printHtmlPart(2)
invokeTag('textField','g',60,['name':("minutosparapalpite"),'required':(""),'value':(configuracaoInstance?.minutosparapalpite)],-1)
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
