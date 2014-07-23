import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolao_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('set','g',3,['var':("usuarioInstance"),'value':(Usuario.get(sec.loggedInUserInfo(field: 'id')))],-1)
printHtmlPart(0)
})
invokeTag('ifLoggedIn','sec',4,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',14,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',14,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(4)
expressionOut.print(assetPath(src:'favicon.ico'))
printHtmlPart(5)
invokeTag('stylesheet','asset',17,['src':("application.css")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',18,['src':("application.js")],-1)
printHtmlPart(3)
invokeTag('layoutHead','g',19,[:],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',20,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',25,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (sec.loggedInUserInfo(field: 'username') == 'admin')) {
printHtmlPart(10)
createTagBody(4, {->
invokeTag('message','g',29,['code':("configuracao.label")],-1)
})
invokeTag('link','g',29,['class':("configuracao"),'controller':("Configuracao"),'action':("index")],4)
printHtmlPart(11)
createTagBody(4, {->
invokeTag('message','g',30,['code':("pais.label")],-1)
})
invokeTag('link','g',30,['class':("paises"),'controller':("Pais"),'action':("index")],4)
printHtmlPart(11)
createTagBody(4, {->
invokeTag('message','g',31,['code':("estadio.label")],-1)
})
invokeTag('link','g',31,['class':("estadio"),'controller':("Estadio"),'action':("index")],4)
printHtmlPart(11)
createTagBody(4, {->
invokeTag('message','g',32,['code':("campeonato.label")],-1)
})
invokeTag('link','g',32,['class':("campeonato"),'controller':("Campeonato"),'action':("index")],4)
printHtmlPart(11)
createTagBody(4, {->
invokeTag('message','g',33,['code':("time.label")],-1)
})
invokeTag('link','g',33,['class':("times"),'controller':("Time"),'action':("index")],4)
printHtmlPart(11)
createTagBody(4, {->
invokeTag('message','g',34,['code':("jogo.label")],-1)
})
invokeTag('link','g',34,['class':("jogos"),'controller':("Jogo"),'action':("index")],4)
printHtmlPart(11)
createTagBody(4, {->
invokeTag('message','g',35,['code':("usuarios.label")],-1)
})
invokeTag('link','g',35,['class':("usuarios"),'controller':("Usuario"),'action':("index")],4)
printHtmlPart(11)
createTagBody(4, {->
invokeTag('message','g',36,['code':("atualizapontos.label")],-1)
})
invokeTag('link','g',36,['class':("atualizapontos"),'controller':("UsuarioBolao"),'action':("atualizapontos")],4)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (sec.loggedInUserInfo(field: 'username') != 'admin')) {
printHtmlPart(10)
createTagBody(4, {->
invokeTag('message','g',41,['code':("bolao.label")],-1)
})
invokeTag('link','g',41,['class':("bolao"),'controller':("Bolao"),'action':("index")],4)
printHtmlPart(11)
createTagBody(4, {->
invokeTag('message','g',42,['code':("usuariobolao.label")],-1)
})
invokeTag('link','g',42,['class':("meusboloes"),'controller':("UsuarioBolao"),'action':("index")],4)
printHtmlPart(11)
createTagBody(4, {->
invokeTag('message','g',43,['code':("dadosusuario.label")],-1)
})
invokeTag('link','g',43,['class':("usuario"),'controller':("Usuario"),'action':("show"),'id':(sec.loggedInUserInfo(field:"id"))],4)
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(3, {->
invokeTag('message','g',46,['code':("logout.label")],-1)
})
invokeTag('link','g',46,['class':("logout"),'controller':("logout"),'action':("index")],3)
printHtmlPart(16)
if(true && (sec.loggedInUserInfo(field: 'primeironome'))) {
printHtmlPart(17)
invokeTag('set','g',49,['var':("usuario"),'value':(sec.loggedInUserInfo(field: 'primeironome'))],-1)
printHtmlPart(18)
}
printHtmlPart(18)
if(true && (sec.loggedInUserInfo(field: 'sobrenome'))) {
printHtmlPart(17)
invokeTag('set','g',52,['var':("usuario"),'value':(usuario + ' ' + sec.loggedInUserInfo(field: 'sobrenome'))],-1)
printHtmlPart(18)
}
printHtmlPart(18)
if(true && (session["usuariobolao"])) {
printHtmlPart(19)
expressionOut.print(message(code: "usuario.username.label"))
printHtmlPart(20)
expressionOut.print(usuario)
printHtmlPart(21)
createTagBody(4, {->
expressionOut.print(session["usuariobolao"].bolao.descricao)
})
invokeTag('link','g',55,['controller':("UsuarioBolao"),'action':("pontuacao"),'id':(session["usuariobolao"].id)],4)
printHtmlPart(22)
}
else {
printHtmlPart(19)
expressionOut.print(message(code: "usuario.username.label"))
printHtmlPart(20)
expressionOut.print(usuario)
printHtmlPart(22)
}
printHtmlPart(23)
})
invokeTag('ifLoggedIn','sec',61,[:],2)
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
createTagBody(3, {->
invokeTag('message','g',64,['code':("criar.usuario.label")],-1)
})
invokeTag('link','g',64,['params':([bolao: params.bolao]),'class':("cadastrousuario"),'controller':("Usuario"),'action':("create")],3)
printHtmlPart(26)
})
invokeTag('ifNotLoggedIn','sec',65,[:],2)
printHtmlPart(27)
createTagBody(2, {->
invokeTag('image','asset',67,['class':("internacionalizacao"),'src':("bandeiras/24/Brazil.png"),'title':(message(code:'portuguesbrasil.label'))],-1)
})
invokeTag('link','g',67,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'pt_BR'])],2)
printHtmlPart(28)
createTagBody(2, {->
invokeTag('image','asset',68,['class':("internacionalizacao"),'src':("bandeiras/24/britain.png"),'title':(message(code:'english.label'))],-1)
})
invokeTag('link','g',68,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'en'])],2)
printHtmlPart(28)
createTagBody(2, {->
invokeTag('image','asset',69,['class':("internacionalizacao"),'src':("bandeiras/24/Spain.png"),'title':(message(code:'spain.label'))],-1)
})
invokeTag('link','g',69,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'es'])],2)
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createTagBody(3, {->
printHtmlPart(31)
expressionOut.print(params.bolao)
printHtmlPart(32)
invokeTag('message','g',79,['code':("springSecurity.login.username.label")],-1)
printHtmlPart(33)
invokeTag('message','g',82,['code':("springSecurity.login.password.label")],-1)
printHtmlPart(34)
invokeTag('actionSubmitImage','g',84,['title':(message(code: 'entrar.label')),'value':(message(code: 'button.create.label')),'src':(assetPath(src:'skin/loginSpring.png'))],-1)
printHtmlPart(9)
createTagBody(4, {->
invokeTag('message','g',85,['code':("esqueceusenha.label")],-1)
})
invokeTag('link','g',85,['controller':("Usuario"),'action':("esqueceusenha"),'class':("esqueceusenha")],4)
printHtmlPart(35)
})
invokeTag('form','g',86,['url':("/${meta(name:'app.name')}/j_spring_security_check"),'method':("POST"),'id':("formlogin"),'class':("cssform"),'autocomplete':("off")],3)
printHtmlPart(36)
})
invokeTag('ifNotLoggedIn','sec',94,[:],2)
printHtmlPart(37)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('image','asset',97,['src':("logo/logo.png"),'alt':("Bolao")],-1)
printHtmlPart(38)
if(true && (( (params.controller=='usuarioBolao' && params.action!='index') || (params.controller!='usuarioBolao') ))) {
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(18)
if(true && (usuarioInstance.imagem)) {
printHtmlPart(39)
invokeTag('image','asset',101,['class':("avatarmain"),'height':("120"),'width':("120"),'src':(usuarioInstance.imagem),'title':(usuarioInstance.buscaNome(usuarioInstance))],-1)
printHtmlPart(18)
}
else {
printHtmlPart(39)
invokeTag('image','asset',104,['class':("avatarmain"),'height':("120"),'width':("120"),'src':("noimage.jpg"),'title':(usuarioInstance.buscaNome(usuarioInstance))],-1)
printHtmlPart(18)
}
printHtmlPart(9)
})
invokeTag('ifLoggedIn','sec',106,[:],3)
printHtmlPart(40)
}
printHtmlPart(41)
invokeTag('layoutBody','g',110,[:],-1)
printHtmlPart(42)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',114,['code':("regulamentogeral.message")],-1)
printHtmlPart(40)
})
invokeTag('link','g',115,['controller':("diversos"),'action':("pontuacao")],2)
printHtmlPart(43)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',117,['code':("contato.message")],-1)
printHtmlPart(40)
})
invokeTag('link','g',118,['controller':("diversos"),'action':("contato")],2)
printHtmlPart(44)
invokeTag('message','g',122,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(45)
})
invokeTag('captureBody','sitemesh',123,[:],1)
printHtmlPart(46)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1406041634000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
