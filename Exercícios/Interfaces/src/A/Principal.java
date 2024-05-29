package A;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args){
        double media_gerentes = 0;
        double media_vendedores = 0;
        double media_assistentes = 0;
        int count_g = 0;
        int count_v = 0;
        int count_a = 0;
        Funcionario[] func = new Funcionario[5];
        func[0] = new Gerente("Dutra", "123456", 10000.0);
        func[1] = new Gerente("Paula", "828497", 50000.0);
        func[2] = new Assistente("Fuvio", "132938", 1000.0);
        func[3] = new Vendedor("Juceia", "629924", 2400.0, 600.0);
        func[4] = new Vendedor("Luli", "6187924", 2400.0, 900.0);

        for (int i = 0; i < 5; i++){
            System.out.println("Funcionario: " + func[i].getNome());
            System.out.println("Salario: " + func[i].calculaSalario() + "\n");
        }

        for (Funcionario funcionario : func) /*MESMO QUE -- (int i = 0; i < 5; i++)*/{
            if (funcionario instanceof Gerente){
                media_gerentes += funcionario.calculaSalario();
                count_g ++;
            }
            if (funcionario instanceof Vendedor){
                media_vendedores += funcionario.calculaSalario();
                count_v ++;
            }
            if (funcionario instanceof Assistente){
                media_assistentes += funcionario.calculaSalario();
                count_a ++;
            }
        }

        System.out.println("Media Gerentes: " + (media_gerentes / count_g));
        System.out.println("Media Vendedores: " + (media_vendedores / count_v));
        System.out.println("Media Asssitentes: " + (media_assistentes / count_a));
    }
}
