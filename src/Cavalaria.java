import java.util.ArrayList;

public class Cavalaria extends UnidadeMovel {

    private ArrayList<Integer> listaPosicoesDestino = new ArrayList<>();

    public Cavalaria() {
        adicionarTipoDano("Coice");
        adicionarTipoDano("Pisoteado");
    }

    @Override
    public String toString() {
        return "Cavalaria{} ";
    }


    public void atacar(Campo campo, int posicaoOrigem, int posicaoDestino) {
        Posicao posicao = campo.getMovimento(posicaoOrigem);
        Unidade unidadeOrigem = posicao.getUnidade();

        if (posicaoDestino >= 0 && posicaoDestino < campo.getPosicao().size()) {
            Posicao posicaoDestinoAtaque = campo.getMovimento(posicaoDestino);

            if (posicaoDestinoAtaque.getUnidade() instanceof Infantaria) {

                int posicaoInt = 6;
                // O dano 1 é o coice e ele só remove a unidade que está atrás
                if (getTipoDano() == 1) {
                    posicaoInt = -6;
                }
                Posicao posicaoFrenteUnidade = campo.getMovimento(posicaoInt);
                if (posicaoFrenteUnidade.getUnidade() instanceof Infantaria) {

                    // Realiza o ataque
                    posicaoDestinoAtaque.setUnidade(unidadeOrigem);
                    posicao.setUnidade(null);
                    posicaoFrenteUnidade.setUnidade(null);

                    Unidade cavalaria = unidadeOrigem;
                    posicaoDestinoAtaque.setUnidade(cavalaria);

                }
            } else if (posicaoDestinoAtaque.getUnidade() instanceof Tesouro) {
                Jogador jogador = Main.jogadores.get(Main.jogadorAtual -1);
                    jogador.unidades.remove(posicaoDestinoAtaque.getUnidade());
            }
        }

    }

    @Override
    public void mover(Campo campo, Posicao posicaoOrigem, int posicaoDestino) {
//        Jogador jogador = new Jogador();


        if (posicaoOrigem.getUnidade() != null) {
            int posicaoAtual = campo.getPosicao().indexOf(posicaoOrigem);

            // Verifica se a posição de destino é válida
            if (posicaoDestino >= 0 && posicaoDestino < campo.getPosicao().size()) {
                Posicao posicaoDestinoUnidade = campo.getMovimento(posicaoDestino);

                if (posicaoOrigem.getUnidade() instanceof Cavalaria) {

                    if (posicaoDestinoUnidade.getUnidade() == null) {

                        if (posicaoDestino == (posicaoAtual + 6) ||
                                posicaoDestino == (posicaoAtual - 1) ||
                                posicaoDestino == (posicaoAtual + 11) ||
                                posicaoDestino == (posicaoAtual + 12) ||
                                posicaoDestino == (posicaoAtual + 13) ||
                                posicaoDestino == (posicaoAtual + 18) ||
                                posicaoDestino == (posicaoAtual - 6) ||
                                posicaoDestino == (posicaoAtual + 1) ||
                                posicaoDestino == (posicaoAtual - 11) ||
                                posicaoDestino == (posicaoAtual - 12) ||
                                posicaoDestino == (posicaoAtual - 13) ||
                                posicaoDestino == (posicaoAtual - 18)) {
                            listaPosicoesDestino.add(posicaoDestino);
                            setListaPosicoesDestino(listaPosicoesDestino);
                            // Executa movimento
                            Unidade unidade = posicaoOrigem.getUnidade();
                            posicaoDestinoUnidade.setUnidade(unidade);
                            posicaoOrigem.setUnidade(null);
                        }
                    }
                }
            }
        }

    }

    @Override
    public void setSimbolo(String simbolo) {
        super.setSimbolo("C");
    }

    public ArrayList<Integer> getListaPosicoesDestino() {
        return listaPosicoesDestino;
    }

    public void setListaPosicoesDestino(ArrayList<Integer> listaPosicoesDestino) {
        this.listaPosicoesDestino = listaPosicoesDestino;
    }
}



