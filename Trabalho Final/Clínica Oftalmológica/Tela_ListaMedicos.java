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

public class Tela_ListaMedicos extends JFrame {

	private JList<String> listaMedicos;
	private List<String> selecionados;
	
	/**
	 * Essa Classe é responsável por listar todos os medicos cadastrados
	 * Note que ela possui dois construtores.
	 * Num deles ela recebe como parâmetro um Object,
	 * isso nos auxilia a definir os medicos registrados na Consulta.
	 * Além de, indicar qual medico deve ser removido.
	 * 
	 * */
	
	public Tela_ListaMedicos() {
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        DadosFuncionarios medicos = new DadosFuncionarios();
        
        for(int i = 0; i < medicos.tamanho(); i++) {
        	if(medicos.getVetorFuncionario().get(i) instanceof Medico)
        		listModel.addElement(medicos.getVetorFuncionario().get(i).getNome());
		}
 
        //create the list
        listaMedicos = new JList<>(listModel);
        listaMedicos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = listaMedicos.getSelectedValuesList();
                    selecionados = selectedValuesList;
                    System.out.println(selectedValuesList);
                }
            }
        });
        getContentPane().setLayout(null);
 
        JScrollPane scrollPane = new JScrollPane(listaMedicos);
        scrollPane.setBounds(0, 0, 368, 170);
        getContentPane().add(scrollPane);
        
        /**
         * Note que o botão excluir chama o método removeDados();
         * */
        JButton excluir = new JButton("Excluir");
        excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeDados();
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
        this.setTitle("Lista de Médicos");
        this.setSize(380, 214);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	/**
	 * Usamos o segundo construtor para setar os Exames registrados na Consulta
	 * 
	 * */
	
	public Tela_ListaMedicos(Consulta A) {
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        DadosFuncionarios medicos = new DadosFuncionarios();
        
        for(int i = 0; i < medicos.tamanho(); i++) {
        	if(medicos.getVetorFuncionario().get(i) instanceof Medico)
        		listModel.addElement(medicos.getVetorFuncionario().get(i).getNome());
		}
 
        //create the list
        listaMedicos = new JList<>(listModel);
        listaMedicos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = listaMedicos.getSelectedValuesList();
                    selecionados = selectedValuesList;
                    System.out.println(selectedValuesList);
                }
            }
        });
        getContentPane().setLayout(null);
 
        JScrollPane scrollPane = new JScrollPane(listaMedicos);
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
        this.setTitle("Lista de Médicos");
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
					Tela_ListaMedicos frame = new Tela_ListaMedicos();
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
    	DadosFuncionarios medicos = new DadosFuncionarios();
    	
    	ArrayList<Medico> vetor = new ArrayList<Medico>();
        
        for(int i = 0; i < selecionados.size(); i++) {
        	for(int j = 0; j< medicos.tamanho(); j++) {
        		if(selecionados.get(i).compareTo(medicos.getVetorFuncionario().get(i).getNome()) == 0) {
        			vetor.add((Medico)(medicos.getVetorFuncionario().get(i)));
        		}
        	}
        	
		}
        
        A.setMedico(vetor.get(0));
    	
    }
    
    /**
     * Método removeDados(). Remove os Médicos selecionados.
     * */
    
    public void removeDados() {
    	DadosFuncionarios medico = new DadosFuncionarios();
        
        for(int i = 0; i < selecionados.size(); i++) {
        	for(int j = 0; j< medico.tamanho(); j++) {
        		if(selecionados.get(i).compareTo(medico.getVetorFuncionario().get(i).getNome()) == 0) {
        			medico.excluir(medico.getVetorFuncionario().get(i).getCpf());
        		}
        	}
        	
		}
        
    }

}
