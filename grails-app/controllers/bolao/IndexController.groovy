package bolao

import grails.plugin.springsecurity.annotation.Secured

class IndexController {

	@Secured('permitAll')
    def index() { }
}
