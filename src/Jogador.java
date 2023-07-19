import java.util.ArrayList;

public class Jogador {

    private int numero;
    ArrayList<Unidade> unidadesJogador1 = new ArrayList<>();
    ArrayList<Unidade> unidadesJogador2 = new ArrayList<>();

    Unidade cavalaria = new Cavalaria();
    Unidade infantaria = new Infantaria();
    Unidade arqueiro = new Arqueiros();
    Unidade tesouro = new Tesouro();

    public Jogador() {

        unidadesJogador1 = new ArrayList<>();

        for (int i = 0; i <= 1; i++) {
            unidadesJogador1.add(new Tesouro());
            unidadesJogador2.add(new Tesouro());
        }
        for (int i = 0; i <= 5; i++) {
            unidadesJogador1.add(new Arqueiros());
            unidadesJogador2.add(new Arqueiros());
        }
        for (int i = 0; i <= 7; i++) {
            unidadesJogador1.add(new Infantaria());
            unidadesJogador2.add(new Infantaria());
        }
        for (int i = 0; i <= 3; i++) {
            unidadesJogador1.add(new Cavalaria());
            unidadesJogador2.add(new Cavalaria());
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setUnidadesJogador1(ArrayList<Unidade> unidadesJogador1) {
        this.unidadesJogador1 = unidadesJogador1;
    }

    public void setUnidades(ArrayList<Unidade> unidadesJogador2) {
        this.unidadesJogador2 = unidadesJogador2;
    }

    public boolean ganhar() {
        for (Unidade unidade : unidadesJogador1 ) {
            if (unidade instanceof Tesouro) {
                return false;
            }
        }
        for (Unidade unidade : unidadesJogador2) {
            if (unidade instanceof Tesouro) {
                return false;
            }
        }
        return true;
    }
}

