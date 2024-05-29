package B;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculadora extends JFrame {
    private List<Integer> numeros = new ArrayList<>();
    private JTextField valoresTextField, menorTextField, maiorTextField, mediaTextField;
    private JButton cadastrarButton, exibirButton, calcularButton;
    private JComboBox<String> operacaoComboBox;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel valoresLabel = new JLabel("Valores:");
        valoresLabel.setBounds(10, 10, 100, 20);
        add(valoresLabel);

        valoresTextField = new JTextField();
        valoresTextField.setBounds(120, 10, 200, 20);
        add(valoresTextField);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(330, 10, 100, 20);
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarValores();
            }
        });
        add(cadastrarButton);

        JLabel menorLabel = new JLabel("Menor:");
        menorLabel.setBounds(10, 40, 100, 20);
        add(menorLabel);

        menorTextField = new JTextField();
        menorTextField.setBounds(120, 40, 200, 20);
        menorTextField.setEditable(false);
        add(menorTextField);

        JLabel maiorLabel = new JLabel("Maior:");
        maiorLabel.setBounds(10, 70, 100, 20);
        add(maiorLabel);

        maiorTextField = new JTextField();
        maiorTextField.setBounds(120, 70, 200, 20);
        maiorTextField.setEditable(false);
        add(maiorTextField);

        JLabel mediaLabel = new JLabel("Média:");
        mediaLabel.setBounds(10, 100, 100, 20);
        add(mediaLabel);

        mediaTextField = new JTextField();
        mediaTextField.setBounds(120, 100, 200, 20);
        mediaTextField.setEditable(false);
        add(mediaTextField);

        exibirButton = new JButton("Exibir");
        exibirButton.setBounds(330, 40, 100, 20);
        exibirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirValores();
            }
        });
        add(exibirButton);

        JLabel operacaoLabel = new JLabel("Operação:");
        operacaoLabel.setBounds(10, 130, 100, 20);
        add(operacaoLabel);

        String[] operacoes = {"Somar", "Multiplicar"};
        operacaoComboBox = new JComboBox<>(operacoes);
        operacaoComboBox.setBounds(120, 130, 200, 20);
        add(operacaoComboBox);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(330, 130, 100, 20);
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularOperacao();
            }
        });
        add(calcularButton);
    }

    private void cadastrarValores() {
        String input = valoresTextField.getText();
        String[] valoresStr = input.split("\\s+");

        for (String valorStr : valoresStr) {
            try {
                int valor = Integer.parseInt(valorStr);
                numeros.add(valor);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, insira apenas números inteiros.");
                return;
            }
        }

        valoresTextField.setText("");
    }

    private void exibirValores() {
        JOptionPane.showMessageDialog(this, "Números digitados: " + numeros.toString());

        if (!numeros.isEmpty()) {
            int menor = Collections.min(numeros);
            int maior = Collections.max(numeros);
            double media = calcularMedia();

            menorTextField.setText(String.valueOf(menor));
            maiorTextField.setText(String.valueOf(maior));
            mediaTextField.setText(String.format("%.2f", media));
        }
    }

    private double calcularMedia() {
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        return (double) soma / numeros.size();
    }

    private void calcularOperacao() {
        String operacao = (String) operacaoComboBox.getSelectedItem();
        int resultado;

        if (numeros.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores antes de calcular.");
            return;
        }

        if (operacao.equals("Somar")) {
            resultado = somarNumeros();
        } else {
            resultado = multiplicarNumeros();
        }

        JOptionPane.showMessageDialog(this, "Resultado: " + resultado);
    }

    private int somarNumeros() {
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        return soma;
    }

    private int multiplicarNumeros() {
        int produto = 1;
        for (int numero : numeros) {
            produto *= numero;
        }
        return produto;
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.setVisible(true);
    }
}
