package cadastroweb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import cadastroweb.bean.PessoaFisica;
import cadastroweb.bean.PessoaJuridica;
import cadastroweb.util.HibernateUtil;

public class CadastroDaoImpl implements CadastroDao{

	private Session session = null;
	private Transaction transaction = null;
	
	public boolean cadastra(Object usuario) {
		boolean sucesso = false;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = (Transaction) (session.beginTransaction());
			
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

	public PessoaFisica loginPF(String user, String pass) {
		PessoaFisica usuario = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			String hql = "SELECT * "
					+ "FROM pessoafisica "
					+ "WHERE usuario = " + user
					+ "AND senha = " + pass;
			Query query = session.createQuery(hql);	
			
			if(!query.list().isEmpty())
				usuario = (PessoaFisica) query.list().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
 
	public PessoaJuridica loginPJ(String user, String pass) {
		PessoaJuridica usuario = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			String hql = "SELECT * "
					+ "FROM pessoajuridica "
					+ "WHERE usuario = " + user
					+ "AND senha = " + pass;
			Query query = session.createQuery(hql);	
			
			if(!query.list().isEmpty())
				usuario = (PessoaJuridica) query.list().get(0);		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
