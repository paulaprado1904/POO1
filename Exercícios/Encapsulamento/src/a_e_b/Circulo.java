package a_e_b;
import java.util.Scanner;
import javax.lang.model.type.NullType;
import java.text.DecimalFormat;

public class Circulo {

    private String nome;
    private Ponto centro;
    private double raio;
    public void setCirculo(double r, Ponto p)
    {   if (r > 0) raio = r;
        centro = p;
    }
    public double diametro(double r){
        double diam;
        diam = 2 * r;
        return diam;
    }

    public double area (double r){
        double area;
        area = 2 * Math.PI * Math.pow(r,2);
        return area;
    }
    public double perimetro (double r){
        double perim;
        perim = 2 * Math.PI * r;
        return perim;
    }

    public void setNome(String name) {
        if (name == null) {
            System.out.println("Nome não cadastrado");
        } else {
            nome = name;
        }
    }

    public String getNome() {
        return nome;
    }

    public double getRaio() {
        return raio;
    }

    public static void main(String a[]) {
        Scanner s = new Scanner(System.in);
        Circulo c = new Circulo();
        double r;
        float x1,y1;
        System.out.println("Insira as coordenadas do centro: ");
        System.out.println("x: ");
        x1 = s.nextFloat();
        System.out.println("y:");
        y1 = s.nextFloat();
        System.out.println("Insira o raio: ");
        r = s.nextDouble();

        Ponto pontoCentro = new Ponto();
        pontoCentro.setPontos(x1,y1);
        c.setCirculo(r, pontoCentro);

        System.out.println("Dados do circulo de raio "+String.format("%.2f",c.getRaio()));
        System.out.println("Diametro      :"+String.format("%.2f",c.diametro(r)));
        System.out.println("Circunferencia:"+String.format("%.2f",c.perimetro(r)));
        System.out.println("Area          :"+String.format("%.2f",c.area(r)));

    }

}