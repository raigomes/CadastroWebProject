package cadastroweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cadastroweb.bean.PessoaJuridica;
import cadastroweb.dao.CadastroDao;
import cadastroweb.dao.CadastroDaoImpl;

@WebServlet("/adicionaUsuarioPJ")
public class AdicionaPessoaJuridicaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
                        
        PrintWriter out = response.getWriter();
                        
        // pegando os parâmetros do request
        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        String usuario = request.getParameter("user");
        String senha = request.getParameter("pass");
        
        // monta um objeto PessoaJuridica
        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome(nome);
        pj.setCnpj(cnpj);
        pj.setUser(usuario);
        pj.setPass(senha);
        
        // salva o usuario
        CadastroDao dao = new CadastroDaoImpl();
        dao.cadastra(pj);
        
       // imprime o nome do usuario que foi adicionado
        out.println("<html>");
        out.println("<body>");
        out.println("Contato " + pj.getNome() + 
                " adicionado com sucesso");
        out.println("<br>");
        out.println("<a href='./login.html'>Login</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
