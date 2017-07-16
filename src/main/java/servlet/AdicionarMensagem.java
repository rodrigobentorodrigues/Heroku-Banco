
package servlet;

import Dao.ChatDao;
import Entidades.Chat;
import Interfaces.CRUD;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="AdicionarMensagem", urlPatterns = {"/add"})
public class AdicionarMensagem extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String mensagem = req.getParameter("mensagem");
        Chat c = new Chat(nome, mensagem);
        CRUD d = new ChatDao();
        d.adicionarMensagem(c);
        ServletOutputStream out = resp.getOutputStream();
        out.write("Adicionado".getBytes());
        out.flush();
        out.close();
    }
    
    
    
}
