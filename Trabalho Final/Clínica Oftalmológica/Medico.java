import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Medico extends Funcionario implements Serializable {
	
	//Atributos
	private String CRM;
	private String especialidade;
	private double SomaConsultasMes; // É a soma de todas as consultas realizadas
	private ArrayList<Plano_Saude> plano = new ArrayList<Plano_Saude>();
	
	//Construtores
	public Medico(String nome, String cpf, String rg, String estadoCivil,Endereco endereco, Date admissão, int carteira, String usuario, String senha, String CRM, String especialidade, double SomaConsultaMes, ArrayList<Plano_Saude> plano){
		super(nome,cpf,rg,estadoCivil,endereco, admissão,carteira,usuario,senha);
		setCRM(CRM);
		setEspecialidade(especialidade);
		setSomaConsultasMes(SomaConsultaMes);
		setPlano(plano);
	}
	
	public Medico(String nome, String cpf, String rg, String estadoCivil,Endereco endereco, Date admissão, int carteira, String usuario, String senha, String CRM, String especialidade, double SomaConsultaMes){
		super(nome,cpf,rg,estadoCivil,endereco, admissão,carteira,usuario,senha);
		setCRM(CRM);
		setEspecialidade(especialidade);
		setSomaConsultasMes(SomaConsultaMes);
	}
	
	//Construtor com planos de saude e cpf
	public Medico(ArrayList<Plano_Saude> plano, String cpf) {
		super(cpf);
		setPlano(plano);
	}
	
	public Medico() {
		
	}

	//Getters and Setters
	public String getCRM() {
		return CRM;
	}

	public void setCRM(String cRM) {
		CRM = cRM;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public double getSomaConsultasMes() {
		return SomaConsultasMes;
	}

	public void setSomaConsultasMes(double somaConsultasMes) {
		if(somaConsultasMes >= 0) SomaConsultasMes = somaConsultasMes;
	}

	public ArrayList<Plano_Saude> getPlano() {
		return plano;
	}

	public void setPlano(ArrayList<Plano_Saude> plano) {
		this.plano = plano;
	}
	
	//Métodos
	public void adicionaSomaConsulta(double valor) {
		if(valor >= 0) setSomaConsultasMes(getSomaConsultasMes() + valor);
	}
	
	public void zerarSomaConsulta() {
		setSomaConsultasMes(0);
	}

	public double calculaSalario() {
		return getSomaConsultasMes();
	}

	public boolean determinaFerias(Date data) {
		@SuppressWarnings("deprecation")
		int mes = data.getMonth();
		if(mes == 12) return true;
		else return false;
	}


	
	
	
	
	

}
