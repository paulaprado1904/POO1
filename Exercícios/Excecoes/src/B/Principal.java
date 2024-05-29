package B;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instancia um HashMap indexado pelo CPF
        Map<String, EmpregadosHash> empregadosMap = new HashMap<>();

        // Pede os dados dos 5 empregados ao usuário e os armazena no HashMap
        for (int i = 0; i < 5; i++) {
            System.out.println("Informe o CPF, idade e salário do empregado " + (i + 1));
            String CPF = scanner.next();
            int idade = scanner.nextInt();
            double salario = scanner.nextDouble();

            EmpregadosHash emp = new EmpregadosHash(CPF, idade, salario);
            empregadosMap.put(CPF, emp);
        }

        // Realiza a busca de um usuário dado o seu CPF
        System.out.println("Informe um CPF para busca:");
        String CPFBusca = scanner.next();

        EmpregadosHash empBuscado = empregadosMap.get(CPFBusca);

        if (empBuscado != null) {
            System.out.println("Empregado encontrado - CPF: " + empBuscado.getCPF() +
                    ", idade: " + empBuscado.getIdade() + ", salário: " + empBuscado.getSalario());
        } else {
            System.out.println("Empregado não encontrado");
        }

        // Retorna os CPFs dos Empregados com menor e maior salários
        double menorSalario = Double.MAX_VALUE;
        double maiorSalario = Double.MIN_VALUE;

        List<String> CPFsMenorSalario = new ArrayList<>();
        List<String> CPFsMaiorSalario = new ArrayList<>();

        for (EmpregadosHash emp : empregadosMap.values()) {
            double salario = emp.getSalario();

            if (salario < menorSalario) {
                menorSalario = salario;
                CPFsMenorSalario.clear();
                CPFsMenorSalario.add(emp.getCPF());
            } else if (salario == menorSalario) {
                CPFsMenorSalario.add(emp.getCPF());
            }

            if (salario > maiorSalario) {
                maiorSalario = salario;
                CPFsMaiorSalario.clear();
                CPFsMaiorSalario.add(emp.getCPF());
            } else if (salario == maiorSalario) {
                CPFsMaiorSalario.add(emp.getCPF());
            }
        }

        System.out.println("CPF(s) do(s) empregado(s) com menor salário: " + CPFsMenorSalario);
        System.out.println("CPF(s) do(s) empregado(s) com maior salário: " + CPFsMaiorSalario);
    }
}
