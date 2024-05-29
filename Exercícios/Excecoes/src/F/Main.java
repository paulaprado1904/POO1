package F;

import F.Contato;
import F.GestaoContatos;
import F.ContatoNaoEncontradoException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestaoContatos gestao = new GestaoContatos();
        Scanner scanner = new Scanner(System.in);

        try {
            // Carrega os contatos do arquivo (se existir)
            carregarContatos(gestao);

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Adicionar Contato");
                System.out.println("2. Listar Contatos de Família");
                System.out.println("3. Listar Amigos");
                System.out.println("4. Listar Contatos Profissionais");
                System.out.println("5. Remover Contato");
                System.out.println("6. Contato mais Velho na Família");
                System.out.println("7. Contato mais Novo nos Amigos");
                System.out.println("8. Salvar Contatos");
                System.out.println("9. Sair");
                System.out.print("Escolha uma opção: ");

                int escolha = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner

                switch (escolha) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer do scanner
                        System.out.print("Sexo (M/F): ");
                        String sexo = scanner.nextLine();
                        System.out.print("Profissão: ");
                        String profissao = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        Contato novoContato = new Contato(nome, idade, sexo, profissao, telefone, email);

                        System.out.print("Categoria (Família/Amigos/Profissional): ");
                        String categoria = scanner.nextLine();

                        if (categoria.equalsIgnoreCase("Família")) {
                            gestao.adicionaContato(novoContato, gestao.getFamilia());
                        } else if (categoria.equalsIgnoreCase("Amigos")) {
                            gestao.adicionaContato(novoContato, gestao.getAmigos());
                        } else if (categoria.equalsIgnoreCase("Profissional")) {
                            gestao.adicionaContato(novoContato, gestao.getProfissional());
                        } else {
                            System.out.println("Categoria inválida.");
                        }
                        break;

                    case 2:
                        System.out.println("\nContatos de Família:");
                        gestao.listaContatos(gestao.getFamilia());
                        break;

                    case 3:
                        System.out.println("\nAmigos:");
                        gestao.listaContatos(gestao.getAmigos());
                        break;

                    case 4:
                        System.out.println("\nContatos Profissionais:");
                        gestao.listaContatos(gestao.getProfissional());
                        break;

                    case 5:
                        System.out.print("Nome do Contato a ser removido: ");
                        String nomeRemover = scanner.nextLine();
                        System.out.print("Categoria (Família/Amigos/Profissional): ");
                        String categoriaRemover = scanner.nextLine();

                        ArrayList<Contato> listaRemover = null;

                        if (categoriaRemover.equalsIgnoreCase("Família")) {
                            listaRemover = gestao.getFamilia();
                        } else if (categoriaRemover.equalsIgnoreCase("Amigos")) {
                            listaRemover = gestao.getAmigos();
                        } else if (categoriaRemover.equalsIgnoreCase("Profissional")) {
                            listaRemover = gestao.getProfissional();
                        } else {
                            System.out.println("Categoria inválida.");
                        }

                        if (listaRemover != null) {
                            try {
                                gestao.eliminaContato(nomeRemover, listaRemover);
                                System.out.println("Contato removido com sucesso.");
                            } catch (ContatoNaoEncontradoException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;

                    case 6:
                        Contato maisVelho = gestao.maisVelho(gestao.getFamilia());
                        System.out.println("Contato mais velho na família: " + maisVelho);
                        break;

                    case 7:
                        Contato maisNovo = gestao.maisNovo(gestao.getAmigos());
                        System.out.println("Contato mais novo nos amigos: " + maisNovo);
                        break;

                    case 8:
                        salvarContatos(gestao);
                        System.out.println("Contatos salvos com sucesso.");
                        break;

                    case 9:
                        salvarContatos(gestao);
                        System.out.println("Contatos salvos. Encerrando o programa.");
                        return;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void carregarContatos(GestaoContatos gestao) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("contatos.dat"))) {
            ArrayList<Contato> familia = (ArrayList<Contato>) ois.readObject();
            ArrayList<Contato> amigos = (ArrayList<Contato>) ois.readObject();
            ArrayList<Contato> profissional = (ArrayList<Contato>) ois.readObject();

            gestao.setFamilia(familia);
            gestao.setAmigos(amigos);
            gestao.setProfissional(profissional);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de contatos não encontrado. Será criado um novo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void salvarContatos(GestaoContatos gestao) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contatos.dat"))) {
            oos.writeObject(gestao.getFamilia());
            oos.writeObject(gestao.getAmigos());
            oos.writeObject(gestao.getProfissional());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
