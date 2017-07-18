
package servlet;

import Dao.ChatDao;
import Entidades.Chat;
import Interfaces.CRUD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@WebServlet(name="Listar", urlPatterns = {"/list"})
public class AdicionarMensagem extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String nome = req.getParameter("nome");
//        String mensagem = req.getParameter("mensagem");
//        Chat c = new Chat(nome, mensagem, true);
//        CRUD d = new ChatDao();
//        d.adicionarMensagem(c);
//        ServletOutputStream out = resp.getOutputStream();
//        out.write("Adicionado".getBytes());
//        out.flush();
//        out.close();
        resp.setContentType("application/json");
        JSONObject objetoJSON = new JSONObject();
        CRUD crud = new ChatDao();
        List<Chat> lista = crud.listarTodos();
        objetoJSON.put("chat", lista);
        PrintWriter p = resp.getWriter();
        p.write(objetoJSON.toString());
        p.flush();
        p.close();
    }  
    
}
