package A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class Principal {
    public static void main(String[] args) {

        List<Empregado> listaEmpregados = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        String cpf;
        int idade;
        double salario;

        // Código para carregar os empregados do arquivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empregados.dat"))) {
            listaEmpregados = (List<Empregado>) ois.readObject();
            System.out.println("Empregados carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Não foi possível carregar os empregados. Iniciando com lista vazia.");
            listaEmpregados = new ArrayList<>();
        }


        for (int i = 0; i < 3; i++){
            System.out.println("Digite o CPF do empregado: ");
            cpf = s.nextLine();

            System.out.println("Digite a idade do empregado: ");
            idade = s.nextInt();

            System.out.println("Digite o salario do empregado: ");
            salario = s.nextDouble();

            s.nextLine();       //limpeza do buffer

            Empregado emp = new Empregado(cpf, idade, salario);
            listaEmpregados.add(emp);
        }

        System.out.println("CPF para busca: ");
        String cpfBusca = s.nextLine();

        Empregado empEncontrado = null;

        for (Empregado x : listaEmpregados){
            if (x.getCPF().equals(cpfBusca)){
                empEncontrado = x;
                break;
            }
        }

        if(empEncontrado != null){
            System.out.println("Empregado Encontrado:");
            empEncontrado.retornaDados();
        }

        double salarioEncontrado = 0;
        double sal;
        System.out.println("Busca de salario, valor:");
        sal = s.nextDouble();

        System.out.println("Empregados encontrados para este salario: ");
        for (Empregado x : listaEmpregados){
            if (x.getSalario() - sal < 0.0000001){
                System.out.println(x.getCPF());
                salarioEncontrado = x.getSalario();
            }
        }
        if(salarioEncontrado == 0){
            System.out.println("Não foram encontrados empregados com o salario correspondente");
        }

        Collections.sort(listaEmpregados);

        System.out.println("Em ordem etária:");
        for(Empregado x : listaEmpregados){
            x.retornaDados();
            System.out.println("-------------");
        }

        // Código para salvar os empregados em um arquivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empregados.dat"))) {
            oos.writeObject(listaEmpregados);
            System.out.println("Empregados salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

