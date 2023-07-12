import java.util.ArrayList;

public class Infantaria extends Unidade{

    int quantidadeCasas;
    int posicaoMover;

    public Infantaria( ){
        quantidadeCasas= this.quantidadeCasas;
        posicaoMover = this.posicaoMover;
        tipoDanos.add("espada");
        tipoDanos.add("bomba instantânea");
        tipoDano = this.tipoDano;
    }

    public Infantaria(int quantidadeCasas, int posicaoMover) {
        super();
    }

    public ArrayList<Posicao> movimentos(Campo campo) {
        ArrayList<Posicao> movimentos = new ArrayList<>();
        Posicao posicaoAtual = this.getPosicao();
        int posicaoJogo = campo.getPosicao().indexOf(posicaoAtual);
        ArrayList<Posicao> posicoesJogo = campo.getPosicao();

        if ((posicaoMover == 12 && quantidadeCasas == 1) ||
                (posicaoMover == 13 && quantidadeCasas == 1) ||
                (posicaoMover == 16 && quantidadeCasas == 1) ||
                (posicaoMover == 17 && quantidadeCasas == 1) ||
                (posicaoMover == 18 && quantidadeCasas == 1) ||
                (posicaoMover == 19 && quantidadeCasas == 1) ||
                (posicaoMover == 22 && quantidadeCasas == 1) ||
                (posicaoMover == 23 && quantidadeCasas == 1) ||
                (posicaoMover == 60 && quantidadeCasas == 1) ||
                (posicaoMover == 61 && quantidadeCasas == 1) ||
                (posicaoMover == 64 && quantidadeCasas == 1) ||
                (posicaoMover == 65 && quantidadeCasas == 1) ||
                (posicaoMover == 66 && quantidadeCasas == 1) ||
                (posicaoMover == 67 && quantidadeCasas == 1) ||
                (posicaoMover == 70 && quantidadeCasas == 1) ||
                (posicaoMover == 71 && quantidadeCasas == 1)) {

            if (identificaPeca(posicaoAtual)) {
                for (int i = 1; i <= quantidadeCasas; i++) {
                    if (posicaoJogo + i < posicoesJogo.size()) {
                        movimentos.add(posicoesJogo.get(posicaoJogo + i));
                    }
                }
            } else {
                return null;
            }
        }

        return movimentos;
    }

    private boolean identificaPeca(Posicao posicao) {
        Unidade unidade = posicao.getUnidade();
        return unidade instanceof Infantaria;
    }

    @Override
    public ArrayList<Posicao> defesa(Campo campo) {
        return null;
    }

    @Override
    public String toString() {
        return "Infantaria{} ";
    }

    @Override
    protected Posicao getPosicao() {
        return null;
    }

    public void atacarCavalaria(Campo campo, int posicaoOrigem, int posicaoDestino) {
        Posicao posicao = campo.getMovimento(posicaoOrigem);
        Unidade unidadeOrigem = posicao.getUnidade();
        if (unidadeOrigem instanceof Infantaria){
            if (posicaoDestino >= 0 && posicaoDestino < campo.getPosicao().size()) {
                Posicao posicaoDestinoAtaque = campo.getMovimento(posicaoDestino);

                if (posicaoDestinoAtaque.getUnidade() instanceof Cavalaria) {
                    System.out.println("Unidade de cavalaria encontrada.");

                    int posicaoFrente = posicaoOrigem + 6;
                    Posicao posicaoFrenteUnidade = campo.getMovimento(posicaoFrente);
                    if (posicaoFrenteUnidade.getUnidade() instanceof Cavalaria) {
                        System.out.println("Cavalaria encontrada na posição à frente.");

                        // Realiza o ataque
                        posicaoDestinoAtaque.setUnidade(unidadeOrigem);
                        posicao.setUnidade(null);
                        posicaoFrenteUnidade.setUnidade(null);

                        Unidade infantaria = unidadeOrigem;
                        posicaoDestinoAtaque.setUnidade(infantaria);


                        System.out.println("cavalaria atacada");
                    } else {
                        System.out.println("Não há cavalaria na posição à frente. O ataque não pode ser realizado.");
                    }
                } else {
                    System.out.println("Posição de destino não contém uma unidade de cavalaria.");
                }
            } else {
                System.out.println("Posição de destino inválida.");
            }

        }
    }
}
