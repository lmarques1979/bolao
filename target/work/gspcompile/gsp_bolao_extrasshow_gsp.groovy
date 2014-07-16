import bolao.Extras
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_extrasshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/extras/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'extras.label', default: 'Extras'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
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
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (extrasInstance?.dateCreated)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("extras.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',30,['date':(extrasInstance?.dateCreated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (extrasInstance?.descricao)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("extras.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(extrasInstance),'field':("descricao")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (extrasInstance?.jogo)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("extras.jogo.label"),'default':("Jogo")],-1)
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(extrasInstance?.jogo?.time1?.descricao?.encodeAsHTML())
printHtmlPart(22)
expressionOut.print(extrasInstance?.jogo?.time2?.descricao?.encodeAsHTML())
})
invokeTag('link','g',48,['controller':("jogo"),'action':("show"),'id':(extrasInstance?.jogo?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (extrasInstance?.lastUpdated)) {
printHtmlPart(23)
invokeTag('message','g',55,['code':("extras.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(24)
invokeTag('formatDate','g',57,['date':(extrasInstance?.lastUpdated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (extrasInstance?.scoretime1)) {
printHtmlPart(25)
invokeTag('message','g',64,['code':("extras.scoretime1.label"),'default':("Scoretime1")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',66,['bean':(extrasInstance),'field':("scoretime1")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (extrasInstance?.scoretime2)) {
printHtmlPart(27)
invokeTag('message','g',73,['code':("extras.scroretime2.label"),'default':("Scroretime2")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',75,['bean':(extrasInstance),'field':("scoretime2")],-1)
printHtmlPart(16)
}
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createTagBody(3, {->
invokeTag('message','g',83,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',83,['class':("edit"),'action':("edit"),'resource':(extrasInstance)],3)
printHtmlPart(31)
invokeTag('actionSubmit','g',84,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(32)
})
invokeTag('form','g',86,['url':([resource:extrasInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',88,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405374970000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
