package cadastroweb.dao;

import cadastroweb.bean.PessoaFisica;
import cadastroweb.bean.PessoaJuridica;

public interface CadastroDao {
	public boolean cadastra(Object usuario);
	public PessoaFisica loginPF(String user, String pass);
	public PessoaJuridica loginPJ(String user, String pass);
}
