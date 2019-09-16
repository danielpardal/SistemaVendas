package sistemavendas

import grails.gorm.services.Service

@Service(SegmentoEmpresa)
interface SegmentoEmpresaService {

    SegmentoEmpresa get(Serializable id)

    List<SegmentoEmpresa> list(Map args)

    Long count()

    void delete(Serializable id)

    SegmentoEmpresa save(SegmentoEmpresa segmentoEmpresa)

}