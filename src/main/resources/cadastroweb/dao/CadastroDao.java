package cadastroweb.dao;

//import cadastroweb.bean.PessoaFisica;
//import cadastroweb.bean.PessoaJuridica;

public interface CadastroDao {
	public boolean cadastra(Object usuario);
	//public boolean cadastra(PessoaJuridica usuario);
	public boolean login(String user, String pass, boolean userType);
}
