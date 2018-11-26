package Local;

import erros.*;

public class Local {

	// Atributos da classe Local;
	private double coordenadax, coordenaday;
	private String logradouro;
	private String cidade;
	private String bairro; // opcional;

	//Construtor do objeto sem bairro;
	public Local(double x, double y, String logradouro, String cidade){
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.coordenadax = x;
		this.coordenaday = y;
		this.bairro = null;
	}

	//Construtor do objeto com bairro;
	public Local (int x, int y, String logradouro, String cidade, String bairro) {
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.coordenadax = x;
		this.coordenaday = y;
		this.bairro = bairro;
	}

	public double getCoordenadax() {
		return this.coordenadax;
	}

	public double getCoordenaday() {
		return this.coordenaday;
	}

	public void setCoordenada(double x, double y) {
		this.coordenadax = x;
		this.coordenaday = y;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
}