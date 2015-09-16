package cadastroweb;

import cadastroweb.bean.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

@SuppressWarnings("deprecation")
public class GeraTabela {

	public static void main(String[] args) {
		AnnotationConfiguration conf = new AnnotationConfiguration()
				.configure("cadastroweb/util/hibernate.cfg.xml");
		
		conf.addAnnotatedClass(PessoaFisica.class);
		conf.addAnnotatedClass(PessoaJuridica.class);
		
		SchemaExport sE = new SchemaExport(conf);
		sE.create(true, true);
		
		System.out.println(" A Tabela " + PessoaFisica.class.getName() + " foi criada.");
		System.out.println(" A Tabela " + PessoaJuridica.class.getName() + " foi criada.");
	}
}