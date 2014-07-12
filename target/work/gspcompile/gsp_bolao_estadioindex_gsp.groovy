import bolao.Estadio
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_estadioindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/estadio/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'estadio.label', default: 'Estadio'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("estadio.list.label")],-1)
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
invokeTag('message','g',14,['code':("estadio.create.label")],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(6)
invokeTag('message','g',18,['code':("estadio.list.label")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('sortableColumn','g',26,['property':("descricao"),'title':(message(code: 'estadio.descricao.label', default: 'Descricao'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',28,['property':("cidade"),'title':(message(code: 'estadio.cidade.label', default: 'Cidade'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',30,['property':("estado"),'title':(message(code: 'estadio.estado.label', default: 'Estado'))],-1)
printHtmlPart(12)
invokeTag('message','g',32,['code':("estadio.pais.label"),'default':("Pais")],-1)
printHtmlPart(13)
loop:{
int i = 0
for( estadioInstance in (estadioInstanceList) ) {
printHtmlPart(14)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: estadioInstance, field: "descricao"))
})
invokeTag('link','g',40,['action':("show"),'id':(estadioInstance.id)],3)
printHtmlPart(16)
expressionOut.print(fieldValue(bean: estadioInstance, field: "cidade"))
printHtmlPart(16)
expressionOut.print(fieldValue(bean: estadioInstance, field: "estado"))
printHtmlPart(17)
if(true && (estadioInstance?.pais?.imagem)) {
printHtmlPart(18)
invokeTag('image','asset',48,['src':("bandeiras/${params.tamanhoiconetimes}/${estadioInstance?.pais?.imagem}"),'title':(estadioInstance?.pais?.descricao)],-1)
printHtmlPart(19)
}
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('paginate','g',57,['total':(estadioInstanceCount ?: 0)],-1)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',60,[:],1)
printHtmlPart(23)
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
