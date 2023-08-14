import java.util.ArrayList;

public class Jogador {

    private int jogadorAtual;
    ArrayList<Unidade> unidades = new ArrayList<>();
//    ArrayList<Unidade> unidadesJogador2 = new ArrayList<>();
    private ArrayList<Integer> indicesValidosJogador = new ArrayList<>();
//    private ArrayList<Integer> indicesValidosJogador2 = new ArrayList<>();
    private int quantidadePecasRestantes = 18;
//    private int quantidadePecasRestantes2 = 18;
    private boolean removerPeca;

    public Jogador(int numeroJogador) {

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

    public void setUnidades(ArrayList<Unidade> unidades) {
        this.unidades = unidades;
    }

    public void setRemoverPeca(boolean removerPeca) {
        this.removerPeca = removerPeca;
    }

    public int getQuantidadePecasRestantes() {
        return quantidadePecasRestantes;
    }

    public void setQuantidadePecasRestantes(int quantidadePecasRestantes) {
        this.quantidadePecasRestantes = quantidadePecasRestantes;
    }

    public void atualizaIndices(int jogadorAtual, int posicaoOrigem, int posicaoDestino) {
        ArrayList<Integer> indicesValidos = getIndicesValidosJogador();
        indicesValidos.remove(Integer.valueOf(posicaoOrigem));
        indicesValidos.add(posicaoDestino);
    }

    public ArrayList<Integer> getIndicesValidosJogador() {
        return indicesValidosJogador;
    }
}



