package sistemavendas

class Empresa {

	String razaoSocial
	Usuario usuarioCadastro
    String cnpj
    String endereco
    String telefone

    static constraints = {
      razaoSocial()
      usuarioCadastro()
      cnpj(unique:true)
      endereco()
      telefone()
    }

    public String toString() {
        return "${razaoSocial}"
    }
}
