import bolao.UsuarioBolao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_usuarioBolaolistaautorizacao_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuarioBolao/listaautorizacao.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'usuarioBolao.label', default: 'UsuarioBolao'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("usuarioBolao.list.label")],-1)
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
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('message','g',22,['code':("bolao.autorizar.label"),'default':("Bolao")],-1)
printHtmlPart(9)
invokeTag('message','g',25,['code':("bolao.nomebolao.label")],-1)
printHtmlPart(10)
invokeTag('message','g',26,['code':("bolao.nomeusuariobolao.label")],-1)
printHtmlPart(10)
invokeTag('message','g',27,['code':("bolao.emailusuariobolao.label")],-1)
printHtmlPart(11)
loop:{
int i = 0
for( usuarioBolaoInstance in (usuarioBolaoInstanceList) ) {
printHtmlPart(12)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(13)
expressionOut.print(usuarioBolaoInstance.bolao.descricao)
printHtmlPart(14)
expressionOut.print(usuarioBolaoInstance.usuario.buscaNome(usuarioBolaoInstance.usuario))
printHtmlPart(14)
expressionOut.print(usuarioBolaoInstance.usuario.email)
printHtmlPart(14)
if(true && (usuarioBolaoInstance.autorizado==false)) {
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
invokeTag('image','asset',51,['src':("skin/ok_24.png"),'title':("Autorizar ${usuarioBolaoInstance.usuario.buscaNome(usuarioBolaoInstance.usuario)}")],-1)
printHtmlPart(15)
})
invokeTag('link','g',52,['action':("autorizar"),'id':(usuarioBolaoInstance.id)],4)
printHtmlPart(17)
}
else {
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
invokeTag('image','asset',56,['src':("skin/remove_24.png"),'title':("Desautorizar ${usuarioBolaoInstance.usuario.buscaNome(usuarioBolaoInstance.usuario)}")],-1)
printHtmlPart(15)
})
invokeTag('link','g',57,['action':("desautorizar"),'id':(usuarioBolaoInstance.id)],4)
printHtmlPart(17)
}
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',66,[:],1)
printHtmlPart(20)
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
