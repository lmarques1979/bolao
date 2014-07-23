import bolao.Palpite
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_palpitepalpiteusuario_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/palpite/palpiteusuario.gsp" }
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
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('hiddenField','g',27,['name':("id"),'value':(usuarioBolaoInstance.id)],-1)
printHtmlPart(16)
invokeTag('message','g',30,['code':("filtro.palpitesusuario.label")],-1)
printHtmlPart(17)
if(true && (params.filtrojogos)) {
printHtmlPart(18)
invokeTag('set','g',38,['var':("filtrojogos"),'value':(params.filtrojogos)],-1)
printHtmlPart(19)
}
else {
printHtmlPart(20)
invokeTag('set','g',41,['var':("filtrojogos"),'value':("4")],-1)
printHtmlPart(19)
}
printHtmlPart(19)
invokeTag('select','g',43,['onchange':("this.form.submit()"),'value':(filtrojogos),'name':("filtrojogos"),'from':([message(code: "filtro.todos.label"), message(code: "filtro.ultimos30.label"), message(code: "filtro.ultimos20.label"), message(code: "filtro.ultimasemana.label")]),'keys':(['1','2','3' ,'4'])],-1)
printHtmlPart(21)
invokeTag('submitButton','g',51,['class':("invisivel"),'name':("create"),'value':("Filtrar")],-1)
printHtmlPart(15)
})
invokeTag('form','g',52,['url':([action:'palpiteusuario'])],2)
printHtmlPart(22)
invokeTag('hiddenField','g',54,['name':("usuariobolao"),'value':(usuarioBolaoInstance.id)],-1)
printHtmlPart(23)
invokeTag('set','g',58,['var':("rodadaanterior"),'value':("-1")],-1)
printHtmlPart(15)
invokeTag('set','g',59,['var':("datajogoanterior"),'value':("-1")],-1)
printHtmlPart(15)
loop:{
int i = 0
for( palpite in (palpitesList) ) {
printHtmlPart(24)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(25)
invokeTag('set','g',63,['var':("rodadaatual"),'value':(palpite?.jogo?.descricaofase)],-1)
printHtmlPart(26)
invokeTag('set','g',64,['var':("datajogoatual"),'value':(palpite?.jogo?.datajogo?.format('dd/MM/yyyy'))],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',66,['name':("jogo"),'value':(palpite?.jogo?.id)],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',67,['name':("id"),'value':(palpite?.id ? palpite?.id : "-1")],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',68,['name':("palpitefinalizado"),'value':(palpite?.finalizado)],-1)
printHtmlPart(29)
if(true && (rodadaanterior!=rodadaatual)) {
printHtmlPart(30)
expressionOut.print(palpite?.jogo?.descricaofase)
printHtmlPart(31)
}
printHtmlPart(27)
if(true && (datajogoanterior!=datajogoatual)) {
printHtmlPart(32)
expressionOut.print(message(code: "datajogo.label"))
printHtmlPart(33)
expressionOut.print(datajogoatual)
printHtmlPart(34)
expressionOut.print(message(code: "peso.label"))
printHtmlPart(33)
expressionOut.print(palpite?.jogo?.peso)
printHtmlPart(35)
}
printHtmlPart(36)
invokeTag('formatDate','g',89,['format':("HH:mm"),'date':(palpite?.jogo?.datajogo)],-1)
printHtmlPart(37)
expressionOut.print(palpite?.jogo?.estadio?.descricao)
printHtmlPart(38)
if(true && (palpite?.jogo?.time1?.imagem)) {
printHtmlPart(39)
invokeTag('image','asset',93,['src':("bandeiras/${params.tamanhoiconetimes}/${palpite?.jogo?.time1?.imagem}"),'title':(palpite?.jogo?.time1?.descricao)],-1)
printHtmlPart(19)
}
printHtmlPart(40)
expressionOut.print(palpite?.jogo?.time1?.descricao)
printHtmlPart(41)
if(true && (palpite.finalizado)) {
printHtmlPart(39)
invokeTag('textField','g',101,['readonly class':("readonly"),'name':("scoretime1"),'maxlength':("1"),'size':("1"),'value':(palpite?.scoretime1)],-1)
printHtmlPart(19)
}
else {
printHtmlPart(39)
invokeTag('textField','g',104,['class':("centro"),'name':("scoretime1"),'maxlength':("1"),'size':("1"),'value':(palpite?.scoretime1)],-1)
printHtmlPart(19)
}
printHtmlPart(42)
if(true && (palpite.finalizado)) {
printHtmlPart(39)
invokeTag('textField','g',114,['readonly class':("readonly"),'name':("scoretime2"),'maxlength':("1"),'size':("1"),'value':(palpite?.scoretime2)],-1)
printHtmlPart(19)
}
else {
printHtmlPart(39)
invokeTag('textField','g',117,['class':("centro"),'name':("scoretime2"),'maxlength':("1"),'size':("1"),'value':(palpite?.scoretime2)],-1)
printHtmlPart(19)
}
printHtmlPart(43)
if(true && (palpite?.jogo?.time2?.imagem)) {
printHtmlPart(39)
invokeTag('image','asset',123,['src':("bandeiras/${params.tamanhoiconetimes}/${palpite?.jogo?.time2?.imagem}"),'title':(palpite?.jogo?.time2?.descricao)],-1)
printHtmlPart(19)
}
printHtmlPart(40)
expressionOut.print(palpite?.jogo?.time2?.descricao)
printHtmlPart(44)
if(true && (jogoInstance?.campeonato?.imagem)) {
printHtmlPart(39)
invokeTag('image','asset',130,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':("campeonatos/${jogoInstance?.campeonato?.descricao}/${jogoInstance?.campeonato?.imagem}"),'title':(jogoInstance?.campeonato?.descricao)],-1)
printHtmlPart(19)
}
printHtmlPart(45)
expressionOut.print(palpite?.jogo?.campeonato?.descricao)
printHtmlPart(46)
loop:{
int k = 0
for( extra in (palpite?.jogo?.extras) ) {
printHtmlPart(19)
if(true && (k==0)) {
printHtmlPart(47)
expressionOut.print(message(code: "extras.label"))
printHtmlPart(48)
}
printHtmlPart(49)
expressionOut.print(extra.descricao)
printHtmlPart(50)
expressionOut.print(extra.scoretime1)
printHtmlPart(51)
expressionOut.print(extra.scoretime2)
printHtmlPart(52)
k++
}
}
printHtmlPart(53)
expressionOut.print(message(code: "resultadofinal.label"))
printHtmlPart(54)
expressionOut.print(palpite?.jogo?.scoretime1)
printHtmlPart(55)
expressionOut.print(palpite?.jogo?.scoretime2)
printHtmlPart(56)
expressionOut.print(message(code: "pontos.label"))
printHtmlPart(56)
expressionOut.print(palpite?.pontuacao)
printHtmlPart(57)
invokeTag('set','g',164,['var':("rodadaanterior"),'value':(rodadaatual)],-1)
printHtmlPart(58)
invokeTag('set','g',165,['var':("datajogoanterior"),'value':(datajogoatual)],-1)
printHtmlPart(15)
i++
}
}
printHtmlPart(59)
invokeTag('paginate','g',170,['total':(palpitesList ?: 0)],-1)
printHtmlPart(60)
})
invokeTag('captureBody','sitemesh',173,[:],1)
printHtmlPart(61)
invokeTag('javascript','asset',176,['src':("filtrochange.js")],-1)
printHtmlPart(62)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405376108000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
