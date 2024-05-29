import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Classe: Tela_Cadastro_PacientecomPlano
 * 
 * DESC: Essa classe recebe os dados da classe PacientecomPlano e salva-os num arquivo Pacientes.bin.
 * 		
 * */

public class Tela_Cadastro_PacientecomPlano extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Os text_field representam os atributos da classe PacientecomPlano. 
	 * Eles recebem os dados digitados pelo usuário (todos em formato texto).
	 * E o atributo PacientecomPlano é o objeto que vamos cadastrar.
	 * 
	 * */
	
	private JTextField txt_nome;
	private JTextField txt_cpf;
	private JTextField txt_rg;
	private JTextField txt_civil;
	private JTextField txt_sexo;
	private JTextField txt_dataNascimento;
	private JTextField txt_dataCadastro;
	private JTextField txt_ultimaC;
	private JTextField txt_logradouro;
	private JTextField txt_numero;
	private JTextField txt_bairro;
	private JTextField txt_cidade;
	private JTextField txt_cep;
	private JTextField txt_complemento;
	private JTextField txt_nroCarteira;
	private JTextField txt_dtaIngresso;
	private JTextField txt_carencia;
	
	private PacientecomPlano paciente = new PacientecomPlano();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro_PacientecomPlano frame = new Tela_Cadastro_PacientecomPlano();
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
	public Tela_Cadastro_PacientecomPlano() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(12, 12, 70, 15);
		contentPane.add(lblNewLabel);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(221, 10, 253, 19);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(12, 39, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		txt_cpf = new JTextField();
		txt_cpf.setBounds(221, 37, 253, 19);
		contentPane.add(txt_cpf);
		txt_cpf.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("RG");
		lblNewLabel_2.setBounds(12, 69, 70, 15);
		contentPane.add(lblNewLabel_2);
		
		txt_rg = new JTextField();
		txt_rg.setBounds(221, 67, 253, 19);
		contentPane.add(txt_rg);
		txt_rg.setColumns(10);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setBounds(12, 96, 102, 15);
		contentPane.add(lblEstadoCivil);
		
		txt_civil = new JTextField();
		txt_civil.setBounds(221, 94, 253, 19);
		contentPane.add(txt_civil);
		txt_civil.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		lblNewLabel_3.setBounds(12, 121, 135, 15);
		contentPane.add(lblNewLabel_3);
		
		txt_sexo = new JTextField();
		txt_sexo.setBounds(221, 119, 253, 19);
		contentPane.add(txt_sexo);
		txt_sexo.setColumns(10);
		
		JLabel dataDeNascimento = new JLabel("Data de Nascimento");
		dataDeNascimento.setBounds(12, 146, 191, 15);
		contentPane.add(dataDeNascimento);
		
		txt_dataNascimento = new JTextField();
		txt_dataNascimento.setBounds(221, 144, 253, 19);
		contentPane.add(txt_dataNascimento);
		txt_dataNascimento.setColumns(10);
		
		JLabel dataDeCadastro = new JLabel("Data de Cadastro");
		dataDeCadastro.setBounds(12, 175, 178, 15);
		contentPane.add(dataDeCadastro);
		
		txt_dataCadastro = new JTextField();
		txt_dataCadastro.setBounds(221, 171, 253, 19);
		contentPane.add(txt_dataCadastro);
		txt_dataCadastro.setColumns(10);
		
		JLabel dataUltimaC = new JLabel("Data Ultima Consulta");
		dataUltimaC.setBounds(12, 198, 162, 15);
		contentPane.add(dataUltimaC);
		
		txt_ultimaC = new JTextField();
		txt_ultimaC.setBounds(221, 196, 253, 19);
		contentPane.add(txt_ultimaC);
		txt_ultimaC.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Logradouro");
		lblNewLabel_5.setBounds(12, 225, 102, 15);
		contentPane.add(lblNewLabel_5);
		
		txt_logradouro = new JTextField();
		txt_logradouro.setBounds(221, 223, 253, 19);
		contentPane.add(txt_logradouro);
		txt_logradouro.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Número");
		lblNewLabel_6.setBounds(12, 255, 70, 15);
		contentPane.add(lblNewLabel_6);
		
		txt_numero = new JTextField();
		txt_numero.setBounds(221, 251, 253, 19);
		contentPane.add(txt_numero);
		txt_numero.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Bairro");
		lblNewLabel_7.setBounds(12, 282, 70, 15);
		contentPane.add(lblNewLabel_7);
		
		txt_bairro = new JTextField();
		txt_bairro.setBounds(221, 280, 253, 19);
		contentPane.add(txt_bairro);
		txt_bairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(12, 309, 70, 15);
		contentPane.add(lblCidade);
		
		txt_cidade = new JTextField();
		txt_cidade.setBounds(221, 307, 253, 19);
		contentPane.add(txt_cidade);
		txt_cidade.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(12, 336, 70, 15);
		contentPane.add(lblCep);
		
		txt_cep = new JTextField();
		txt_cep.setBounds(221, 334, 253, 19);
		contentPane.add(txt_cep);
		txt_cep.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(12, 366, 102, 15);
		contentPane.add(lblComplemento);
		
		
		txt_complemento = new JTextField();
		txt_complemento.setBounds(221, 364, 253, 19);
		contentPane.add(txt_complemento);
		txt_complemento.setColumns(10);
		
		JLabel nroCarteira = new JLabel("N° da Carteira");
		nroCarteira.setBounds(12, 393, 191, 15);
		contentPane.add(nroCarteira);
		
		txt_nroCarteira = new JTextField();
		txt_nroCarteira.setBounds(221, 391, 253, 19);
		contentPane.add(txt_nroCarteira);
		txt_nroCarteira.setColumns(10);
		
		JLabel dataIngresso = new JLabel("Data de Ingresso");
		dataIngresso.setBounds(12, 417, 178, 15);
		contentPane.add(dataIngresso);
		
		txt_dtaIngresso = new JTextField();
		txt_dtaIngresso.setBounds(221, 415, 253, 19);
		contentPane.add(txt_dtaIngresso);
		txt_dtaIngresso.setColumns(10);
		
		JLabel carencia = new JLabel("Carência");
		carencia.setBounds(12, 438, 162, 15);
		contentPane.add(carencia);
		
		txt_carencia = new JTextField();
		txt_carencia.setBounds(221, 436, 253, 19);
		contentPane.add(txt_carencia);
		txt_carencia.setColumns(10);
		
		/**
		 * Os botões Salvar e Cancelar fecham a tela quando clicados.
		 * 
		 * Note que a classe Paciente com Plano de Saúde tem um atributo Plano de Saúde. Para setá-lo clicamos no botão Planos.
		 * É exibido, então, uma lista com os nomes de planos de saúde cadastrados.
		 */
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coletaDados();
				salvar();
				dispose();
				
			}
		});
		btnSalvar.setBounds(221, 506, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(350, 506, 117, 25);
		contentPane.add(btnCancelar);
		
		/**
		 * Note que no construtor Tela_ListaPlanos(paciente); usamos o atributo Paciente com Plano dessa classe. 
		 * Para assim setar o Plano de Saúde.
		 */
		
		JButton btnPlanoDeSade = new JButton("Plano de Saúde");
		btnPlanoDeSade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListaPlanos planos = new Tela_ListaPlanos(paciente);
				planos.setVisible(true);
			}
		});
		btnPlanoDeSade.setBounds(221, 469, 246, 25);
		contentPane.add(btnPlanoDeSade);
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
		int carteira = 0;
		
		try {
			numero = Integer.parseInt(txt_numero.getText());
			cep = Integer.parseInt(txt_cep.getText());
			carteira = Integer.parseInt(txt_nroCarteira.getText());
			
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Os dados Número, CEP ou NroCarteira", "alerta",
					JOptionPane.ERROR_MESSAGE);
			
		}
		//Dados Endereço
		String bairro = txt_bairro.getText();
		String cidade = txt_cidade.getText();
		String complemento = txt_complemento.getText();
		Endereco endereco = new Endereco(logradouro,numero,bairro,cidade,cep,complemento);
		
		//Dados Pessoa
		String nome = txt_nome.getText();
		String CPF = txt_cpf.getText();
		String RG = txt_rg.getText();
		String EstadoCivil = txt_civil.getText();
		String sexo = txt_sexo.getText();
		
		Date dataDeNascimento = null;
		Date dataDeCadastro = null;
		Date dataUltimaConsulta = null;
		Date dataDeIngresso = null;
			
		//Dados Paciente
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			dataDeNascimento = formato.parse(txt_dataNascimento.getText());
			dataDeCadastro = formato.parse(txt_dataCadastro.getText());
			dataUltimaConsulta = formato.parse(txt_ultimaC.getText());
			dataDeIngresso = formato.parse(txt_dtaIngresso.getText());
		}catch(ParseException e1){
			JOptionPane.showMessageDialog(null, "O formato da Data deve ser dd/MM/yyyy !", "alerta",
					JOptionPane.ERROR_MESSAGE);
		}
		
		Paciente p = new Paciente(nome,CPF,RG,EstadoCivil, endereco,sexo,dataDeNascimento,dataDeCadastro,dataUltimaConsulta);
		
		boolean carencia = false;
		
		if((txt_carencia.getText().compareTo("Sim") == 0) || (txt_carencia.getText().compareTo("sim") == 0)) carencia = true;
		
		//Seta os valores do PacientecomPlano
		paciente.setCadastro(dataDeCadastro);
		paciente.setCarencia(carencia);
		paciente.setCpf(CPF);
		paciente.setEndereco(endereco);
		paciente.setEstadoCivil(EstadoCivil);
		paciente.setIngresso(dataDeIngresso);
		paciente.setNascimento(dataDeNascimento);
		paciente.setNome(nome);
		paciente.setNroCarteira(carteira);
		paciente.setRg(RG);
		paciente.setSexo(sexo);
		paciente.setUltimaConsulta(dataUltimaConsulta);
		
	}
	
	/**
	 * O método salvar(), declara um objeto da classe DadosPacientes
	 * para salvar o objeto PacientecomPlano no arquivo Pacientes.bin
	 * 
	 * */
	
	public void salvar() {
		DadosPacientes dados = new DadosPacientes();
		dados.cadastrar((Paciente)paciente);
		dados.salvar();
		
	}

}
