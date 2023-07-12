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
}
