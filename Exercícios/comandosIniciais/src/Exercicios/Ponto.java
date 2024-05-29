package Exercicios;
import java.util.Scanner;
public class Ponto {
    private float x, y;

    public void cadastraPonto(float x1, float y1) {
        x = x1;
        y = y1;
    }

    public double distEntrePontos(float x1, float y1, float x2, float y2) {
        double dist = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2-y1), 2));
        return dist;
    }


}
