import java.util.ArrayList;

public class Campo {

    private ArrayList<Posicao> listaPosicoes = new ArrayList<>();
    private int posicaoDefinida;
    private int padraoJogo;

    public Campo() {
            for (int i = 0; i < 85; i++) {
                listaPosicoes.add(new Posicao());
                if ((i >= 6 && i <= 11) || (i >= 72 && i <= 77)) {
                    listaPosicoes.get(i).setUnidade(new Arqueiros());
                }
                if (i == 12 || i == 13 || i == 16 || i == 17
                        || i == 18 || i == 19 || i == 22 || i == 23
                        || i == 60 || i == 61 || i == 64 || i == 65
                        || i == 66 || i == 67 || i == 70 || i == 71) {
                    listaPosicoes.get(i).setUnidade(new Infantaria());
                }
                if (i == 14 || i == 15 || i == 20 || i == 21
                        || i == 62 || i == 63 || i == 68 || i == 69) {
                    listaPosicoes.get(i).setUnidade(new Cavalaria());
                }
                if (i == 3 || i == 4
                        || i == 81 || i == 82) {
                    listaPosicoes.get(i).setUnidade(new Tesouro());
                }
            }
        }

        public void imprimirJogo () {
            int pos = 0;
            for (int i = 0; i < 14; i++) {
                for (int j = 0; j < 6; j++) {
                    if (pos < listaPosicoes.size()) {
                        Unidade unidade = listaPosicoes.get(pos).getUnidade();
                        if (unidade != null) {
                            System.out.print(unidade.toString() + " ");
                        } else {
                            System.out.print("           "); // 11 espaços em branco
                        }
                        pos++;
                    } else {
                        System.out.print("           "); // 11 espaços em branco
                    }
                }
                System.out.println();
            }
        }

        public ArrayList<Posicao> getPosicao () {
            return listaPosicoes;
        }

        public Posicao getMovimento ( int posicaoMover){
            if (posicaoMover >= 0 && posicaoMover < listaPosicoes.size()) {
                return listaPosicoes.get(posicaoMover);
            } else {
                return null; // aqui ele retorna nulo caso não encontre a posição
            }
        }

        public int getPosicaoDefinida () {
            return posicaoDefinida;
        }

        public void setPosicaoDefinida ( int posicaoDefinida){
            this.posicaoDefinida = posicaoDefinida;
        }

        public ArrayList<Posicao> getListaPosicoes () {
            return listaPosicoes;
        }


        public void setPadraoJogo ( int padraoJogo){
            this.padraoJogo = padraoJogo;
        }

        public int getPadraoJogo() {
            return padraoJogo;
        }
}
