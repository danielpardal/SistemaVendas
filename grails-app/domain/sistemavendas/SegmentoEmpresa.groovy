package sistemavendas

class SegmentoEmpresa {

	String desSegmento
	Empresa empresa
    Boolean ativo = true

    static constraints = {
      desSegmento()
      empresa(nullable:true)
      ativo()
    }

    public String toString() {
        return "${desSegmento}"
    }
}
