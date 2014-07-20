import bolao.Campeonato
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_campeonato_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/campeonato/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: campeonatoInstance, field: 'descricao', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("campeonato.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("descricao"),'maxlength':("50"),'required':(""),'value':(campeonatoInstance?.descricao)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: campeonatoInstance, field: 'imagem', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("campeonato.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(5)
expressionOut.print(campeonatoInstance?.imagem)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: campeonatoInstance, field: 'enabled', 'error'))
printHtmlPart(7)
invokeTag('message','g',25,['code':("campeonato.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',28,['name':("enabled"),'value':(campeonatoInstance?.enabled)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: campeonatoInstance, field: 'jogos', 'error'))
printHtmlPart(9)
invokeTag('message','g',34,['code':("campeonato.jogos.label"),'default':("Jogos")],-1)
printHtmlPart(10)
for( j in (campeonatoInstance.jogos) ) {
printHtmlPart(11)
createTagBody(2, {->
invokeTag('formatDate','g',38,['format':("dd/MM/yyyy HH:mm"),'date':(j?.datajogo)],-1)
printHtmlPart(12)
if(true && (j?.time1?.imagem)) {
printHtmlPart(13)
invokeTag('image','asset',39,['class':("jogocampeonato"),'src':("bandeiras/24/${j?.time1?.imagem}"),'title':(j?.time1?.descricao)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(j?.time1.descricao)
printHtmlPart(14)
expressionOut.print(j?.scoretime1)
printHtmlPart(15)
expressionOut.print(j?.scoretime2)
printHtmlPart(14)
expressionOut.print(j?.time2.descricao)
printHtmlPart(16)
if(true && (j?.time2?.imagem)) {
printHtmlPart(17)
invokeTag('image','asset',42,['class':("jogocampeonato"),'src':("bandeiras/24/${j?.time2?.imagem}"),'title':(j?.time2?.descricao)],-1)
printHtmlPart(13)
}
})
invokeTag('link','g',43,['class':("nounderline"),'controller':("jogo"),'action':("show"),'id':(j.id)],2)
printHtmlPart(18)
}
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
