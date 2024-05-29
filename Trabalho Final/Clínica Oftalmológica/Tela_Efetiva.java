import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Tela_Efetiva extends JFrame {

	private JPanel contentPane;
	private JTextField txt_data;
	private JTextField txt_hora;
	
	private Consulta consulta = new Consulta();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Efetiva frame = new Tela_Efetiva();
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
	public Tela_Efetiva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Efetiva Consulta");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 438, 22);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(6, 23, 438, 12);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Data:");
		lblNewLabel_1.setBounds(143, 79, 39, 16);
		contentPane.add(lblNewLabel_1);
		
		txt_data = new JTextField();
		txt_data.setBounds(180, 74, 130, 26);
		contentPane.add(txt_data);
		txt_data.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hora:");
		lblNewLabel_1_1.setBounds(143, 123, 39, 16);
		contentPane.add(lblNewLabel_1_1);
		
		txt_hora = new JTextField();
		txt_hora.setColumns(10);
		txt_hora.setBounds(180, 118, 130, 26);
		contentPane.add(txt_hora);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(51, 184, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coletaDados();
				buscar();
				Tela_Exibe_Consulta tela = new Tela_Exibe_Consulta(consulta);
				tela.setVisible(true);
			}
		});
		btnBuscar.setBounds(264, 184, 117, 29);
		contentPane.add(btnBuscar);
	}
	
	public void coletaDados() {
		Date data = null;
			
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			data = formato.parse(txt_data.getText());
		}catch(ParseException e1){
			JOptionPane.showMessageDialog(null, "Os formato da Data deve ser dd/MM/yyyy !", "alerta",
					JOptionPane.ERROR_MESSAGE);
		}
		
		LocalTime hora = null;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("H:mm:ss");
		hora = hora.parse(txt_hora.getText(),formato);
		
		consulta.setData(data);
		consulta.setHora(hora);
	}
	
	public void buscar() {
		DadosConsultas dados = new DadosConsultas();
		boolean achei = false;
		for(int i = 0; i< dados.tamanho(); i++) {
			if(consulta.getData().equals(dados.getVetorConsulta().get(i).getData()) && consulta.getHora().equals(dados.getVetorConsulta().get(i).getHora())){
				consulta.setValor(dados.getVetorConsulta().get(i).getValor());
				consulta.setFuncionario(dados.getVetorConsulta().get(i).getFuncionario());
				consulta.setMedico(dados.getVetorConsulta().get(i).getMedico());
				consulta.setPaciente(dados.getVetorConsulta().get(i).getPaciente());
				consulta.setExames(dados.getVetorConsulta().get(i).getExames());
				achei = true;
				break;
			}
		}
		if(!achei) {
			JOptionPane.showMessageDialog(null, "Não há consultas nesse dia e hora!", "alerta",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
}