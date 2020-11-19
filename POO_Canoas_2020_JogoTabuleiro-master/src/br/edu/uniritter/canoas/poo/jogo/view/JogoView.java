package br.edu.uniritter.canoas.poo.jogo.view;

import br.edu.uniritter.canoas.poo.jogo.model.Jogador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogoView {

    public static int intQtdJogadores(int min, int max) {
        System.out.println("quantos jogadores teremos ?");
        int qtd = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                qtd = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("valor inválido.");
                //scanner.close();
            }
        } while (qtd < min || qtd> max);
        return qtd;
    }
    public static String InformeJogador(int idx) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do Jogador "+idx+":");
        String nome  = scanner.nextLine();
        return nome;


    }
    public static void mostraJogadorAtual(Jogador jog) {
        System.out.println("Agora é a vez de "+jog.getNome());
    }

    public static void mostraJogadorAnterior(Jogador jog) {
        System.out.println(""+jog.getNome());
    }

    public static void continuar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pressione enter para continuar");
        String nome  = scanner.nextLine();
    }

    //Método para recomeçar a partida
    public static void recomecar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pressione enter para recomeçar o jogo");
        String nome  = scanner.nextLine();
    }
    //Método que mostra o granhador da partida
    public static void mostraGanhador(Jogador jog) {

        System.out.println("|-------------------------|");
        System.out.println("|-----  FIM DE JOGO ------|");
        System.out.println("|O ganhador é: "+jog.getNome());
        System.out.println("|-------------------------|");
    }

}
