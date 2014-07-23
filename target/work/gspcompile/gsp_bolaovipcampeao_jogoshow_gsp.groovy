import bolao.Jogo
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_jogoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/jogo/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'jogo.label', default: 'Jogo'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("jogo.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',14,['code':("jogo.create.label")],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(6)
invokeTag('message','g',18,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (jogoInstance?.datajogo)) {
printHtmlPart(11)
invokeTag('message','g',26,['code':("jogo.datajogo.label"),'default':("Datajogo")],-1)
printHtmlPart(12)
invokeTag('formatDate','g',28,['format':("dd/MM/yyyy HH:mm"),'date':(jogoInstance?.datajogo)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (jogoInstance?.estadio)) {
printHtmlPart(15)
invokeTag('message','g',35,['code':("jogo.estadio.label"),'default':("Fase")],-1)
printHtmlPart(16)
expressionOut.print(jogoInstance?.estadio?.descricao)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (jogoInstance?.peso)) {
printHtmlPart(17)
invokeTag('message','g',44,['code':("jogo.peso.label"),'default':("Peso")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',46,['bean':(jogoInstance),'field':("peso")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (jogoInstance?.fase)) {
printHtmlPart(19)
invokeTag('message','g',53,['code':("jogo.fase.label"),'default':("Fase")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',55,['bean':(jogoInstance),'field':("fase")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (jogoInstance?.descricaofase)) {
printHtmlPart(20)
invokeTag('message','g',62,['code':("jogo.descricaofase.label"),'default':("Descrição Fase")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',64,['bean':(jogoInstance),'field':("descricaofase")],-1)
printHtmlPart(13)
}
printHtmlPart(21)
if(true && (jogoInstance?.time1)) {
printHtmlPart(22)
invokeTag('message','g',71,['code':("jogo.time1.label"),'default':("Time1")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(jogoInstance?.time1?.descricao)
})
invokeTag('link','g',73,['controller':("time"),'action':("show"),'id':(jogoInstance?.time1?.id)],3)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (jogoInstance?.scoretime1)) {
printHtmlPart(24)
invokeTag('message','g',80,['code':("jogo.scoretime1.label"),'default':("Scoretime1")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',82,['bean':(jogoInstance),'field':("scoretime1")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (jogoInstance?.scoretime2)) {
printHtmlPart(26)
invokeTag('message','g',89,['code':("jogo.scoretime2.label"),'default':("Scoretime2")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',91,['bean':(jogoInstance),'field':("scoretime2")],-1)
printHtmlPart(13)
}
printHtmlPart(21)
if(true && (jogoInstance?.time2)) {
printHtmlPart(28)
invokeTag('message','g',98,['code':("jogo.time2.label"),'default':("Time2")],-1)
printHtmlPart(29)
createTagBody(3, {->
expressionOut.print(jogoInstance?.time2?.descricao)
})
invokeTag('link','g',100,['controller':("time"),'action':("show"),'id':(jogoInstance?.time2?.id)],3)
printHtmlPart(30)
}
printHtmlPart(21)
if(true && (jogoInstance?.campeonato)) {
printHtmlPart(31)
invokeTag('message','g',108,['code':("jogo.campeonato.label"),'default':("Campeonato")],-1)
printHtmlPart(32)
createTagBody(3, {->
expressionOut.print(jogoInstance?.campeonato?.descricao)
})
invokeTag('link','g',110,['controller':("campeonato"),'action':("show"),'id':(jogoInstance?.campeonato?.id)],3)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (jogoInstance?.encerrado)) {
printHtmlPart(33)
invokeTag('message','g',117,['code':("jogo.encerrado.label"),'default':("Campeonato")],-1)
printHtmlPart(34)
invokeTag('formatBoolean','g',119,['boolean':(jogoInstance?.encerrado)],-1)
printHtmlPart(13)
}
printHtmlPart(21)
if(true && (jogoInstance?.timezone)) {
printHtmlPart(35)
invokeTag('message','g',126,['code':("jogo.timezone.label"),'default':("Scoretime2")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',128,['bean':(jogoInstance),'field':("timezone")],-1)
printHtmlPart(13)
}
printHtmlPart(37)
createTagBody(2, {->
printHtmlPart(38)
createTagBody(3, {->
invokeTag('message','g',136,['code':("button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',136,['class':("edit"),'action':("edit"),'resource':(jogoInstance)],3)
printHtmlPart(39)
invokeTag('actionSubmit','g',137,['class':("delete"),'action':("delete"),'value':(message(code: 'button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(40)
})
invokeTag('form','g',139,['url':([resource:jogoInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(41)
})
invokeTag('captureBody','sitemesh',141,[:],1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405434168000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
