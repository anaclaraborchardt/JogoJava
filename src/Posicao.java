public class Posicao {

    private Unidade unidade;

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public void moverPeca(Campo campo, Posicao posicaoOrigem, int posicaoDestino) {
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

                if (posicaoOrigem.getUnidade() instanceof Cavalaria ||
                        posicaoOrigem.getUnidade() instanceof Infantaria) {

                    // Verifica se a posição de destino está vazia
                    if (posicaoDestinoUnidade.getUnidade() == null) {
                        if (posicaoOrigem.getUnidade() instanceof Infantaria) {
                            if (posicaoDestino == posPossivelInfant3
                                    || posicaoDestino == (posicaoAtual + 6)
                                    || posicaoDestino == (posicaoAtual + 12)
                            ||posicaoDestino == (posicaoAtual - 6)
                                    ||posicaoDestino == (posicaoAtual - 12)){
                                // Executa movimento
                                Unidade unidade = posicaoOrigem.getUnidade();
                                posicaoDestinoUnidade.setUnidade(unidade);
                                posicaoOrigem.setUnidade(null);
                                jogador.unidadesJogador1.remove(posicaoOrigem);

                            } else {
                                System.out.println("O Arqueiro não pode executar esse movimento. " +
                                        "\nEle pode andar um ou dois blocos para frente ");
                            }
                        }
                        if (posicaoOrigem.getUnidade() instanceof Cavalaria) {

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
                                    posicaoDestino == (posicaoAtual - 18) ) {
                                // Executa movimento
                                Unidade unidade = posicaoOrigem.getUnidade();
                                posicaoDestinoUnidade.setUnidade(unidade);
                                posicaoOrigem.setUnidade(null);
                                jogador.unidadesJogador1.remove(posicaoOrigem);

                            } else {
                                System.out.println("O Cavaleiro não pode executar esse movimento. ");
                            }
                        }
                    } else {
                        System.out.println("Posição Ocupada. Tente novamente");
                    }
                } else {
                    System.out.println("Esta unidade não pode se movimentar. Tente novamente");
                }
            } else {
                System.out.println("Posição Inexistente. Tente novamente");
            }
        } else {
            System.out.println("Posição sem unidade. Tente novamente");
        }
    }

    public void atacarArqueiros(Campo campo, int posicaoOrigem, int posicaoDestino){
        Posicao posicao = campo.getMovimento(posicaoOrigem);
        Unidade unidadeOrigem = posicao.getUnidade();
        if (unidadeOrigem instanceof Infantaria){

        }

    }

}









