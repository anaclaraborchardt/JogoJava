import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Jogador jogador = new Jogador();
    static int jogadorAtual = 1;

    public static void main(String[] args) {

        Campo campo = new Campo();


        Infantaria infantaria = new Infantaria();
        Cavalaria cavalaria = new Cavalaria();
        Arqueiros arqueiros = new Arqueiros();

        do {

            Integer posicaoOrigem = null;
            do{
                campo.imprimirJogo();
                defineGanhador();
                System.out.println(jogador.unidadesJogador1);
                posicaoOrigem = mover();
            }while(posicaoOrigem == null);

                    System.out.println("Para qual posição você deseja ir? (Digite o índice de destino)");
                    System.out.println("\nCaso queira atacar, digite 100");
                    int posicaoDestino = sc.nextInt();

                    if (posicaoDestino == 100) {
                        System.out.println("Qual a peca que deseja atacar 1- Infant; 2- Caval");
                        int peca = sc.nextInt();
                        System.out.println("Qual a posição da peça que deseja atacar? ");
                        int posicaoPecaAtaque = sc.nextInt();

                        if (peca == 1) {

                            System.out.println("Qual dano você quer utilizar? \n");
                            System.out.println("Cavalaria" + cavalaria.tipoDanos);
                            int tipoDano = sc.nextInt();
                            cavalaria.tipoDano = tipoDano;
                            cavalaria.setTipoDano(tipoDano);

                            cavalaria.atacar(campo, posicaoOrigem, posicaoPecaAtaque);
                            arqueiros.atacar(campo, posicaoOrigem, posicaoPecaAtaque);

                        } else if (peca == 2) {

                            System.out.println("Qual dano você quer utilizar? \n");
                            System.out.println("Infantaria" + infantaria.tipoDanos);
                            int tipoDano = sc.nextInt();
                            infantaria.tipoDano = tipoDano;
                            infantaria.setTipoDano(tipoDano);

                            infantaria.atacar(campo, posicaoOrigem, posicaoPecaAtaque);
                            arqueiros.atacar(campo, posicaoOrigem, posicaoPecaAtaque);

                        }

                    } else {
                        ArrayList<Posicao> listaPosicoes = campo.getPosicao();
                        if (posicaoOrigem >= 0 && posicaoOrigem < listaPosicoes.size()) {
                            Posicao posicaoOrigemObj = listaPosicoes.get(posicaoOrigem);
                            cavalaria.mover(campo, posicaoOrigemObj, posicaoDestino);
                            infantaria.mover(campo, posicaoOrigemObj, posicaoDestino);
                            arqueiros.mover(campo, posicaoOrigemObj, posicaoDestino);
                        } else {
                            System.out.println("A posição de origem é inválida.");
                        }
                    }




        } while (true);
    }

    public static Integer mover() {

        System.out.println("Arqueiro: anda 1 ou 2 espaços para frente ou um para o lado;\n" +
                "Cavalaria: Pode andar para frente, trás, lado esquerdo ou direito\n" +
                "Arqueiro não pode se mover\n" +
                "O objetivo final é atacar o castelo");

        System.out.println("\nQual posição deseja mover ou atacar? (Digite o índice da peça).");
        int posicaoOrigem = sc.nextInt();

        if (jogadorAtual == 1) {
            jogadorAtual = 2;
            jogador.setUnidades(jogador.unidadesJogador2);
        } else if (jogadorAtual == 2) {
            jogadorAtual = 1;
            jogador.setUnidades(jogador.unidadesJogador1);
        }
        return posicaoOrigem;
    }

    public static void defineGanhador(){
        if(jogador.ganhar() == true){
            System.out.println("O ganhador é o jogador "+ jogadorAtual);
        }
    }
}
