package br.edu.uniritter.canoas.poo.jogo.view;

import br.edu.uniritter.canoas.poo.jogo.model.CasaAzar;
import br.edu.uniritter.canoas.poo.jogo.model.CasaSorte;
import br.edu.uniritter.canoas.poo.jogo.model.Tabuleiro;

public class TabuleiroView {
    public static void showSituacaoAtual(Tabuleiro tab){
        for (int i = 0; i < tab.getQtdCasas(); i++) {
            //if (tab.getCasaOcupada(i) != null) {
            //    System.out.println("casa "+i+": "+tab.getCasaOcupada(i)+" ->"+tab.getJogadoresCasa(i));
            //}
            CasaView.desenhaCasa(tab.getCasa(i), tab.getJogadoresCasa(i));
        }
        System.out.println("============");
        JogoView.continuar();
    }
}
