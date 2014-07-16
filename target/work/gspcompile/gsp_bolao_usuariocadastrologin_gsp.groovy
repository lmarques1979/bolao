import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_usuariocadastrologin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/cadastrologin.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'usuario.label', default: 'Usuario'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("usuario.list.label")],-1)
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
invokeTag('message','g',18,['code':("springSecurity.login.header")],-1)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
expressionOut.print(postUrl)
printHtmlPart(9)
invokeTag('message','g',26,['code':("springSecurity.login.username.label")],-1)
printHtmlPart(10)
invokeTag('message','g',31,['code':("springSecurity.login.password.label")],-1)
printHtmlPart(11)
expressionOut.print(params.bolao)
printHtmlPart(12)
expressionOut.print(rememberMeParameter)
printHtmlPart(13)
if(true && (hasCookie)) {
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',39,['code':("springSecurity.login.remember.me.label")],-1)
printHtmlPart(16)
createClosureForHtmlPart(17, 2)
invokeTag('link','g',42,['controller':("Usuario"),'action':("esqueceusenha")],2)
printHtmlPart(18)
expressionOut.print(message(code: "springSecurity.login.button"))
printHtmlPart(19)
invokeTag('message','g',56,['code':("usuario.create.label")],-1)
printHtmlPart(20)
if(true && (flash.message)) {
printHtmlPart(21)
expressionOut.print(flash.message)
printHtmlPart(22)
}
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(25)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(26)
expressionOut.print(error.field)
printHtmlPart(27)
}
printHtmlPart(28)
invokeTag('message','g',63,['error':(error)],-1)
printHtmlPart(29)
})
invokeTag('eachError','g',64,['bean':(usuarioInstance),'var':("error")],3)
printHtmlPart(30)
})
invokeTag('hasErrors','g',66,['bean':(usuarioInstance)],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(31)
invokeTag('render','g',69,['template':("form")],-1)
printHtmlPart(32)
invokeTag('submitButton','g',72,['name':("create"),'class':("save"),'value':(message(code: 'button.create.label', default: 'Create'))],-1)
printHtmlPart(33)
})
invokeTag('uploadForm','g',74,['url':([resource:usuarioInstance, action:'save'])],2)
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',78,[:],1)
printHtmlPart(35)
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
