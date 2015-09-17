package cadastroweb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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
			
//			String query = "SELECT * "
//					+ "FROM pessoafisica "
//					+ "WHERE usuario = " + user
//					+ " AND senha = " + pass;
//			
//			List<?> result = session.createSQLQuery(query).addEntity(PessoaFisica.class).list();	
			
			Query query = session.createQuery("FROM PessoaFisica WHERE user = :usuario AND pass = :senha");
			query.setParameter("usuario", user);
			query.setParameter("senha", pass);
			List<?> result = query.list();
			
			if(!result.isEmpty())
				usuario = (PessoaFisica) result.get(0);
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
			
//			String query = "SELECT * "
//					+ "FROM pessoajuridica "
//					+ "WHERE usuario = " + user
//					+ " AND senha = " + pass;
//			List result = session.createSQLQuery(query).addEntity(PessoaJuridica.class).list();	
			
			Query query = session.createQuery("FROM PessoaJuridica WHERE user = :usuario AND pass = :senha");
			query.setParameter("usuario", user);
			query.setParameter("senha", pass);
			List<?> result = query.list();
			
			if(!result.isEmpty())
				usuario = (PessoaJuridica) result.get(0);		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
