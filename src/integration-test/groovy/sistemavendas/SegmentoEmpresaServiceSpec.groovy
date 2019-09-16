package sistemavendas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SegmentoEmpresaServiceSpec extends Specification {

    SegmentoEmpresaService segmentoEmpresaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SegmentoEmpresa(...).save(flush: true, failOnError: true)
        //new SegmentoEmpresa(...).save(flush: true, failOnError: true)
        //SegmentoEmpresa segmentoEmpresa = new SegmentoEmpresa(...).save(flush: true, failOnError: true)
        //new SegmentoEmpresa(...).save(flush: true, failOnError: true)
        //new SegmentoEmpresa(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //segmentoEmpresa.id
    }

    void "test get"() {
        setupData()

        expect:
        segmentoEmpresaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SegmentoEmpresa> segmentoEmpresaList = segmentoEmpresaService.list(max: 2, offset: 2)

        then:
        segmentoEmpresaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        segmentoEmpresaService.count() == 5
    }

    void "test delete"() {
        Long segmentoEmpresaId = setupData()

        expect:
        segmentoEmpresaService.count() == 5

        when:
        segmentoEmpresaService.delete(segmentoEmpresaId)
        sessionFactory.currentSession.flush()

        then:
        segmentoEmpresaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SegmentoEmpresa segmentoEmpresa = new SegmentoEmpresa()
        segmentoEmpresaService.save(segmentoEmpresa)

        then:
        segmentoEmpresa.id != null
    }
}
