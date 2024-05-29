import java.io.Serializable;
import java.util.ArrayList;

public class DadosFuncionarios{
	
	//Atributos
	private ArrayList<Funcionario> vetorFuncionario = new ArrayList<Funcionario>();
	
	//Construtores
	public DadosFuncionarios(ArrayList<Funcionario> vetorFuncionario) {
		setVetorFuncionario(vetorFuncionario);
	}
	public DadosFuncionarios() {
		if(Persist.recuperar("Funcionarios.bin") != null)
			this.vetorFuncionario = (ArrayList<Funcionario>) Persist.recuperar("Funcionarios.bin");
	}
	
	//Setters and Getters
	public ArrayList<Funcionario> getVetorFuncionario() {
		return vetorFuncionario;
	}
	public void setVetorFuncionario(ArrayList<Funcionario> vetorFuncionario) {
		if(Persist.recuperar("Funcionarios.bin") == null) this.vetorFuncionario = vetorFuncionario;
		else{
			this.vetorFuncionario = (ArrayList<Funcionario>) Persist.recuperar("Funcionarios.bin");
			for(int i = 0; i< getVetorFuncionario().size(); i++) {
				cadastrar(vetorFuncionario.get(i));
			}
		}
		
	}
	
	
	//Métodos
	public void cadastrar(Funcionario A) {
		this.vetorFuncionario.add(A); 
		System.out.println("Total de funcionários: ");
		System.out.println(this.vetorFuncionario.size());
	}
	

	public Funcionario consultar(String usuario, String senha) {
		for(int i = 0; i< this.getVetorFuncionario().size(); i++) {
			if(usuario.equals(this.getVetorFuncionario().get(i).getUsuario()) && senha.equals(this.getVetorFuncionario().get(i).getUsuario())) return this.getVetorFuncionario().get(i);
		}
		return null;
	}
	
	public int tamanho() {
		System.out.println("Total de funcionários: ");
		System.out.println( this.vetorFuncionario.size());
		return this.vetorFuncionario.size();
	}
	
	public boolean excluir(String CPF) {
		for(int i = 0; i< this.getVetorFuncionario().size(); i++) {
			if(CPF.equals(this.getVetorFuncionario().get(i).getCpf())) {
				this.vetorFuncionario.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean salvar() {
		boolean r = Persist.gravar(this.getVetorFuncionario(), "Funcionarios.bin");
		return r;
	}	
}
