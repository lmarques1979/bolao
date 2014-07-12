import bolao.Configuracao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_configuracaoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/configuracao/show.gsp" }
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
invokeTag('message','g',14,['code':("configuracao.list.label")],-1)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (configuracaoInstance?.alturaimagens)) {
printHtmlPart(10)
invokeTag('message','g',22,['code':("configuracao.alturaimagens.label"),'default':("Altura Imagens")],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',24,['bean':(configuracaoInstance),'field':("alturaimagens")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (configuracaoInstance?.larguraimagens)) {
printHtmlPart(14)
invokeTag('message','g',31,['code':("configuracao.larguraimagens.label"),'default':("Largura Imagens")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',33,['bean':(configuracaoInstance),'field':("larguraimagens")],-1)
printHtmlPart(12)
}
printHtmlPart(16)
if(true && (configuracaoInstance?.alturaimagensthumbs)) {
printHtmlPart(17)
invokeTag('message','g',40,['code':("configuracao.alturaimagensthumbs.label"),'default':("Altura Imagens Thumnail")],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',42,['bean':(configuracaoInstance),'field':("alturaimagensthumbs")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (configuracaoInstance?.larguraimagensthumbs)) {
printHtmlPart(18)
invokeTag('message','g',49,['code':("configuracao.larguraimagensthumbs.label"),'default':("Largura Imagens Thumbnail")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',51,['bean':(configuracaoInstance),'field':("larguraimagensthumbs")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (configuracaoInstance?.tamanhoiconetimes)) {
printHtmlPart(20)
invokeTag('message','g',58,['code':("configuracao.tamanhoiconetimes.label"),'default':("Tamanho Icone Times")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',60,['bean':(configuracaoInstance),'field':("tamanhoiconetimes")],-1)
printHtmlPart(12)
}
printHtmlPart(16)
if(true && (configuracaoInstance?.itensporpagina)) {
printHtmlPart(22)
invokeTag('message','g',67,['code':("configuracao.itensporpagina.label"),'default':("Itens por Página")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',69,['bean':(configuracaoInstance),'field':("itensporpagina")],-1)
printHtmlPart(12)
}
printHtmlPart(16)
if(true && (configuracaoInstance?.minutosparapalpite)) {
printHtmlPart(23)
invokeTag('message','g',76,['code':("configuracao.minutosparapalpite.label"),'default':("Minutos para Palpite")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',78,['bean':(configuracaoInstance),'field':("minutosparapalpite")],-1)
printHtmlPart(12)
}
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
invokeTag('message','g',87,['code':("button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',87,['class':("edit"),'action':("edit"),'resource':(configuracaoInstance)],3)
printHtmlPart(27)
invokeTag('actionSubmit','g',88,['class':("delete"),'action':("delete"),'value':(message(code: 'button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(28)
})
invokeTag('form','g',90,['url':([resource:configuracaoInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',92,[:],1)
printHtmlPart(30)
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
