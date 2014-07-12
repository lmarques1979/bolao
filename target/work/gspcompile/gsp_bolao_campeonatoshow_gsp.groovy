import bolao.Campeonato
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_campeonatoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/campeonato/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'campeonato.label', default: 'Campeonato'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("campeonato.list.label")],-1)
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
invokeTag('message','g',14,['code':("campeonato.create.label")],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(6)
invokeTag('message','g',18,['code':("campeonato.list.label")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (campeonatoInstance?.descricao)) {
printHtmlPart(11)
invokeTag('message','g',26,['code':("campeonato.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',28,['bean':(campeonatoInstance),'field':("descricao")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (campeonatoInstance?.imagem)) {
printHtmlPart(15)
invokeTag('message','g',35,['code':("campeonato.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(16)
if(true && (campeonatoInstance.imagem)) {
printHtmlPart(17)
invokeTag('image','asset',39,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':("campeonatos/${campeonatoInstance.descricao}/${campeonatoInstance.imagem}"),'title':(campeonatoInstance.descricao)],-1)
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (campeonatoInstance?.enabled)) {
printHtmlPart(21)
invokeTag('message','g',48,['code':("campeonato.enabled.label"),'default':("Ativo")],-1)
printHtmlPart(22)
invokeTag('formatBoolean','g',50,['boolean':(campeonatoInstance?.enabled)],-1)
printHtmlPart(13)
}
printHtmlPart(23)
if(true && (campeonatoInstance?.jogos)) {
printHtmlPart(24)
invokeTag('message','g',58,['code':("campeonato.jogos.label"),'default':("Jogos")],-1)
printHtmlPart(25)
for( j in (campeonatoInstance.jogos) ) {
printHtmlPart(26)
createTagBody(4, {->
invokeTag('formatDate','g',61,['format':("dd/MM/yyyy HH:mm"),'date':(j?.datajogo)],-1)
printHtmlPart(27)
if(true && (j?.time1?.imagem)) {
printHtmlPart(18)
invokeTag('image','asset',62,['class':("jogocampeonato"),'src':("bandeiras/24/${j?.time1?.imagem}"),'title':(j?.time1?.descricao)],-1)
printHtmlPart(18)
}
printHtmlPart(28)
expressionOut.print(j?.time1.descricao)
printHtmlPart(28)
expressionOut.print(j?.scoretime1)
printHtmlPart(29)
expressionOut.print(j?.scoretime2)
printHtmlPart(28)
expressionOut.print(j?.time2.descricao)
printHtmlPart(30)
if(true && (j?.time2?.imagem)) {
printHtmlPart(18)
invokeTag('image','asset',65,['class':("jogocampeonato"),'src':("bandeiras/24/${j?.time2?.imagem}"),'title':(j?.time2?.descricao)],-1)
printHtmlPart(31)
}
})
invokeTag('link','g',66,['class':("nounderline"),'controller':("jogo"),'action':("show"),'id':(j.id)],4)
printHtmlPart(32)
}
printHtmlPart(33)
}
printHtmlPart(34)
createTagBody(2, {->
printHtmlPart(35)
createTagBody(3, {->
invokeTag('message','g',77,['code':("button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',77,['class':("edit"),'action':("edit"),'resource':(campeonatoInstance)],3)
printHtmlPart(36)
invokeTag('actionSubmit','g',78,['class':("delete"),'action':("delete"),'value':(message(code: 'button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(37)
})
invokeTag('form','g',80,['url':([resource:campeonatoInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(38)
})
invokeTag('captureBody','sitemesh',82,[:],1)
printHtmlPart(39)
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
