package cadastroweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cadastroweb.dao.CadastroDao;
import cadastroweb.dao.CadastroDaoImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
        
        // pegando os parâmetros do request
        String usuario = request.getParameter("user");
        String senha = request.getParameter("pass");
        String userType = request.getParameter("userType");
        
        CadastroDao dao = new CadastroDaoImpl();
        
        if(!usuario.isEmpty() && !senha.isEmpty()) {
        	switch(userType) {
        		case "pf":
        			dao.loginPF(usuario, senha);
        			break;
        		case "pj":
        			dao.loginPJ(usuario, senha);
        			break;
        		default:
        			out.println("<h1>RadioButton Errado</h1>");
        	}
        	
        	
        }
        else {
        	out.println("<html>");
        	out.println("<body>");
        	out.println("<h1>Insira os dados corretamente!</h1>");
        	out.println("<a href='./login.html'>Voltar</a>");
        	out.println("</body>");
        	out.println("</html>");
        }
	}
}
