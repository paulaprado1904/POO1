package Exercicios;

public class Triangulo {

    private int l1, l2, l3, classif;

    public void cadastraTriangulo(int l1a, int l2a, int l3a, int i) {
        l1 = l1a > 0 ? l1a : 1;
        l2 = l2a > 0 ? l2a : 1;
        l3 = l3a > 0 ? l3a : 1;
        classif = i;
    }

    int calculaPerimetro() {
        return l1+l2+l3;
    }

    String retornaTipo() {
        if ((l1 == l2)&&(l2 == l3)) return "equilatero";
        else if ((l1 == l2)||(l2 == l3)||(l1 == l3)) return "isosceles";
        else return "escaleno";
    }

    public String toString() {
        return "Dados triangulo "+classif+" -> Lado 1: "+l1+", Lado 2: "+l2+", Lado 3: "+l3+".";
    }

}

