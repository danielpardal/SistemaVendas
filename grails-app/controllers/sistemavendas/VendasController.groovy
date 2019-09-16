package sistemavendas

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VendasController {

    VendasService vendasService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendasService.list(params), model:[vendasCount: vendasService.count()]
    }

    def show(Long id) {
        respond vendasService.get(id)
    }

    def create() {
        respond new Vendas(params)
    }

    def save(Vendas vendas) {
        if (vendas == null) {
            notFound()
            return
        }

        try {
            vendasService.save(vendas)
        } catch (ValidationException e) {
            respond vendas.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendas.label', default: 'Vendas'), vendas.id])
                redirect vendas
            }
            '*' { respond vendas, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendasService.get(id)
    }

    def update(Vendas vendas) {
        if (vendas == null) {
            notFound()
            return
        }

        try {
            vendasService.save(vendas)
        } catch (ValidationException e) {
            respond vendas.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendas.label', default: 'Vendas'), vendas.id])
                redirect vendas
            }
            '*'{ respond vendas, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendasService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendas.label', default: 'Vendas'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendas.label', default: 'Vendas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
