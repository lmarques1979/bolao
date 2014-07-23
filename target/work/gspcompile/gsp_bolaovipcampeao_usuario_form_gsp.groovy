import seguranca.Usuario
import bolao.Time
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_usuario_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'username', 'error'))
printHtmlPart(2)
invokeTag('message','g',6,['code':("usuario.username.label"),'default':("Username")],-1)
printHtmlPart(3)
invokeTag('textField','g',9,['name':("username"),'size':("20"),'maxlenght':("30"),'required':(""),'value':(usuarioInstance?.username)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'password', 'error'))
printHtmlPart(5)
invokeTag('message','g',15,['code':("usuario.password.label"),'default':("Password")],-1)
printHtmlPart(3)
invokeTag('passwordField','g',18,['name':("password"),'size':("20"),'maxlenght':("30"),'required':(""),'value':(usuarioInstance?.password)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'email', 'error'))
printHtmlPart(6)
invokeTag('message','g',24,['code':("usuario.email.label"),'default':("Email")],-1)
printHtmlPart(3)
invokeTag('field','g',27,['type':("email"),'size':("35"),'maxlenght':("100"),'name':("email"),'required':(""),'value':(usuarioInstance?.email)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'primeironome', 'error'))
printHtmlPart(7)
invokeTag('message','g',33,['code':("usuario.primeironome.label"),'default':("Primeironome")],-1)
printHtmlPart(3)
invokeTag('textField','g',36,['name':("primeironome"),'required':(""),'value':(usuarioInstance?.primeironome)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'sobrenome', 'error'))
printHtmlPart(8)
invokeTag('message','g',42,['code':("usuario.sobrenome.label"),'default':("Sobrenome")],-1)
printHtmlPart(9)
invokeTag('textField','g',45,['name':("sobrenome"),'value':(usuarioInstance?.sobrenome)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'imagem', 'error'))
printHtmlPart(8)
invokeTag('message','g',51,['code':("usuario.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(10)
expressionOut.print(usuarioInstance?.imagem)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'timecoracao', 'error'))
printHtmlPart(8)
invokeTag('message','g',60,['code':("usuario.timecoracao.label"),'default':("Time de Coração")],-1)
printHtmlPart(9)
invokeTag('select','g',63,['id':("timecoracao"),'name':("timecoracao.id"),'noSelection':(['': message(code:"usuario.selecionartimecoracao.label")]),'from':(Time.list()),'optionValue':("descricao"),'optionKey':("id"),'value':(usuarioInstance?.timecoracao?.id),'class':("many-to-one")],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'enabled', 'error'))
printHtmlPart(13)
invokeTag('message','g',68,['code':("usuario.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(9)
invokeTag('checkBox','g',71,['name':("enabled"),'value':(usuarioInstance?.enabled)],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'accountExpired', 'error'))
printHtmlPart(15)
invokeTag('message','g',78,['code':("usuario.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(16)
invokeTag('checkBox','g',80,['name':("accountExpired"),'value':(usuarioInstance?.accountExpired)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'accountLocked', 'error'))
printHtmlPart(17)
invokeTag('message','g',86,['code':("usuario.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(9)
invokeTag('checkBox','g',89,['name':("accountLocked"),'value':(usuarioInstance?.accountLocked)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'enabled', 'error'))
printHtmlPart(13)
invokeTag('message','g',95,['code':("usuario.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(9)
invokeTag('checkBox','g',98,['name':("enabled"),'value':(usuarioInstance?.enabled)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'passwordExpired', 'error'))
printHtmlPart(18)
invokeTag('message','g',104,['code':("usuario.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(9)
invokeTag('checkBox','g',107,['name':("passwordExpired"),'value':(usuarioInstance?.passwordExpired)],-1)
printHtmlPart(19)
expressionOut.print(params.bolao)
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
