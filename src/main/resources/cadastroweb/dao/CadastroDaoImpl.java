package cadastroweb.dao;

import javax.transaction.Transaction;

import org.hibernate.Session;

//import cadastroweb.bean.PessoaFisica;
//import cadastroweb.bean.PessoaJuridica;
import cadastroweb.util.HibernateUtil;

public class CadastroDaoImpl implements CadastroDao{

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastra(Object usuario) {
		boolean sucesso = false;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = (Transaction) session.beginTransaction();
			
			session.persist(usuario);
			
			transaction.commit();
			sucesso = true;
			
			System.out.println("Usuário adicionado");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return sucesso;
	}	

	public boolean login(String user, String pass, boolean userType) {
		// TODO Auto-generated method stub
		return false;
	}
 
}
