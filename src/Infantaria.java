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
    protected Posicao getPosicao() {
        return null;
    }

    public void atacarCavalaria(Campo campo, int posicaoOrigem, int posicaoDestino) {
        Posicao posicao = campo.getMovimento(posicaoOrigem);
        Unidade unidadeOrigem = posicao.getUnidade();

        if (unidadeOrigem instanceof Infantaria) {
            if (posicaoDestino >= 0 && posicaoDestino < campo.getPosicao().size()) {
                Posicao posicaoDestinoAtaque = campo.getMovimento(posicaoDestino);

                if (posicaoDestinoAtaque.getUnidade() instanceof Cavalaria) {
                    System.out.println("Unidade de Cavalaria encontrada.");

                    // O dano 1 é a espada e só ataca o que está do lado direito
                    if (tipoDano == 1) {
                        int posicaoFrente = posicaoOrigem + 1;
                        Posicao posicaoFrenteUnidade = campo.getMovimento(posicaoFrente);
                        if (posicaoFrenteUnidade.getUnidade() instanceof Cavalaria) {
                            System.out.println("Infantaria encontrada na posição à frente.");

                            // Realiza o ataque
                            posicaoDestinoAtaque.setUnidade(unidadeOrigem);
                            posicao.setUnidade(null);
                            posicaoFrenteUnidade.setUnidade(null);

                            Unidade infantaria = unidadeOrigem;
                            posicaoDestinoAtaque.setUnidade(infantaria);

                            System.out.println("Cavalaria atacada");
                        }

                        //O dano 2 é a bomba e só ataca o que está do lado esquerdo
                    } else if (tipoDano == 2) {
                        int posicaoFrente2 = posicaoOrigem -1;
                        Posicao posicaoFrenteUnidade2 = campo.getMovimento(posicaoFrente2);

                        if (posicaoFrenteUnidade2.getUnidade() instanceof Cavalaria) {
                            System.out.println("Cavalaria encontrada na posição à frente.");

                            // Realiza o ataque
                            posicaoDestinoAtaque.setUnidade(unidadeOrigem);
                            posicao.setUnidade(null);
                            posicaoFrenteUnidade2.setUnidade(null);

                            Unidade infantaria = unidadeOrigem;
                            posicaoDestinoAtaque.setUnidade(infantaria);

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
}

