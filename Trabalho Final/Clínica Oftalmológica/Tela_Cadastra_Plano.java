import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Classe: Tela_Cadastro_Plano
 * 
 * DESC: Essa classe recebe os dados da classe Plano de Saúde e salva-os num arquivo Planos.bin.
 * 
 * */

public class Tela_Cadastra_Plano extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Os text_field que representam os atributos da classe Plano_Saude. 
	 * Eles recebem os dados digitados pelo usuário (todos em formato texto).
	 * E o atributo Plano_Saude é o objeto que vamos cadastrar.
	 * */
	
	private JTextField txt_nome;
	private JTextField txt_cnpj;
	private JTextField txt_logradouro;
	private JTextField txt_numero;
	private JTextField txt_bairro;
	private JTextField txt_cidade;
	private JTextField txt_cep;
	private JTextField txt_complemento;
	
	private Plano_Saude plano = new Plano_Saude();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastra_Plano frame = new Tela_Cadastra_Plano();
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
	public Tela_Cadastra_Plano() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(12, 36, 70, 15);
		contentPane.add(lblCnpj);
		
		txt_cnpj = new JTextField();
		txt_cnpj.setBounds(304, 34, 114, 19);
		contentPane.add(txt_cnpj);
		txt_cnpj.setColumns(10);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(12, 59, 83, 15);
		contentPane.add(lblLogradouro);
		
		txt_logradouro = new JTextField();
		txt_logradouro.setBounds(304, 57, 114, 19);
		contentPane.add(txt_logradouro);
		txt_logradouro.setColumns(10);
		
		JLabel lblNmero = new JLabel("Número");
		lblNmero.setBounds(12, 77, 70, 28);
		contentPane.add(lblNmero);
		
		txt_numero = new JTextField();
		txt_numero.setBounds(304, 82, 114, 19);
		contentPane.add(txt_numero);
		txt_numero.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Bairro");
		lblNewLabel_1.setBounds(12, 105, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		txt_bairro = new JTextField();
		txt_bairro.setBounds(304, 103, 114, 19);
		contentPane.add(txt_bairro);
		txt_bairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(12, 125, 70, 15);
		contentPane.add(lblCidade);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(12, 145, 70, 15);
		contentPane.add(lblCep);
		
		txt_cidade = new JTextField();
		txt_cidade.setBounds(304, 123, 114, 19);
		contentPane.add(txt_cidade);
		txt_cidade.setColumns(10);
		
		txt_cep = new JTextField();
		txt_cep.setBounds(304, 143, 114, 19);
		contentPane.add(txt_cep);
		txt_cep.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(12, 172, 106, 15);
		contentPane.add(lblComplemento);
		
		txt_complemento = new JTextField();
		txt_complemento.setBounds(304, 170, 114, 19);
		contentPane.add(txt_complemento);
		txt_complemento.setColumns(10);
		
		/**
		 * Os únicos botões dessa tela são Salvar e Cancelar.
		 * Ambos fecham a tela quando clicados.
		 * 
		 */
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(304, 233, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coletaDados();
				salvar();
				dispose();
			}
		});
		btnSalvar.setBounds(176, 233, 117, 25);
		contentPane.add(btnSalvar);
	}
	
	/**
	 * O método coletaDados(), pega os valores dos text_field e os atribui as variáveis corretas,
	 * fazendo as devidas conversões. Note que os text_field só recebem Strings, logo,
	 * variáveis do tipo Date, por exemplo, vão precisar passar por um tratamento antes de recebererem o dado.
	 * 
	 * */
	
	public void coletaDados() {
		
		String logradouro = txt_logradouro.getText();
		
		int numero = 0;
		int cep = 0;
		
		try {
			numero = Integer.parseInt(txt_numero.getText());
			cep = Integer.parseInt(txt_cep.getText());
			
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Os dados Número ou CEP estão incorretos", "alerta",
					JOptionPane.ERROR_MESSAGE);
			
		}
		
		//Dados Endereço
		String bairro = txt_bairro.getText();
		String cidade = txt_cidade.getText();
		String complemento = txt_complemento.getText();
		Endereco endereco = new Endereco(logradouro,numero,bairro,cidade,cep,complemento);
		
		//Dados Plano
		String nome = txt_nome.getText();
		String CNPJ = txt_cnpj.getText();
		
		plano.setCNPJ(CNPJ);
		plano.setEndereco(endereco);
		plano.setNome(nome);
	
	}
	
	/**
	 * O método salvar(), declara um objeto da classe DadosPlanos
	 * para salvar o objeto Plano_Saude no arquivo Planos.bin
	 * 
	 * */
	public void salvar() {
		//Salvando em arquivo		
		DadosPlanos dados = new DadosPlanos();
		dados.cadastrar((Plano_Saude)plano);
		dados.salvar();
	}

}
