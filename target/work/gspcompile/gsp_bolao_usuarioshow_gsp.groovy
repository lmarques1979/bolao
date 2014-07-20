import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_usuarioshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/show.gsp" }
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
invokeTag('message','g',13,['code':("usuario.list.label")],-1)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (usuarioInstance?.imagem)) {
printHtmlPart(9)
invokeTag('message','g',22,['code':("usuario.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(10)
if(true && (usuarioInstance.imagem)) {
printHtmlPart(11)
invokeTag('image','asset',26,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':(usuarioInstance.imagem),'title':(usuarioInstance.username)],-1)
printHtmlPart(12)
}
else {
printHtmlPart(11)
invokeTag('image','asset',29,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':("noimage.jpg"),'title':(usuarioInstance.username)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (usuarioInstance?.timecoracao)) {
printHtmlPart(15)
invokeTag('message','g',38,['code':("usuario.timecoracao.label"),'default':("Time de Coração")],-1)
printHtmlPart(10)
if(true && (usuarioInstance.timecoracao.imagem)) {
printHtmlPart(11)
invokeTag('image','asset',42,['src':("bandeiras/32/${usuarioInstance.timecoracao.imagem}"),'title':(usuarioInstance.timecoracao.descricao)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(16)
if(true && (usuarioInstance?.username)) {
printHtmlPart(17)
invokeTag('message','g',51,['code':("usuario.username.label"),'default':("Username")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',53,['bean':(usuarioInstance),'field':("username")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (usuarioInstance?.email)) {
printHtmlPart(21)
invokeTag('message','g',62,['code':("usuario.email.label"),'default':("Email")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',64,['bean':(usuarioInstance),'field':("email")],-1)
printHtmlPart(23)
}
printHtmlPart(20)
if(true && (usuarioInstance?.primeironome)) {
printHtmlPart(24)
invokeTag('message','g',71,['code':("usuario.primeironome.label"),'default':("Primeironome")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',73,['bean':(usuarioInstance),'field':("primeironome")],-1)
printHtmlPart(23)
}
printHtmlPart(20)
if(true && (usuarioInstance?.sobrenome)) {
printHtmlPart(26)
invokeTag('message','g',80,['code':("usuario.sobrenome.label"),'default':("Sobrenome")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',82,['bean':(usuarioInstance),'field':("sobrenome")],-1)
printHtmlPart(23)
}
printHtmlPart(20)
if(true && (usuarioInstance?.enabled)) {
printHtmlPart(28)
invokeTag('message','g',89,['code':("usuario.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(29)
invokeTag('formatBoolean','g',91,['boolean':(usuarioInstance?.enabled)],-1)
printHtmlPart(23)
}
printHtmlPart(30)
if(true && (usuarioInstance?.accountExpired)) {
printHtmlPart(31)
invokeTag('message','g',99,['code':("usuario.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(32)
invokeTag('formatBoolean','g',101,['boolean':(usuarioInstance?.accountExpired)],-1)
printHtmlPart(23)
}
printHtmlPart(20)
if(true && (usuarioInstance?.accountLocked)) {
printHtmlPart(33)
invokeTag('message','g',108,['code':("usuario.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(34)
invokeTag('formatBoolean','g',110,['boolean':(usuarioInstance?.accountLocked)],-1)
printHtmlPart(23)
}
printHtmlPart(20)
if(true && (usuarioInstance?.enabled)) {
printHtmlPart(28)
invokeTag('message','g',117,['code':("usuario.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(29)
invokeTag('formatBoolean','g',119,['boolean':(usuarioInstance?.enabled)],-1)
printHtmlPart(23)
}
printHtmlPart(35)
if(true && (usuarioInstance?.passwordExpired)) {
printHtmlPart(36)
invokeTag('message','g',127,['code':("usuario.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(37)
invokeTag('formatBoolean','g',129,['boolean':(usuarioInstance?.passwordExpired)],-1)
printHtmlPart(23)
}
printHtmlPart(38)
createTagBody(2, {->
printHtmlPart(39)
createTagBody(3, {->
invokeTag('message','g',141,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',141,['class':("edit"),'action':("edit"),'resource':(usuarioInstance)],3)
printHtmlPart(40)
invokeTag('actionSubmit','g',142,['class':("delete"),'action':("delete"),'value':(message(code: 'button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(41)
})
invokeTag('form','g',144,['url':([resource:usuarioInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(42)
})
invokeTag('captureBody','sitemesh',146,[:],1)
printHtmlPart(43)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405788413000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
