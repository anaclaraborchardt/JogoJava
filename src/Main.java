import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Campo campo = new Campo();
        Jogador jogador = new Jogador();
        int jogadorAtual = 1;
        Cavalaria cavalaria = new Cavalaria();
        Infantaria infantaria = new Infantaria();
        Arqueiros arqueiros = new Arqueiros();

        do {
            System.out.println("Jogador " + jogadorAtual);
            System.out.println(jogadorAtual == 1 ? jogador.unidadesJogador1 : jogador.unidadesJogador2);
            campo.imprimirJogo();

            boolean escolhaValida = false;
            int posicaoOrigem;

            do {
                System.out.println("Qual posição deseja mover? (Digite o índice da peça).");
                posicaoOrigem = sc.nextInt();

                ArrayList<Integer> validIndices = jogador.pegaIndice(jogadorAtual);
                if (!validIndices.contains(posicaoOrigem)) {
                    System.out.println("Essa não é uma de suas peças");
                    System.out.println("Escolha outra posição: ");
                } else {
                    escolhaValida = true;
                }
            } while (!escolhaValida);

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
                            jogador.atualizaIndices(jogadorAtual, posicaoOrigem, posicaoDestino);
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
    public static void confereVencedor(Jogador jogador1, Jogador jogador2) {
        if (!jogador1.aindaHaPecas(1) && !jogador2.aindaHaPecas(2)) {
            System.out.println("Empate! Ambos os jogadores ficaram sem peças.");
        } else if (!jogador1.aindaHaPecas(1)) {
            System.out.println("Jogador 2 venceu! Jogador 1 ficou sem peças.");
        } else if (!jogador2.aindaHaPecas(2)) {
            System.out.println("Jogador 1 venceu! Jogador 2 ficou sem peças.");
        } else {
            System.out.println("O jogo ainda não terminou. Ambos os jogadores têm peças.");
        }
    }

}
