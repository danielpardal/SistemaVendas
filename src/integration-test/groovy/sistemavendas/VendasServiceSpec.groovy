package sistemavendas

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendasServiceSpec extends Specification {

    VendasService vendasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Vendas(...).save(flush: true, failOnError: true)
        //new Vendas(...).save(flush: true, failOnError: true)
        //Vendas vendas = new Vendas(...).save(flush: true, failOnError: true)
        //new Vendas(...).save(flush: true, failOnError: true)
        //new Vendas(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendas.id
    }

    void "test get"() {
        setupData()

        expect:
        vendasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Vendas> vendasList = vendasService.list(max: 2, offset: 2)

        then:
        vendasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendasService.count() == 5
    }

    void "test delete"() {
        Long vendasId = setupData()

        expect:
        vendasService.count() == 5

        when:
        vendasService.delete(vendasId)
        sessionFactory.currentSession.flush()

        then:
        vendasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Vendas vendas = new Vendas()
        vendasService.save(vendas)

        then:
        vendas.id != null
    }
}
