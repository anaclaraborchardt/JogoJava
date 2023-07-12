import java.util.ArrayList;

public class Cavalaria extends Unidade{

    public Cavalaria(){
        tipoDanos.add("Coice");
        tipoDanos.add("Pisoteado");
        tipoDano = this.tipoDano;
    }

    @Override
    public ArrayList<Posicao> movimentos(Campo campo) {
        ArrayList<Posicao> movimentos = new ArrayList<>();
        for(Posicao posicao: campo.getPosicao()){
            int indice = campo.getPosicao().indexOf(posicao);
        }
        return movimentos;
    }

    @Override
    public ArrayList<Posicao> defesa(Campo campo) {
        return null;
    }

    @Override
    public String toString() {
        return "Cavalaria{} " ;
    }

    @Override
    protected Posicao getPosicao() {
        return null;
    }

    public void atacarInfantaria(Campo campo, int posicaoOrigem, int posicaoDestino) {
        Posicao posicao = campo.getMovimento(posicaoOrigem);
        Unidade unidadeOrigem = posicao.getUnidade();

        if (unidadeOrigem instanceof Cavalaria) {
            if (posicaoDestino >= 0 && posicaoDestino < campo.getPosicao().size()) {
                Posicao posicaoDestinoAtaque = campo.getMovimento(posicaoDestino);

                if (posicaoDestinoAtaque.getUnidade() instanceof Infantaria) {
                    System.out.println("Unidade de infantaria encontrada.");

                    int posicaoFrente = posicaoOrigem + 6;
                    Posicao posicaoFrenteUnidade = campo.getMovimento(posicaoFrente);
                    if (posicaoFrenteUnidade.getUnidade() instanceof Infantaria) {
                        System.out.println("Infantaria encontrada na posição à frente.");

                        // Realiza o ataque
                        posicaoDestinoAtaque.setUnidade(unidadeOrigem);
                        posicao.setUnidade(null);
                        posicaoFrenteUnidade.setUnidade(null);

                        Unidade cavalaria = unidadeOrigem;
                        posicaoDestinoAtaque.setUnidade(cavalaria);


                        System.out.println("Infantaria atacada");
                    } else {
                        System.out.println("Não há infantaria na posição à frente. O ataque não pode ser realizado.");
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
