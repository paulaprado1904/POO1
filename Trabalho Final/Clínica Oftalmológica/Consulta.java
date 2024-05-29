import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Consulta implements Pagamento,Serializable {
	
	//Atributos
	private Date data;
	private LocalTime hora;
	private String medicamentos;
	private String sintomas;
	private String receita;
	private boolean efetua;
	private Demais_Funcionarios funcionario;
	private Medico medico;
	private Paciente paciente;
	private ArrayList<Exame> exames = new ArrayList<Exame>();
	private double valor;
	
	//Construtores
	public Consulta(Date data, LocalTime hora, String Receita, boolean efetua, Demais_Funcionarios funcionario, Medico medico, Paciente paciente, double valor) {
		setData(data);
		setHora(hora);
		setReceita(receita);
		setEfetua(efetua);
		setFuncionario(funcionario);
		setMedico(medico);
		setPaciente(paciente);
	}
	
	public Consulta(Paciente p, Medico m) {
		setMedico(medico);
		setPaciente(paciente);
	}
	
	public Consulta() {
	}
	
	//Getters and Setters
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public String getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public String getReceita() {
		return receita;
	}
	public void setReceita(String receita) {
		this.receita = receita;
	}
	public boolean isEfetua() {
		return efetua;
	}
	public void setEfetua(boolean efetua) {
		this.efetua = efetua;
	}

	public Demais_Funcionarios getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Demais_Funcionarios funcionario) {
		if(funcionario.determinaFerias(data) == false) this.funcionario = funcionario;
		else this.funcionario = null;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		if(medico.determinaFerias(data) == false) this.medico = medico;
		else this.medico = null;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public ArrayList<Exame> getExames() {
		return exames;
	}

	public void setExames(ArrayList<Exame> exames) {
		this.exames = exames;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		if(valor >= 0) this.valor = valor;
	}

	//Métodos
	public void efetuaConsulta(String medicamentos,ArrayList<Exame> exames, String sintomas) {
		setEfetua(true);
		setMedicamentos(medicamentos);
		setExames(exames);
		setSintomas(sintomas);
		paciente.setUltimaConsulta(getData());
		funcionario.adicionaConsulta();
		medico.adicionaSomaConsulta(valorPago());
	}

	public double valorPago() {
		double valor;
		if(paciente instanceof PacientecomPlano) {
			 valor = this.getValor();
			return valor;
		}
		else if(paciente instanceof PacientesemPlano) {
			valor = this.getValor() - (this.getValor() * ((PacientesemPlano)paciente).getDesconto());
			return valor;
		}
		else return 0;
	}
	
	
	

	
	
	

}
