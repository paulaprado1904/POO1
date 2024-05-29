import java.io.Serializable;
import java.util.Date;

public class PacientesemPlano extends Paciente implements Serializable{
	
	//Atributo
	private double desconto;
	
	//Construtores
	public PacientesemPlano(String nome, String cpf, String rg, String estadoCivil, Endereco endereco,String sexo, Date nascimento, Date cadastro, Date ultimaConsulta, double desconto) {
		super(nome,cpf,rg,estadoCivil,endereco,sexo,nascimento,cadastro,ultimaConsulta);
		setDesconto(desconto);
		
	}
	public PacientesemPlano() {
		
	}
	
	public PacientesemPlano(Paciente p, double desconto) {
		super(p.getNome(),p.getCpf(),p.getRg(),p.getEstadoCivil(),p.getEndereco(),p.getSexo(),p.getNascimento(),p.getCadastro(),p.getUltimaConsulta());
		setDesconto(desconto);
		
	}

	//Getters and Setters
	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	

}
