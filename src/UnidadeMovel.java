import java.util.ArrayList;

public abstract class UnidadeMovel extends Unidade {

    public abstract void atacar(Campo campo, int posicaoOrigem, int posicaoDestino);

    public abstract void mover(Campo campo, Posicao posicaoOrigem, int posicaoDestino);

    public String defesa(Campo campo, int posicaoOrigem, int posicaoAtaque) {

        // Verificar se o defensor é uma Cavalaria e o atacante é uma Infantaria
        if (getChancesDefesa() == 0) {
            atacar(campo, posicaoOrigem, posicaoAtaque);
            return ("Sua " + this.getClass().getSimpleName() + " peça não tinha mais defesa");
        }
        setChancesDefesa(getChancesDefesa() - 1);

        return ("Sua  "+ this.getClass().getSimpleName() + " peça ainda tem defesa");
    }

}
