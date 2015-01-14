import bolao.Jogo
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_jogoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/jogo/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'jogo.label', default: 'Jogo'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("jogo.list.label")],-1)
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
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',14,['code':("jogo.create.label")],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(message(code: "filtro.statusjogo.label"))
printHtmlPart(10)
expressionOut.print(message(code: "campeonato.label"))
printHtmlPart(11)
if(true && (params.filtrodata)) {
printHtmlPart(12)
invokeTag('set','g',34,['var':("filtrodata"),'value':(params.filtrodata)],-1)
printHtmlPart(13)
}
else {
printHtmlPart(14)
invokeTag('set','g',37,['var':("filtrodata"),'value':("2")],-1)
printHtmlPart(13)
}
printHtmlPart(15)
invokeTag('select','g',40,['onchange':("this.form.submit()"),'value':(filtrodata),'name':("filtrodata"),'from':([message(code: "filtro.todos.label"), message(code: "filtro.pendente.label"), message(code: "filtro.encerrado.label")]),'keys':(['1','2','3'])],-1)
printHtmlPart(16)
if(true && (params.filtrocampeonato)) {
printHtmlPart(12)
invokeTag('set','g',46,['var':("filtrocampeonato"),'value':(params.filtrocampeonato)],-1)
printHtmlPart(13)
}
else {
printHtmlPart(14)
invokeTag('set','g',49,['var':("filtrocampeonato"),'value':("-1")],-1)
printHtmlPart(13)
}
printHtmlPart(15)
invokeTag('select','g',52,['onchange':("this.form.submit()"),'id':("campeonato"),'name':("filtrocampeonato"),'noSelection':(['-1':message(code: "filtro.campeonato.label")]),'from':(bolao.Campeonato.list()),'optionValue':("descricao"),'optionKey':("id"),'required':(""),'value':(filtrocampeonato),'class':("many-to-one")],-1)
printHtmlPart(17)
invokeTag('submitButton','g',59,['class':("invisivel"),'name':("create"),'value':("Filtrar")],-1)
printHtmlPart(18)
})
invokeTag('form','g',60,['url':([resource:jogoInstance, action:'filtro'])],2)
printHtmlPart(19)
invokeTag('message','g',62,['code':("jogo.list.label")],-1)
printHtmlPart(20)
invokeTag('set','g',67,['var':("rodadaanterior"),'value':("-1")],-1)
printHtmlPart(21)
invokeTag('set','g',68,['var':("datajogoanterior"),'value':("-1")],-1)
printHtmlPart(21)
loop:{
int i = 0
for( jogoInstance in (jogoInstanceList) ) {
printHtmlPart(22)
invokeTag('set','g',71,['var':("rodadaatual"),'value':(jogoInstance?.descricaofase)],-1)
printHtmlPart(23)
invokeTag('set','g',72,['var':("datajogoatual"),'value':(jogoInstance?.datajogo?.format('dd/MM/yyyy'))],-1)
printHtmlPart(23)
if(true && (rodadaanterior!=rodadaatual)) {
printHtmlPart(24)
expressionOut.print(jogoInstance?.descricaofase)
printHtmlPart(25)
}
printHtmlPart(23)
if(true && (datajogoanterior!=datajogoatual)) {
printHtmlPart(26)
expressionOut.print(message(code: "jogo.datajogo.label"))
printHtmlPart(27)
expressionOut.print(datajogoatual)
printHtmlPart(28)
expressionOut.print(message(code: "jogo.peso.label"))
printHtmlPart(27)
expressionOut.print(jogoInstance?.peso)
printHtmlPart(29)
}
printHtmlPart(30)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(31)
createTagBody(3, {->
printHtmlPart(32)
invokeTag('formatDate','g',95,['format':("HH:mm"),'date':(jogoInstance?.datajogo)],-1)
printHtmlPart(33)
expressionOut.print(jogoInstance?.estadio?.descricao)
printHtmlPart(13)
})
invokeTag('link','g',96,['action':("show"),'id':(jogoInstance.id)],3)
printHtmlPart(34)
expressionOut.print(jogoInstance.timezone)
printHtmlPart(35)
if(true && (jogoInstance?.time1?.imagem)) {
printHtmlPart(32)
invokeTag('image','asset',100,['src':("bandeiras/${params.tamanhoiconetimes}/${jogoInstance?.time1?.imagem}"),'title':(jogoInstance?.time1?.descricao)],-1)
printHtmlPart(13)
}
printHtmlPart(36)
expressionOut.print(jogoInstance?.time1?.descricao)
printHtmlPart(37)
expressionOut.print(jogoInstance?.scoretime1)
printHtmlPart(38)
expressionOut.print(jogoInstance?.scoretime2)
printHtmlPart(39)
if(true && (jogoInstance?.time2?.imagem)) {
printHtmlPart(32)
invokeTag('image','asset',120,['src':("bandeiras/${params.tamanhoiconetimes}/${jogoInstance?.time2?.imagem}"),'title':(jogoInstance?.time2?.descricao)],-1)
printHtmlPart(13)
}
printHtmlPart(36)
expressionOut.print(jogoInstance?.time2?.descricao)
printHtmlPart(40)
if(true && (jogoInstance?.campeonato?.imagem)) {
printHtmlPart(32)
invokeTag('image','asset',127,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':("campeonatos/${jogoInstance?.campeonato?.descricao}/${jogoInstance?.campeonato?.imagem}"),'title':(jogoInstance?.campeonato?.descricao)],-1)
printHtmlPart(13)
}
printHtmlPart(41)
expressionOut.print(jogoInstance?.campeonato?.descricao)
printHtmlPart(42)
loop:{
int k = 0
for( extra in (jogoInstance?.extras) ) {
printHtmlPart(43)
if(true && (k==0)) {
printHtmlPart(44)
expressionOut.print(message(code: "extras.label"))
printHtmlPart(45)
}
printHtmlPart(46)
expressionOut.print(extra.descricao)
printHtmlPart(47)
expressionOut.print(extra.scoretime1)
printHtmlPart(48)
expressionOut.print(extra.scoretime2)
printHtmlPart(49)
k++
}
}
printHtmlPart(23)
invokeTag('set','g',149,['var':("rodadaanterior"),'value':(rodadaatual)],-1)
printHtmlPart(23)
invokeTag('set','g',150,['var':("datajogoanterior"),'value':(datajogoatual)],-1)
printHtmlPart(21)
i++
}
}
printHtmlPart(50)
invokeTag('paginate','g',155,['total':(jogoInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(51)
})
invokeTag('captureBody','sitemesh',158,[:],1)
printHtmlPart(52)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405435763000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
