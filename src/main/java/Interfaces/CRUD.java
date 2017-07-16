
package Interfaces;

import Entidades.Chat;
import java.util.List;

public interface CRUD {
    
    boolean criarTabela();
    void adicionarMensagem(Chat c);
    List<Chat> listarTodos();
    
}
