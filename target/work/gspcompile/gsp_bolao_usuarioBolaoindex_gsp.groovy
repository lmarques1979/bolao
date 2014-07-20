import bolao.UsuarioBolao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_usuarioBolaoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuarioBolao/index.gsp" }
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
printHtmlPart(3)
if(true && (usuarioBolaoInstanceCount > 0)) {
printHtmlPart(4)
invokeTag('message','g',12,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
if(true && (usuarioBolaoInstanceList[0].usuario.imagem)) {
printHtmlPart(6)
invokeTag('image','asset',19,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':(usuarioBolaoInstanceList[0].usuario.imagem),'title':(usuarioBolaoInstanceList[0].usuario.username)],-1)
printHtmlPart(7)
}
else {
printHtmlPart(8)
invokeTag('image','asset',22,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':("noimage.jpg"),'title':(usuarioBolaoInstanceList[0].usuario.username)],-1)
printHtmlPart(7)
}
printHtmlPart(9)
expressionOut.print(usuarioBolaoInstanceList[0].usuario.buscaNome(usuarioBolaoInstanceList[0].usuario))
printHtmlPart(10)
invokeTag('image','asset',31,['src':("skin/email.png"),'title':("E-mail")],-1)
printHtmlPart(11)
expressionOut.print(usuarioBolaoInstanceList[0].usuario.email)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',41,['code':("usuarioBolao.list.label"),'default':("Bolao")],-1)
printHtmlPart(16)
invokeTag('message','g',44,['code':("usuarioBolao.bolao.label")],-1)
printHtmlPart(17)
invokeTag('message','g',45,['code':("usuarioBolao.campeonato.label")],-1)
printHtmlPart(17)
invokeTag('message','g',46,['code':("usuarioBolao.posicaoatual.label")],-1)
printHtmlPart(17)
invokeTag('message','g',47,['code':("usuarioBolao.status.label")],-1)
printHtmlPart(18)
loop:{
int i = 0
for( usuarioBolaoInstance in (usuarioBolaoInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
if(true && (usuarioBolaoInstance?.bolao?.imagem)) {
printHtmlPart(21)
invokeTag('image','asset',58,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':(usuarioBolaoInstance?.bolao?.imagem),'title':(usuarioBolaoInstance?.bolao?.descricao)],-1)
printHtmlPart(22)
}
printHtmlPart(23)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: usuarioBolaoInstance?.bolao, field: "descricao"))
})
invokeTag('link','g',60,['controller':("UsuarioBolao"),'action':("pontuacao"),'id':(usuarioBolaoInstance.id)],4)
printHtmlPart(24)
expressionOut.print(usuarioBolaoInstance.bolao.campeonato.descricao)
printHtmlPart(25)
expressionOut.print(usuarioBolaoInstance.posicaoatual)
printHtmlPart(26)
invokeTag('formatBoolean','g',72,['boolean':(usuarioBolaoInstance.bolao.enabled)],-1)
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
}
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',83,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405897928000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
