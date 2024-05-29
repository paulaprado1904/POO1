import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * Classe: Tela_Cadastro_Médico
 * 
 * DESC: Essa classe recebe os dados da classe Medico e salva-os num arquivo Funcionarios.bin.
 * 		
 * */

public class Tela_Cadastro_Médico extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Os text_field representam os atributos da classe Medico. 
	 * Eles recebem os dados digitados pelo usuário (todos em formato texto).
	 * Os JButton são os botões da tela.
	 * E o atributo Medico é o objeto que vamos cadastrar.
	 * 
	 * */

	private JTextField txt_nome;
	private JTextField txt_cpf;
	private JTextField txt_rg;
	private JTextField txt_civil;
	private JTextField txt_data;
	private JTextField txt_carteira;
	private JTextField txt_usuario;
	private JTextField txt_senha;
	private JTextField txt_logradouro;
	private JTextField txt_numero;
	private JTextField txt_bairro;
	private JTextField txt_cidade;
	private JTextField txt_cep;
	private JTextField txt_complemento;
	private JTextField txt_crm;
	private JTextField txt_especialidade;
	private JTextField txt_soma;
	
	private Medico medico = new Medico();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro_Médico frame = new Tela_Cadastro_Médico();
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
	public Tela_Cadastro_Médico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 606);
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
		
		JLabel lblNewLabel_3 = new JLabel("Data de Admissão");
		lblNewLabel_3.setBounds(12, 121, 135, 15);
		contentPane.add(lblNewLabel_3);
		
		txt_data = new JTextField();
		txt_data.setBounds(221, 119, 253, 19);
		contentPane.add(txt_data);
		txt_data.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nº da carteira");
		lblNewLabel_4.setBounds(12, 146, 135, 15);
		contentPane.add(lblNewLabel_4);
		
		txt_carteira = new JTextField();
		txt_carteira.setBounds(221, 144, 253, 19);
		contentPane.add(txt_carteira);
		txt_carteira.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(12, 175, 70, 15);
		contentPane.add(lblUsurio);
		
		txt_usuario = new JTextField();
		txt_usuario.setBounds(221, 171, 253, 19);
		contentPane.add(txt_usuario);
		txt_usuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(12, 198, 70, 15);
		contentPane.add(lblSenha);
		
		txt_senha = new JTextField();
		txt_senha.setBounds(221, 196, 253, 19);
		contentPane.add(txt_senha);
		txt_senha.setColumns(10);
		
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
		
		JLabel lblCRM = new JLabel("CRM");
		lblCRM.setBounds(12, 393, 70, 15);
		contentPane.add(lblCRM);
		
		txt_crm = new JTextField();
		txt_crm.setBounds(221, 391, 253, 19);
		contentPane.add(txt_crm);
		txt_crm.setColumns(10);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(12, 417, 102, 15);
		contentPane.add(lblEspecialidade);
		
		txt_especialidade = new JTextField();
		txt_especialidade.setBounds(221, 415, 253, 19);
		contentPane.add(txt_especialidade);
		txt_especialidade.setColumns(10);
		
		JLabel lblSomaDeConsultas = new JLabel("Soma Consulta Mês");
		lblSomaDeConsultas.setBounds(12, 438, 162, 15);
		contentPane.add(lblSomaDeConsultas);
		
		txt_soma = new JTextField();
		txt_soma.setBounds(221, 436, 253, 19);
		contentPane.add(txt_soma);
		txt_soma.setColumns(10);
		
		/**
		 * Os botões Salvar e Cancelar fecham a tela quando clicados.
		 * 
		 * Note que a classe Médico tem um atributo ArrayList de Planos de Saúde. Para setá-lo clicamos no botão Planos.
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
		btnSalvar.setBounds(221, 516, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(357, 516, 117, 25);
		contentPane.add(btnCancelar);
		
		/**
		 * Note que no construtor Tela_ListaPlanos(medico); usamos o atributo Médico dessa classe. 
		 * Para assim setar os Planos de Saúde.
		 */
		
		JButton planoSaude = new JButton("Planos de Saúde");
		planoSaude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListaPlanos planos = new Tela_ListaPlanos(medico);
				planos.setVisible(true);
			}
		});
		planoSaude.setBounds(221, 466, 253, 25);
		contentPane.add(planoSaude);
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
		double soma = 0;
		
		try {
			numero = Integer.parseInt(txt_numero.getText());
			cep = Integer.parseInt(txt_cep.getText());
			carteira = Integer.parseInt(txt_carteira.getText());
			soma = Double.parseDouble((txt_soma.getText()).replaceAll(",", "."));
			
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Os dados Número, CEP, Carteira ou Soma Consulta Mês", "alerta!",
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
		Date dataDeAdmissao = null;
			
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			dataDeAdmissao = formato.parse(txt_data.getText());
		}catch(ParseException e1){
			JOptionPane.showMessageDialog(null, "Os formato da Data deve ser dd/MM/yyyy !", "alerta",
					JOptionPane.ERROR_MESSAGE);
		}
		
		//Dados Funcionário
		String usuario = txt_usuario.getText();
		String senha = txt_senha.getText();
		
		//Dados Médico
		String CRM = txt_crm.getText();
		String especialidade = txt_especialidade.getText();
		
		
		//Setando dados do médico
		medico.setNome(nome);
		medico.setCpf(CPF);
		medico.setRg(RG);
		medico.setEstadoCivil(EstadoCivil);
		medico.setEndereco(endereco);
		medico.setAdmissão(dataDeAdmissao);
		medico.setCarteira(carteira);
		medico.setUsuario(usuario);
		medico.setSenha(senha);
		medico.setCRM(CRM);
		medico.setEspecialidade(especialidade);
		medico.setSomaConsultasMes(soma);

	}
	
	/**
	 * O método salvar(), declara um objeto da classe DadosFuncionarios
	 * para salvar o objeto Medico no arquivo Funcionarios.bin
	 * 
	 * */
	
	public void salvar() {
		DadosFuncionarios dados = new DadosFuncionarios();
		dados.cadastrar((Funcionario)medico);
		dados.salvar();
		
	}
}
