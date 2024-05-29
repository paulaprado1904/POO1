import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Tela_ListaPacientes extends JFrame {
	
	private JList<String> listaPacientes;
	private List<String> selecionados;
	
	/**
	 * Essa Classe é responsável por listar todos os pacientes cadastrados
	 * Note que ela possui dois construtores.
	 * Num deles ela recebe como parâmetro um Object,
	 * isso nos auxilia a definir o paciente que atenderá a Consulta.
	 * Além de, indicar qual Paciente deve ser removido.
	 * 
	 * */
	
	/**
	 * Usamos o construtor padrão para remover Dados
	 * */
	public Tela_ListaPacientes() {
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        DadosPacientes pacientes = new DadosPacientes();
        
        for(int i = 0; i < pacientes.tamanho(); i++) {
        	listModel.addElement(pacientes.getVetorPaciente().get(i).getNome());
		}
 
        //create the list
        listaPacientes = new JList<>(listModel);
        listaPacientes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = listaPacientes.getSelectedValuesList();
                    selecionados = selectedValuesList;
                    System.out.println(selectedValuesList);
                }
            }
        });
        getContentPane().setLayout(null);
 
        JScrollPane scrollPane = new JScrollPane(listaPacientes);
        scrollPane.setBounds(0, 0, 387, 170);
        getContentPane().add(scrollPane);
        
        /**
         * Note que o botão excluir chama o método removeDados();
         * */
        JButton excluir = new JButton("Excluir");
        excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        scrollPane.setColumnHeaderView(excluir);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        scrollPane.setRowHeaderView(btnCancelar);
 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Lista de Pacientes");
        this.setSize(399, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	/**
	 * Usamos o segundo construtor para setar o Funcionário que registrou a Consulta
	 * 
	 * */
	
	public Tela_ListaPacientes(Consulta A) {
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        DadosPacientes pacientes = new DadosPacientes();
        
        for(int i = 0; i < pacientes.tamanho(); i++) {
        	listModel.addElement(pacientes.getVetorPaciente().get(i).getNome());
		}
 
        //create the list
        listaPacientes = new JList<>(listModel);
        listaPacientes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = listaPacientes.getSelectedValuesList();
                    selecionados = selectedValuesList;
                    System.out.println(selectedValuesList);
                }
            }
        });
        getContentPane().setLayout(null);
 
        JScrollPane scrollPane = new JScrollPane(listaPacientes);
        scrollPane.setBounds(0, 0, 190, 170);
        getContentPane().add(scrollPane);
        
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coletaDados(A);
				dispose();
			}
		});
        scrollPane.setColumnHeaderView(salvar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        scrollPane.setRowHeaderView(btnCancelar);
 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Lista de Pacientes");
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_ListaPacientes frame = new Tela_ListaPacientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
    /***
     * Método coletaDados(). Aqui ele recebe um Object e seta ele conforme a sua classe.
     * 
     * */
    public void coletaDados(Consulta A) {
    	DadosPacientes pacientes = new DadosPacientes();
    	
    	ArrayList<Paciente> vetor = new ArrayList<Paciente>();
        
        for(int i = 0; i < selecionados.size(); i++) {
        	for(int j = 0; j< pacientes.tamanho(); j++) {
        		if(selecionados.get(i).compareTo(pacientes.getVetorPaciente().get(i).getNome()) == 0) {
        			vetor.add(pacientes.getVetorPaciente().get(i));
        		}
        	}
        	
		}
        
        A.setPaciente(vetor.get(0));
    	
    }
    
    /**
     * Método removeDados(). Remove os Demais_Funcionarios selecionados.
     * */
    
    public void removeDados() {
    	DadosPacientes pacientes = new DadosPacientes();
    	
        for(int i = 0; i < selecionados.size(); i++) {
        	for(int j = 0; j< pacientes.tamanho(); j++) {
        		if(selecionados.get(i).compareTo(pacientes.getVetorPaciente().get(i).getNome()) == 0) {
        			pacientes.excluir(pacientes.getVetorPaciente().get(i).getCpf());
        		}
        	}
        	
		}
        
    }



}
