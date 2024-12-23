package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import entidades.Cliente;
import entidades.OrdemServico;
import entidades.Veiculo;
import enums.Status;

public class Controle {
	Scanner scan = new Scanner(System.in);
	private List<OrdemServico> ordens = new ArrayList<>();
	private List<Veiculo> veiculos = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();

	public void criarOS(Date data, double valorPecas, double valorMaoDeObra, Veiculo veiculo, String descricaoMaoObra,
			Status status) {

		OrdemServico os = new OrdemServico(data, valorPecas, valorMaoDeObra, veiculo, descricaoMaoObra, status);
		ordens.add(os);
	}

	public void cadastrarVeiculo(String placa, String modelo, Cliente cliente) {
	}

	public void cadastrarCliente(String nome) {
		Cliente cl = new Cliente(nome);
		clientes.add(cl);
	}

	public String imprimirOrdens() {
		for (OrdemServico os : ordens) {
			System.out.println(os);
		}
		return null;
	}

	public String imprimirVeiculos() {
		return null;
	}

	public String imprimirClientes() {
		for (Cliente cliente:clientes) {
			System.out.println(cliente);
		}
		return null;
	}

	public void alterarValoresOS(int idOrdem, double valorPecas, double valorMaoDeObra, String descricao) {
	
	}

	public void alterarStatusOS(int idOrdem, String status) {
	
	}

	public String imprimirOrdensPlaca(String placaVeiculo) {
	
		return null;
	}

	public String imprimirOrdensCliente(String nomeCliente) {
	
		return null;
	}

	public String imprimirVeiculosCliente(String nomeCliente) {
	
		return null;
	}

	public String imprimirOrdensStatus(String status) {
	
		return null;
	}

	public String imprimirOrdensPeriodo(String dataInicial, String dataFinal) {

		return null;
	}

	public Veiculo getVeiculo(String placaVeiculo) {
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getPlaca().equalsIgnoreCase(placaVeiculo)) {
				return veiculo;
			}
		}
		return null;
	}

//POSSÍVEIS métodos auxiliares, conforme achem necessário:
//	private Veiculo getVeiculo(int id){
//	}
//	private Veiculo getVeiculo (String placaVeiculo){
//	}
//	private boolean veiculoEstaCadastrado(String placaVeiculo){
//	}

}
