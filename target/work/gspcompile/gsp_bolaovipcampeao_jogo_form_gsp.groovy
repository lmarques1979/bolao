import bolao.Jogo
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_jogo_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/jogo/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(message(code: "jogo.timezone.label"))
printHtmlPart(1)
invokeTag('timeZoneSelect','g',12,['class':("timezone"),'name':("timezone"),'value':(tz)],-1)
printHtmlPart(2)
expressionOut.print(message(code: "jogo.datajogo.label"))
printHtmlPart(3)
expressionOut.print(message(code: "jogo.horajogo.label"))
printHtmlPart(3)
expressionOut.print(message(code: "jogo.peso.label"))
printHtmlPart(3)
expressionOut.print(message(code: "jogo.rodada.label"))
printHtmlPart(4)
expressionOut.print(message(code: "jogo.descfase.label"))
printHtmlPart(1)
invokeTag('textField','g',26,['name':("datajogo"),'class':("w8em format-d-m-y"),'size':("9"),'value':(params.datajogo)],-1)
printHtmlPart(5)
invokeTag('textField','g',30,['name':("horajogo"),'size':("3"),'id':("hora"),'class':("time"),'value':(params.horajogo)],-1)
printHtmlPart(6)
invokeTag('textField','g',35,['name':("peso"),'size':("2"),'value':(jogoInstance?.peso)],-1)
printHtmlPart(6)
invokeTag('textField','g',40,['name':("fase"),'size':("1"),'value':(jogoInstance?.fase)],-1)
printHtmlPart(7)
invokeTag('textField','g',45,['name':("descricaofase"),'size':("8"),'value':(jogoInstance?.descricaofase)],-1)
printHtmlPart(8)
expressionOut.print(message(code: "jogo.estadio.label"))
printHtmlPart(9)
expressionOut.print(message(code: "jogo.time1.label"))
printHtmlPart(3)
expressionOut.print(message(code: "jogo.scoretime1.label"))
printHtmlPart(9)
expressionOut.print(message(code: "jogo.scoretime2.label"))
printHtmlPart(9)
expressionOut.print(message(code: "jogo.time2.label"))
printHtmlPart(10)
expressionOut.print(message(code: "extras.label"))
printHtmlPart(11)
invokeTag('select','g',61,['id':("estadio"),'name':("estadio.id"),'from':(bolao.Estadio.list()),'optionValue':("estadioCidadeEstado"),'optionKey':("id"),'required':(""),'value':(jogoInstance?.estadio?.id),'class':("many-to-one")],-1)
printHtmlPart(5)
invokeTag('select','g',65,['id':("time1"),'name':("time1.id"),'from':(bolao.Time.list()),'optionValue':("descricao"),'optionKey':("id"),'required':(""),'value':(jogoInstance?.time1?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
invokeTag('textField','g',70,['class':("centro"),'name':("scoretime1"),'maxlength':("1"),'size':("1"),'value':(jogoInstance?.scoretime1)],-1)
printHtmlPart(12)
invokeTag('textField','g',74,['class':("centro"),'name':("scoretime2"),'maxlength':("1"),'size':("1"),'value':(jogoInstance?.scoretime2)],-1)
printHtmlPart(12)
invokeTag('select','g',78,['id':("time2"),'name':("time2.id"),'from':(bolao.Time.list()),'optionValue':("descricao"),'optionKey':("id"),'required':(""),'value':(jogoInstance?.time2?.id),'class':("many-to-one")],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
invokeTag('image','asset',84,['src':("skin/add.png"),'title':(message(code: 'adicionarextra.label'))],-1)
printHtmlPart(15)
})
invokeTag('link','g',85,['controller':("extras"),'action':("create"),'id':(jogoInstance.id)],1)
printHtmlPart(2)
expressionOut.print(message(code: "jogo.campeonato.label"))
printHtmlPart(9)
expressionOut.print(message(code: "jogo.encerrado.label"))
printHtmlPart(16)
invokeTag('select','g',96,['id':("campeonato"),'name':("campeonato.id"),'from':(bolao.Campeonato.list()),'optionValue':("descricao"),'optionKey':("id"),'required':(""),'value':(jogoInstance?.campeonato?.id),'class':("many-to-one")],-1)
printHtmlPart(17)
invokeTag('checkBox','g',99,['name':("encerrado"),'value':(jogoInstance?.encerrado)],-1)
printHtmlPart(18)
expressionOut.print(message(code: "extras.label"))
printHtmlPart(9)
expressionOut.print(message(code: "manutencao.extras.label"))
printHtmlPart(19)
loop:{
int i = 0
for( extra in (jogoInstance.extras) ) {
printHtmlPart(20)
expressionOut.print(extra.descricao)
printHtmlPart(21)
expressionOut.print(extra.jogo.time1.descricao)
printHtmlPart(21)
expressionOut.print(extra.scoretime1)
printHtmlPart(22)
expressionOut.print(extra.scoretime2)
printHtmlPart(21)
expressionOut.print(extra.jogo.time2.descricao)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('image','asset',118,['src':("skin/edit.png")],-1)
printHtmlPart(25)
})
invokeTag('link','g',119,['controller':("extras"),'action':("edit"),'id':(extra.id)],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('hiddenField','g',121,['name':("id"),'value':(extra.id)],-1)
printHtmlPart(24)
invokeTag('actionSubmitImage','g',122,['controller':("extras"),'action':("delete"),'value':(message(code: 'button.delete.label')),'title':(message(code: 'button.delete.label')),'src':(assetPath(src:'skin/remove.png')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(25)
})
invokeTag('form','g',123,['controller':("extras"),'action':("delete"),'method':("DELETE")],2)
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405432534000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
