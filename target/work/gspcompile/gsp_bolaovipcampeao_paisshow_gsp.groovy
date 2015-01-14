import bolao.Pais
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_paisshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pais/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'pais.label', default: 'Pais'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("pais.list.label")],-1)
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
invokeTag('message','g',13,['code':("pais.list.label")],-1)
})
invokeTag('link','g',13,['class':("list"),'action':("index")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',14,['code':("pais.create.label")],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(6)
invokeTag('message','g',18,['code':("pais.list.label")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (paisInstance?.codigo)) {
printHtmlPart(11)
invokeTag('message','g',26,['code':("pais.codigo.label"),'default':("Codigo")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',28,['bean':(paisInstance),'field':("codigo")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (paisInstance?.descricao)) {
printHtmlPart(15)
invokeTag('message','g',35,['code':("pais.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',37,['bean':(paisInstance),'field':("descricao")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (paisInstance?.imagem)) {
printHtmlPart(17)
invokeTag('message','g',44,['code':("pais.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',46,['bean':(paisInstance),'field':("imagem")],-1)
printHtmlPart(13)
}
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
createTagBody(3, {->
invokeTag('message','g',56,['code':("button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',56,['class':("edit"),'action':("edit"),'resource':(paisInstance)],3)
printHtmlPart(21)
invokeTag('actionSubmit','g',57,['class':("delete"),'action':("delete"),'value':(message(code: 'button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(22)
})
invokeTag('form','g',59,['url':([resource:paisInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',61,[:],1)
printHtmlPart(24)
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
