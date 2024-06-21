import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductListWindow extends JFrame {

    public ProductListWindow(List<Produto> produtoList) {
        // Configurações da janela
        setTitle("Lista de Produtos"); // Define o título da janela
        setSize(500, 300); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela atual ao sair
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Definir colunas da tabela
        String[] columnNames = {"Nome", "Descrição", "Valor", "Disponível"};

        // Criar modelo de tabela
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Adicionar dados ao modelo de tabela
        for (Produto produto : produtoList) {
            Object[] row = {
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getValor(),
                    produto.isDisponivel() ? "Sim" : "Não"
            };
            model.addRow(row); // Adiciona cada linha com dados do produto à tabela
        }

        // Criar a tabela com o modelo
        JTable table = new JTable(model); // Cria a tabela usando o modelo

        // Adicionar a tabela a um JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(table);

        // Botão para cadastrar novo produto
        JButton newProductButton = new JButton("Cadastrar novo produto");
        newProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductForm(); // Abre a tela de cadastro de produto ao clicar no botão
                dispose(); // Fecha a janela atual de listagem
            }
        });

        // Adicionar o JScrollPane e o botão ao painel principal usando BorderLayout
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER); // Adiciona a tabela no centro
        panel.add(newProductButton, BorderLayout.SOUTH); // Adiciona o botão na parte inferior

        // Adicionar o painel à janela principal
        add(panel);

        // Torna a janela visível
        setVisible(true);
    }
}
