import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int jogadorAtual = 1;
    static Jogador jogador1 = new Jogador(1, "ana");
    static Jogador jogador2 = new Jogador(2, "clara");
    static ArrayList<Jogador> jogadores = new ArrayList<>();

    static int posicaoDestino;
    static int posicaoOrigem;
    static UnidadeMovel unidadeOrigem;
    static Unidade unidadeAtacada;
    static boolean jogoAcabou = false;
    static boolean definida = false;
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        jogadores.add(jogador1);
        jogadores.add(jogador2);

        menuInicial();
        Campo campo = new Campo();

        do {
            campo.imprimirJogo();
            escolheUnidade();
            posicaoMover(campo);
        } while (!jogoAcabou);
    }

    public static void definePosicao(Campo campo){
        int i;

        do {
            do {
                for (i = 6; i != 0; i--) {
                    System.out.println("CAVALARIA");
                    setaPosicoes(campo);
                    System.out.println("Você tem " + i + " peças para definir");
                }

            } while (i > 0);
            System.out.println("Cavalaria Definida");

            do {
                for (i = 4; i != 0; i--) {
                    System.out.println("INFANTARIA");
                    setaPosicoes(campo);
                    System.out.println("Você tem " + i + " peças para definir");
                }

            } while (i > 0);
            System.out.println("Infantaria Definida");

            do {
                for (i = 3; i != 0; i--) {
                    System.out.println("ARQUEIROS");
                    setaPosicoes(campo);
                    System.out.println("Você tem " + i + " peças para definir");
                }

            } while (i > 0);
            System.out.println("Arqueiros Definidos");
            definida = true;

        }while(!definida);
    }

    public static void setaPosicoes(Campo campo){
        ArrayList<Integer> posicoesEscolhidas = new ArrayList<>();
        System.out.println("Antes de iniciar a partida, faça as definições iniciais:");
        System.out.println("Escolha onde quer colocar suas Unidades");
        int posicaoDefinida = sc.nextInt();
        posicoesEscolhidas.add(posicaoDefinida);
        campo.setPosicaoDefinida(posicaoDefinida);
        System.out.println(campo.getPosicaoDefinida());
    }

    public static void escolheUnidade(){
        boolean continua = false;
            Jogador jogador = jogadores.get(jogadorAtual - 1);
            //1 - 6 até 24
            //2 - 60 até 78
            System.out.println("Jogador " + jogadorAtual);

            if (jogadorAtual == 1) {
                System.out.println("Você pode mover da 6 até a 24");
            } else {
                System.out.println("Você pode mover da 60 até a 78");
            }

        do {
            System.out.println(jogador.unidades);
            System.out.println("Qual posição deseja mover? (Digite o índice da peça).");
            posicaoOrigem = sc.nextInt();

            ArrayList<Integer> indicesValidos = jogador.getIndicesValidosJogador();
            if (!indicesValidos.contains(posicaoOrigem)) {
                System.out.println("Essa não é uma de suas peças");
                System.out.println("Escolha outra posição: ");
            }else {
                continua = true;
            }
        }while(!continua);

    }

    public static void posicaoMover(Campo campo) {
        Jogador jogador = jogadores.get(jogadorAtual - 1);
        System.out.println("Para qual posição você deseja ir? (Digite o índice de destino)");
        //teste
        Cavalaria cavalaria = new Cavalaria();
        System.out.println(cavalaria.getListaPosicoesDestino());
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

            if (!(unidadeAtacada instanceof Tesouro)) {
                UnidadeMovel unidadeMovel = (UnidadeMovel) unidadeAtacada;
                String retornoDefesa = unidadeMovel.defesa(campo, posicaoOrigem, posicaoPecaAtaque);

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

    public static void menuInicial(){
        Campo campo = new Campo();
        System.out.println("Escolha a opção que deseja jogar: " +
                "\n1- Definir as peças;" +
                "\n2- Utilizar campo padrão");
        int padraoJogo = sc.nextInt();

        switch(padraoJogo){

            case 1:
                definePosicao(campo);
                campo.setPadraoJogo(2);
                break;
            case 2:
                System.out.println("Campo Padrão");
                campo.setPadraoJogo(1);
        }

        nomeJogador(jogador1, jogador2);
    }

    public static void nomeJogador(Jogador jogador1, Jogador jogador2){
        String nomeJ1;
        String nomeJ2;
        System.out.println("Jogador 1: Insira seu nome: ");
        nomeJ1 = sc.next();
        jogador1 = new Jogador(1,nomeJ1);
        System.out.println("Jogador 2: Insira seu nome: ");
        nomeJ2 = sc.next();
        jogador2 = new Jogador(1,nomeJ2);

    }

}
