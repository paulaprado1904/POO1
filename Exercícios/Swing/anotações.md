Claro! Abaixo você encontrará um guia simples para referência rápida ao usar a interface Swing em Java para criar componentes como botões, text fields, labels, tabelas, etc. Vamos organizar isso de maneira estruturada para facilitar a consulta:

---

### Guia de Referência Rápida para Interface Swing em Java

#### 1. **Configuração Básica da Janela Principal**

Para criar uma janela principal (`JFrame`):

```java
JFrame frame = new JFrame("Título da Janela");
frame.setSize(600, 400); // Define o tamanho da janela
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar
frame.setLocationRelativeTo(null); // Centraliza a janela na tela
```

#### 2. **Painéis e Layouts**

Usamos `JPanel` para organizar componentes dentro da janela, e `LayoutManager` para definir como os componentes são posicionados:

```java
JPanel panel = new JPanel();
panel.setLayout(new BorderLayout()); // Exemplo de BorderLayout, pode ser GridLayout, GridBagLayout, etc.
```

#### 3. **Componentes Básicos**

##### 3.1. **Label (Rótulo)**

```java
JLabel label = new JLabel("Texto do Rótulo");
panel.add(label, BorderLayout.NORTH); // Adiciona o rótulo ao painel, BorderLayout.NORTH é um exemplo
```

##### 3.2. **TextField (Campo de Texto)**

```java
JTextField textField = new JTextField(20); // 20 é o número de colunas visíveis
panel.add(textField, BorderLayout.CENTER); // Adiciona o campo de texto ao painel
```

##### 3.3. **Button (Botão)**

```java
JButton button = new JButton("Texto do Botão");
panel.add(button, BorderLayout.SOUTH); // Adiciona o botão ao painel, BorderLayout.SOUTH é um exemplo
```

##### 3.4. **CheckBox (Caixa de Seleção)**

```java
JCheckBox checkBox = new JCheckBox("Texto da Caixa de Seleção");
panel.add(checkBox, BorderLayout.WEST); // Adiciona a caixa de seleção ao painel, BorderLayout.WEST é um exemplo
```

#### 4. **Eventos**

##### 4.1. **ActionListener para Botão**

```java
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Lógica a ser executada quando o botão for clicado
    }
});
```

#### 5. **Tabelas**

##### 5.1. **Definição de Colunas e Modelo**

```java
String[] columnNames = {"Coluna 1", "Coluna 2", "Coluna 3"};
Object[][] data = {
    {"Dado 1", "Dado 2", "Dado 3"},
    {"Dado 4", "Dado 5", "Dado 6"}
};
DefaultTableModel model = new DefaultTableModel(data, columnNames);
```

##### 5.2. **Criar Tabela e Adicionar a JScrollPane**

```java
JTable table = new JTable(model);
JScrollPane scrollPane = new JScrollPane(table);
panel.add(scrollPane, BorderLayout.CENTER); // Adiciona a tabela com rolagem ao painel
```

#### 6. **JOptionPane (Caixa de Diálogo)**

##### 6.1. **Mensagem de Informação**

```java
JOptionPane.showMessageDialog(frame, "Mensagem de Informação");
```

##### 6.2. **Mensagem de Confirmação**

```java
int option = JOptionPane.showConfirmDialog(frame, "Confirma esta ação?", "Confirmação", JOptionPane.YES_NO_OPTION);
if (option == JOptionPane.YES_OPTION) {
    // Ação se o usuário confirmar
} else {
    // Ação se o usuário cancelar
}
```

#### 7. **Exibição da Janela Principal**

```java
frame.add(panel); // Adiciona o painel à janela principal
frame.setVisible(true); // Torna a janela visível
```

---

Este guia oferece uma visão geral dos passos básicos e exemplos de código para criar e gerenciar interfaces gráficas usando Swing em Java. Utilize-o como referência rápida ao desenvolver aplicações com interface gráfica.
