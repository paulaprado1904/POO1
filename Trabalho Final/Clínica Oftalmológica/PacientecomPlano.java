import java.io.Serializable;
import java.util.Date;

public class PacientecomPlano extends Paciente implements Serializable{
	private int nroCarteira;
	private Date ingresso;
	private boolean carencia;
	private Plano_Saude plano;
	
	public PacientecomPlano(String nome, String cpf, String rg, String estadoCivil, Endereco endereco, String sexo, Date nascimento, Date cadastro, Date ultimaConsulta, int nroCarteira, Date ingresso, boolean carencia, Plano_Saude plano) {
		super(nome,cpf,rg,estadoCivil,endereco,sexo,nascimento,cadastro,ultimaConsulta);
		setNroCarteira(nroCarteira);
		setIngresso(ingresso);
		setCarencia(carencia);
		setPlano(plano);
	}
	public PacientecomPlano(Paciente p, int nroCarteira, Date ingresso, boolean carencia) {
		super(p);
		setNroCarteira(nroCarteira);
		setIngresso(ingresso);
		setCarencia(carencia);
	}
	public PacientecomPlano() {

	}

	public int getNroCarteira() {
		return nroCarteira;
	}

	public void setNroCarteira(int nroCarteira) {
		if(nroCarteira > 0) this.nroCarteira = nroCarteira;
	}

	public Date getIngresso() {
		return ingresso;
	}

	public void setIngresso(Date ingresso) {
		this.ingresso = ingresso;
	}

	public boolean isCarencia() {
		return carencia;
	}

	public void setCarencia(boolean carencia) {
		this.carencia = carencia;
	}

	public Plano_Saude getPlano() {
		return plano;
	}

	public void setPlano(Plano_Saude plano) {
		this.plano = plano;
	}
	
	

}
