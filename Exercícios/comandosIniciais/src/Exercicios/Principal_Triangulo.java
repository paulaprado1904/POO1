package Exercicios;
import java.util.Scanner;
public class Principal_Triangulo {

    public static void main(String a[]) {
        Scanner s = new Scanner(System.in);
        Triangulo[] ts = new Triangulo[10];
        int opcao = 0;
        int triangs = 0;
        do {
            System.out.println("1) Inserir triangulo;");
            System.out.println("2) Mostrar triangulos cadastrados;");
            System.out.println("3) Mostrar o numero de triangulos equilateros;");
            System.out.println("4) Mostrar o triangulo cadastrado com o maior perimetro.");
            System.out.print("OPCAO: ");
            opcao = s.nextInt();
            int a1,b1,c1;
            switch (opcao) {
                case 1:
                    ts[triangs] = new Triangulo();
                    System.out.print("Primeiro lado: ");
                    a1 = s.nextInt();
                    System.out.print("Segundo lado: ");
                    b1 = s.nextInt();
                    System.out.print("Terceiro lado: ");
                    c1 = s.nextInt();
                    ts[triangs].cadastraTriangulo(a1,b1,c1,triangs+1);
                    System.out.println("Triangulo cadastrado.");
                    triangs++;
                    break;
                case 2:
                    for (int i=0;i<triangs;i++)
                        System.out.println(ts[i]);
                    break;
                case 3:
                    int nte = 0;
                    for (int i=0;i<triangs;i++)
                        if (ts[i].retornaTipo().equals("equilatero"))
                            nte++;
                    System.out.println("Numero de triangulos equilateros: "+nte+".");
                    break;
                case 4:
                    if (triangs > 0) {
                        Triangulo maior = ts[0];
                        for (int i=1;i<triangs;i++)
                            if (ts[i].calculaPerimetro() > maior.calculaPerimetro())
                                maior = ts[i];
                        System.out.println("Triangulo com maior perimetro: "+maior+".");
                    }else
                        System.out.println("Sem triangulos cadastrados.");
                    break;
            }
        }while (opcao != 5);
    }
}
