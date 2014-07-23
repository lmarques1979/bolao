import bolao.Extras
import bolao.Jogo
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_extras_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/extras/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('set','g',4,['var':("jogo"),'value':(Jogo.get(Long.valueOf(params.id).longValue()))],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',5,['name':("jogo"),'value':(jogo.id)],-1)
printHtmlPart(2)
invokeTag('message','g',10,['code':("extras.descricao.label")],-1)
printHtmlPart(3)
invokeTag('message','g',11,['code':("jogo.time1.label")],-1)
printHtmlPart(3)
invokeTag('message','g',12,['code':("extras.scoretime1.label")],-1)
printHtmlPart(3)
invokeTag('message','g',13,['code':("extras.scoretime2.label")],-1)
printHtmlPart(3)
invokeTag('message','g',14,['code':("jogo.time2.label")],-1)
printHtmlPart(4)
invokeTag('textField','g',19,['name':("descricao"),'required':(""),'value':(extrasInstance?.descricao)],-1)
printHtmlPart(5)
if(true && (jogo?.time1?.imagem)) {
printHtmlPart(6)
invokeTag('image','asset',21,['src':("bandeiras/${params.tamanhoiconetimes}/${jogo?.time1?.imagem}"),'title':(jogo?.time1?.descricao)],-1)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('field','g',24,['name':("scoretime1"),'required':(""),'type':("number"),'size':("2"),'maxlength':("2"),'value':(extrasInstance.scoretime1)],-1)
printHtmlPart(5)
invokeTag('field','g',25,['name':("scoretime2"),'required':(""),'type':("number"),'size':("2"),'maxlength':("2"),'value':(extrasInstance.scoretime2)],-1)
printHtmlPart(5)
if(true && (jogo?.time2?.imagem)) {
printHtmlPart(6)
invokeTag('image','asset',27,['src':("bandeiras/${params.tamanhoiconetimes}/${jogo?.time2?.imagem}"),'title':(jogo?.time2?.descricao)],-1)
printHtmlPart(7)
}
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405366212000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
