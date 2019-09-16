package sistemavendas

class Usuario {

    String nome
	String cpf
    String rg
    String telefone
    String desLogin
    String senha

    static constraints = {
      nome()
      cpf(unique:true)
      rg()
      telefone()
      desLogin()
      senha()
    }

    public String toString() {
        return "${nome}"
    }
}
