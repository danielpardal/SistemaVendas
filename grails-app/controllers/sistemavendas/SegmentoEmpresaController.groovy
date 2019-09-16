package sistemavendas

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SegmentoEmpresaController {

    SegmentoEmpresaService segmentoEmpresaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond segmentoEmpresaService.list(params), model:[segmentoEmpresaCount: segmentoEmpresaService.count()]
    }

    def show(Long id) {
        respond segmentoEmpresaService.get(id)
    }

    def create() {
        respond new SegmentoEmpresa(params)
    }

    def save(SegmentoEmpresa segmentoEmpresa) {
        if (segmentoEmpresa == null) {
            notFound()
            return
        }

        try {
            segmentoEmpresaService.save(segmentoEmpresa)
        } catch (ValidationException e) {
            respond segmentoEmpresa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'segmentoEmpresa.label', default: 'SegmentoEmpresa'), segmentoEmpresa.id])
                redirect segmentoEmpresa
            }
            '*' { respond segmentoEmpresa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond segmentoEmpresaService.get(id)
    }

    def update(SegmentoEmpresa segmentoEmpresa) {
        if (segmentoEmpresa == null) {
            notFound()
            return
        }

        try {
            segmentoEmpresaService.save(segmentoEmpresa)
        } catch (ValidationException e) {
            respond segmentoEmpresa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'segmentoEmpresa.label', default: 'SegmentoEmpresa'), segmentoEmpresa.id])
                redirect segmentoEmpresa
            }
            '*'{ respond segmentoEmpresa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        segmentoEmpresaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'segmentoEmpresa.label', default: 'SegmentoEmpresa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'segmentoEmpresa.label', default: 'SegmentoEmpresa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
