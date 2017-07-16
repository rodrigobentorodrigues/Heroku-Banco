
package servlet;

import Dao.ChatDao;
import Interfaces.CRUD;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ServletConexao", urlPatterns = {"/criar"})
public class CriarTabela extends HttpServlet{

    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        CRUD crud = new ChatDao();
        boolean c = crud.criarTabela();
        if(c){
            out.write("Teste com Postgres Heroku".getBytes());
        } else {
            out.write("Teste com Postgres Heroku - Falhado".getBytes());
        }
        out.write("Teste com Postgres Heroku".getBytes());
        out.flush();
        out.close();
    }
    
    
    
}
