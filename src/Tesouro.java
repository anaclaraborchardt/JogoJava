import java.util.ArrayList;

public class Tesouro extends Unidade{

    public Tesouro(){

    }

    public ArrayList<Posicao> movimentos(Campo campo) {
        return null;
    }

    public ArrayList<Posicao> defesa(Campo campo) {
        return null;
    }

    protected Posicao getPosicao() {
        return null;
    }

    @Override
    public void atacar(Campo campo, int posicaoOrigem, int posicaoDestino) {

    }

    @Override
    public void mover(Campo campo, Posicao posicaoOrigem, int posicaoDestino) {

    }

    @Override
    public void defesa(Campo campo, Posicao posicaoOrigem, int posicaoDestino) {

    }

    public String toString() {
        return "Tesouro{} " ;
    }
}
