package A;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal() {
        // Configurações gerais da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setTitle("Tela Principal");

        // Criação dos botões
        JButton preencherButton = new JButton("Preencher Dados");
        JButton visualizarButton = new JButton("Visualizar Dados");

        // Adicionando os botões ao painel
        JPanel panel = new JPanel();
        panel.add(preencherButton);
        panel.add(visualizarButton);

        // Adicionando o painel à janela
        add(panel);

        // ActionListener para o botão "Visualizar Dados"
        visualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader reader = new FileReader("dados.txt");
                    BufferedReader bufferedReader = new BufferedReader(reader);

                    ArrayList<String> cpfs = new ArrayList<>();
                    String linha;
                    while ((linha = bufferedReader.readLine()) != null) {
                        String[] partes = linha.split(";");
                        cpfs.add(partes[1]); // O CPF está na segunda posição
                    }

                    bufferedReader.close();

                    if (cpfs.isEmpty()) {
                        JOptionPane.showMessageDialog(TelaPrincipal.this, "Nenhum usuário cadastrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    String cpfSelecionado = (String) JOptionPane.showInputDialog(
                            TelaPrincipal.this,
                            "Selecione um CPF:",
                            "Visualizar Dados",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            cpfs.toArray(),
                            cpfs.get(0) // CPF padrão selecionado
                    );

                    if (cpfSelecionado != null) {
                        FileReader dadosReader = new FileReader("dados.txt");
                        BufferedReader dadosBufferedReader = new BufferedReader(dadosReader);

                        String dadosLinha;
                        while ((dadosLinha = dadosBufferedReader.readLine()) != null) {
                            String[] partes = dadosLinha.split(";");
                            if (partes[1].equals(cpfSelecionado)) {
                                TelaDados telaDados = new TelaDados();

                                // Preenche os campos com os dados
                                telaDados.getNomeField().setText(partes[0]);
                                telaDados.getCpfField().setText(partes[1]);
                                telaDados.getDataNascimentoField().setText(partes[2]);

                                if (partes[3].equals("Masculino")) {
                                    telaDados.getMasculinoRadioButton().setSelected(true);
                                } else {
                                    telaDados.getFemininoRadioButton().setSelected(true);
                                }

                                telaDados.getNumeroContaField().setText(partes[4]);
                                telaDados.getSenhaField().setText(partes[5]);
                                telaDados.getEmailField().setText(partes[6]);

                                if (partes[7].equals("Sim")) {
                                    telaDados.getReceberNoticiasCheckbox().setSelected(true);
                                }

                                telaDados.setVisible(true);

                                break;
                            }
                        }

                        dadosBufferedReader.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // ActionListener para o botão "Preencher Dados"
        preencherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaDados telaDados = new TelaDados();
                telaDados.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
}
