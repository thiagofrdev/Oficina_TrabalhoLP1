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

	public void criarOS(Date data, double valorPecas, double valorMaoDeObra, Veiculo veiculo, String descricaoMaoObra, Status status) {
		OrdemServico os = new OrdemServico(data, valorPecas, valorMaoDeObra, veiculo, descricaoMaoObra, status);
		ordens.add(os);
		System.out.println("Ordem cadastrada!!!");
	}

	public void cadastrarVeiculo(String placa, String modelo, String nome) {		
		boolean encontrarCliente = false;
		for(Cliente cliente:clientes) {			
			if(cliente.getNome().equals(nome)) {
				Veiculo vc = new Veiculo(placa, modelo, cliente);
				veiculos.add(vc);
				encontrarCliente = true;					
				System.out.println("Veículo cadastrado!!!");
			}			
		}	
		if(encontrarCliente == false) {
			System.out.printf("Não foi encontrado nenhum cliente chamado '%s'", nome);
		}		
	}

	public void cadastrarCliente(String nome) {
		if (getCliente(nome) == null) {
			Cliente cl = new Cliente(nome);
			clientes.add(cl);
			System.out.println("Cliente cadastrado!!!");
		} else {
			System.out.printf("Já existe um cliente chamado '%s'\n", nome);
		}
		
	}

	public String imprimirOrdens() {
		for (OrdemServico os : ordens) {
			System.out.println(os);
		}
		return null;
	}

	public String imprimirVeiculos() {
		if (veiculos.isEmpty()) {
			return "Nenhum veículo cadastrado.";
		}
	
		StringBuilder sb = new StringBuilder();
		sb.append("===== Lista de Veículos Cadastrados =====\n");
		
		for (Veiculo v : veiculos) {
			sb.append(v.toString()).append("\n");
		}
	
		return sb.toString();
		
    }
	

	public String imprimirClientes() {
		for (Cliente cliente:clientes) {
			System.out.println(cliente);
		}
		return null;
	}

	public void alterarValoresOS(int idOrdem, double valorPecas, double valorMaoDeObra, String descricao) {
		for (OrdemServico os : ordens) {
			if (os.getId() == idOrdem) {
				os.setValorPecas(valorPecas);
				os.setValorMaoDeObra(valorMaoDeObra);
				os.setDescricaoMaoObra(descricao);
				System.out.println("Ordem de serviço atualizada com sucesso!");
				return; 
			}
		}
		System.out.println("Ordem de serviço não encontrada com o ID fornecido.");
	}

	public void alterarStatusOS(int idOrdem, Status status) {
		for (OrdemServico os : ordens){
			if (os.getId() == idOrdem) {
				os.setStatus(status);
			}
		}
	}

	public String imprimirOrdensPlaca(String placaVeiculo) {
		for (Veiculo vc : veiculos){
			if(vc.getPlaca() == placaVeiculo){
				for (OrdemServico os : ordens){
					if (os.getVeiculo() == vc)
						return "Ordem encontrada: " + os.getVeiculo();
				}
			} else {
				return "Placa não encontrada";
			}
		}
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

	public OrdemServico imprimirOrdensId(int idOrdem) {
		for (OrdemServico os : ordens){
			if (os.getId() == idOrdem) {
				System.out.println(os);
				return os;
			}
		}
		System.out.printf("Não existe uma OS com o ID %d\n", idOrdem);
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

	public Cliente getCliente(String nomeCliente) {
		for (Cliente c : clientes) {
			if (c.getNome().equals(nomeCliente)) {
				return c;
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
