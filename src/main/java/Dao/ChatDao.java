
package Dao;

import Entidades.Chat;
import Fabricas.ConFactory;
import Interfaces.CRUD;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatDao implements CRUD{

    private Connection con;
    
    public ChatDao(){
        try {
            this.con = ConFactory.getConnection2();
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean criarTabela() {
        String sql = "CREATE TABLE chat (id serial primary key, nome text, mensagem text);";
        int retorno = 0;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void adicionarMensagem(Chat c) {
        String sql = "INSERT INTO chat (nome, mensagem) VALUES (?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getMensagem());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Chat> listarTodos(){
        String sql = "SELECT * FROM chat";
        List<Chat> auxiliar = new ArrayList<Chat>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Chat c = new Chat();
                c.setNome(rs.getString("nome"));
                c.setMensagem(rs.getString("mensagem"));
                auxiliar.add(c);
            }
            stmt.close();
            return auxiliar;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return auxiliar;
        }
    }
    
}
