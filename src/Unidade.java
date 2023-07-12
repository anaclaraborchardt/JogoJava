import java.util.ArrayList;

public abstract class Unidade {

    int quantidadeDefesa;
    int quantidadeVidas;
    int tipoDano;
    ArrayList<String> tipoDanos = new ArrayList<>();

    private Posicao posicao;

    public abstract ArrayList<Posicao> movimentos(
            Campo campo
    );

    public abstract ArrayList<Posicao> defesa(
            Campo campo
    );
    // public boolean identificaPeca(Posicao posicao, ArrayList<Posicao> movimentos) {
    //    if (posicao.getUnidade() == null) {
    //        movimentos.add(posicao);
    //       return false;
    //  } else{
    //      return true;
    //   }
    // }

    @Override
    public String toString() {
        return "Unidade{}";
    }



    protected abstract Posicao getPosicao();



}
