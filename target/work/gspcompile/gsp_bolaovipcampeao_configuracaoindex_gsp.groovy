import bolao.Configuracao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_configuracaoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/configuracao/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'configuracao.label', default: 'Configuracao'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("configuracao.list.label")],-1)
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
if(true && (configuracaoInstanceCount==0)) {
printHtmlPart(6)
createTagBody(3, {->
invokeTag('message','g',16,['code':("configuracao.create.label")],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],3)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('message','g',21,['code':("configuracao.list.label")],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',29,['property':("alturaimagens"),'title':(message(code: 'configuracao.alturaimagens.label', default: 'Altura Imagens'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',31,['property':("larguraimagens"),'title':(message(code: 'configuracao.larguraimagens.label', default: 'Largura Imagens'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',33,['property':("alturaimagensthumbs"),'title':(message(code: 'configuracao.alturaimagensthumbs.label', default: 'Altura Imagens Thumbnail'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',35,['property':("larguraimagensthumbs"),'title':(message(code: 'configuracao.larguraimagensthumbs.label', default: 'Largura Imagens Thumbnail'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',37,['property':("tamanhoiconetimes"),'title':(message(code: 'configuracao.tamanhoiconetimes.label', default: 'Tamanho Icone Times'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',39,['property':("itensporpagina"),'title':(message(code: 'configuracao.itensporpagina.label', default: 'Itens por Página'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',41,['property':("minutosparapalpite"),'title':(message(code: 'configuracao.minutosparapalpite.label', default: 'Minutos para Palpite'))],-1)
printHtmlPart(15)
loop:{
int i = 0
for( configuracaoInstance in (configuracaoInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "alturaimagens"))
})
invokeTag('link','g',48,['action':("show"),'id':(configuracaoInstance.id)],3)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "larguraimagens"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "alturaimagensthumbs"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "larguraimagensthumbs"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "tamanhoiconetimes"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "itensporpagina"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "minutosparapalpite"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',68,['total':(configuracaoInstanceCount ?: 0)],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',71,[:],1)
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
