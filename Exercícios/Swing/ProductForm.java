import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProductForm extends JFrame {

    private List<Produto> produtoList; // Lista para armazenar produtos
    private JTextField nameField; // Campo de texto para o nome do produto
    private JTextArea descriptionArea; // Área de texto para a descrição do produto
    private JTextField valueField; // Campo de texto para o valor do produto
    private JCheckBox availableCheckBox; // CheckBox para indicar disponibilidade do produto

    public ProductForm() {
        // Inicializa a lista de produtos
        produtoList = new ArrayList<>();

        // Configurações da janela principal
        setTitle("Cadastro de Produto"); // Define o título da janela
        setSize(500, 400); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar a janela
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Painel principal usando GridBagLayout para organizar componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Define margens entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL; // Define como os componentes se expandem

        // Nome do Produto
        JLabel nameLabel = new JLabel("Nome do Produto:");
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 0; // Linha 0
        panel.add(nameLabel, gbc); // Adiciona o rótulo ao painel

        nameField = new JTextField(20); // Campo de texto para o nome do produto
        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 0; // Linha 0
        panel.add(nameField, gbc); // Adiciona o campo de texto ao painel

        // Descrição
        JLabel descriptionLabel = new JLabel("Descrição:");
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 1; // Linha 1
        panel.add(descriptionLabel, gbc); // Adiciona o rótulo ao painel

        descriptionArea = new JTextArea(5, 20); // Área de texto para a descrição do produto
        descriptionArea.setLineWrap(true); // Habilita quebra de linha automática
        descriptionArea.setWrapStyleWord(true); // Quebra de palavras
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea); // Adiciona barra de rolagem
        descriptionScrollPane.setPreferredSize(new Dimension(250, 80)); // Define tamanho preferido
        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 1; // Linha 1
        gbc.gridwidth = 2; // Ocupa 2 colunas
        gbc.fill = GridBagConstraints.BOTH; // Preenche horizontal e verticalmente
        panel.add(descriptionScrollPane, gbc); // Adiciona a área de texto ao painel

        // Valor
        gbc.gridwidth = 1; // Restaura o número padrão de colunas ocupadas
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenche horizontalmente
        JLabel valueLabel = new JLabel("Valor:");
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 2; // Linha 2
        panel.add(valueLabel, gbc); // Adiciona o rótulo ao painel

        valueField = new JTextField(10); // Campo de texto para o valor do produto
        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 2; // Linha 2
        panel.add(valueField, gbc); // Adiciona o campo de texto ao painel

        // Disponível
        JLabel availableLabel = new JLabel("Disponível:");
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 3; // Linha 3
        panel.add(availableLabel, gbc); // Adiciona o rótulo ao painel

        availableCheckBox = new JCheckBox(); // CheckBox para indicar disponibilidade
        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 3; // Linha 3
        panel.add(availableCheckBox, gbc); // Adiciona a checkBox ao painel

        // Botão de Salvar
        JButton saveButton = new JButton("Salvar");
        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 4; // Linha 4
        panel.add(saveButton, gbc); // Adiciona o botão ao painel

        // Botão de Listagem
        JButton listButton = new JButton("Listar Produtos");
        gbc.gridx = 2; // Coluna 2
        gbc.gridy = 4; // Linha 4
        panel.add(listButton, gbc); // Adiciona o botão ao painel

        // Adiciona ação ao botão de salvar
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarProduto(); // Chama o método para salvar o produto
            }
        });

        // Adiciona ação ao botão de listagem
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaDeListagem(); // Chama o método para abrir a janela de listagem
            }
        });

        // Adiciona o painel à janela principal
        add(panel);

        // Torna a janela visível
        setVisible(true);
    }

    private void salvarProduto() {
        String nome = nameField.getText(); // Obtém o nome do campo de texto
        String descricao = descriptionArea.getText(); // Obtém a descrição da área de texto
        double valor;
        try {
            valor = Double.parseDouble(valueField.getText()); // Obtém e converte o valor para double
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE); // Exibe mensagem de erro se o valor não puder ser convertido
            return;
        }
        boolean disponivel = availableCheckBox.isSelected(); // Verifica se o produto está disponível

        Produto produto = new Produto(nome, descricao, valor, disponivel); // Cria um novo objeto Produto
        produtoList.add(produto); // Adiciona o produto à lista

        // Limpa os campos após salvar
        nameField.setText(""); // Limpa o campo de nome
        descriptionArea.setText(""); // Limpa a área de descrição
        valueField.setText(""); // Limpa o campo de valor
        availableCheckBox.setSelected(false); // Reseta o checkBox de disponibilidade

        // Exibe uma mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");

        // Abre a janela de listagem de produtos
        abrirJanelaDeListagem();
    }

    private void abrirJanelaDeListagem() {
        new ProductListWindow(produtoList); // Cria uma nova janela de listagem de produtos
    }

    public static void main(String[] args) {
        // Executa a aplicação na thread de despacho de eventos para garantir a segurança de threads
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProductForm(); // Cria uma nova instância de ProductForm (janela principal)
            }
        });
    }
}
