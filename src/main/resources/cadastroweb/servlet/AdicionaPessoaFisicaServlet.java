package cadastroweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cadastroweb.bean.PessoaFisica;
import cadastroweb.dao.CadastroDao;
import cadastroweb.dao.CadastroDaoImpl;

@WebServlet("/adicionaUsuarioPF")
public class AdicionaPessoaFisicaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
                        
        PrintWriter out = response.getWriter();
                        
        // pegando os parâmetros do request
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String usuario = request.getParameter("user");
        String senha = request.getParameter("pass");
        
        // monta um objeto contato
        PessoaFisica pf = new PessoaFisica();
        pf.setNome(nome);
        pf.setCpf(cpf);
        pf.setUser(usuario);
        pf.setPass(senha);
        
        // salva o contato
        CadastroDao dao = new CadastroDaoImpl();
        dao.cadastra(pf);
        
        // imprime o nome do contato que foi adicionado
        out.println("<html>");
        out.println("<body>");
        out.println("Contato " + pf.getNome() + 
                " adicionado com sucesso");
        out.println("<br>");
        out.println("<a href='./login.html'>Login</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
