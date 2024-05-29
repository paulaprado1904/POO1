import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Paciente extends Pessoa implements Serializable{
	
	private String sexo;
	private Date nascimento;
	private Date cadastro;
	private Date ultimaConsulta;

	public Paciente(String nome, String cpf, String rg, String estadoCivil, Endereco endereco, String sexo, Date nascimento, Date cadastro, Date ultimaConsulta) {
		super(nome, cpf, rg, estadoCivil, endereco);
		setSexo(sexo);
		setNascimento(nascimento);
		setCadastro(cadastro);
		setUltimaConsulta(ultimaConsulta);
	}
	
	public Paciente(Paciente p) {
		super(p.getNome(), p.getCpf(), p.getRg(), p.getEstadoCivil(), p.getEndereco());
		setSexo(p.getSexo());
		setNascimento(p.getNascimento());
		setCadastro(p.getCadastro());
		setUltimaConsulta(p.getUltimaConsulta());
	}
	public Paciente() {
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public Date getUltimaConsulta() {
		return ultimaConsulta;
	}

	public void setUltimaConsulta(Date ultimaConsulta) {
		this.ultimaConsulta = ultimaConsulta;
	}	
	
	
}
