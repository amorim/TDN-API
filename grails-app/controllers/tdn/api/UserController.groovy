package tdn.api

import com.tdnsecuredrest.User
import grails.converters.JSON
import grails.rest.RestfulController
import org.springframework.security.access.prepost.PostAuthorize

import javax.annotation.security.RolesAllowed

@RolesAllowed(["ROLE_USER"])
class UserController {

    static responseFormats = ['json', 'xml']
    transient springSecurityService
    static transients = ['springSecurityService']

    def show() {
        respond User.get(springSecurityService.principal.id)
    }

}