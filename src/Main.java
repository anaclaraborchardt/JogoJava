import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Campo campo = new Campo();
        Posicao posicaoOrigem2 = new Posicao();

        Infantaria infantaria = new Infantaria();
        Cavalaria cavalaria = new Cavalaria();
        Arqueiros arqueiros = new Arqueiros();

        do {
            campo.imprimirJogo();

            //implementar a rodada
            System.out.println("Qual posição deseja mover? (Digite o índice da peça)");
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

                    Posicao posicaoOrigem3 = campo.getMovimento(posicaoOrigem);
                    posicaoOrigem3.atacarInfantaria(campo, posicaoOrigem, posicaoPecaAtaque);
                } else if (peca == 2) {
                    System.out.println("Qual dano você quer utilizar? \n");
                    System.out.println("Infantaria" + infantaria.tipoDanos);
                    int tipoDano = sc.nextInt();
                    infantaria.tipoDano = tipoDano;

                    //passar o dano
//                    if(tipoDano == 1){
//
//                    }else if(tipoDano ==2){
//
//                    }
                    Posicao posicaoOrigem3 = campo.getMovimento(posicaoOrigem);
                    posicaoOrigem3.atacarCavalaria(campo, posicaoOrigem, posicaoPecaAtaque);

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


        } while (true);
    }

}
