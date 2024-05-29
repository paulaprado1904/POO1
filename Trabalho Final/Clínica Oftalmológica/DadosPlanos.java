import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class DadosPlanos{
	
	//Atributos
	private ArrayList<Plano_Saude> vetorPlano = new ArrayList<Plano_Saude>();
	
	//Construtores
	public DadosPlanos(ArrayList<Plano_Saude> vetorPlano) {
		setVetorPlano(vetorPlano);
	}
	public DadosPlanos() {
		if(Persist.recuperar("Planos.bin") != null)
			this.vetorPlano = (ArrayList<Plano_Saude>) Persist.recuperar("Planos.bin");
	}
	
	//Setters and Getters
	public ArrayList<Plano_Saude> getVetorPlano() {
		return vetorPlano;
	}
	public void setVetorPlano(ArrayList<Plano_Saude> vetorPlano) {
		if(Persist.recuperar("Planos.bin") == null) this.vetorPlano = vetorPlano;
		else{
			this.vetorPlano = (ArrayList<Plano_Saude>) Persist.recuperar("Planos.bin");
			for(int i = 0; i< getVetorPlano().size(); i++) {
				cadastrar(vetorPlano.get(i));
			}
		}
		
	}
	
	
	//Métodos
	public void cadastrar(Plano_Saude A) {
		this.vetorPlano.add(A); 
		System.out.println("Total de planos: ");
		System.out.println(this.vetorPlano.size());
	}
	
	public int tamanho() {
		System.out.println("Total de planos: ");
		System.out.println( this.vetorPlano.size());
		return this.vetorPlano.size();
	}

	public Plano_Saude consultar(String CNPJ) {
		for(int i = 0; i< this.getVetorPlano().size(); i++) {
			if(CNPJ.equals(this.getVetorPlano().get(i).getCNPJ())) return this.getVetorPlano().get(i); 
		}
		return null;
	}
	
	public boolean excluir(String CNPJ){
		for(int i = 0; i< this.getVetorPlano().size(); i++) {
			if(CNPJ.equals(this.getVetorPlano().get(i).getCNPJ())){
				this.getVetorPlano().remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean salvar() {
		boolean r = Persist.gravar(this.getVetorPlano(), "Planos.bin");
		return r;
	}	
}
