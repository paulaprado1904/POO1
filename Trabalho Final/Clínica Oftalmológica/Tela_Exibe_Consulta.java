
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;

public class Tela_Exibe_Consulta extends JFrame {

	private JPanel contentPane;

	private JTextField txt_medicamentos;
	private JTextField txt_sintomas;
	
	private Consulta consulta = new Consulta();
	private JTextField txt_receita;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Exibe_Consulta frame = new Tela_Exibe_Consulta();
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
	public Tela_Exibe_Consulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel data = new JLabel("Medicamentos:");
		data.setBounds(32, 54, 177, 15);
		contentPane.add(data);
		
		txt_medicamentos = new JTextField();
		txt_medicamentos.setBounds(221, 45, 253, 87);
		contentPane.add(txt_medicamentos);
		txt_medicamentos.setColumns(10);
		
		JLabel valor = new JLabel("Sintomas:");
		valor.setBounds(58, 159, 151, 15);
		contentPane.add(valor);
		
		txt_sintomas = new JTextField();
		txt_sintomas.setBounds(221, 144, 253, 85);
		contentPane.add(txt_sintomas);
		txt_sintomas.setColumns(10);
		
		/**
		 * Os botões Salvar e Cancelar fecham a tela quando clicados.
		 *
		 */
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnSalvar.setBounds(357, 389, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(221, 389, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnExames = new JButton("Exames");
		btnExames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListaExames tela = new Tela_ListaExames();
				tela.setVisible(true);
			}
		});
		btnExames.setBounds(221, 352, 253, 25);
		contentPane.add(btnExames);
		
		JLabel lblNewLabel = new JLabel("Dados Consulta");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 479, 25);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(6, 23, 479, 12);
		contentPane.add(separator);
		
		txt_receita = new JTextField();
		txt_receita.setColumns(10);
		txt_receita.setBounds(221, 241, 253, 85);
		contentPane.add(txt_receita);
		
		JLabel lblReceita = new JLabel("Receita");
		lblReceita.setBounds(58, 241, 151, 15);
		contentPane.add(lblReceita);
	}
	
	public Tela_Exibe_Consulta(Consulta A) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel data = new JLabel("Medicamentos:");
		data.setBounds(114, 54, 95, 15);
		contentPane.add(data);
		
		txt_medicamentos = new JTextField();
		txt_medicamentos.setBounds(221, 45, 253, 87);
		contentPane.add(txt_medicamentos);
		txt_medicamentos.setColumns(10);
		
		JLabel valor = new JLabel("Sintomas:");
		valor.setBounds(146, 159, 63, 15);
		contentPane.add(valor);
		
		txt_sintomas = new JTextField();
		txt_sintomas.setBounds(221, 144, 253, 85);
		contentPane.add(txt_sintomas);
		txt_sintomas.setColumns(10);
		
		/**
		 * Os botões Salvar e Cancelar fecham a tela quando clicados.
		 *
		 */
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coletaDados(A);
				atualizar(A);
				dispose();
				
			}
		});
		btnSalvar.setBounds(357, 278, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(228, 278, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnExames = new JButton("Exames");
		btnExames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListaExames tela = new Tela_ListaExames(A);
				tela.setVisible(true);
			}
		});
		btnExames.setBounds(221, 241, 253, 25);
		contentPane.add(btnExames);
		
		JLabel lblNewLabel = new JLabel("Dados Consulta");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 479, 25);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(6, 23, 479, 12);
		contentPane.add(separator);
	}
	
	/**
	 * O método coletaDados(), pega os valores dos text_field e os atribui as variáveis corretas,
	 * fazendo as devidas conversões. Note que os text_field só recebem Strings, logo,
	 * variáveis do tipo Date, por exemplo, vão precisar passar por um tratamento antes de recebererem o dado.
	 * 
	 * */
	
	public void coletaDados(Consulta A) {
		
		String medicamentos = txt_medicamentos.getText();
		String sintomas = txt_sintomas.getText();
		String receita = txt_receita.getText();
		
		A.setReceita(receita);
		
		Date data = new Date();
		
		A.efetuaConsulta(medicamentos, A.getExames(), sintomas);
	}
	
	public void atualizar(Consulta A) {
		DadosConsultas dados = new DadosConsultas();
		ArrayList<Consulta> consulta = new ArrayList<Consulta>();
		consulta = dados.getVetorConsulta();
		
		for(int i = 0; i < dados.tamanho(); i++) {
			if ((A.getData().equals(consulta.get(i).getData())) && (A.getHora().equals(consulta.get(i).getHora()))){
				consulta.get(i).setData(A.getData());
				consulta.get(i).setEfetua(true);
				consulta.get(i).setExames(A.getExames());
				consulta.get(i).setFuncionario(A.getFuncionario());
				consulta.get(i).setHora(A.getHora());
				consulta.get(i).setMedicamentos(A.getMedicamentos());
				consulta.get(i).setMedico(A.getMedico());
				consulta.get(i).setPaciente(A.getPaciente());
				consulta.get(i).setReceita(A.getReceita());
				consulta.get(i).setSintomas(A.getSintomas());
				consulta.get(i).setValor(A.getValor());
				
				break;
			}
		}
		dados.salvar();
		
	}

}