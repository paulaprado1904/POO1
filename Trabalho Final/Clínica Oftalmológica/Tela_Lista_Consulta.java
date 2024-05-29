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

public class Tela_Lista_Consulta extends JFrame {

	private JList<String> listaConsulta;
	private List<String> selecionados;
	private ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	
	/**
	 * Essa Classe é responsável por listar todos as consultas cadastradas.
	 * E remover as consultas selecionadas.
	 * */
	

	public Tela_Lista_Consulta() {
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        DadosConsultas consulta = new DadosConsultas();
        
        for(int i = 0; i < consulta.tamanho(); i++) {
        	Consulta A = consulta.getVetorConsulta().get(i);
        	consultas.add(A);
        	listModel.addElement(exibeDados(A));
		}
 
        //create the list
        listaConsulta = new JList<>(listModel);
        listaConsulta.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    final List<String> selectedValuesList = listaConsulta.getSelectedValuesList();
                    selecionados = selectedValuesList;
                    System.out.println(selectedValuesList);
                }
            }
        });
        getContentPane().setLayout(null);
 
        JScrollPane scrollPane = new JScrollPane(listaConsulta);
        scrollPane.setBounds(0, 0, 325, 170);
        getContentPane().add(scrollPane);
        
        
        /**
         * Note que o botão salvar chama o método removeDados();
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
        this.setTitle("Lista de Consultas");
        this.setSize(329, 200);
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
	
	public String exibeDados(Consulta A) {
		String dados = "Dia: " +A.getData().getDay() + "/" + A.getData().getMonth() + "/" + A.getData().getYear()
				+ "\nHora: " + A.getHora().getHour() + ":" + A.getHora().getMinute() + ":" + A.getHora().getSecond();
		
		return dados;
	}
    
    /**
     * Método removeDados(). Remove as Consultas selecionadas.
     * */
    public void removeDados() {
    	DadosConsultas dados = new DadosConsultas();
        
        for(int i = 0; i < consultas.size(); i++) {
        	for(int j = 0; j< dados.tamanho(); j++) {
        		if(consultas.get(i).equals(dados.getVetorConsulta().get(i))) {
        			dados.excluir(dados.getVetorConsulta().get(i).getData(), dados.getVetorConsulta().get(i).getHora());
        		}
        	}
        	
		}
    	
    }

}
