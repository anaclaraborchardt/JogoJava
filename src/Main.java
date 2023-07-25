import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Cavalaria cavalaria = new Cavalaria();
    static Infantaria infantaria = new Infantaria();
    static Arqueiros arqueiros = new Arqueiros();
    static int jogadorAtual = 1;
    static Jogador jogador = new Jogador();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Campo campo = new Campo();

        boolean jogoAcabou;
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

            Unidade unidadeOrigem = campo.getMovimento(posicaoOrigem).getUnidade();

            if (posicaoDestino == 100) {
                System.out.println("Qual a posição da peça que deseja atacar? ");
                int posicaoPecaAtaque = sc.nextInt();

                if(unidadeOrigem instanceof Infantaria) {

                    System.out.println("Qual dano você quer utilizar? \n");
                    System.out.println("Infantaria" + infantaria.getTipoDanos());
                    int tipoDano = sc.nextInt();
                    infantaria.setTipoDano(tipoDano);

                    infantaria.atacar(campo, posicaoOrigem, posicaoPecaAtaque);

                    if (cavalaria.getChancesDefesa() > 0) {
                        cavalaria.defesa(campo, posicaoOrigem, posicaoPecaAtaque, true);
                    } else {
                        System.out.println("A Cavalaria não tem mais chances de defesa!");
                        cavalaria.defesa(campo, posicaoOrigem, posicaoPecaAtaque, false);
                    }

                }else if(unidadeOrigem instanceof Cavalaria) {

                    System.out.println("Qual dano você quer utilizar? \n");
                    System.out.println("Cavalaria" + cavalaria.getTipoDanos());
                    int tipoDano = sc.nextInt();
                    cavalaria.setTipoDano(tipoDano);

                    cavalaria.atacar(campo, posicaoOrigem, posicaoPecaAtaque);

                    if (cavalaria.getChancesDefesa() > 0) {
                        infantaria.defesa(campo, posicaoOrigem, posicaoPecaAtaque, true);
                    } else {
                        System.out.println("A Cavalaria não tem mais chances de defesa!");
                        infantaria.defesa(campo, posicaoOrigem, posicaoPecaAtaque, false);
                    }

                }else if(unidadeOrigem instanceof Arqueiros){
                    System.out.println("Você só pode usar a flecha \n");
                    int tipoDano = sc.nextInt();
                    arqueiros.setTipoDano(tipoDano);

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
            jogoAcabou = !jogador.aindaHaPecas(1) || !jogador.aindaHaPecas(2);


        } while (!jogoAcabou);
        confereVencedor(jogador);
    }
    public static void confereVencedor(Jogador jogador) {
        if (!jogador.aindaHaPecas(1) && !jogador.aindaHaPecas(2)) {
            System.out.println("Empate! Ambos os jogadores ficaram sem peças.");
        } else if (!jogador.aindaHaPecas(1)) {
            System.out.println("Jogador 2 venceu! Jogador 1 ficou sem peças.");
        } else if (!jogador.aindaHaPecas(2)) {
            System.out.println("Jogador 1 venceu! Jogador 2 ficou sem peças.");
        } else {
            System.out.println("O jogo ainda não terminou. Ambos os jogadores têm peças.");
        }
    }

}
