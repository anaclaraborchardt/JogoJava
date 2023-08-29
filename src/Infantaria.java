public class Infantaria extends UnidadeMovel {
    public Infantaria( ){
        adicionarTipoDano("espada");
        adicionarTipoDano("bomba instantânea");
    }

    @Override
    public String toString() {
        return "Infantaria{} ";
    }

    @Override
    public void atacar(Campo campo, int posicaoOrigem, int posicaoDestino) {
        Posicao posicao = campo.getMovimento(posicaoOrigem);
        Unidade unidadeOrigem = posicao.getUnidade();

            if (posicaoDestino >= 0 && posicaoDestino < campo.getPosicao().size()) {
                Posicao posicaoDestinoAtaque = campo.getMovimento(posicaoDestino);

                if (posicaoDestinoAtaque.getUnidade() instanceof Cavalaria ||
                        posicaoDestinoAtaque.getUnidade() instanceof Arqueiros) {
                    // O dano 1 é a espada e só ataca o que está do lado direito
                    int posicaoInt = 1;
                    // O dano 1 é o coice e ele só remove a unidade que está atrás
                    if (getTipoDano() == 2) {
                        posicaoInt = -1;
                    }
                        //O dano 2 é a bomba e só ataca o que está do lado esquerdo
                        Posicao posicaoFrenteUnidade = campo.getMovimento(posicaoInt);

                        if (posicaoFrenteUnidade.getUnidade() instanceof Cavalaria ||
                                posicaoDestinoAtaque.getUnidade() instanceof Arqueiros) {

                            // Realiza o ataque
                            posicaoDestinoAtaque.setUnidade(unidadeOrigem);
                            posicao.setUnidade(null);
                            posicaoFrenteUnidade.setUnidade(null);

                            Unidade infantaria = unidadeOrigem;
                            posicaoDestinoAtaque.setUnidade(infantaria);


                    }

                } else if (posicaoDestinoAtaque.getUnidade() instanceof Tesouro) {
                        Jogador jogador = Main.jogadores.get(Main.jogadorAtual -1);
                        jogador.unidades.remove(posicaoDestinoAtaque.getUnidade());
                    }
            }
        }

    @Override
    public void mover(Campo campo, Posicao posicaoOrigem, int posicaoDestino) {
            int posicaoAtual = campo.getPosicao().indexOf(posicaoOrigem);

            // Verifica se a posição de destino é válida
            if (posicaoDestino >= 0 && posicaoDestino < campo.getPosicao().size()) {
                Posicao posicaoDestinoUnidade = campo.getMovimento(posicaoDestino);

                // Verifica se a posição de destino está vazia
                if (posicaoDestinoUnidade.getUnidade() == null) {
                        if (posicaoDestino == (posicaoAtual + 1)
                                || posicaoDestino == (posicaoAtual + 6)
                                || posicaoDestino == (posicaoAtual + 12)
                                || posicaoDestino == (posicaoAtual - 6)
                                || posicaoDestino == (posicaoAtual - 12)) {
                            // Executa movimento
                            Unidade unidade = posicaoOrigem.getUnidade();
                            posicaoDestinoUnidade.setUnidade(unidade);
                            posicaoOrigem.setUnidade(null);

                        }
            }
        }
    }

    @Override
    public void setSimbolo(String simbolo) {
        super.setSimbolo("I");
    }


}