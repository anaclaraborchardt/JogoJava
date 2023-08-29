import java.util.ArrayList;

public class Jogador {

    ArrayList<Unidade> unidades = new ArrayList<>();
    private ArrayList<Integer> indicesValidosJogador = new ArrayList<>();
    private int quantidadePecasRestantes = 18;
    private boolean removerPeca;

    public Jogador(int numeroJogador, String nome) {

        for (int i = 0; i <= 1; i++) {
            unidades.add(new Tesouro());
        }
        for (int i = 0; i <= 5; i++) {
            unidades.add(new Arqueiros());
        }
        for (int i = 0; i <= 7; i++) {
            unidades.add(new Infantaria());
        }
        for (int i = 0; i <= 3; i++) {
            unidades.add(new Cavalaria());
        }
        if(numeroJogador == 1) {
            for (int i = 0; i <= 23; i++) {
                indicesValidosJogador.add(i);
            }
        }else {
            for (int i = 60; i <= 83; i++) {
                indicesValidosJogador.add(i);
            }
        }
    }

    public void setRemoverPeca(boolean removerPeca) {
        this.removerPeca = removerPeca;
    }

    public int getQuantidadePecasRestantes() {
        return quantidadePecasRestantes;
    }

    public void atualizaIndices(int jogadorAtual, int posicaoOrigem, int posicaoDestino) {
        ArrayList<Integer> indicesValidos = getIndicesValidosJogador();
        indicesValidos.remove(Integer.valueOf(posicaoOrigem));
        indicesValidos.add(posicaoDestino);
    }

    public ArrayList<Integer> getIndicesValidosJogador() {
        return indicesValidosJogador;
    }

//    public static ArrayList<Jogador> adicionaJogador(){
//
//    }

}



