import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class DadosConsultas{
		//Atributos
		private ArrayList<Consulta> vetorConsulta = new ArrayList<Consulta>();
		
		//Construtores
		public DadosConsultas(ArrayList<Consulta> vetorConsulta) {
			setVetorConsulta(vetorConsulta);
		}
		public DadosConsultas() {
			if(Persist.recuperar("Consultas.bin") != null)
				this.vetorConsulta = (ArrayList<Consulta>) Persist.recuperar("Consultas.bin");
		}
		
		//Setters and Getters
		public ArrayList<Consulta> getVetorConsulta() {
			return vetorConsulta;
		}
		public void setVetorConsulta(ArrayList<Consulta> vetorConsulta) {
			if(Persist.recuperar("Consultas.bin") == null) this.vetorConsulta = vetorConsulta;
			else{
				this.vetorConsulta = (ArrayList<Consulta>) Persist.recuperar("Consultas.bin");
				for(int i = 0; i< getVetorConsulta().size(); i++) {
					cadastrar(vetorConsulta.get(i));
				}
			}
		}
		
		
		//Métodos
		public void cadastrar(Consulta A) {
			this.vetorConsulta.add(A); 
			System.out.println("Total de consultas: ");
			System.out.println(this.vetorConsulta.size());
		}
		
		public Consulta consultar(Date data, LocalTime hora) {
			for(int i = 0; i< this.getVetorConsulta().size(); i++) {
				if(data.equals(this.getVetorConsulta().get(i).getData()) && hora.equals(this.getVetorConsulta().get(i).getHora())) return this.getVetorConsulta().get(i); 
			}
			return null;
		}
		
		public int tamanho() {
			System.out.println("Total de consultas: ");
			System.out.println( this.vetorConsulta.size());
			return this.vetorConsulta.size();
		}
		
		public boolean excluir(Date data, LocalTime hora) {
			for(int i = 0; i< this.getVetorConsulta().size(); i++) {
				if(data.equals(this.getVetorConsulta().get(i).getData()) && hora.equals(this.getVetorConsulta().get(i).getHora())){
					this.getVetorConsulta().remove(i);
					return true;
				}
			}
			return false;
		}
		
		public boolean salvar() {
			boolean r = Persist.gravar(this.getVetorConsulta(), "Consultas.bin");
			return r;
		}		

}
