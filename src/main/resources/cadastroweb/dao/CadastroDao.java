package cadastroweb.dao;

<<<<<<< HEAD
import cadastroweb.bean.PessoaFisica;
import cadastroweb.bean.PessoaJuridica;

public interface CadastroDao {
	public boolean cadastra(Object usuario);
	public PessoaFisica loginPF(String user, String pass);
	public PessoaJuridica loginPJ(String user, String pass);
=======
//import cadastroweb.bean.PessoaFisica;
//import cadastroweb.bean.PessoaJuridica;

public interface CadastroDao {
	public boolean cadastra(Object usuario);
	//public boolean cadastra(PessoaJuridica usuario);
	public boolean login(String user, String pass, boolean userType);
>>>>>>> branch 'master' of https://github.com/raigomes/CadastroWebProject.git
}
