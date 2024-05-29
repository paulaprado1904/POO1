package A;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TelaDados extends JFrame {
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField dataNascimentoField;
    private JRadioButton masculinoRadioButton;
    private JRadioButton femininoRadioButton;
    private JTextField numeroContaField;
    private JPasswordField senhaField;
    private JTextField emailField;
    private JCheckBox receberNoticiasCheckbox;
    private JButton button1;

    public TelaDados() {

        setSize(400, 300);
        setTitle("Cadastro de Usuário");

        // Criação dos campos de informação
        nomeField = new JTextField(20);
        cpfField = new JTextField(20);
        dataNascimentoField = new JTextField(10);
        masculinoRadioButton = new JRadioButton("Masculino");
        femininoRadioButton = new JRadioButton("Feminino");
        numeroContaField = new JTextField(15);
        senhaField = new JPasswordField(15);
        emailField = new JTextField(20);
        receberNoticiasCheckbox = new JCheckBox("Deseja receber notícias?");

        // Agrupando os radio buttons em um grupo para garantir que apenas um pode ser selecionado
        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(masculinoRadioButton);
        grupoSexo.add(femininoRadioButton);

        // Botões de salvar e cancelar
        JButton salvarButton = new JButton("Salvar");
        JButton cancelarButton = new JButton("Cancelar");

        // Adicionando os campos e botões ao painel
        JPanel panel = new JPanel(new GridLayout(9, 2));
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("CPF:"));
        panel.add(cpfField);
        panel.add(new JLabel("Data de Nascimento:"));
        panel.add(dataNascimentoField);
        panel.add(new JLabel("Sexo:"));
        panel.add(masculinoRadioButton);
        panel.add(new JLabel(""));
        panel.add(femininoRadioButton);
        panel.add(new JLabel("Número da Conta:"));
        panel.add(numeroContaField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(receberNoticiasCheckbox);
        panel.add(new JLabel(""));
        panel.add(salvarButton);
        panel.add(cancelarButton);

        // Adicionando o painel à janela
        add(panel);

        // ActionListener para o botão "Salvar"
        salvarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarDados();
            }
        });

        // ActionListener para o botão "Cancelar"
        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela sem salvar os dados
            }
        });
    }

    private void salvarDados() {
        try {
            FileWriter writer = new FileWriter("dados.txt", true);
            PrintWriter printWriter = new PrintWriter(writer);

            // Verificando se todos os campos foram preenchidos
            if (nomeField.getText().isEmpty() || cpfField.getText().isEmpty() ||
                    dataNascimentoField.getText().isEmpty() ||
                    (!masculinoRadioButton.isSelected() && !femininoRadioButton.isSelected()) ||
                    numeroContaField.getText().isEmpty() || senhaField.getPassword().length == 0 ||
                    emailField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificando se CPF e Número da Conta são numéricos
            try {
                Long.parseLong(cpfField.getText());
                Long.parseLong(numeroContaField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "CPF e Número da Conta devem ser numéricos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Escrevendo os dados no arquivo
            printWriter.println(nomeField.getText() + ";" + cpfField.getText() + ";" + dataNascimentoField.getText() + ";" +
                    (masculinoRadioButton.isSelected() ? "Masculino" : "Feminino") + ";" +
                    numeroContaField.getText() + ";" + new String(senhaField.getPassword()) + ";" +
                    emailField.getText() + ";" + (receberNoticiasCheckbox.isSelected() ? "Sim" : "Não"));

            printWriter.close();
            JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaDados().setVisible(true);
            }
        });
    }


    public JTextField getNomeField() {
        return nomeField;
    }

    public JTextField getCpfField() {
        return cpfField;
    }

    public JTextField getDataNascimentoField() {
        return dataNascimentoField;
    }

    public JRadioButton getMasculinoRadioButton() {
        return masculinoRadioButton;
    }

    public JRadioButton getFemininoRadioButton() {
        return femininoRadioButton;
    }

    public JTextField getNumeroContaField() {
        return numeroContaField;
    }

    public JPasswordField getSenhaField() {
        return senhaField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JCheckBox getReceberNoticiasCheckbox() {
        return receberNoticiasCheckbox;
    }

}
