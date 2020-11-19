package br.edu.uniritter.canoas.poo.jogo.model;

import br.edu.uniritter.canoas.poo.jogo.JogoController;
import br.edu.uniritter.canoas.poo.jogo.view.CasaView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tabuleiro  {
    private Casa[] casas;
    private List<Jogador> jogadores;
    //                     10            20             30
    public Tabuleiro(int qtdCasas, int percSorte, int percAzar) {
        this.jogadores = new ArrayList<>();
        this.casas = new Casa[qtdCasas];
        int qtdSorte = qtdCasas * percSorte / 100;
        int qtdAzar = qtdCasas * percAzar / 100;
        int i = 0;
        for ( ; i < (qtdCasas - qtdSorte - qtdAzar);  i++) {
            casas[i] = new CasaNeutra();

        }
        for (int x = 0; x < qtdSorte; x++) {
            casas[i] = new CasaSorte();
            i++;
        }
        for (int x = 0; x < qtdAzar; x++) {
            casas[i] = new CasaAzar();
            i++;
        }
        embaralhaCasas();

    }
    private void embaralhaCasas() {
        Random rand = new Random();
        for (int x = 0; x <50; x++) {
            int pos1 = rand.nextInt(this.casas.length);
            int pos2 = rand.nextInt(this.casas.length);
            Casa temp = this.casas[pos1];
            this.casas[pos1] = this.casas[pos2];
            this.casas[pos2] = temp;
        }
    }
    public Casa getCasa(int pos) {
        return this.casas[pos];
    }
    public Casa getCasaOcupada(int pos) {
        Casa retorno = null;
        for(Jogador jog : jogadores) {
            if (jog.getPosicaoAtual() == pos) {
                retorno = this.casas[pos];
            }
        }
        return retorno;
    }
    public String getJogadoresCasa(int pos) {
        String retorno = "";
        for(Jogador jog : jogadores) {
            if (jog.getPosicaoAtual() == pos) {
                retorno += jog.getNome()+", ";
            }
        }
        return retorno;
    }
    public int getJogadoresPos(int pos) {
        int retorno = 0;
        for(Jogador jog : jogadores) {
            if (jog.getPosicaoAtual() == pos) {
                retorno = jog.getPosicaoAtual();
            }
        }
        return retorno;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }
    public void addJogador(Jogador jog) throws MuitosJogadoresException {
        if (this.jogadores.size() == 6) {
            throw new MuitosJogadoresException();
        } else {
            this.jogadores.add(jog);
        }
    }
    public int getQtdCasas() {
        return this.casas.length;
    }

    //Verificando a posição do jogador e comparando com o tamanho do tabuleiro.
    public boolean verificaFim(Tabuleiro tab){
        boolean retorno = false;
        for (int i = 0; i < tab.getQtdCasas(); i++) {
            if (tab.getJogadoresPos(i) > tab.getQtdCasas()){
                retorno = true;

            } else {
                retorno =  false;
            }
        }
        return retorno;
    }

    //Método retorna true ou false se a posição do jogador form maior que o tamanho do tabuleiro
    public boolean getFinal(int pos, int qtd){
        if( pos > qtd ){
            return true;
        } else {
            return false;
        }

    }
}
