import java.util.ArrayList;

public abstract class Unidade {

    int tipoDano;
    ArrayList<String> tipoDanos = new ArrayList<>();

    public abstract ArrayList<Posicao> movimentos(
            Campo campo
    );

    public abstract ArrayList<Posicao> defesa(
            Campo campo
    );

    @Override
    public String toString() {
        return "Unidade{}";
    }

    public abstract void atacar(Campo campo, int posicaoOrigem, int posicaoDestino);

    public abstract void mover(Campo campo, Posicao posicaoOrigem, int posicaoDestino);

    public abstract void defesa(Campo campo, Posicao posicaoOrigem, int posicaoDestino);

    public void setTipoDano(int tipoDano) {
        this.tipoDano = tipoDano;
    }

}
