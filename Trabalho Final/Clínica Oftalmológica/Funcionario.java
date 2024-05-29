import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Funcionario extends Pessoa implements Serializable{
	
	//Atributos
	private Date admissão;
	private int carteira;
	private String usuario;
	private String senha;
	
	//Construtores
	public Funcionario(String nome, String cpf, String rg, String estadoCivil, Endereco endereco, Date admissão, int carteira, String usuario, String senha){
		super(nome,cpf,rg,estadoCivil, endereco);
		setAdmissão(admissão);
		setCarteira(carteira);
		setUsuario(usuario);
		setSenha(senha);
	}
	public Funcionario(String cpf) {
		super(cpf);
	}
	public Funcionario() {
	}

	// Getters and Setters
	public Date getAdmissão() {
		return admissão;
	}

	public void setAdmissão(Date admissão){
		this.admissão = admissão;
	}

	public int getCarteira() {
		return carteira;
	}

	public void setCarteira(int carteira) {
		if(carteira > 0)this.carteira = carteira;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	// Métodos
	public abstract double calculaSalario();
	
	public abstract boolean determinaFerias(Date data);
}
