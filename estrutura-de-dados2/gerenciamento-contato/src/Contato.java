import java.io.Serializable;

public class Contato implements Serializable, Comparable<Contato> {
    String nome;
    String numeroDeTelefone;

    public Contato(String nome, String numeroDeTelefone) {
        this.nome = nome;
        this.numeroDeTelefone = numeroDeTelefone;
    }

    @Override
    public String toString() {
        return nome + " - " + numeroDeTelefone;
    }

    @Override
    public int compareTo(Contato other) {
        return this.nome.compareTo(other.nome);
    }
}
