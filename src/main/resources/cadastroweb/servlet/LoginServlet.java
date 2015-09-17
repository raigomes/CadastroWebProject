package cadastroweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cadastroweb.bean.PessoaFisica;
import cadastroweb.bean.PessoaJuridica;
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
        	Map<String, String> userData;
        	
        	switch(userType) {
        		case "pf":
        			PessoaFisica pf = dao.loginPF(usuario, senha);
        			userData = getUserData(pf);
        			printResponse(out, userData);
        			
        			break;
        		case "pj":
        			PessoaJuridica pj = dao.loginPJ(usuario, senha);
        			userData = getUserData(pj);
        			printResponse(out, userData);
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

	private Map<String, String> getUserData(PessoaFisica pf) {
		Map<String, String> data = new HashMap<>();
		
		if (pf != null) {
			data.put("Nome", pf.getNome());
			data.put("CPF", pf.getCpf());
			data.put("Usuario", pf.getUser());
			data.put("Senha", pf.getPass());
		}
		
		return data;
	}
	
	private Map<String, String> getUserData(PessoaJuridica pj) {
		Map<String, String> data = new HashMap<>();
		
		if (pj != null) {
			data.put("Nome", pj.getNome());
			data.put("CNPJ", pj.getCnpj());
			data.put("Usuario", pj.getUser());
			data.put("Senha", pj.getPass());
		}
		
		return data;
	}

	private void printResponse(PrintWriter out, Map<String, String> userData) {
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' type='text/css' href='./css/style.css'>");
		out.println("<head>");
    	out.println("<body>");
		
		if(userData.isEmpty()) {
			out.println("<h1>Usuário não encontrado!</h1>");
			out.println("<a href='./login.html'>Voltar</a>");  
		}
		else {
			Iterator<Entry<String,String>> it = userData.entrySet().iterator();
			
			out.println("<div id='user_data'>");
			
			out.println("<h1>"+userData.get("Nome")+"</h1>");
			
			while(it.hasNext()) {
				Map.Entry<String, String> pair = it.next();
				
				out.println("<p><strong>"+pair.getKey()+":</strong> "+pair.getValue()+"<p>");
				
				it.remove();
			}
			
			out.println("<a href='./index.html'>Voltar</a>");
			
			out.println("</div>");
		}
		
		out.println("</body>");
    	out.println("</html>");
	}
	
}
