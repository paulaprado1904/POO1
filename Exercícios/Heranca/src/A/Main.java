package A;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Vendedores[] vendedores = new Vendedores[5];
        Administrativos[] administrativos = new Administrativos[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Cadastro de Vendedor " + (i+1));
            System.out.print("Nome: ");
            String nome = s.nextLine();
            System.out.print("RG: ");
            String rg = s.nextLine();
            System.out.print("Salário Base: ");
            float salarioBase = Float.parseFloat(s.nextLine());
            System.out.print("Total de Vendas: ");
            float totalVendas = Float.parseFloat(s.nextLine());
            System.out.print("Ano de Entrada: ");
            String entradaData = s.nextLine(); // Obtém a entrada como uma string
            LocalDate dataEntrada = LocalDate.parse(entradaData);

            vendedores[i] = new Vendedores(nome, rg, salarioBase, dataEntrada, totalVendas);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Cadastro de Administrativo " + (i+1));
            System.out.print("Nome: ");
            String nome = s.nextLine();
            System.out.print("RG: ");
            String rg = s.nextLine();
            System.out.print("Salário Base: ");
            float salarioBase = Float.parseFloat(s.nextLine());
            System.out.print("Horas Extras: ");
            float horasExtras = Float.parseFloat(s.nextLine());
            System.out.print("Ano de Entrada: ");
            String entradaData = s.nextLine(); // Obtém a entrada como uma string
            LocalDate dataEntrada = LocalDate.parse(entradaData);

            administrativos[i] = new Administrativos(nome, rg, salarioBase, dataEntrada, horasExtras);
        }

        // Testando os métodos
        for (Vendedores vendedor : vendedores) {
            System.out.println("\nDados do Vendedor:");
            System.out.println("Nome: " + vendedor.getNome());
            System.out.println("RG: " + vendedor.getRg());
            System.out.println("Salário Base: " + vendedor.getSalariobase());
            System.out.println("Total de Vendas: " + vendedor.getTotalVendas());
            System.out.println("Salário Final: " + vendedor.getSalariofinal());
            System.out.println("Anos na Empresa: " + vendedor.anosNaEmpresa());
        }

        for (Administrativos administrativo : administrativos) {
            System.out.println("\nDados do Administrativo:");
            System.out.println("Nome: " + administrativo.getNome());
            System.out.println("RG: " + administrativo.getRg());
            System.out.println("Salário Base: " + administrativo.getSalariobase());
            System.out.println("Horas Extras: " + administrativo.getHorasExtras());
            System.out.println("Salário Final: " + administrativo.getSalarioFinal());
            System.out.println("Anos na Empresa: " + administrativo.anosNaEmpresa());
        }
    }
}
