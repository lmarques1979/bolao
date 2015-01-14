import bolao.Bolao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_indexindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("titulopagina.label")],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
if(true && (params.bolao)) {
printHtmlPart(5)
invokeTag('set','g',13,['var':("bolaoInstance"),'value':(Bolao.get(params.bolao.toLong()))],-1)
printHtmlPart(6)
expressionOut.print(message(code: 'cadastreseouloguese.label'))
printHtmlPart(7)
if(true && (bolaoInstance.imagem)) {
printHtmlPart(8)
invokeTag('image','asset',18,['height':("100"),'width':("100"),'src':(bolaoInstance.imagem),'title':(bolaoInstance.descricao)],-1)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(message(code: 'jacadastrado.label'))
printHtmlPart(11)
expressionOut.print(message(code: 'semcadastro.label'))
printHtmlPart(12)
}
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',28,[:],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1406078811000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
