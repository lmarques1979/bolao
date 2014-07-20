import bolao.UsuarioBolao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_usuarioBolaoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuarioBolao/show.gsp" }
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
invokeTag('message','g',12,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',15,['code':("palpite.label")],-1)
})
invokeTag('link','g',15,['class':("palpites"),'controller':("Palpite"),'action':("index")],2)
printHtmlPart(6)
expressionOut.print(usuarioBolaoInstance?.bolao?.descricao)
printHtmlPart(7)
if(true && (usuarioBolaoInstance?.bolao?.imagem)) {
printHtmlPart(8)
invokeTag('image','asset',26,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':("bolao/${usuarioBolaoInstance?.bolao?.descricao}/${usuarioBolaoInstance?.bolao?.imagem}"),'title':(usuarioBolaoInstance?.bolao?.descricao)],-1)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(usuarioBolaoInstance?.bolao?.informacao)
printHtmlPart(11)
invokeTag('image','asset',40,['src':("skin/bolao_criacao.png"),'title':("Data de Criação")],-1)
printHtmlPart(12)
invokeTag('formatDate','g',40,['format':("dd/MM/yyyy HH:mm"),'date':(usuarioBolaoInstance?.bolao?.dateCreated)],-1)
printHtmlPart(13)
invokeTag('image','asset',41,['src':("skin/administrador.png"),'title':("Administrador")],-1)
printHtmlPart(14)
expressionOut.print(usuarioBolaoInstance?.bolao?.admin?.username)
printHtmlPart(13)
invokeTag('image','asset',42,['src':("skin/membros.png"),'title':("Quantidade de Membros")],-1)
printHtmlPart(15)
expressionOut.print(usuarioBolaoInstanceCount)
printHtmlPart(16)
expressionOut.print(usuarioBolaoInstance?.bolao?.descricao)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',56,[:],1)
printHtmlPart(18)
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
