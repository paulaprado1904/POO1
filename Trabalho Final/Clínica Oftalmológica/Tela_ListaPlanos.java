import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;

public class Tela_ListaPlanos extends JFrame {

	private JList<String> listaPlanos;
	private List<String> selecionados;
	
	/**
	 * Essa Classe é responsável por listar todos os planos de saúde cadastrados
	 * Note que ela possui dois construtores.
	 * Num deles ela recebe como parâmetro um Object,
	 * isso nos auxilia a definir os planos de saude das classes Médico e PacientecomPlano.
	 * Além de, indicar qual Plano deve ser removido.
	 * 
	 * */

	/**
	 * Usamos o construtor padrão para remover Dados
	 * */
	public Tela_ListaPlanos() {
      
        DefaultListModel<String> listModel = new DefaultListModel<>();
        DadosPlanos planos = new DadosPlanos();
        
        for(int i = 0; i < planos.tamanho(); i++) {
        	listModel.addElement(planos.getVetorPlano().get(i).getNome());
		}
 
        //create the list
        listaPlanos = new JList<>(listModel);
        listaPlanos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = listaPlanos.getSelectedValuesList();
                    selecionados = selectedValuesList;
                    System.out.println(selectedValuesList);
                }
            }
        });
        getContentPane().setLayout(null);
 
        JScrollPane scrollPane = new JScrollPane(listaPlanos);
        scrollPane.setBounds(0, 0, 387, 170);
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
        this.setTitle("Lista de Planos de Saúde");
        this.setSize(399, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
	
	/**
	 * Usamos o segundo construtor para setar os valores de Médico e Paciente com Plano
	 * 
	 * */
	
	public Tela_ListaPlanos(Object A) {
	      
        DefaultListModel<String> listModel = new DefaultListModel<>();
        DadosPlanos planos = new DadosPlanos();
        
        for(int i = 0; i < planos.tamanho(); i++) {
        	listModel.addElement(planos.getVetorPlano().get(i).getNome());
		}
 
        //create the list
        listaPlanos = new JList<>(listModel);
        listaPlanos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = listaPlanos.getSelectedValuesList();
                    selecionados = selectedValuesList;
                    System.out.println(selectedValuesList);
                }
            }
        });
        getContentPane().setLayout(null);
 
        JScrollPane scrollPane = new JScrollPane(listaPlanos);
        scrollPane.setBounds(0, 0, 190, 170);
        getContentPane().add(scrollPane);
        
        /**
         * Note que o botão salvar chama o método coletaDados();
         * */
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
        this.setTitle("Lista de Planos de Saúde");
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
	
	/**
	 * Método Main
	 * */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tela_ListaPlanos();
            }
        });
    }
    /***
     * Método coletaDados(). Aqui ele recebe um Object e seta ele conforme a sua classe.
     * 
     * */
    public void coletaDados(Object A) {
    	DadosPlanos planos = new DadosPlanos();
    	
    	ArrayList<Plano_Saude> vetor = new ArrayList<Plano_Saude>();
        
        for(int i = 0; i < selecionados.size(); i++) {
        	for(int j = 0; j< planos.tamanho(); j++) {
        		if(selecionados.get(i).compareTo(planos.getVetorPlano().get(i).getNome()) == 0) {
        			vetor.add(planos.getVetorPlano().get(i));
        		}
        	}
        	
		}
        
        if(A instanceof Medico) {
        	((Medico) A).setPlano(vetor);
        }
        else if(A instanceof PacientecomPlano) {
        	((PacientecomPlano) A).setPlano(vetor.get(0));
        }
    }
    
    /**
     * Método removeDados(). Remove os Planos de Saúde selecionados.
     * */
    
    public void removeDados() {
    	DadosPlanos planos = new DadosPlanos();
    	
        for(int i = 0; i < selecionados.size(); i++) {
        	for(int j = 0; j< planos.tamanho(); j++) {
        		if(selecionados.get(i).compareTo(planos.getVetorPlano().get(i).getNome()) == 0) {
        			planos.excluir(planos.getVetorPlano().get(i).getCNPJ());
        		}
        	}
        	
		}
        
    }

}
