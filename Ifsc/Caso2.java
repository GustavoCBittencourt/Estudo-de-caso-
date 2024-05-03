package Ifsc;

import java.util.Scanner;

class Tabuleiro {
    private char[][] grid;

    public Tabuleiro() {
        grid = new char[10][10];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = '~'; // '~'
            }
        }
    }

    public void exibirTabuleiro() {
        System.out.println("  A B C D E F G H I J");
        for (int i = 0; i < 10; i++) {
            System.out.print((i) + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class JogoBatalhaNaval {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			Tabuleiro tabuleiro = new Tabuleiro();

			while (true) {
			    System.out.println("Batalha Naval");
			    System.out.println("1. Iniciar Jogo");
			    System.out.println("2. Sair");

			    int escolha = scanner.nextInt();

			    switch (escolha) {
			        case 1:
			            tabuleiro.exibirTabuleiro();
			            break;
			        case 2:
			            System.out.println("Até logo!");
			            return;
			        default:
			            System.out.println("Escolha inválida. Por favor, escolha novamente.");
			    }
			}
		}
    }
}

