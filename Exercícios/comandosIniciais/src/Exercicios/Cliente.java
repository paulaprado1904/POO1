package Exercicios;
import java.util.Scanner;
    public class Cliente {
        private String nome;
        private String cpf;
        private int idade;
        private String telefone;

        public void cadastrarCliente(String nome, String cpf, int idade, String telefone) {
            this.nome = nome;
            this.cpf = cpf;
            this.idade = idade;
            this.telefone = telefone;
        }

        public void mostrarDadosCliente() {
            System.out.println("Nome: " + nome);
            System.out.println("CPF: " + cpf);
            System.out.println("Idade: " + idade);
            System.out.println("Telefone: " + telefone);
        }

}
