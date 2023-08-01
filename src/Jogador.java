import java.util.ArrayList;

import java.util.ArrayList;

public class Jogador {

    private int jogadorAtual;
    ArrayList<Unidade> unidadesJogador1 = new ArrayList<>();
    ArrayList<Unidade> unidadesJogador2 = new ArrayList<>();
    private ArrayList<Integer> indicesValidosJogador1 = new ArrayList<>();
    private ArrayList<Integer> indicesValidosJogador2 = new ArrayList<>();
    private int quantidadePecasRestantes1;
    private int quantidadePecasRestantes2;
    private boolean removerPeca;

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

    public void setUnidadesJogador1(ArrayList<Unidade> unidadesJogador1) {
        this.unidadesJogador1 = unidadesJogador1;
    }

    public void setUnidades(ArrayList<Unidade> unidadesJogador2) {
        this.unidadesJogador2 = unidadesJogador2;
    }

    public boolean isRemoverPeca() {
        return removerPeca;
    }

    public void setRemoverPeca(boolean removerPeca) {
        this.removerPeca = removerPeca;
    }
    public int getQuantidadePecasRestantes1() {
        return quantidadePecasRestantes1;
    }

    public void setQuantidadePecasRestantes1(int quantidadePecasRestantes1) {
        this.quantidadePecasRestantes1 = quantidadePecasRestantes1;
    }
    public int getQuantidadePecasRestantes2() {
        return quantidadePecasRestantes2;
    }

    public void setQuantidadePecasRestantes2(int quantidadePecasRestantes2) {
        this.quantidadePecasRestantes2 = quantidadePecasRestantes2;
    }

    public ArrayList<Integer> pegaIndice(int jogadorAtual) {
        return jogadorAtual == 1 ? indicesValidosJogador1 : indicesValidosJogador2;
    }

    public void atualizaIndices(int jogadorAtual, int posicaoOrigem, int posicaoDestino) {
        ArrayList<Integer> indicesValidos = pegaIndice(jogadorAtual);
        indicesValidos.remove(Integer.valueOf(posicaoOrigem));
        indicesValidos.add(posicaoDestino);
    }

    public static void removePeca(Jogador jogador1, Jogador jogador2){
        if(jogador1.isRemoverPeca() == true){
            if(Main.jogadorAtual == 1){
                jogador1.setQuantidadePecasRestantes1(jogador1.getQuantidadePecasRestantes1()-1);
            }else{
                jogador2.setQuantidadePecasRestantes2(jogador2.getQuantidadePecasRestantes2()-1);
            }
        }
    }

}



