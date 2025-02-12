package entidades;

import java.util.Date;
import enums.Status;

public class OrdemServico {
	private int id;
	private Date data;
	private double valorPecas;
	private double valorMaoDeObra;
	private Veiculo veiculo;
	private String descricaoMaoObra;
	private static int geradorId;
	private Status status;

	public OrdemServico(Date data, double valorPecas, double valorMaoDeObra, Veiculo veiculo, String descricaoMaoObra,
			Status status) {
		geradorId++;
		this.id = geradorId;
		this.data = data;
		this.valorPecas = valorPecas;
		this.valorMaoDeObra = valorMaoDeObra;
		this.veiculo = veiculo;
		this.descricaoMaoObra = descricaoMaoObra;
		this.status = status;
	}

	public double getValorTotal() {
		return valorPecas + valorMaoDeObra;
	}

	public int getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorPecas() {
		return valorPecas;
	}

	public void setValorPecas(double valorPecas) {
		this.valorPecas = valorPecas;
	}

	public double getValorMaoDeObra() {
		return valorMaoDeObra;
	}

	public void setValorMaoDeObra(double valorMaoDeObra) {
		this.valorMaoDeObra = valorMaoDeObra;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getDescricaoMaoObra() {
		return descricaoMaoObra;
	}

	public void setDescricaoMaoObra(String descricaoMaoObra) {
		this.descricaoMaoObra = descricaoMaoObra;
	}

	public static int getGeradorId() {
		return geradorId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String toString() {
		return "ID: " + id
			+ "\nData: " + data
			+ "\nValor de peças: R$" + valorPecas
			+ "\nValor de mão de obra: R$" + valorMaoDeObra
			+ "\nVeículo (placa): " + veiculo.getPlaca()
			+ "\nVeículo (modelo): " + veiculo.getModelo()
			+ "\nCliente: " + veiculo.getCliente().getNome()
			+ "\nDescrição da mão de obra: " + descricaoMaoObra
			+ "\nStatus: " + status
			+ "\n";
	}

}
