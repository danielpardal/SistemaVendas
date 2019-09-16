package sistemavendas

import grails.gorm.services.Service

@Service(Vendas)
interface VendasService {

    Vendas get(Serializable id)

    List<Vendas> list(Map args)

    Long count()

    void delete(Serializable id)

    Vendas save(Vendas vendas)

}