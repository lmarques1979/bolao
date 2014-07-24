import bolao.Palpite
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_palpiteindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/palpite/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'palpite.label', default: 'Palpite'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("palpite.list.label")],-1)
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
invokeTag('message','g',14,['code':("palpite.list.label")],-1)
printHtmlPart(5)
expressionOut.print(usuarioBolaoInstance.usuario.buscaNome(usuarioBolaoInstance.usuario))
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (flash.erros)) {
printHtmlPart(10)
loop:{
int i = 0
for( erro in (flash.erros) ) {
printHtmlPart(11)
expressionOut.print(erro)
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
}
else {
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
invokeTag('hiddenField','g',28,['name':("id"),'value':(usuarioBolaoInstance.id)],-1)
printHtmlPart(16)
invokeTag('message','g',31,['code':("palpite.filtro.label")],-1)
printHtmlPart(17)
if(true && (params.filtrodatapalpite)) {
printHtmlPart(18)
invokeTag('set','g',39,['var':("filtrodatapalpite"),'value':(params.filtrodatapalpite)],-1)
printHtmlPart(19)
}
else {
printHtmlPart(20)
invokeTag('set','g',42,['var':("filtrodatapalpite"),'value':("2")],-1)
printHtmlPart(19)
}
printHtmlPart(21)
invokeTag('select','g',45,['id':("filtropalpite"),'value':(filtrodatapalpite),'name':("filtrodatapalpite"),'from':([message(code: "filtro.todos.label"), message(code: "filtro.emaberto.label"), message(code: "filtro.finalizados.label")]),'keys':(['1','2','3'])],-1)
printHtmlPart(22)
})
invokeTag('form','g',53,['id':("formfiltropalpite"),'url':([action:'index',controller:'palpite']),'method':("POST")],3)
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(15)
invokeTag('hiddenField','g',57,['name':("usuariobolao"),'value':(usuarioBolaoInstance.id)],-1)
printHtmlPart(24)
if(true && (filtrodatapalpite!='3' && palpitesemAberto>0)) {
printHtmlPart(25)
invokeTag('actionSubmit','g',64,['id':("botaopalpitesalvar"),'action':("save"),'value':(message(code: 'button.create.label', default: 'Update'))],-1)
printHtmlPart(26)
}
printHtmlPart(27)
invokeTag('set','g',70,['var':("rodadaanterior"),'value':("-1")],-1)
printHtmlPart(28)
invokeTag('set','g',71,['var':("datajogoanterior"),'value':("-1")],-1)
printHtmlPart(28)
loop:{
int i = 0
for( palpite in (palpitesList) ) {
printHtmlPart(29)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(30)
invokeTag('set','g',75,['var':("rodadaatual"),'value':(palpite?.jogo?.descricaofase)],-1)
printHtmlPart(31)
invokeTag('set','g',76,['var':("datajogoatual"),'value':(palpite?.jogo?.datajogo?.format('dd/MM/yyyy'))],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',78,['name':("jogo"),'value':(palpite?.jogo?.id)],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',79,['name':("id"),'value':(palpite?.id ? palpite?.id : "-1")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',80,['name':("palpitefinalizado"),'value':(palpite?.finalizado)],-1)
printHtmlPart(32)
if(true && (rodadaanterior!=rodadaatual)) {
printHtmlPart(33)
expressionOut.print(palpite?.jogo?.descricaofase)
printHtmlPart(34)
}
printHtmlPart(21)
if(true && (datajogoanterior!=datajogoatual)) {
printHtmlPart(35)
expressionOut.print(message(code: "datajogo.label"))
printHtmlPart(36)
expressionOut.print(datajogoatual)
printHtmlPart(37)
expressionOut.print(message(code: "peso.label"))
printHtmlPart(36)
expressionOut.print(palpite?.jogo?.peso)
printHtmlPart(38)
}
printHtmlPart(39)
invokeTag('formatDate','g',101,['format':("HH:mm"),'date':(palpite?.jogo?.datajogo)],-1)
printHtmlPart(40)
expressionOut.print(palpite?.jogo?.estadio?.descricao)
printHtmlPart(41)
if(true && (palpite?.jogo?.time1?.imagem)) {
printHtmlPart(42)
invokeTag('image','asset',105,['src':("bandeiras/${params.tamanhoiconetimes}/${palpite?.jogo?.time1?.imagem}"),'title':(palpite?.jogo?.time1?.descricao)],-1)
printHtmlPart(43)
}
printHtmlPart(44)
expressionOut.print(palpite?.jogo?.time1?.descricao)
printHtmlPart(45)
if(true && (palpite.finalizado)) {
printHtmlPart(42)
invokeTag('textField','g',113,['readonly class':("readonly"),'name':("scoretime1"),'maxlength':("2"),'size':("1"),'value':(palpite?.scoretime1)],-1)
printHtmlPart(43)
}
else {
printHtmlPart(42)
invokeTag('textField','g',116,['class':("centro"),'name':("scoretime1"),'maxlength':("2"),'size':("1"),'value':(palpite?.scoretime1)],-1)
printHtmlPart(43)
}
printHtmlPart(46)
if(true && (palpite.finalizado)) {
printHtmlPart(42)
invokeTag('textField','g',127,['readonly class':("readonly"),'name':("scoretime2"),'maxlength':("2"),'size':("1"),'value':(palpite?.scoretime2)],-1)
printHtmlPart(43)
}
else {
printHtmlPart(42)
invokeTag('textField','g',130,['class':("centro"),'name':("scoretime2"),'maxlength':("2"),'size':("1"),'value':(palpite?.scoretime2)],-1)
printHtmlPart(43)
}
printHtmlPart(47)
if(true && (palpite?.jogo?.time2?.imagem)) {
printHtmlPart(42)
invokeTag('image','asset',136,['src':("bandeiras/${params.tamanhoiconetimes}/${palpite?.jogo?.time2?.imagem}"),'title':(palpite?.jogo?.time2?.descricao)],-1)
printHtmlPart(43)
}
printHtmlPart(44)
expressionOut.print(palpite?.jogo?.time2?.descricao)
printHtmlPart(48)
if(true && (jogoInstance?.campeonato?.imagem)) {
printHtmlPart(42)
invokeTag('image','asset',143,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':("campeonatos/${jogoInstance?.campeonato?.descricao}/${jogoInstance?.campeonato?.imagem}"),'title':(jogoInstance?.campeonato?.descricao)],-1)
printHtmlPart(43)
}
printHtmlPart(49)
expressionOut.print(palpite?.jogo?.campeonato?.descricao)
printHtmlPart(50)
loop:{
int k = 0
for( extra in (palpite?.jogo?.extras) ) {
printHtmlPart(43)
if(true && (k==0)) {
printHtmlPart(51)
expressionOut.print(message(code: "extras.label"))
printHtmlPart(52)
}
printHtmlPart(53)
expressionOut.print(extra.descricao)
printHtmlPart(54)
expressionOut.print(extra.scoretime1)
printHtmlPart(55)
expressionOut.print(extra.scoretime2)
printHtmlPart(56)
k++
}
}
printHtmlPart(57)
expressionOut.print(message(code: "resultadofinal.label"))
printHtmlPart(58)
expressionOut.print(palpite?.jogo?.scoretime1)
printHtmlPart(59)
expressionOut.print(palpite?.jogo?.scoretime2)
printHtmlPart(60)
expressionOut.print(message(code: "pontos.label"))
printHtmlPart(60)
expressionOut.print(palpite?.pontuacao)
printHtmlPart(61)
invokeTag('set','g',177,['var':("rodadaanterior"),'value':(rodadaatual)],-1)
printHtmlPart(62)
invokeTag('set','g',178,['var':("datajogoanterior"),'value':(datajogoatual)],-1)
printHtmlPart(28)
i++
}
}
printHtmlPart(63)
if(true && (filtrodatapalpite!='3' && palpitesemAberto>0)) {
printHtmlPart(25)
invokeTag('actionSubmit','g',185,['id':("botaopalpitesalvar"),'action':("save"),'value':(message(code: 'button.create.label', default: 'Update'))],-1)
printHtmlPart(26)
}
printHtmlPart(64)
})
invokeTag('form','g',191,['url':([action:'save',controller:'palpite']),'method':("POST")],3)
printHtmlPart(65)
invokeTag('paginate','g',193,['total':(palpitesList ?: 0)],-1)
printHtmlPart(66)
invokeTag('javascript','asset',196,['src':("filtrochange.js")],-1)
printHtmlPart(9)
}
printHtmlPart(67)
})
invokeTag('captureBody','sitemesh',200,[:],1)
printHtmlPart(68)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1406208330000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
