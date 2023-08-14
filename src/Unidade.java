import java.util.ArrayList;

public abstract class Unidade {

    private int tipoDano;
    private int chancesDefesa = 1;
    private boolean ataque;
    private ArrayList<String> tipoDanos = new ArrayList<>();

    @Override
    public String toString() {
        return "Unidade{}";
    }

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
