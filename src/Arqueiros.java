import java.util.ArrayList;

public class Arqueiros extends Unidade{

    public Arqueiros(){
        adicionarTipoDano("flecha");;
    }

    @Override
    public String toString() {
        return "Arqueiros{} " ;
    }

    @Override
    public void atacar(Campo campo, int posicaoOrigem, int posicaoDestino) {

        Posicao posicao = campo.getMovimento(posicaoOrigem);
        Unidade unidadeOrigem = posicao.getUnidade();

        if (unidadeOrigem instanceof Arqueiros) {
            if (posicaoDestino >= 0 && posicaoDestino < campo.getPosicao().size()) {
                Posicao posicaoDestinoAtaque = campo.getMovimento(posicaoDestino);

                if (posicaoDestinoAtaque.getUnidade() instanceof Infantaria ||
                        posicaoDestinoAtaque.getUnidade() instanceof Cavalaria) {

                    int posicaoFrente = posicaoOrigem + 36;
                    Posicao posicaoFrenteUnidade = campo.getMovimento(posicaoFrente);

                    // Realiza o ataque
                    posicaoDestinoAtaque.setUnidade(null);
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

            // Verifica se a posição de destino é válida
            if (posicaoDestino >= 0 && posicaoDestino < campo.getPosicao().size()) {
                Posicao posicaoDestinoUnidade = campo.getMovimento(posicaoDestino);

                if (posicaoOrigem.getUnidade() instanceof Cavalaria) {
                    System.out.println("Arqueiro não pode se mover");
                }
            }
        }

    }

    @Override
    public void defesa(Campo campo, int posicaoOrigem, int posicaoAtaque, boolean seDefendendo) {

        // Verificar se o defensor é uma Cavalaria e o atacante é uma Infantaria
        if (this instanceof Arqueiros) {
            if (!seDefendendo) {
                atacar(campo, posicaoOrigem, posicaoAtaque);
            } else {
                setChancesDefesa(getChancesDefesa() - 1);
            }
        }
    }
}
