import bolao.Campeonato
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_campeonatoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/campeonato/index.gsp" }
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
invokeTag('message','g',14,['code':("default.new.label"),'args':([entityName])],-1)
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
invokeTag('sortableColumn','g',26,['property':("descricao"),'title':(message(code: 'campeonato.descricao.label', default: 'Descricao'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',28,['property':("imagem"),'title':(message(code: 'campeonato.imagem.label', default: 'Imagem'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',30,['property':("enabled"),'title':(message(code: 'campeonato.enabled.label', default: 'Ativo'))],-1)
printHtmlPart(12)
loop:{
int i = 0
for( campeonatoInstance in (campeonatoInstanceList) ) {
printHtmlPart(13)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: campeonatoInstance, field: "descricao"))
})
invokeTag('link','g',39,['action':("show"),'id':(campeonatoInstance.id)],3)
printHtmlPart(15)
if(true && (campeonatoInstance.imagem)) {
printHtmlPart(16)
invokeTag('image','asset',42,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':(campeonatoInstance.imagem),'title':(campeonatoInstance.descricao)],-1)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('formatBoolean','g',46,['boolean':(campeonatoInstance.enabled)],-1)
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
invokeTag('paginate','g',54,['total':(campeonatoInstanceCount ?: 0)],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',57,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405788518000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
