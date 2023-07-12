import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Campo campo = new Campo();
        Posicao posicaoOrigem2 = new Posicao();
        Jogador jogador = new Jogador();
        int jogadorAtual = 1;

        Infantaria infantaria = new Infantaria();
        Cavalaria cavalaria = new Cavalaria();
        Arqueiros arqueiros = new Arqueiros();

        do {
            Posicao posicao2 = new Posicao();
                int indice = campo.getPosicao().indexOf(posicao2);

            System.out.println("Jogador " + jogadorAtual);
            System.out.println(jogadorAtual == 1 ? jogador.unidadesJogador1 : jogador.unidadesJogador2);
            campo.imprimirJogo();

            //implementar a rodada
            System.out.println("Qual posição deseja mover? (Digite o índice da peça).");
            int posicaoOrigem = sc.nextInt();

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

                    cavalaria.atacarInfantaria(campo, posicaoOrigem, posicaoPecaAtaque);
                    arqueiros.atacarInfantariaCavalaria(campo,posicaoOrigem,posicaoPecaAtaque);

                } else if (peca == 2) {

                    System.out.println("Qual dano você quer utilizar? \n");
                    System.out.println("Infantaria" + infantaria.tipoDanos);
                    int tipoDano = sc.nextInt();
                    infantaria.tipoDano = tipoDano;
                    infantaria.setTipoDano(tipoDano);

                    infantaria.atacarCavalaria(campo, posicaoOrigem, posicaoPecaAtaque);
                    arqueiros.atacarInfantariaCavalaria(campo,posicaoOrigem,posicaoPecaAtaque);

                }

            } else {
                ArrayList<Posicao> listaPosicoes = campo.getPosicao();
                if (posicaoOrigem >= 0 && posicaoOrigem < listaPosicoes.size()) {
                    Posicao posicao = listaPosicoes.get(posicaoOrigem);
                    posicao.moverPeca(campo, posicao, posicaoDestino);
                } else {
                    System.out.println("A posição de origem é inválida.");
                }
            }
            if (jogadorAtual == 1) {
                jogadorAtual = 2;
                jogador.setUnidades(jogador.unidadesJogador2);
            } else if (jogadorAtual == 2) {
                jogadorAtual = 1;
                jogador.setUnidades(jogador.unidadesJogador1);
            }


        } while (true);
    }

}
