package Exercicios;

import java.util.Scanner;
public class Soma {
    public static void main(String a[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Primeiro numero:");
        int num1 = s.nextInt();
        System.out.println("Segundo numero:");
        int num2 = s.nextInt();
        int soma = num1 + num2;
        System.out.println(soma);
    }

}
