import java.util.ArrayList;

public class Cavalaria extends Unidade {

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

        if (unidadeOrigem instanceof Cavalaria) {
            if (posicaoDestino >= 0 && posicaoDestino < campo.getPosicao().size()) {
                Posicao posicaoDestinoAtaque = campo.getMovimento(posicaoDestino);

                if (posicaoDestinoAtaque.getUnidade() instanceof Infantaria) {
                    System.out.println("Unidade de infantaria encontrada.");

                    // O dano 1 é o coice e ele só remove a unidade que está atrás
                    if (getTipoDano() == 1) {
                        int posicaoFrente = posicaoOrigem - 6;
                        Posicao posicaoFrenteUnidade = campo.getMovimento(posicaoFrente);
                        if (posicaoFrenteUnidade.getUnidade() instanceof Infantaria) {
                            System.out.println("Infantaria encontrada na posição à frente.");

                            // Realiza o ataque
                            posicaoDestinoAtaque.setUnidade(unidadeOrigem);
                            posicao.setUnidade(null);
                            posicaoFrenteUnidade.setUnidade(null);

                            Unidade cavalaria = unidadeOrigem;
                            posicaoDestinoAtaque.setUnidade(cavalaria);

                            System.out.println("Infantaria atacada");
                        }

                        //o dano 2 é pisoteado e só remove a unidade da frente
                    } else if (getTipoDano() == 2) {
                        int posicaoFrente2 = posicaoOrigem + 6;
                        Posicao posicaoFrenteUnidade2 = campo.getMovimento(posicaoFrente2);

                        if (posicaoFrenteUnidade2.getUnidade() instanceof Infantaria) {
                            System.out.println("Infantaria encontrada na posição à frente.");

                            // Realiza o ataque
                            posicaoDestinoAtaque.setUnidade(unidadeOrigem);
                            posicao.setUnidade(null);
                            posicaoFrenteUnidade2.setUnidade(null);

                            Unidade cavalaria = unidadeOrigem;
                            posicaoDestinoAtaque.setUnidade(cavalaria);
                            setAtaque(true);

                            System.out.println("Infantaria atacada");
                        }
                    } else {
                        System.out.println("Tipo de dano inválido.");
                    }
                } else {
                    System.out.println("Posição de destino não contém uma unidade de infantaria.");
                }
            } else {
                System.out.println("Posição de destino inválida.");
            }
        }
    }

    @Override
    public void mover(Campo campo, Posicao posicaoOrigem, int posicaoDestino) {
        Jogador jogador = new Jogador();

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

    @Override
    public void defesa(Campo campo, int posicaoOrigem, int posicaoAtaque, boolean seDefendendo) {

        // Verificar se o defensor é uma Cavalaria e o atacante é uma Infantaria
        if (this instanceof Cavalaria) {
            if (seDefendendo) {
                // Defesa bem-sucedida
                // Aqui você pode adicionar qualquer ação que deseja executar quando a defesa for bem-sucedida.
            } else {
                // A peça não é atacada, pois está se defendendo
                // Reduzir o número de chances de defesa após a defesa
                setChancesDefesa(getChancesDefesa() - 1);
            }
        }
    }


}



