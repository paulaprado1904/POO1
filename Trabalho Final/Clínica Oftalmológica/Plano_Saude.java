import java.io.Serializable;

public class Plano_Saude implements Serializable{
	
	//Atributos
	private String nome;
	private String CNPJ;
	private Endereco endereco;
	
	//Construtores
	public Plano_Saude(String nome, String CNPJ, Endereco endereco) {
		setNome(nome);
		setCNPJ(CNPJ);
		setEndereco(endereco);
	}
	public Plano_Saude() {
	}
	
	//Getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	
	
}
