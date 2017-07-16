
package Entidades;

public class Chat {
    
    private String nome;
    private String mensagem;
    
    public Chat(String nome, String msg){
        this.nome = nome;
        this.mensagem = msg;
    }
    
    public Chat(){};

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Chat{" + "nome=" + nome + ", mensagem=" + mensagem + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 37 * hash + (this.mensagem != null ? this.mensagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chat other = (Chat) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.mensagem == null) ? (other.mensagem != null) : !this.mensagem.equals(other.mensagem)) {
            return false;
        }
        return true;
    }
    
    
    
}

