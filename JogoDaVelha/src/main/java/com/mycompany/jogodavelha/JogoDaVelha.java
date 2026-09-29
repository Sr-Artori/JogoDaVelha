

package com.mycompany.jogodavelha;

import java.util.Random;
import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        Random random = new Random();

        char[][] tabuleiro = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };

        int jogadas = 0;
        boolean jogoAcabou = false;

        while (!jogoAcabou) {

            System.out.println("\nJOGO DA VELHA");
            System.out.println("-------------");
            for (int i = 0; i < 3; i++) {
                System.out.println(" " + tabuleiro[i][0] + " | "
                        + tabuleiro[i][1] + " | "
                        + tabuleiro[i][2]);

                if (i < 2) {
                    System.out.println("---+---+---");
                }
            }

            int casa;

            while (true) {
                System.out.print("\nEscolha uma casa (1-9): ");
                casa = ler.nextInt();

                if (casa < 1 || casa > 9) {
                    System.out.println("Escolha uma casa entre 1 e 9!");
                    continue;
                }

                int linha = (casa - 1) / 3;
                int coluna = (casa - 1) % 3;

                if (tabuleiro[linha][coluna] == 'X'
                        || tabuleiro[linha][coluna] == 'O') {
                    System.out.println("Essa casa já está ocupada!");
                } else {
                    tabuleiro[linha][coluna] = 'X';
                    break;
                }
            }

            jogadas++;

            if (venceu(tabuleiro, 'X')) {
                mostrarTabuleiro(tabuleiro);
                System.out.println("\nVocê ganhou!");
                jogoAcabou = true;
                break;
            }

            if (jogadas == 9) {
                mostrarTabuleiro(tabuleiro);
                System.out.println("\nEmpate!");
                jogoAcabou = true;
                break;
            }

            int casaMaquina;

            while (true) {
                casaMaquina = random.nextInt(9) + 1;

                int linha = (casaMaquina - 1) / 3;
                int coluna = (casaMaquina - 1) % 3;

                if (tabuleiro[linha][coluna] != 'X'
                        && tabuleiro[linha][coluna] != 'O') {

                    tabuleiro[linha][coluna] = 'O';
                    break;
                }
            }

            System.out.println("\nA máquina escolheu a casa " + casaMaquina + ".");

            jogadas++;

            if (venceu(tabuleiro, 'O')) {
                mostrarTabuleiro(tabuleiro);
                System.out.println("\nA máquina ganhou!");
                jogoAcabou = true;
            }
        }

        ler.close();
    }

    public static boolean venceu(char[][] tabuleiro, char jogador) {

        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador
                    && tabuleiro[i][1] == jogador
                    && tabuleiro[i][2] == jogador) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == jogador
                    && tabuleiro[1][i] == jogador
                    && tabuleiro[2][i] == jogador) {
                return true;
            }
        }

        if (tabuleiro[0][0] == jogador
                && tabuleiro[1][1] == jogador
                && tabuleiro[2][2] == jogador) {
            return true;
        }

        if (tabuleiro[0][2] == jogador
                && tabuleiro[1][1] == jogador
                && tabuleiro[2][0] == jogador) {
            return true;
        }

        return false;
    }

    public static void mostrarTabuleiro(char[][] tabuleiro) {

        System.out.println("\n-------------");

        for (int i = 0; i < 3; i++) {
            System.out.println(" " + tabuleiro[i][0] + " | "
                    + tabuleiro[i][1] + " | "
                    + tabuleiro[i][2]);

            if (i < 2) {
                System.out.println("---+---+---");
            }
        }

        System.out.println("-------------");
    }
}