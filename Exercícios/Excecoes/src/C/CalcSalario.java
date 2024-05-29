package C;
import java.io.*;
import java.util.*;

public class CalcSalario {
    public static void main(String[] args) {
        // Passo 1: Ler os Dados dos Arquivos
        Map<String, Double> salariosBrutos = lerArquivo("salbruto.dat");
        Map<String, Double> descontos = lerArquivo("desc.dat");

        // Passo 2: Processar os Dados
        Map<String, Double> salariosLiquidos = new HashMap<>();

        for (String cpf : salariosBrutos.keySet()) {
            if (descontos.containsKey(cpf)) {
                double salarioBruto = salariosBrutos.get(cpf);
                double desconto = descontos.get(cpf);
                double salarioLiquido = salarioBruto - desconto;
                salariosLiquidos.put(cpf, salarioLiquido);
            }
        }
// ...
        // teste - System.out.println("Salários Brutos: " + salariosBrutos);


        // teste - System.out.println("Descontos: " + descontos);
// ...

        // Passo 3: Escrever no Arquivo de Saída
        escreverArquivo("salliq.dat", salariosLiquidos);
    }

    // Método para ler um arquivo e retornar um Map com CPF e valor
    private static Map<String, Double> lerArquivo(String nomeArquivo) {
        Map<String, Double> dados = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(" ");

                if (partes.length == 2) {
                    String cpf = partes[0];
                    double valor = Double.parseDouble(partes[1]);
                    dados.put(cpf, valor);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + nomeArquivo);
        }

        return dados;
    }

    // Método para escrever um Map em um arquivo no formato CPF valor
    private static void escreverArquivo(String nomeArquivo, Map<String, Double> dados) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Map.Entry<String, Double> entry : dados.entrySet()) {
                writer.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + nomeArquivo);
        }
    }
}