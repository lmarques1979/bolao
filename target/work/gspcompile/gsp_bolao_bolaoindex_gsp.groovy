import bolao.Bolao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_bolaoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bolao/index.gsp" }
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
invokeTag('message','g',13,['code':("bolao.create.label")],-1)
})
invokeTag('link','g',13,['class':("create"),'action':("create")],2)
printHtmlPart(5)
invokeTag('message','g',17,['code':("bolao.list.label")],-1)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('sortableColumn','g',24,['property':("descricao"),'title':(message(code: 'bolao.descricao.label', default: 'Descricao'))],-1)
printHtmlPart(10)
invokeTag('message','g',26,['code':("bolao.informacao.label")],-1)
printHtmlPart(11)
invokeTag('message','g',28,['code':("bolao.url.label")],-1)
printHtmlPart(12)
invokeTag('message','g',30,['code':("bolao.admin.label")],-1)
printHtmlPart(13)
invokeTag('message','g',32,['code':("campeonato.label")],-1)
printHtmlPart(13)
invokeTag('message','g',34,['code':("bolao.autorizacao.label")],-1)
printHtmlPart(11)
invokeTag('message','g',36,['code':("bolao.imagem.label")],-1)
printHtmlPart(11)
invokeTag('message','g',38,['code':("bolao.enabled.label")],-1)
printHtmlPart(14)
loop:{
int i = 0
for( bolaoInstance in (bolaoInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: bolaoInstance, field: "descricao"))
})
invokeTag('link','g',49,['action':("show"),'id':(bolaoInstance.id)],3)
printHtmlPart(17)
expressionOut.print(bolaoInstance?.informacao)
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',54,['target':("_blank"),'class':("create"),'controller':("index"),'params':([bolao: bolaoInstance?.id])],3)
printHtmlPart(20)
expressionOut.print(bolaoInstance?.admin?.primeironome)
printHtmlPart(21)
if(true && (bolaoInstance?.admin?.sobrenome)) {
printHtmlPart(22)
expressionOut.print(" "+ bolaoInstance?.admin?.sobrenome)
printHtmlPart(23)
}
printHtmlPart(24)
expressionOut.print(bolaoInstance?.campeonato?.descricao)
printHtmlPart(18)
invokeTag('formatBoolean','g',66,['boolean':(bolaoInstance?.autorizacao)],-1)
printHtmlPart(25)
if(true && (bolaoInstance?.autorizacao==true)) {
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',68,['code':("bolao.autorizar.label")],-1)
})
invokeTag('link','g',68,['class':("autorizacao"),'controller':("UsuarioBolao"),'action':("listaautorizacao"),'id':(bolaoInstance.id)],4)
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (bolaoInstance.imagem)) {
printHtmlPart(22)
invokeTag('image','asset',74,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':(bolaoInstance.imagem),'title':(bolaoInstance.descricao)],-1)
printHtmlPart(28)
}
printHtmlPart(29)
invokeTag('formatBoolean','g',78,['boolean':(bolaoInstance?.enabled)],-1)
printHtmlPart(30)
i++
}
}
printHtmlPart(31)
invokeTag('paginate','g',86,['total':(bolaoInstanceCount ?: 0)],-1)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',89,[:],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405788448000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
