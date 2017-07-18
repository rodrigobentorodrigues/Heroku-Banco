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

public class ChatDao implements CRUD {

    private Connection con;

    public ChatDao() {
        try {
            this.con = ConFactory.getConnection();
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean criarTabela() {
        String sql = "CREATE TABLE chat (id serial primary key, nome text, "
                + "mensagem text, verificador boolean);";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            this.con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public void adicionarMensagem(Chat c) {
        String sql = "INSERT INTO chat (nome, mensagem, verificador) VALUES (?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getMensagem());
            stmt.setBoolean(3, c.isVerificador());
            stmt.executeUpdate();
            stmt.close();
            this.con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Chat> listarTodos() {
        List<Chat> auxiliar = null;
        String sql = "SELECT * FROM chat";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            auxiliar = new ArrayList<Chat>();
            while (rs.next()) {
                Chat c = new Chat();
                c.setNome(rs.getString("nome"));
                c.setMensagem(rs.getString("mensagem"));
                c.setVerificador(rs.getBoolean("verificador"));
                auxiliar.add(c);
            }
            stmt.close();
            this.con.close();
            return auxiliar;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return auxiliar;
    }

}
