import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_usuarioBolaopontuacao_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuarioBolao/pontuacao.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'usuarioBolao.label', default: 'UsuarioBolao'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("usuarioBolao.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
if(true && (usuarioBolaoInstance?.bolao?.enabled==true)) {
printHtmlPart(5)
if(true && (params.id)) {
printHtmlPart(6)
createTagBody(4, {->
invokeTag('message','g',15,['code':("palpite.label")],-1)
})
invokeTag('link','g',15,['class':("palpites"),'controller':("Palpite"),'action':("index"),'id':(params.id)],4)
printHtmlPart(7)
}
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(usuarioBolaoInstance?.bolao?.descricao)
printHtmlPart(10)
if(true && (usuarioBolaoInstance?.bolao?.imagem)) {
printHtmlPart(11)
invokeTag('image','asset',28,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':("bolao/${usuarioBolaoInstance?.bolao?.descricao}/${usuarioBolaoInstance?.bolao?.imagem}"),'title':(usuarioBolaoInstance?.bolao?.descricao)],-1)
printHtmlPart(6)
}
printHtmlPart(12)
expressionOut.print(usuarioBolaoInstance?.bolao?.informacao)
printHtmlPart(13)
invokeTag('image','asset',39,['src':("skin/bolao_criacao.png"),'title':("Data de Criação")],-1)
printHtmlPart(14)
expressionOut.print(message(code: "datacriacao.label"))
printHtmlPart(15)
invokeTag('formatDate','g',39,['format':("dd/MM/yyyy HH:mm"),'date':(usuarioBolaoInstance?.bolao?.dateCreated)],-1)
printHtmlPart(16)
invokeTag('image','asset',40,['src':("skin/administrador.png"),'title':("Administrador")],-1)
printHtmlPart(14)
expressionOut.print(message(code: "administrador.label"))
printHtmlPart(15)
expressionOut.print(usuarioBolaoInstance?.bolao?.admin?.username)
printHtmlPart(16)
invokeTag('image','asset',41,['src':("skin/membros.png"),'title':("Quantidade de Membros")],-1)
printHtmlPart(14)
expressionOut.print(message(code: "membros.label"))
printHtmlPart(15)
expressionOut.print(usuarioBolaoInstanceCount)
printHtmlPart(17)
expressionOut.print(message(code: "resenhas.label"))
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('hiddenField','g',50,['name':("idusuariobolao"),'value':(params.id)],-1)
printHtmlPart(6)
invokeTag('textField','g',51,['class':("resenha"),'id':("resenha"),'name':("resenha"),'size':("60"),'maxlenght':("100"),'value':(message(code: "digiteresenha.label"))],-1)
printHtmlPart(6)
invokeTag('actionSubmitImage','g',52,['value':(message(code: "button.create.label")),'src':(assetPath(src:'skin/send.png'))],-1)
printHtmlPart(7)
})
invokeTag('form','g',53,['action':("salvaresenha"),'method':("POST")],2)
printHtmlPart(19)
loop:{
int i = 0
for( resenha in (resenhasList) ) {
printHtmlPart(20)
invokeTag('image','asset',60,['height':("35"),'width':("35"),'src':("usuarios/${resenha?.usuariobolao?.usuario?.username}/${resenha?.usuariobolao?.usuario?.imagem}"),'title':(resenha?.usuariobolao?.usuario?.buscaNome(resenha?.usuariobolao?.usuario))],-1)
printHtmlPart(21)
invokeTag('formatDate','g',63,['format':("dd/MM/yyyy HH:mm"),'date':(resenha?.dateCreated)],-1)
printHtmlPart(22)
expressionOut.print(resenha?.resenha)
printHtmlPart(23)
if(true && ((resenha?.usuariobolao?.usuario?.id==sec.loggedInUserInfo(field: 'id').toLong() ) || (resenha?.usuariobolao?.bolao?.admin?.id==sec.loggedInUserInfo(field: 'id').toLong()))) {
printHtmlPart(24)
createTagBody(4, {->
printHtmlPart(25)
invokeTag('image','asset',70,['src':("skin/delete.png"),'title':(message(code: "delete.resenha.label"))],-1)
printHtmlPart(24)
})
invokeTag('link','g',71,['onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"),'controller':("resenha"),'action':("delete"),'id':(resenha.id)],4)
printHtmlPart(26)
}
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
expressionOut.print(message(code: "detalhesdobolao.label.label"))
printHtmlPart(29)
expressionOut.print(usuarioBolaoInstance?.bolao?.descricao)
printHtmlPart(30)
invokeTag('message','g',88,['code':("palpite.pontuacaousuarios.label"),'default':("Bolao")],-1)
printHtmlPart(31)
expressionOut.print(message(code: "avatar.label"))
printHtmlPart(32)
expressionOut.print(message(code: "participante.label"))
printHtmlPart(32)
expressionOut.print(message(code: "timeparticipante.label"))
printHtmlPart(32)
expressionOut.print(message(code: "pontos.label"))
printHtmlPart(32)
expressionOut.print(message(code: "palpites.label"))
printHtmlPart(33)
loop:{
int i = 0
for( usuariobolao in (usuariosBolao) ) {
printHtmlPart(34)
expressionOut.print((i%2) == 0 ? 'even' : 'odd')
printHtmlPart(35)
expressionOut.print(usuariobolao[3])
printHtmlPart(36)
if(true && (usuariobolao[0].imagem)) {
printHtmlPart(26)
invokeTag('image','asset',109,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':("usuarios/${usuariobolao[0].username}/${usuariobolao[0].imagem}"),'title':(usuariobolao[0].username)],-1)
printHtmlPart(37)
}
else {
printHtmlPart(26)
invokeTag('image','asset',112,['height':(params.alturaimagensthumbs),'width':(params.larguraimagensthumbs),'src':("usuarios/noimage.jpg"),'title':(usuariobolao[0].username)],-1)
printHtmlPart(37)
}
printHtmlPart(38)
if(true && (usuariobolao[0]?.primeironome)) {
printHtmlPart(39)
invokeTag('set','g',117,['var':("usuario"),'value':(usuariobolao[0]?.primeironome)],-1)
printHtmlPart(37)
}
printHtmlPart(37)
if(true && (usuariobolao[0]?.sobrenome)) {
printHtmlPart(39)
invokeTag('set','g',120,['var':("usuario"),'value':(usuario + ' ' + usuariobolao[0]?.sobrenome)],-1)
printHtmlPart(37)
}
printHtmlPart(37)
expressionOut.print(usuario)
printHtmlPart(40)
if(true && (usuariobolao[0].timecoracao.imagem)) {
printHtmlPart(26)
invokeTag('image','asset',125,['src':("bandeiras/24/${usuariobolao[0].timecoracao.imagem}"),'title':(usuariobolao[0].timecoracao.descricao)],-1)
printHtmlPart(37)
}
printHtmlPart(41)
expressionOut.print(usuariobolao[1] ? usuariobolao[1] : 0)
printHtmlPart(40)
if(true && (usuariobolao[2])) {
printHtmlPart(26)
if(true && (usuariobolao[2].id==Integer.parseInt(params.id))) {
printHtmlPart(24)
createTagBody(5, {->
printHtmlPart(25)
invokeTag('image','asset',133,['src':("palpites.png"),'title':("Ver Palpites")],-1)
printHtmlPart(24)
})
invokeTag('link','g',134,['controller':("Palpite"),'action':("index"),'id':(params.id)],5)
printHtmlPart(26)
}
else {
printHtmlPart(24)
createTagBody(5, {->
printHtmlPart(25)
invokeTag('image','asset',138,['src':("palpites.png"),'title':(message(code: "verpalpites.label"))],-1)
printHtmlPart(24)
})
invokeTag('link','g',139,['controller':("Palpite"),'action':("palpiteusuario"),'id':(usuariobolao[2].id)],5)
printHtmlPart(26)
}
printHtmlPart(37)
}
else {
printHtmlPart(26)
expressionOut.print(message(code: "naofezpalpite.label"))
printHtmlPart(37)
}
printHtmlPart(42)
i++
}
}
printHtmlPart(43)
})
invokeTag('captureBody','sitemesh',156,[:],1)
printHtmlPart(44)
invokeTag('javascript','asset',158,['src':("limparesenha.js")],-1)
printHtmlPart(45)
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
