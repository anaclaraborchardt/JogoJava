import java.util.ArrayList;

public class Jogador {

    private int numero;
    ArrayList<Unidade> unidadesJogador1 = new ArrayList<>();
    ArrayList<Unidade> unidadesJogador2 = new ArrayList<>();

    Unidade cavalaria = new Cavalaria();
    Unidade infantaria = new Infantaria();
    Unidade arqueiro = new Arqueiros();

    public Jogador() {
        unidadesJogador1 = new ArrayList<>();

        unidadesJogador2 = new ArrayList<>();

    }

    public int getNumero() {
        return numero;
    }

    public void setUnidadesJogador1(ArrayList<Unidade> unidadesJogador1) {
        this.unidadesJogador1 = unidadesJogador1;
    }

    public void setUnidades(ArrayList<Unidade> unidadesJogador2) {
    }
}

