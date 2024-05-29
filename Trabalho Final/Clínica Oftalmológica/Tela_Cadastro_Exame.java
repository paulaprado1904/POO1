import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Classe: Tela_Cadastro_Exame
 * 
 * DESC: Essa classe recebe os dados da classe Exame e salva-os num arquivo Exames.bin.
 *  
 * */

public class Tela_Cadastro_Exame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Os text_field representam os atributos da classe Exame. 
	 * Eles recebem os dados digitados pelo usuário (todos em formato texto).
	 * E o atributo Exame é o objeto que vamos cadastrar.
	 * 
	 * */
	
	private JTextField txt_nome;
	
	private Exame exame = new Exame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro_Exame frame = new Tela_Cadastro_Exame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_Cadastro_Exame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(12, 12, 70, 15);
		contentPane.add(lblNewLabel);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(304, 10, 114, 19);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		/**
		 * Os únicos botões dessa tela são Salvar e Cancelar.
		 * Ambos fecham a tela quando clicados.
		 */
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(301, 93, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coletaDados();
				salvar();
				dispose();
			}
		});
		btnSalvar.setBounds(173, 93, 117, 25);
		contentPane.add(btnSalvar);
	}
	
	/**
	 * O método coletaDados(), pega os valores dos text_field e os atribui as variáveis corretas,
	 * fazendo as devidas conversões. Note que os text_field só recebem Strings, logo,
	 * variáveis do tipo Date, por exemplo, vão precisar passar por um tratamento antes de recebererem o dado.
	 * 
	 * */
	
	public void coletaDados() {
		//Dados Exame
		String nome = txt_nome.getText();
		exame.setNome(nome);
	}
	
	/**
	 * O método salvar(), declara um objeto da classe DadosExames
	 * para salvar o objeto Exame no arquivo Exames.bin
	 * 
	 * */
	public void salvar() {
		
		//Salvando em arquivo		
		DadosExames dados = new DadosExames();
		dados.cadastrar(exame);
		dados.salvar();
	}

}
