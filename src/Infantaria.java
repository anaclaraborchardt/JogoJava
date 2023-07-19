import java.util.ArrayList;

public class Infantaria extends Unidade{

    int quantidadeCasas;
    int posicaoMover;

    public Infantaria( ){
        quantidadeCasas= this.quantidadeCasas;
        posicaoMover = this.posicaoMover;
        tipoDanos.add("espada");
        tipoDanos.add("bomba instantânea");
        tipoDano = this.tipoDano;
    }


    @Override
    public ArrayList<Posicao> movimentos(Campo campo) {
        return null;
    }

    @Override
    public ArrayList<Posicao> defesa(Campo campo) {
        return null;
    }

    @Override
    public String toString() {
        return "Infantaria{} ";
    }

    @Override
    public void atacar(Campo campo, int posicaoOrigem, int posicaoDestino) {
        Posicao posicao = campo.getMovimento(posicaoOrigem);
        Unidade unidadeOrigem = posicao.getUnidade();

        if (unidadeOrigem instanceof Infantaria) {
            if (posicaoDestino >= 0 && posicaoDestino < campo.getPosicao().size()) {
                Posicao posicaoDestinoAtaque = campo.getMovimento(posicaoDestino);

                if (posicaoDestinoAtaque.getUnidade() instanceof Cavalaria) {

                    // O dano 1 é a espada e só ataca o que está do lado direito
                    if (tipoDano == 1) {
                        int posicaoFrente = posicaoOrigem + 1;
                        Posicao posicaoFrenteUnidade = campo.getMovimento(posicaoFrente);
                        if (posicaoFrenteUnidade.getUnidade() instanceof Cavalaria) {

                            // Realiza o ataque
                            posicaoDestinoAtaque.setUnidade(unidadeOrigem);
                            posicao.setUnidade(null);
                            posicaoFrenteUnidade.setUnidade(null);

                            Unidade infantaria = unidadeOrigem;
                            posicaoDestinoAtaque.setUnidade(infantaria);

                        }

                        //O dano 2 é a bomba e só ataca o que está do lado esquerdo
                    } else if (tipoDano == 2) {
                        int posicaoFrente2 = posicaoOrigem - 1;
                        Posicao posicaoFrenteUnidade2 = campo.getMovimento(posicaoFrente2);

                        if (posicaoFrenteUnidade2.getUnidade() instanceof Cavalaria) {

                            // Realiza o ataque
                            posicaoDestinoAtaque.setUnidade(unidadeOrigem);
                            posicao.setUnidade(null);
                            posicaoFrenteUnidade2.setUnidade(null);

                            Unidade infantaria = unidadeOrigem;
                            posicaoDestinoAtaque.setUnidade(infantaria);

                            System.out.println("Infantaria atacada");
                        }
                    }
                }
            }
        }
    }
    @Override
    public void mover(Campo campo, Posicao posicaoOrigem, int posicaoDestino) {
        Jogador jogador = new Jogador();
        // Verifica se a posição de origem tem unidade
        if (posicaoOrigem.getUnidade() != null) {
            int posicaoAtual = campo.getPosicao().indexOf(posicaoOrigem);
            int posPossivelInfant = posicaoAtual + 6;
            int posPossivelInfant2 = posicaoAtual + 12;
            int posPossivelInfant3 = posicaoAtual + 1;


            // Verifica se a posição de destino é válida
            if (posicaoDestino >= 0 && posicaoDestino < campo.getPosicao().size()) {
                Posicao posicaoDestinoUnidade = campo.getMovimento(posicaoDestino);

                // Verifica se a posição de destino está vazia
                if (posicaoDestinoUnidade.getUnidade() == null) {
                    if (posicaoOrigem.getUnidade() instanceof Infantaria) {
                        if (posicaoDestino == posPossivelInfant3
                                || posicaoDestino == (posicaoAtual + 6)
                                || posicaoDestino == (posicaoAtual + 12)
                                || posicaoDestino == (posicaoAtual - 6)
                                || posicaoDestino == (posicaoAtual - 12)) {
                            // Executa movimento
                            Unidade unidade = posicaoOrigem.getUnidade();
                            posicaoDestinoUnidade.setUnidade(unidade);
                            posicaoOrigem.setUnidade(null);
                            jogador.unidadesJogador1.remove(posicaoOrigem);

                    }
                }
            }
        }
        }
    }

}