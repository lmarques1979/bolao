import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_bolaovipcampeao_layoutsmain_gsp extends GroovyPage {
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
})
invokeTag('ifLoggedIn','sec',48,[:],2)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
createTagBody(3, {->
invokeTag('message','g',51,['code':("criar.usuario.label")],-1)
})
invokeTag('link','g',51,['params':([bolao: params.bolao]),'class':("cadastrousuario"),'controller':("Usuario"),'action':("create")],3)
printHtmlPart(19)
})
invokeTag('ifNotLoggedIn','sec',52,[:],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createTagBody(3, {->
printHtmlPart(22)
expressionOut.print(params.bolao)
printHtmlPart(23)
invokeTag('message','g',64,['code':("springSecurity.login.username.label")],-1)
printHtmlPart(24)
invokeTag('message','g',67,['code':("springSecurity.login.password.label")],-1)
printHtmlPart(25)
invokeTag('actionSubmitImage','g',69,['title':(message(code: 'entrar.label')),'value':(message(code: 'button.create.label')),'src':(assetPath(src:'skin/loginSpring.png'))],-1)
printHtmlPart(9)
createTagBody(4, {->
invokeTag('message','g',70,['code':("esqueceusenha.label")],-1)
})
invokeTag('link','g',70,['controller':("Usuario"),'action':("esqueceusenha"),'class':("esqueceusenha")],4)
printHtmlPart(26)
})
invokeTag('form','g',71,['url':("/${meta(name:'app.name')}/j_spring_security_check"),'method':("POST"),'id':("formlogin"),'class':("cssform"),'autocomplete':("off")],3)
printHtmlPart(27)
})
invokeTag('ifNotLoggedIn','sec',79,[:],2)
printHtmlPart(28)
createTagBody(2, {->
invokeTag('image','asset',83,['class':("internacionalizacao"),'src':("bandeiras/24/Brazil.png"),'title':(message(code:'portuguesbrasil.label'))],-1)
})
invokeTag('link','g',83,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'pt_BR'])],2)
printHtmlPart(29)
createTagBody(2, {->
invokeTag('image','asset',84,['class':("internacionalizacao"),'src':("bandeiras/24/britain.png"),'title':(message(code:'english.label'))],-1)
})
invokeTag('link','g',84,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'en'])],2)
printHtmlPart(29)
createTagBody(2, {->
invokeTag('image','asset',85,['class':("internacionalizacao"),'src':("bandeiras/24/Spain.png"),'title':(message(code:'spain.label'))],-1)
})
invokeTag('link','g',85,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'es'])],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(30)
if(true && (sec.loggedInUserInfo(field: 'primeironome'))) {
printHtmlPart(31)
invokeTag('set','g',89,['var':("usuario"),'value':(sec.loggedInUserInfo(field: 'primeironome'))],-1)
printHtmlPart(32)
}
printHtmlPart(32)
if(true && (sec.loggedInUserInfo(field: 'sobrenome'))) {
printHtmlPart(31)
invokeTag('set','g',92,['var':("usuario"),'value':(usuario + ' ' + sec.loggedInUserInfo(field: 'sobrenome'))],-1)
printHtmlPart(32)
}
printHtmlPart(32)
if(true && (session["usuariobolao"])) {
printHtmlPart(33)
expressionOut.print(message(code: "usuario.username.label"))
printHtmlPart(34)
expressionOut.print(usuario)
printHtmlPart(35)
createTagBody(4, {->
expressionOut.print(session["usuariobolao"].bolao.descricao)
})
invokeTag('link','g',95,['controller':("UsuarioBolao"),'action':("pontuacao"),'id':(session["usuariobolao"].id)],4)
printHtmlPart(36)
}
else {
printHtmlPart(33)
expressionOut.print(message(code: "usuario.username.label"))
printHtmlPart(34)
expressionOut.print(usuario)
printHtmlPart(37)
}
printHtmlPart(38)
})
invokeTag('ifLoggedIn','sec',101,[:],2)
printHtmlPart(39)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('image','asset',108,['src':("logo/logo.png"),'alt':("Bolao")],-1)
printHtmlPart(40)
if(true && (( (params.controller=='usuarioBolao' && params.action!='index') || (params.controller!='usuarioBolao') ))) {
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(41)
if(true && (usuarioInstance.imagem)) {
printHtmlPart(32)
invokeTag('image','asset',112,['class':("avatarmain"),'height':("60"),'width':("60"),'src':(usuarioInstance.imagem),'title':(usuarioInstance.buscaNome(usuarioInstance))],-1)
printHtmlPart(41)
}
else {
printHtmlPart(32)
invokeTag('image','asset',115,['class':("avatarmain"),'height':("60"),'width':("60"),'src':("noimage.jpg"),'title':(usuarioInstance.buscaNome(usuarioInstance))],-1)
printHtmlPart(41)
}
printHtmlPart(9)
})
invokeTag('ifLoggedIn','sec',117,[:],3)
printHtmlPart(42)
}
printHtmlPart(43)
invokeTag('layoutBody','g',121,[:],-1)
printHtmlPart(44)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',125,['code':("regulamentogeral.message")],-1)
printHtmlPart(42)
})
invokeTag('link','g',126,['controller':("diversos"),'action':("pontuacao")],2)
printHtmlPart(45)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',128,['code':("contato.message")],-1)
printHtmlPart(42)
})
invokeTag('link','g',129,['controller':("diversos"),'action':("contato")],2)
printHtmlPart(46)
invokeTag('message','g',133,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(47)
})
invokeTag('captureBody','sitemesh',134,[:],1)
printHtmlPart(48)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1406219273000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
