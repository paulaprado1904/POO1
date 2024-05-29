package E;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] vetor = new int[10];
        int posicao;
        int valor;

        while (true) {
            try {
                System.out.print("Informe a posição (-1 para sair): ");
                posicao = scanner.nextInt();

                if (posicao == -1) {
                    break;
                }

                if (posicao < 0 || posicao >= 10) {
                    throw new ArrayIndexOutOfBoundsException("Posição inválida.");
                }

                System.out.print("Informe o valor: ");
                valor = scanner.nextInt();

                vetor[posicao] = valor;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Informe um valor numérico.");
                scanner.next(); // Limpar o buffer do scanner
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Valores no vetor:");

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Posição " + i + ": " + vetor[i]);
        }
    }
}
