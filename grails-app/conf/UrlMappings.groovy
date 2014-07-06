class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		
		"/"(controller:"index")
		//"/"(view:"/index")
        "500"(view:'/error')
		"403"(controller: 'error', action: 'denied')
		"404"(controller: 'error', action: 'notfound')

	}
}
