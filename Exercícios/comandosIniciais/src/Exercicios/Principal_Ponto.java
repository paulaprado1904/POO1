package Exercicios;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Principal_Ponto {

    public static void main(String a[]) {
        Scanner s = new Scanner(System.in);
        Ponto p = new Ponto();
        int id = 0;
        float x1,x2,y1,y2;
        System.out.println("Ponto 1");
        System.out.println("x: ");
        x1 = s.nextFloat();
        System.out.println("y:");
        y1 = s.nextFloat();
        p.cadastraPonto(x1,y1);
        System.out.println("Ponto 2");
        System.out.println("x: ");
        x2 = s.nextFloat();
        System.out.println("y:");
        y2 = s.nextFloat();
        p.cadastraPonto(x2,y2);

        System.out.println("Distância entre os pontos: " + String.format("%.3f", p.distEntrePontos(x1, y1, x2, y2)));

    }
}
