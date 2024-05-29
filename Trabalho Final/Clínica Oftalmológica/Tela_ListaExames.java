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

public class Tela_ListaExames extends JFrame {

	private JList<String> listaExames;
	private List<String> selecionados;
	
	/**
	 * Essa Classe é responsável por listar todos os exames cadastrados
	 * Note que ela possui dois construtores.
	 * Num deles ela recebe como parâmetro um Object,
	 * isso nos auxilia a definir os exames registrados na Consulta.
	 * Além de, indicar qual Exame deve ser removido.
	 * 
	 * */
	
	/**
	 * Usamos o construtor padrão para remover Dados
	 * */
	public Tela_ListaExames() {
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        DadosExames exame = new DadosExames();
        
        for(int i = 0; i < exame.tamanho(); i++) {
        	listModel.addElement(exame.getVetorExame().get(i).getNome());
		}
 
        //create the list
        listaExames = new JList<>(listModel);
        listaExames.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = listaExames.getSelectedValuesList();
                    selecionados = selectedValuesList;
                    System.out.println(selectedValuesList);
                }
            }
        });
        getContentPane().setLayout(null);
 
        JScrollPane scrollPane = new JScrollPane(listaExames);
        scrollPane.setBounds(0, 0, 325, 170);
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
        this.setTitle("Lista de Exames");
        this.setSize(329, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	/**
	 * Usamos o segundo construtor para setar os Exames registrados na Consulta
	 * 
	 * */
	
	public Tela_ListaExames(Consulta A) {
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        DadosExames exame = new DadosExames();
        
        for(int i = 0; i < exame.tamanho(); i++) {
        	listModel.addElement(exame.getVetorExame().get(i).getNome());
		}
 
        //create the list
        listaExames = new JList<>(listModel);
        listaExames.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = listaExames.getSelectedValuesList();
                    selecionados = selectedValuesList;
                    System.out.println(selectedValuesList);
                }
            }
        });
        getContentPane().setLayout(null);
 
        JScrollPane scrollPane = new JScrollPane(listaExames);
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
        this.setTitle("Lista de Exames");
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
					Tela_ListaExames frame = new Tela_ListaExames();
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
    	DadosExames exames = new DadosExames();
    	
    	ArrayList<Exame> vetor = new ArrayList<Exame>();
        
        for(int i = 0; i < selecionados.size(); i++) {
        	for(int j = 0; j< exames.tamanho(); j++) {
        		if(selecionados.get(i).compareTo(exames.getVetorExame().get(i).getNome()) == 0) {
        			vetor.add(exames.getVetorExame().get(i));
        		}
        	}
        	
		}
        
        A.setExames(vetor);
    	
    }
    
    
    /**
     * Método removeDados(). Remove os Demais_Funcionarios selecionados.
     * */
    public void removeDados() {
    	DadosExames exames = new DadosExames();
        
        for(int i = 0; i < selecionados.size(); i++) {
        	for(int j = 0; j< exames.tamanho(); j++) {
        		if(selecionados.get(i).compareTo(exames.getVetorExame().get(i).getNome()) == 0) {
        			exames.excluir(exames.getVetorExame().get(i).getNome());
        		}
        	}
        	
		}
    	
    }

}
