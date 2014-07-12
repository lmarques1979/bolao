import bolao.Jogo
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_jogo_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/jogo/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(message(code: "jogo.datajogo.label"))
printHtmlPart(1)
expressionOut.print(message(code: "jogo.horajogo.label"))
printHtmlPart(1)
expressionOut.print(message(code: "jogo.peso.label"))
printHtmlPart(1)
expressionOut.print(message(code: "jogo.rodada.label"))
printHtmlPart(1)
expressionOut.print(message(code: "jogo.descfase.label"))
printHtmlPart(1)
expressionOut.print(message(code: "jogo.estadio.label"))
printHtmlPart(2)
invokeTag('textField','g',20,['name':("datajogo"),'class':("w8em format-d-m-y"),'size':("9"),'value':(params.datajogo)],-1)
printHtmlPart(3)
invokeTag('textField','g',24,['name':("horajogo"),'size':("3"),'id':("hora"),'class':("time"),'value':(params.horajogo)],-1)
printHtmlPart(4)
invokeTag('textField','g',29,['name':("peso"),'size':("2"),'value':(jogoInstance?.peso)],-1)
printHtmlPart(4)
invokeTag('textField','g',34,['name':("fase"),'size':("1"),'value':(jogoInstance?.fase)],-1)
printHtmlPart(4)
invokeTag('textField','g',39,['name':("descricaofase"),'size':("8"),'value':(jogoInstance?.descricaofase)],-1)
printHtmlPart(5)
invokeTag('select','g',45,['id':("estadio"),'name':("estadio.id"),'from':(bolao.Estadio.list()),'optionValue':("estadioCidadeEstado"),'optionKey':("id"),'required':(""),'value':(jogoInstance?.estadio?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
expressionOut.print(message(code: "jogo.time1.label"))
printHtmlPart(1)
expressionOut.print(message(code: "jogo.scoretime1.label"))
printHtmlPart(7)
expressionOut.print(message(code: "jogo.scoretime2.label"))
printHtmlPart(7)
expressionOut.print(message(code: "jogo.time2.label"))
printHtmlPart(1)
expressionOut.print(message(code: "jogo.campeonato.label"))
printHtmlPart(7)
expressionOut.print(message(code: "jogo.encerrado.label"))
printHtmlPart(2)
invokeTag('select','g',61,['id':("time1"),'name':("time1.id"),'from':(bolao.Time.list()),'optionValue':("descricao"),'optionKey':("id"),'required':(""),'value':(jogoInstance?.time1?.id),'class':("many-to-one")],-1)
printHtmlPart(4)
invokeTag('textField','g',66,['class':("centro"),'name':("scoretime1"),'maxlength':("1"),'size':("1"),'value':(jogoInstance?.scoretime1)],-1)
printHtmlPart(8)
invokeTag('textField','g',70,['class':("centro"),'name':("scoretime2"),'maxlength':("1"),'size':("1"),'value':(jogoInstance?.scoretime2)],-1)
printHtmlPart(8)
invokeTag('select','g',74,['id':("time2"),'name':("time2.id"),'from':(bolao.Time.list()),'optionValue':("descricao"),'optionKey':("id"),'required':(""),'value':(jogoInstance?.time2?.id),'class':("many-to-one")],-1)
printHtmlPart(4)
invokeTag('select','g',79,['id':("campeonato"),'name':("campeonato.id"),'from':(bolao.Campeonato.list()),'optionValue':("descricao"),'optionKey':("id"),'required':(""),'value':(jogoInstance?.campeonato?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
invokeTag('checkBox','g',83,['name':("encerrado"),'value':(jogoInstance?.encerrado)],-1)
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
