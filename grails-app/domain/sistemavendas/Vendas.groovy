package sistemavendas

class Vendas {

    Empresa empresa
	Usuario usuarioCadastro
    Double valorVenda
    Date dataVenda
    Boolean emitidoNF = false

    static constraints = {
      dataVenda()
      empresa()
      usuarioCadastro()
      valorVenda()
      emitidoNF()
    }
}
