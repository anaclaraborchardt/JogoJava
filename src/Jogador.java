import java.util.ArrayList;

import java.util.ArrayList;

public class Jogador {

    private int numero;
    ArrayList<Unidade> unidadesJogador1 = new ArrayList<>();
    ArrayList<Unidade> unidadesJogador2 = new ArrayList<>();
    private ArrayList<Integer> indicesValidosJogador1 = new ArrayList<>();
    private ArrayList<Integer> indicesValidosJogador2 = new ArrayList<>();

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
        for (int i = 0; i <= 23; i++) {
            indicesValidosJogador1.add(i);
        }

        for (int i = 60; i <= 83; i++) {
            indicesValidosJogador2.add(i);
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

    public boolean aindaHaPecas(int jogadorAtual) {
        ArrayList<Unidade> unidadesJogador = jogadorAtual == 1 ? unidadesJogador1 : unidadesJogador2;
        return !unidadesJogador.isEmpty();
    }

    public ArrayList<Integer> pegaIndice(int jogadorAtual) {
        return jogadorAtual == 1 ? indicesValidosJogador1 : indicesValidosJogador2;
    }

    public void atualizaIndices(int jogadorAtual, int posicaoOrigem, int posicaoDestino) {
        ArrayList<Integer> validIndices = pegaIndice(jogadorAtual);
        validIndices.remove(Integer.valueOf(posicaoOrigem));
        validIndices.add(posicaoDestino);
    }
}



