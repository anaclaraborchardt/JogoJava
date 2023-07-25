import java.util.ArrayList;

public abstract class Unidade {

    private int tipoDano;
    private int chancesDefesa;
    private boolean ataque;
    private ArrayList<String> tipoDanos = new ArrayList<>();

    @Override
    public String toString() {
        return "Unidade{}";
    }

    public abstract void atacar(Campo campo, int posicaoOrigem, int posicaoDestino);

    public abstract void mover(Campo campo, Posicao posicaoOrigem, int posicaoDestino);

    public abstract void defesa(Campo campo, int posicaoOrigem, int posicaoAtaque, boolean seDefendendo);

    public void setTipoDano(int tipoDano) {
        this.tipoDano = tipoDano;
    }

    public int getTipoDano() {
        return tipoDano;
    }

    public int getChancesDefesa() {
        return chancesDefesa;
    }

    public int setChancesDefesa(int chancesDefesa) {
        this.chancesDefesa = chancesDefesa;
        return chancesDefesa;
    }
    public ArrayList<String> getTipoDanos() {
        return tipoDanos;
    }

    public void adicionarTipoDano(String tipoDano) {
        tipoDanos.add(tipoDano);
    }

    public boolean isAtaque() {
        return ataque;
    }

    public void setAtaque(boolean ataque) {
        this.ataque = ataque;
    }
}
