import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int jogadorAtual = 1;
    static Jogador jogador1 = new Jogador(1);
    static Jogador jogador2 = new Jogador(2);
    static ArrayList<Jogador> jogadores = new ArrayList<>();
    static boolean jogoAcabou;
    static int posicaoDestino;
    static int posicaoOrigem;
    static UnidadeMovel unidadeOrigem;
    static Unidade unidadeAtacada;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        jogadores.add(jogador1);
        jogadores.add(jogador2);

        Campo campo = new Campo();

        do {
            Jogador jogador = jogadores.get(jogadorAtual - 1);
            //1 - 6 até 24
            //2 - 60 até 78
            System.out.println("Jogador " + jogadorAtual);

            if(jogadorAtual == 1){
                System.out.println("Você pode mover da 6 até a 24");
            }else{
                System.out.println("Você pode mover da 60 até a 78");
            }

            System.out.println(jogador.unidades);
            campo.imprimirJogo();

            boolean escolhaValida = false;

            do {
                System.out.println("Qual posição deseja mover? (Digite o índice da peça).");
                posicaoOrigem = sc.nextInt();

                ArrayList<Integer> indicesValidos = jogador.getIndicesValidosJogador();
                if (!indicesValidos.contains(posicaoOrigem)) {
                    System.out.println("Essa não é uma de suas peças");
                    System.out.println("Escolha outra posição: ");
                } else {
                    escolhaValida = true;
                }
            } while (!escolhaValida);

            System.out.println("Para qual posição você deseja ir? (Digite o índice de destino)");
            System.out.println("\nCaso queira atacar, digite 100");
            posicaoDestino = sc.nextInt();

            unidadeOrigem = (UnidadeMovel) campo.getMovimento(posicaoOrigem).getUnidade();

            if (posicaoDestino == 100) {
                System.out.println("Qual a posição da peça que deseja atacar? ");
                int posicaoPecaAtaque = sc.nextInt();
                unidadeAtacada = campo.getMovimento(posicaoPecaAtaque).getUnidade();

                ArrayList<Integer> indicesValidos = jogador.getIndicesValidosJogador();
                if (!indicesValidos.contains(posicaoPecaAtaque)) {
                    System.out.println("Você não pode atacar uma de suas peças!");
                }

                    System.out.println("Qual dano você quer utilizar? \n");
                    System.out.println(unidadeOrigem.getClass().getSimpleName() + " " + unidadeOrigem.getTipoDanos());
                    int tipoDano = sc.nextInt();
                    unidadeOrigem.setTipoDano(tipoDano);


                 unidadeOrigem.atacar(campo, posicaoOrigem, posicaoPecaAtaque);
                    jogador.setRemoverPeca(true);

                    if(!(unidadeAtacada instanceof Tesouro)){
                        UnidadeMovel unidadeMovel = (UnidadeMovel) unidadeAtacada;
                        String retornoDefesa = unidadeMovel.defesa(campo, posicaoOrigem, posicaoPecaAtaque) ;

                        System.out.println(retornoDefesa);
                    }


            } else {
                ArrayList<Posicao> listaPosicoes = campo.getPosicao();
                if (posicaoOrigem >= 0 && posicaoOrigem < listaPosicoes.size()) {
                    Posicao posicaoOrigemObj = listaPosicoes.get(posicaoOrigem);
                    unidadeOrigem.mover(campo, posicaoOrigemObj, posicaoDestino);

                    jogador.atualizaIndices(jogadorAtual, posicaoOrigem, posicaoDestino);
                } else {
                    System.out.println("A posição de origem é inválida.");
                }
            }
            alternaJogador();


        } while (!jogoAcabou);

        confereVencedor();
    }
    public static void confereVencedor() {
        if(jogador1.getQuantidadePecasRestantes()==0){
            System.out.println("Jogador 2 venceu!");
            jogoAcabou = true;
        }else if(jogador2.getQuantidadePecasRestantes()==0){
            System.out.println("Jogador 1 venceu!");
            jogoAcabou = true;
        }
    }

    public static void alternaJogador(){
        if (jogadorAtual == 1) {
            jogadorAtual = 2;
        } else if (jogadorAtual == 2) {
            jogadorAtual = 1;
        }
    }

}
