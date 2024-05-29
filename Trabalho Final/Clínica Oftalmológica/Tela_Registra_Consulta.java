import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Classe: Tela_Registra_Consulta
 * 
 * DESC: Essa classe recebe os dados da classe Consulta e salva-os num arquivo Consultas.bin.
 * 		
 * */

public class Tela_Registra_Consulta extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Os text_field representam os atributos da classe Consulta. 
	 * Eles recebem os dados digitados pelo usuário (todos em formato texto).
	 * Os JButton são os botões da tela.
	 * E o atributo Consulta é o objeto que vamos cadastrar.
	 * 
	 * */
	
	private JTextField txt_data;
	private JTextField txt_hora;
	private JTextField txt_valor;
	
	private Consulta consulta = new Consulta();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Registra_Consulta frame = new Tela_Registra_Consulta();
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
	public Tela_Registra_Consulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel data = new JLabel("Data");
		data.setBounds(12, 12, 70, 15);
		contentPane.add(data);
		
		txt_data = new JTextField();
		txt_data.setBounds(221, 10, 253, 19);
		contentPane.add(txt_data);
		txt_data.setColumns(10);
		
		JLabel hora = new JLabel("Hora");
		hora.setBounds(12, 39, 70, 15);
		contentPane.add(hora);
		
		txt_hora = new JTextField();
		txt_hora.setBounds(221, 37, 253, 19);
		contentPane.add(txt_hora);
		txt_hora.setColumns(10);
		
		JLabel valor = new JLabel("Valor R$");
		valor.setBounds(12, 66, 135, 15);
		contentPane.add(valor);
		
		txt_valor = new JTextField();
		txt_valor.setBounds(221, 64, 253, 19);
		contentPane.add(txt_valor);
		txt_valor.setColumns(10);
		
		/**
		 * Os botões Salvar e Cancelar fecham a tela quando clicados.
		 *
		 */
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coletaDados();
				salvar();
				dispose();
				
			}
		});
		btnSalvar.setBounds(221, 261, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(357, 261, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnfuncionario = new JButton("Funcionário");
		btnfuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListaDemais planos = new Tela_ListaDemais(consulta);
				planos.setVisible(true);
			}
		});
		btnfuncionario.setBounds(221, 95, 253, 25);
		contentPane.add(btnfuncionario);
		
		JButton btnMdico = new JButton("Médico");
		btnMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListaMedicos lista = new Tela_ListaMedicos(consulta);
				lista.setVisible(true);
			}
		});
		btnMdico.setBounds(221, 132, 253, 25);
		contentPane.add(btnMdico);
		
		JButton btnpaciente = new JButton("Paciente");
		btnpaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListaPacientes lista = new Tela_ListaPacientes(consulta);
				lista.setVisible(true);
			}
		});
		btnpaciente.setBounds(221, 169, 253, 25);
		contentPane.add(btnpaciente);
		
		JButton btnExames = new JButton("Exames");
		btnExames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListaExames lista = new Tela_ListaExames(consulta);
				lista.setVisible(true);
			}
		});
		btnExames.setBounds(221, 206, 253, 25);
		contentPane.add(btnExames);
	}
	
	/**
	 * O método coletaDados(), pega os valores dos text_field e os atribui as variáveis corretas,
	 * fazendo as devidas conversões. Note que os text_field só recebem Strings, logo,
	 * variáveis do tipo Date, por exemplo, vão precisar passar por um tratamento antes de recebererem o dado.
	 * 
	 * */
	
	public void coletaDados() {
		
		double valor = 0;
		
		try {
			valor = Double.parseDouble((txt_valor.getText()).replaceAll(",", "."));
			
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Os dados Número, CEP, Carteira ou Soma Consulta Mês", "alerta!",
					JOptionPane.ERROR_MESSAGE);
			
		}
		
		Date data = null;
			
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			data = formato.parse(txt_data.getText());
		}catch(ParseException e1){
			JOptionPane.showMessageDialog(null, "alerta", "Os formato da Data deve ser dd/MM/yyyy !",
					JOptionPane.ERROR_MESSAGE);
		}
		
		LocalTime hora = null;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("H:mm:ss");
		hora = hora.parse(txt_hora.getText(),formato);
		
		consulta.setData(data);
		consulta.setHora(hora);
		consulta.setValor(valor);

	}
	
	/**
	 * O método salvar(), declara um objeto da classe DadosConsultas
	 * para salvar o objeto Consulta no arquivo Consultas.bin
	 * 
	 * */
	
	public void salvar() {
		DadosConsultas dados = new DadosConsultas();
		dados.cadastrar((Consulta)consulta);
		dados.salvar();
		
	}
}
