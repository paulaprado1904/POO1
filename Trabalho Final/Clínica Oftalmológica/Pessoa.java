import java.io.Serializable;

public class Pessoa implements Serializable{
	private String nome;
	private String cpf;
	private String rg;
	private byte estadoCivil;		// 0 - solteiro, 1 - casado, 2 - divorciado
	private Endereco endereco;
	
	public Pessoa(String nome, String cpf, String rg, String estadoCivil, Endereco endereco) {
		setNome(nome);
		setCpf(cpf);
		setRg(rg);
		setEstadoCivil(estadoCivil);
		setEndereco(endereco);
	}
	public Pessoa(String cpf) {
		setCpf(cpf);
	}
	public Pessoa() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(ValidaCPF.isCPF(cpf)==true) this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEstadoCivil() {
		if(estadoCivil == 0) return "Solteiro";
		else if(estadoCivil == 1) return "Casado";
		else return "Divorciado";
	}
	public void setEstadoCivil(String estadoCivil) {
		if(estadoCivil == "Solteiro") this.estadoCivil = 0;
		else if(estadoCivil == "Casado") this.estadoCivil = 1;
		else if(estadoCivil == "Divorciado") this.estadoCivil = 2;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

}
