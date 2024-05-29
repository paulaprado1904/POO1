import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Tela_ConsultaDados extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_ConsultaDados frame = new Tela_ConsultaDados();
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
	public Tela_ConsultaDados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlano = new JButton("Plano de Saúde");
		btnPlano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListaPlanos lista = new Tela_ListaPlanos();
			}
		});
		btnPlano.setBounds(65, 23, 321, 25);
		contentPane.add(btnPlano);
		
		JButton btnPaciente = new JButton("Paciente");
		btnPaciente.setBounds(65, 60, 321, 25);
		contentPane.add(btnPaciente);
		
		JButton btnFuncionario = new JButton("Funcionário");
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListaDemais lista = new Tela_ListaDemais();
			}
		});
		btnFuncionario.setBounds(65, 101, 321, 25);
		contentPane.add(btnFuncionario);
		
		JButton btnExame = new JButton("Exame");
		btnExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_ListaExames lista = new Tela_ListaExames();
			}
		});
		btnExame.setBounds(65, 143, 321, 25);
		contentPane.add(btnExame);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Lista_Consulta lista = new Tela_Lista_Consulta();
			}
		});
		btnConsulta.setBounds(65, 185, 321, 25);
		contentPane.add(btnConsulta);
	}

}
