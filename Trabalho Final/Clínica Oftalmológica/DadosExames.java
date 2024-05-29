import java.io.Serializable;
import java.util.ArrayList;

public class DadosExames{
	
	//Atributos
	private ArrayList<Exame> vetorExame = new ArrayList<Exame>();

	//Construtores
	public DadosExames(ArrayList<Exame> vetorExame) {
		setVetorExame(vetorExame);
	}
	
	public DadosExames() {
		if(Persist.recuperar("Exames.bin") != null)
			this.vetorExame = (ArrayList<Exame>) Persist.recuperar("Exames.bin");
	}
	
	//Getters and Setters
	public ArrayList<Exame> getVetorExame() {
		return vetorExame;
	}

	public void setVetorExame(ArrayList<Exame> vetorExame) {
		if(Persist.recuperar("Exames.bin") == null) this.vetorExame = vetorExame;
		else{
			this.vetorExame = (ArrayList<Exame>) Persist.recuperar("Exames.bin");
			for(int i = 0; i< getVetorExame().size(); i++) {
				cadastrar(vetorExame.get(i));
			}
		}
	}
	
	//Métodos
	public void cadastrar(Exame A) {
		this.vetorExame.add(A); 
		System.out.println("Total de exames: ");
		System.out.println(this.vetorExame.size());
	}
	
	public Exame consultar(String nome) {
		for(int i = 0; i< this.getVetorExame().size(); i++) {
			if(nome.equals(this.getVetorExame().get(i).getNome())) return this.getVetorExame().get(i);
		}
		return null;
	}
	
	public int tamanho() {
		System.out.println("Total de exames: ");
		System.out.println( this.vetorExame.size());
		return this.vetorExame.size();
	}
	
	public boolean excluir(String nome) {
		for(int i = 0; i< this.getVetorExame().size(); i++) {
			if(nome.equals(this.getVetorExame().get(i).getNome())) {
				this.vetorExame.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean salvar() {
		boolean r = Persist.gravar(this.getVetorExame(), "Exames.bin");
		return r;
	}	
	
	
	
	
}
