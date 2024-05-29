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

public class Tela_ListaDemais extends JFrame {

	private JList<String> listaDemais;
	private List<String> selecionados;
	
	/**
	 * Essa Classe é responsável por listar todos os demais funcionários cadastrados
	 * Note que ela possui dois construtores.
	 * Num deles ela recebe como parâmetro um Object,
	 * isso nos auxilia a definir o funcionário que registrou uma Consulta.
	 * Além de, indicar qual Consulta deve ser removido.
	 * 
	 * */

	
	/**
	 * Usamos o construtor padrão para remover Dados
	 * */
	public Tela_ListaDemais() {
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        DadosFuncionarios demais = new DadosFuncionarios();
        
        for(int i = 0; i < demais.tamanho(); i++) {
        	if(demais.getVetorFuncionario().get(i) instanceof Demais_Funcionarios)
        		listModel.addElement(demais.getVetorFuncionario().get(i).getNome());
		}
 
        //create the list
        listaDemais = new JList<>(listModel);
        listaDemais.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = listaDemais.getSelectedValuesList();
                    selecionados = selectedValuesList;
                    System.out.println(selectedValuesList);
                }
            }
        });
        getContentPane().setLayout(null);
 
        JScrollPane scrollPane = new JScrollPane(listaDemais);
        scrollPane.setBounds(0, 0, 362, 170);
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
        this.setTitle("Lista de Funcionários");
        this.setSize(384, 207);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	/**
	 * Usamos o segundo construtor para setar o Funcionário que registrou a Consulta
	 * 
	 * */
	
	public Tela_ListaDemais(Consulta A) {
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		 DadosFuncionarios demais = new DadosFuncionarios();
        
        for(int i = 0; i < demais.tamanho(); i++) {
        	if(demais.getVetorFuncionario().get(i) instanceof Demais_Funcionarios)
        		listModel.addElement(demais.getVetorFuncionario().get(i).getNome());
		}
 
        //create the list
        listaDemais = new JList<>(listModel);
        listaDemais.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = listaDemais.getSelectedValuesList();
                    selecionados = selectedValuesList;
                    System.out.println(selectedValuesList);
                }
            }
        });
        getContentPane().setLayout(null);
 
        JScrollPane scrollPane = new JScrollPane(listaDemais);
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
        this.setTitle("Lista de Funcionários");
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
					Tela_ListaDemais frame = new Tela_ListaDemais();
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
    	DadosFuncionarios demais = new DadosFuncionarios();
    	
    	ArrayList<Demais_Funcionarios> vetor = new ArrayList<Demais_Funcionarios>();
        
        for(int i = 0; i < selecionados.size(); i++) {
        	for(int j = 0; j< demais.tamanho(); j++) {
        		if(selecionados.get(i).compareTo(demais.getVetorFuncionario().get(i).getNome()) == 0) {
        			vetor.add((Demais_Funcionarios)(demais.getVetorFuncionario().get(i)));
        		}
        	}
        	
		}
        
        A.setFuncionario(vetor.get(0));
    	
    }
    
    /**
     * Método removeDados(). Remove os Demais_Funcionarios selecionados.
     * */
    
    public void removeDados() {
    	DadosFuncionarios demais = new DadosFuncionarios();
        
        for(int i = 0; i < selecionados.size(); i++) {
        	for(int j = 0; j< demais.tamanho(); j++) {
        		if(selecionados.get(i).compareTo(demais.getVetorFuncionario().get(i).getNome()) == 0) {
        			demais.excluir(demais.getVetorFuncionario().get(i).getCpf());
        		}
        	}
        	
		}
        
    }


}
