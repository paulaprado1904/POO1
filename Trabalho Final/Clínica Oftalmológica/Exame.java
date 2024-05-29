import java.io.Serializable;

public class Exame implements Serializable{
	
	private String nome;
	
	public Exame(String nome) {
		setNome(nome);
	}
	
	public Exame() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
