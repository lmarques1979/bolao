import bolao.Bolao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_diversoscontato_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/diversos/contato.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'bolao.label', default: 'Bolao'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("regulamento.list.label")],-1)
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
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('message','g',19,['code':("contato.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',24,['code':("nomecontato.label")],-1)
printHtmlPart(10)
invokeTag('textField','g',27,['name':("nomecontato"),'size':("30"),'maxlength':("50"),'required':("")],-1)
printHtmlPart(11)
invokeTag('message','g',33,['code':("emailcontato.label")],-1)
printHtmlPart(10)
invokeTag('textField','g',36,['name':("emailcontato"),'size':("40"),'maxlength':("50"),'required':("")],-1)
printHtmlPart(12)
invokeTag('message','g',42,['code':("telefonecontato.label")],-1)
printHtmlPart(13)
invokeTag('textField','g',44,['name':("telefonecontato"),'size':("15"),'maxlength':("14")],-1)
printHtmlPart(14)
invokeTag('message','g',50,['code':("assuntocontato.label")],-1)
printHtmlPart(13)
invokeTag('textField','g',52,['name':("assuntocontato"),'size':("30"),'maxlength':("50")],-1)
printHtmlPart(15)
invokeTag('message','g',58,['code':("mensagemcontato.label")],-1)
printHtmlPart(10)
invokeTag('textArea','g',61,['name':("mensagemcontato"),'rows':("5"),'cols':("35"),'required':("")],-1)
printHtmlPart(16)
invokeTag('submitButton','g',65,['name':("create"),'value':(message(code: 'button.send.label'))],-1)
printHtmlPart(17)
})
invokeTag('form','g',68,['controller':("diversos"),'action':("enviaremail")],2)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(19)
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
