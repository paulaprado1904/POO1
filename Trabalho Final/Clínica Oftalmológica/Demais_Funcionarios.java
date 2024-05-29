import java.util.Date;
import java.io.Serializable;

public class Demais_Funcionarios extends Funcionario implements Serializable{
	
	//Atributos
	private String cargo;
	private double salarioBase;
	private static int nroConsultas;
	private static int limiteConsultas;
	private static double gratificacao;
	
	//Construtores
	public Demais_Funcionarios(String nome, String cpf, String rg, String estadoCivil, Endereco endereco, Date admissão, int carteira, String usuario, String senha, String cargo, double salarioBase, int nroConsultas, int limiteConsultas, double gratificacao){
		super(nome,cpf,rg,estadoCivil,endereco, admissão,carteira,usuario,senha);
		setCargo(cargo);
		setSalarioBase(salarioBase);
		setNroConsultas(nroConsultas);
		setLimiteConsultas(limiteConsultas);
		setGratificacao(gratificacao);
	}
	
	//Construtores
	public Demais_Funcionarios(){
	}
	
	//Getters and Setters
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		if(salarioBase >= 0) this.salarioBase = salarioBase;
	}
	public static double getGratificacao() {
		return gratificacao;
	}
	public static void setGratificacao(double gratificacao) {
		if(gratificacao >= 0) Demais_Funcionarios.gratificacao = gratificacao;
	}
	public static int getNroConsultas() {
		return nroConsultas;
	}
	public static void setNroConsultas(int nroConsultas) {
		if(nroConsultas >= 0)Demais_Funcionarios.nroConsultas = nroConsultas;
	}
	public static int getLimiteConsultas() {
		return limiteConsultas;
	}
	public static void setLimiteConsultas(int limiteConsultas) {
		if(limiteConsultas>=0)Demais_Funcionarios.limiteConsultas = limiteConsultas;
	}
	
	public void adicionaConsulta() {
		setNroConsultas(getNroConsultas() + 1);
	}
	
	//Métodos
	public double calculaSalario() {
		if(Demais_Funcionarios.getNroConsultas() >= Demais_Funcionarios.getLimiteConsultas()) {
			return salarioBase + gratificacao;
		}
		else return salarioBase;
	}

	public boolean determinaFerias(Date data) {
		int mes = data.getMonth();
		int ano = data.getYear();
		int admissão = this.getAdmissão().getYear();
		if(mes == 12 && (ano - admissão > 1)) return true;
		else return false;
	}
	
	
}
