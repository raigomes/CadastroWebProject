package cadastroweb.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new AnnotationConfiguration().
<<<<<<< HEAD
			configure("cadastroweb/util/hibernate.cfg.xml")
=======
			configure("livrariaweb/util/hibernate.cfg.xml")
>>>>>>> branch 'master' of https://github.com/raigomes/CadastroWebProject.git
			.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
