import java.io.Serializable;

public class Endereco implements Serializable{
	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private int cep;
	private String complemento;
	
	public Endereco(String logradouro, int numero, String bairro, String cidade, int cep, String complemento) {
		setLogradouro(logradouro);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setComplemento(complemento);
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		if(numero > 0) this.numero = numero;
		else this.numero = 0;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		if(cep > 0) this.cep = cep;
		else this.cep = 0;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
