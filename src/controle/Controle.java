package controle;

import entidades.Cliente;
import entidades.OrdemServico;
import entidades.Veiculo;
import enums.Status;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controle {
	Scanner scan = new Scanner(System.in);
	private List<OrdemServico> ordens = new ArrayList<>();
	private List<Veiculo> veiculos = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();

	public void criarOS(LocalDate data, double valorPecas, double valorMaoDeObra, Veiculo veiculo,
			String descricaoMaoObra, Status status) {
		OrdemServico os = new OrdemServico(data, valorPecas, valorMaoDeObra, veiculo, descricaoMaoObra, status);
		ordens.add(os);
		System.out.println("Ordem cadastrada!!!");
	}

	public void cadastrarVeiculo(String placa, String modelo, String nome) {
		boolean encontrarCliente = false;
		for (Cliente cliente : clientes) {
			if (cliente.getNome().equals(nome)) {
				Veiculo vc = new Veiculo(placa, modelo, cliente);
				veiculos.add(vc);
				encontrarCliente = true;
				System.out.println("Veículo cadastrado!!!");
			}
		}
		if (encontrarCliente == false) {
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
		if (veiculos.isEmpty()) {
			return "Nenhum veículo cadastrado.";
		}

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
			sb.append("ID: ").append(v.getId())
					.append(" | Placa: ").append(v.getPlaca())
					.append(" | Modelo: ").append(v.getModelo())
					.append("\n");
		}

		return sb.toString();

	}

	public String imprimirClientes() {
		for (Cliente cliente : clientes) {
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
				System.out.println("Ordem de Serviço atualizada com sucesso!");
				return;
			}
		}
		System.out.printf("Não existe uma OS com o ID %d\n", idOrdem);
	}

	public void alterarStatusOS(int idOrdem, Status status) {
		for (OrdemServico os : ordens) {
			if (os.getId() == idOrdem) {
				os.setStatus(status);
			}
		}
		System.out.println("Alteração feita com sucesso!");
	}

	public String imprimirOrdensPlaca(String placaVeiculo) {
		if (!veiculos.isEmpty()) {
			for (Veiculo vc : veiculos) {
				if (placaVeiculo.equals(vc.getPlaca())) {
					if (!ordens.isEmpty()){
						for (OrdemServico os : ordens) {
							if (os.getVeiculo().getPlaca().equals(vc.getPlaca()))
								return "Ordem encontrada: " + os.getVeiculo();
						}
					} else {
						return "Não há Ordens de Serviço cadastradas!";
					}					
				}
			}
		} else {
			return "Não há veículos cadastrados!";
		}
		return "Placa não encontrada";
	}

	public String imprimirOrdensCliente(String nomeCliente) {
		boolean encontrouCliente = false;
		boolean encontrouVeiculo = false;
		boolean encontrouOrdem = false;
		StringBuilder resultado = new StringBuilder();
		
		
		for (Cliente c : clientes) {
			if (nomeCliente.equalsIgnoreCase(c.getNome())) {
				encontrouCliente = true;				
				for (Veiculo v : veiculos) {
					if (v.getCliente() != null && nomeCliente.equalsIgnoreCase(v.getCliente().getNome())) {
						encontrouVeiculo = true;
						for (OrdemServico o : ordens) {
							if (o.getVeiculo() != null && o.getVeiculo().getPlaca().equalsIgnoreCase(v.getPlaca())) {
								resultado.append(o.toString()).append("\n");
								encontrouOrdem = true;
							}
						}
					}
				}				
				break;
			}
		}		
		
		if (!encontrouCliente) {
			resultado.append("O cliente ").append(nomeCliente).append(" não foi cadastrado!");
		} 
		
		else if (encontrouCliente && !encontrouVeiculo) {
			resultado.append("O cliente ").append(nomeCliente).append(" não possui veículos cadastrados!");
		}
		
		else if (encontrouCliente && encontrouVeiculo && !encontrouOrdem) {
			resultado.append("O cliente ").append(nomeCliente).append(" não possui ordens de serviço cadastradas!");
		}
		
		return resultado.toString();
	}
	


	public String imprimirVeiculosCliente(String nomeCliente) {
		boolean econtrouVeiculo = false;
		boolean encontrouCliente = false;
		for (Cliente c : clientes) {
			if (nomeCliente.equalsIgnoreCase(c.getNome())) {
				encontrouCliente = true;
				for (Veiculo v : veiculos) {
					if (nomeCliente.equalsIgnoreCase(v.getCliente().getNome())) {
						System.out.println(v);
						econtrouVeiculo = true;
					}

				}
				if (econtrouVeiculo == false) {
					System.out.println("O cliente " + nomeCliente + " não possui veículos cadastrados!");

				}

			}
		}

		if (encontrouCliente == false) {
			System.out.println("O cliente " + nomeCliente + " não foi cadastrado!");
		}

		return "";
	}

	public String imprimirOrdensStatus(String status) {
		try {			
			Status statusenum = Status.valueOf(status.toUpperCase().replace(" ", ""));
			boolean encontrouStatus = false;
			for (OrdemServico o : ordens) {
				if (statusenum == o.getStatus()) {
					System.out.println(o);
					encontrouStatus = true;
				}
			}
			if (encontrouStatus == false) {
				System.out.println("Não há nenhuma ordem [" + statusenum + "] no momento!");
			}
		} catch (IllegalArgumentException e) {
			return "Status " + status + " inválido.";
		}
		return "";
	}

	public OrdemServico imprimirOrdensId(int idOrdem) {
		for (OrdemServico os : ordens) {
			if (os.getId() == idOrdem) {
				System.out.println(os);
				return os;
			}
		}
		System.out.printf("Não existe uma OS com o ID %d\n", idOrdem);
		return null;
	}

	public String imprimirOrdensPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		StringBuilder resultado = new StringBuilder();
		boolean encontrou = false;
	
		for (OrdemServico o : ordens) {
			LocalDate dataOrdem = o.getData();
	
			if ((dataOrdem.isEqual(dataInicial) || dataOrdem.isAfter(dataInicial)) &&
				(dataOrdem.isEqual(dataFinal) || dataOrdem.isBefore(dataFinal))) {
				resultado.append(o.toString()).append("\n");
				encontrou = true;
			}
		}
	
		if (!encontrou) {
			resultado.append("Nenhuma ordem encontrada no período informado.");
		}
		
		return resultado.toString();
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

	// POSSÍVEIS métodos auxiliares, conforme achem necessário:
	// private Veiculo getVeiculo(int id){
	// }
	// private Veiculo getVeiculo (String placaVeiculo){
	// }
	// private boolean veiculoEstaCadastrado(String placaVeiculo){
	// }

}
