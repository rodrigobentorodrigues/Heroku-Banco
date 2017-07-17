
package Entidades;

import java.io.Serializable;

public class Chat implements Serializable{
    
    private String nome;
    private String mensagem;
    private boolean verificador;
    
    public Chat(String nome, String msg, boolean vrf){
        this.nome = nome;
        this.mensagem = msg;
        this.verificador = vrf;
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

    public boolean isVerificador() {
        return verificador;
    }

    public void setVerificador(boolean verificador) {
        this.verificador = verificador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 59 * hash + (this.mensagem != null ? this.mensagem.hashCode() : 0);
        hash = 59 * hash + (this.verificador ? 1 : 0);
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
        if (this.verificador != other.verificador) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.mensagem == null) ? (other.mensagem != null) : !this.mensagem.equals(other.mensagem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chat{" + "nome=" + nome + ", mensagem=" + mensagem + ", verificador=" + verificador + '}';
    }
    
}

