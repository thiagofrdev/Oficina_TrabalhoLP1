package entidades;

import enums.Status;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrdemServico {
	private int id;
	private LocalDate data;
	private double valorPecas;
	private double valorMaoDeObra;
	private Veiculo veiculo;
	private String descricaoMaoObra;
	private static int geradorId;
	private Status status;

	DateTimeFormatter formatoSaida = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");

	public OrdemServico(LocalDate data, double valorPecas, double valorMaoDeObra, Veiculo veiculo, String descricaoMaoObra,
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
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
		StringBuilder sb = new StringBuilder();
    sb.append("=====================================================\n")
      .append("|                 ORDEM DE SERVIÇO                  |\n")
      .append("=====================================================\n")
      .append(String.format("| %-23s: %-24s |\n", "ID", id))
      .append(String.format("| %-23s: %-24s |\n", "Data", data.format(formatoSaida)))
      .append(String.format("| %-23s: R$%-22.2f |\n", "Valor de peças", valorPecas))
      .append(String.format("| %-23s: R$%-22.2f |\n", "Valor de mão de obra", valorMaoDeObra))
      .append(String.format("| %-23s: %-24s |\n", "Placa do veículo", veiculo.getPlaca()))
      .append(String.format("| %-23s: %-24s |\n", "Modelo do veículo", veiculo.getModelo()))
      .append(String.format("| %-23s: %-24s |\n", "Cliente", veiculo.getCliente().getNome()))
      .append(String.format("| %-23s: %-24s |\n", "Descrição", descricaoMaoObra))
      .append(String.format("| %-23s: %-24s |\n", "Status", status))
      .append("=====================================================\n");

		return sb.toString();
	}
}