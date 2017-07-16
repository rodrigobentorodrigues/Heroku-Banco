
package Dao;

import Fabricas.ConFactory;
import Interfaces.CRUD;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void adicionarMensagem(String nome, String mensagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removerMensagem(String nome, String mensagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
