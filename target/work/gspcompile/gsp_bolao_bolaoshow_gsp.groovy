import bolao.Bolao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_bolaoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bolao/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'bolao.label', default: 'Bolao'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("bolao.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',13,['code':("bolao.list.label")],-1)
})
invokeTag('link','g',13,['class':("list"),'action':("index")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',14,['code':("bolao.create.label")],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(6)
invokeTag('message','g',18,['code':("bolao.list.label")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (bolaoInstance?.campeonato)) {
printHtmlPart(11)
invokeTag('message','g',26,['code':("bolao.campeonato.label"),'default':("Campeonato")],-1)
printHtmlPart(12)
createTagBody(3, {->
expressionOut.print(bolaoInstance?.campeonato?.descricao)
})
invokeTag('link','g',28,['controller':("campeonato"),'action':("show"),'id':(bolaoInstance?.campeonato?.id)],3)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (bolaoInstance?.admin)) {
printHtmlPart(15)
invokeTag('message','g',35,['code':("bolao.admin.label"),'default':("Admin")],-1)
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(bolaoInstance?.admin?.username)
})
invokeTag('link','g',37,['controller':("usuario"),'action':("show"),'id':(bolaoInstance?.admin?.id)],3)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (bolaoInstance?.descricao)) {
printHtmlPart(17)
invokeTag('message','g',44,['code':("bolao.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',46,['bean':(bolaoInstance),'field':("descricao")],-1)
printHtmlPart(13)
}
printHtmlPart(19)
if(true && (bolaoInstance?.informacao)) {
printHtmlPart(17)
invokeTag('message','g',53,['code':("bolao.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',55,['bean':(bolaoInstance),'field':("descricao")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (bolaoInstance?.autorizacao)) {
printHtmlPart(20)
invokeTag('message','g',62,['code':("bolao.autorizacao.label")],-1)
printHtmlPart(21)
invokeTag('formatBoolean','g',64,['boolean':(bolaoInstance?.autorizacao)],-1)
printHtmlPart(13)
}
printHtmlPart(19)
if(true && (bolaoInstance?.imagem)) {
printHtmlPart(22)
invokeTag('message','g',71,['code':("bolao.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',73,['bean':(bolaoInstance),'field':("imagem")],-1)
printHtmlPart(13)
}
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
createTagBody(3, {->
invokeTag('message','g',83,['code':("button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',83,['class':("edit"),'action':("edit"),'resource':(bolaoInstance)],3)
printHtmlPart(26)
invokeTag('actionSubmit','g',84,['class':("delete"),'action':("delete"),'value':(message(code: 'button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(27)
})
invokeTag('form','g',86,['url':([resource:bolaoInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',88,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405788581000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
