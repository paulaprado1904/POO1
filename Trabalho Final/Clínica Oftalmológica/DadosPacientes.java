import java.io.Serializable;
import java.util.ArrayList;

public class DadosPacientes{
	
	//Atributos
	private ArrayList<Paciente> vetorPaciente = new ArrayList<Paciente>();
	
	//Construtores
	public DadosPacientes(ArrayList<Paciente> vetorPaciente) {
		setVetorPaciente(vetorPaciente);
	}
	public DadosPacientes() {
		if(Persist.recuperar("Pacientes.bin") != null)
			this.vetorPaciente = (ArrayList<Paciente>) Persist.recuperar("Pacientes.bin");
	}
	
	//Setters and Getters
	public ArrayList<Paciente> getVetorPaciente() {
		return vetorPaciente;
	}

	public void setVetorPaciente(ArrayList<Paciente> vetorPaciente) {
		if(Persist.recuperar("Pacientes.bin") == null) this.vetorPaciente = vetorPaciente;
		else{
			this.vetorPaciente = (ArrayList<Paciente>) Persist.recuperar("Pacientes.bin");
			for(int i = 0; i< getVetorPaciente().size(); i++) {
				cadastrar(vetorPaciente.get(i));
			}
		}
	}

	public void cadastrar(Paciente A) {
		this.vetorPaciente.add(A); 
		System.out.println("Total de pacientes: ");
		System.out.println(this.vetorPaciente.size());
	}
	
	public Paciente consultar(String CPF) {
		for(int i = 0; i< this.getVetorPaciente().size(); i++) {
			if(CPF.equals(this.getVetorPaciente().get(i).getCpf())) return this.getVetorPaciente().get(i);
		}
		return null;
	}
	
	public int tamanho() {
		System.out.println("Total de pacientes: ");
		System.out.println( this.vetorPaciente.size());
		return this.vetorPaciente.size();
	}
	
	public boolean excluir(String CPF) {
		for(int i = 0; i< this.getVetorPaciente().size(); i++) {
			if(CPF.equals(this.getVetorPaciente().get(i).getCpf())) {
				this.vetorPaciente.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean salvar() {
		boolean r = Persist.gravar(this.getVetorPaciente(), "Pacientes.bin");
		return r;
	}	
	

	
}
