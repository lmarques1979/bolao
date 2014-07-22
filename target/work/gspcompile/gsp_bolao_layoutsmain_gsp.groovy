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
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',10,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
expressionOut.print(assetPath(src:'favicon.ico'))
printHtmlPart(3)
invokeTag('stylesheet','asset',13,['src':("application.css")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',14,['src':("application.js")],-1)
printHtmlPart(1)
invokeTag('layoutHead','g',15,[:],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',21,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (sec.loggedInUserInfo(field: 'username') == 'admin')) {
printHtmlPart(9)
createTagBody(4, {->
invokeTag('message','g',25,['code':("configuracao.label")],-1)
})
invokeTag('link','g',25,['class':("configuracao"),'controller':("Configuracao"),'action':("index")],4)
printHtmlPart(10)
createTagBody(4, {->
invokeTag('message','g',26,['code':("pais.label")],-1)
})
invokeTag('link','g',26,['class':("paises"),'controller':("Pais"),'action':("index")],4)
printHtmlPart(10)
createTagBody(4, {->
invokeTag('message','g',27,['code':("estadio.label")],-1)
})
invokeTag('link','g',27,['class':("estadio"),'controller':("Estadio"),'action':("index")],4)
printHtmlPart(10)
createTagBody(4, {->
invokeTag('message','g',28,['code':("campeonato.label")],-1)
})
invokeTag('link','g',28,['class':("campeonato"),'controller':("Campeonato"),'action':("index")],4)
printHtmlPart(10)
createTagBody(4, {->
invokeTag('message','g',29,['code':("time.label")],-1)
})
invokeTag('link','g',29,['class':("times"),'controller':("Time"),'action':("index")],4)
printHtmlPart(10)
createTagBody(4, {->
invokeTag('message','g',30,['code':("jogo.label")],-1)
})
invokeTag('link','g',30,['class':("jogos"),'controller':("Jogo"),'action':("index")],4)
printHtmlPart(10)
createTagBody(4, {->
invokeTag('message','g',31,['code':("usuarios.label")],-1)
})
invokeTag('link','g',31,['class':("usuarios"),'controller':("Usuario"),'action':("index")],4)
printHtmlPart(10)
createTagBody(4, {->
invokeTag('message','g',32,['code':("atualizapontos.label")],-1)
})
invokeTag('link','g',32,['class':("atualizapontos"),'controller':("UsuarioBolao"),'action':("atualizapontos")],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (sec.loggedInUserInfo(field: 'username') != 'admin')) {
printHtmlPart(9)
createTagBody(4, {->
invokeTag('message','g',37,['code':("bolao.label")],-1)
})
invokeTag('link','g',37,['class':("bolao"),'controller':("Bolao"),'action':("index")],4)
printHtmlPart(10)
createTagBody(4, {->
invokeTag('message','g',38,['code':("usuariobolao.label")],-1)
})
invokeTag('link','g',38,['class':("meusboloes"),'controller':("UsuarioBolao"),'action':("index")],4)
printHtmlPart(10)
createTagBody(4, {->
invokeTag('message','g',39,['code':("dadosusuario.label")],-1)
})
invokeTag('link','g',39,['class':("usuario"),'controller':("Usuario"),'action':("show"),'id':(sec.loggedInUserInfo(field:"id"))],4)
printHtmlPart(13)
}
printHtmlPart(14)
createTagBody(3, {->
invokeTag('message','g',42,['code':("logout.label")],-1)
})
invokeTag('link','g',42,['class':("logout"),'controller':("logout"),'action':("index")],3)
printHtmlPart(15)
if(true && (sec.loggedInUserInfo(field: 'primeironome'))) {
printHtmlPart(16)
invokeTag('set','g',45,['var':("usuario"),'value':(sec.loggedInUserInfo(field: 'primeironome'))],-1)
printHtmlPart(17)
}
printHtmlPart(17)
if(true && (sec.loggedInUserInfo(field: 'sobrenome'))) {
printHtmlPart(16)
invokeTag('set','g',48,['var':("usuario"),'value':(usuario + ' ' + sec.loggedInUserInfo(field: 'sobrenome'))],-1)
printHtmlPart(17)
}
printHtmlPart(17)
if(true && (session["usuariobolao"])) {
printHtmlPart(18)
expressionOut.print(message(code: "usuario.username.label"))
printHtmlPart(19)
expressionOut.print(usuario)
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(session["usuariobolao"].bolao.descricao)
})
invokeTag('link','g',51,['controller':("UsuarioBolao"),'action':("pontuacao"),'id':(session["usuariobolao"].id)],4)
printHtmlPart(21)
}
else {
printHtmlPart(18)
expressionOut.print(message(code: "usuario.username.label"))
printHtmlPart(19)
expressionOut.print(usuario)
printHtmlPart(21)
}
printHtmlPart(22)
})
invokeTag('ifLoggedIn','sec',57,[:],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
createTagBody(3, {->
invokeTag('message','g',60,['code':("criar.usuario.label")],-1)
})
invokeTag('link','g',60,['params':([bolao: params.bolao]),'class':("cadastrousuario"),'controller':("Usuario"),'action':("create")],3)
printHtmlPart(25)
})
invokeTag('ifNotLoggedIn','sec',61,[:],2)
printHtmlPart(26)
createTagBody(2, {->
invokeTag('image','asset',63,['class':("internacionalizacao"),'src':("bandeiras/24/Brazil.png"),'title':(message(code:'portuguesbrasil.label'))],-1)
})
invokeTag('link','g',63,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'pt_BR'])],2)
printHtmlPart(27)
createTagBody(2, {->
invokeTag('image','asset',64,['class':("internacionalizacao"),'src':("bandeiras/24/britain.png"),'title':(message(code:'english.label'))],-1)
})
invokeTag('link','g',64,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'en'])],2)
printHtmlPart(27)
createTagBody(2, {->
invokeTag('image','asset',65,['class':("internacionalizacao"),'src':("bandeiras/24/Spain.png"),'title':(message(code:'spain.label'))],-1)
})
invokeTag('link','g',65,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'es'])],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
createTagBody(3, {->
printHtmlPart(30)
expressionOut.print(params.bolao)
printHtmlPart(31)
invokeTag('message','g',75,['code':("springSecurity.login.username.label")],-1)
printHtmlPart(32)
invokeTag('message','g',78,['code':("springSecurity.login.password.label")],-1)
printHtmlPart(33)
invokeTag('actionSubmitImage','g',80,['title':(message(code: 'entrar.label')),'value':(message(code: 'button.create.label')),'src':(assetPath(src:'skin/loginSpring.png'))],-1)
printHtmlPart(8)
createTagBody(4, {->
invokeTag('message','g',81,['code':("esqueceusenha.label")],-1)
})
invokeTag('link','g',81,['controller':("Usuario"),'action':("esqueceusenha"),'class':("esqueceusenha")],4)
printHtmlPart(34)
})
invokeTag('form','g',82,['url':("/${meta(name:'app.name')}/j_spring_security_check"),'method':("POST"),'id':("formlogin"),'class':("cssform"),'autocomplete':("off")],3)
printHtmlPart(35)
})
invokeTag('ifNotLoggedIn','sec',90,[:],2)
printHtmlPart(36)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('image','asset',93,['src':("logo/logo.png"),'alt':("Bolao")],-1)
printHtmlPart(37)
invokeTag('layoutBody','g',96,[:],-1)
printHtmlPart(38)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',100,['code':("regulamentogeral.message")],-1)
printHtmlPart(39)
})
invokeTag('link','g',101,['controller':("diversos"),'action':("pontuacao")],2)
printHtmlPart(40)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',103,['code':("contato.message")],-1)
printHtmlPart(39)
})
invokeTag('link','g',104,['controller':("diversos"),'action':("contato")],2)
printHtmlPart(41)
invokeTag('message','g',108,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(42)
})
invokeTag('captureBody','sitemesh',109,[:],1)
printHtmlPart(43)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405975739000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
