package G;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestaoContatos gestaoContatos = new GestaoContatos();

        // Implementar um menu de opções para o usuário
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Remover Contato");
            System.out.println("3. Listar Contatos");
            System.out.println("4. Encontrar Contato Mais Velho");
            System.out.println("5. Encontrar Contato Mais Novo");
            System.out.println("6. Salvar Contatos em Arquivo");
            System.out.println("7. Carregar Contatos de Arquivo");
            System.out.println("8. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (escolha) {
                case 1:
                    // Obter informações do novo contato do usuário
                    System.out.println("Nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Idade:");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.println("Sexo:");
                    String sexo = scanner.nextLine();
                    System.out.println("Profissão:");
                    String profissao = scanner.nextLine();
                    System.out.println("Telefone:");
                    String telefone = scanner.nextLine();
                    System.out.println("Email:");
                    String email = scanner.nextLine();

                    Contato novoContato = new Contato(nome, idade, sexo, profissao, telefone, email);

                    // Perguntar em qual categoria adicionar o contato
                    System.out.println("Em qual categoria deseja adicionar o contato?");
                    System.out.println("1. Família");
                    System.out.println("2. Amigos");
                    System.out.println("3. Profissional");
                    int categoria = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    HashMap<String, Contato> mapa = null;

                    switch (categoria) {
                        case 1:
                            mapa = gestaoContatos.getFamilia();
                            break;
                        case 2:
                            mapa = gestaoContatos.getAmigos();
                            break;
                        case 3:
                            mapa = gestaoContatos.getProfissional();
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }

                    if (mapa != null) {
                        gestaoContatos.adicionaContato(novoContato, mapa);
                        System.out.println("Contato adicionado com sucesso.");
                    }

                    break;

                case 2:
                    // Remover contato
                    System.out.println("Digite o nome do contato que deseja remover:");
                    String nomeRemover = scanner.nextLine();
                    System.out.println("Em qual categoria deseja remover o contato?");
                    System.out.println("1. Família");
                    System.out.println("2. Amigos");
                    System.out.println("3. Profissional");
                    int categoriaRemover = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    HashMap<String, Contato> mapaRemover = null;

                    switch (categoriaRemover) {
                        case 1:
                            mapaRemover = gestaoContatos.getFamilia();
                            break;
                        case 2:
                            mapaRemover = gestaoContatos.getAmigos();
                            break;
                        case 3:
                            mapaRemover = gestaoContatos.getProfissional();
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }

                    if (mapaRemover != null) {
                        try {
                            gestaoContatos.eliminaContato(nomeRemover, mapaRemover);
                            System.out.println("Contato removido com sucesso.");
                        } catch (ContatoNaoEncontradoException e) {
                            System.out.println("Contato não encontrado.");
                        }
                    }

                    break;

                case 3:
                    // Listar contatos
                    System.out.println("Em qual categoria deseja listar os contatos?");
                    System.out.println("1. Família");
                    System.out.println("2. Amigos");
                    System.out.println("3. Profissional");
                    int categoriaListar = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    HashMap<String, Contato> mapaListar = null;

                    switch (categoriaListar) {
                        case 1:
                            mapaListar = gestaoContatos.getFamilia();
                            break;
                        case 2:
                            mapaListar = gestaoContatos.getAmigos();
                            break;
                        case 3:
                            mapaListar = gestaoContatos.getProfissional();
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }

                    if (mapaListar != null) {
                        gestaoContatos.listaContatos(mapaListar);
                    }

                    break;

                case 4:
                    // Encontrar contato mais velho
                    System.out.println("Em qual categoria deseja encontrar o contato mais velho?");
                    System.out.println("1. Família");
                    System.out.println("2. Amigos");
                    System.out.println("3. Profissional");
                    int categoriaMaisVelho = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    HashMap<String, Contato> mapaMaisVelho = null;

                    switch (categoriaMaisVelho) {
                        case 1:
                            mapaMaisVelho = gestaoContatos.getFamilia();
                            break;
                        case 2:
                            mapaMaisVelho = gestaoContatos.getAmigos();
                            break;
                        case 3:
                            mapaMaisVelho = gestaoContatos.getProfissional();
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }

                    if (mapaMaisVelho != null) {
                        Contato maisVelho = gestaoContatos.maisVelho(mapaMaisVelho);
                        if (maisVelho != null) {
                            System.out.println("Contato mais velho: " + maisVelho);
                        } else {
                            System.out.println("Nenhum contato encontrado.");
                        }
                    }

                    break;

                case 5:
                    // Encontrar contato mais novo
                    System.out.println("Em qual categoria deseja encontrar o contato mais novo?");
                    System.out.println("1. Família");
                    System.out.println("2. Amigos");
                    System.out.println("3. Profissional");
                    int categoriaMaisNovo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    HashMap<String, Contato> mapaMaisNovo = null;

                    switch (categoriaMaisNovo) {
                        case 1:
                            mapaMaisNovo = gestaoContatos.getFamilia();
                            break;
                        case 2:
                            mapaMaisNovo = gestaoContatos.getAmigos();
                            break;
                        case 3:
                            mapaMaisNovo = gestaoContatos.getProfissional();
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }

                    if (mapaMaisNovo != null) {
                        Contato maisNovo = gestaoContatos.maisNovo(mapaMaisNovo);
                        if (maisNovo != null) {
                            System.out.println("Contato mais novo: " + maisNovo);
                        } else {
                            System.out.println("Nenhum contato encontrado.");
                        }
                    }

                    break;

                case 6:
                    // Salvar contatos em arquivo
                    System.out.println("Digite o caminho do arquivo para salvar os contatos (ex: contatos.txt):");
                    String caminhoSalvar = scanner.nextLine();

                    try {
                        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(caminhoSalvar));
                        outputStream.writeObject(gestaoContatos);
                        outputStream.close();
                        System.out.println("Contatos salvos com sucesso.");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar contatos: " + e.getMessage());
                    }

                    break;

                case 7:
                    // Carregar contatos de arquivo
                    System.out.println("Digite o caminho do arquivo para carregar os contatos (ex: contatos.txt):");
                    String caminhoCarregar = scanner.nextLine();

                    try {
                        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(caminhoCarregar));
                        gestaoContatos = (GestaoContatos) inputStream.readObject();
                        inputStream.close();
                        System.out.println("Contatos carregados com sucesso.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao carregar contatos: " + e.getMessage());
                    }

                    break;

                case 8:
                    // Sair do programa
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
