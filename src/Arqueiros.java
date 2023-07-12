import java.util.ArrayList;

public class Arqueiros extends Unidade{

    private int distancia;

    public Arqueiros(){
        tipoDanos.add("flecha");
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
        return "Arqueiros{} " ;
    }

    @Override
    protected Posicao getPosicao() {
        return null;
    }

    public void atacarInfantariaCavalaria(Campo campo, int posicaoOrigem, int posicaoDestino){
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
}
