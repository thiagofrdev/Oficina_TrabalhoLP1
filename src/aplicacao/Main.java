package aplicacao;

import controle.Controle;
import entidades.OrdemServico;
import enums.Status;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controle oficina = new Controle();
		DateTimeFormatter formato =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

		
		int resp;
		do {
			System.out.print("""
					========================================================================================
									       MENU OFICINA
					========================================================================================
					   (0) Sair
					   (1) Criar ordem de serviço
					   (2) Cadastrar cliente
					   (3) Cadastrar veículo
					   (4) Imprimir todos os clientes cadastrados
					   (5) Imprimir todos os veículos cadastrados
					   (6) Imprimir todas as ordens de serviço
					   (7) Alterar uma OS informando valor das peças, descrição e valor da mão de obra
					   (8) Alterar o status de uma OS informando o ID e o status
					   (9) Imprimir ordens de serviço informando a placa do carro
					   (10) Imprimir ordens de serviço informando o nome do cliente
					   (11) Imprimir os veículos de um cliente
					   (12) Imprimir as ordens de serviço por status
					   (13) Imprimir ordens de serviço de um período

						""");
			System.out.println();
			System.out.print("O que deseja? ");
			resp = sc.nextInt();

			switch (resp) {
				case 0:
					System.out.println("Saindo do sistema...");
					break;
				case 1:
					System.out.println("Criar ordem de serviço");
					System.out.print("Valor das peças (XXX,XX): ");
					double valorPecas = sc.nextDouble();
					System.out.print("Valor da mão de obra (XXX,XX): ");
					double valorMaoDeObra = sc.nextDouble();
					sc.nextLine();
					System.out.print("Placa do veículo: ");
					String placa = sc.nextLine();
					if (oficina.getVeiculo(placa) != null) {
						System.out.print("Descrição da mão de obra: ");
						String descricao = sc.nextLine();
						System.out.print("Status (1-ABERTA, 2-EM_ANDAMENTO, 3-CONCLUIDA): ");
						int statusInt = sc.nextInt();
						sc.nextLine();
						Status status = statusInt == 1 ? Status.ABERTA
								: statusInt == 2 ? Status.EMANDAMENTO : Status.CONCLUIDA;

						LocalDate data = null;
						boolean dataValida = false;
						do {
							System.out.print("Digite a data (DD/MM/AAAA): ");
							String dataInserida = sc.next();
							try {
								data = LocalDate.parse(dataInserida, formato);
								dataValida = true; 
							} catch (DateTimeParseException e) {
								System.out.println("Formato de data inválido. Tente novamente!");
							}
						} while (!dataValida);

						oficina.criarOS(data, valorPecas, valorMaoDeObra, oficina.getVeiculo(placa), descricao, status);
						OrdemServico os = oficina.imprimirOrdensId(OrdemServico.getGeradorId());
						System.out.println("Ordem de serviço criada com sucesso:");
						System.out.println(os.toString());
						break;
					} else {
						System.out.printf("Não existe um veiculo cadastrado com a placa '%s'", placa);
						break;
					}
				case 2:
					System.out.println("Cadastrar cliente");
					sc.nextLine();
					System.out.print("Digite o nome do cliente: ");
					String nome = sc.nextLine();
					oficina.cadastrarCliente(nome);
					break;
				case 3:
					System.out.println("Cadastrar veículo");
					System.out.print("Digite a placa do veículo: ");
					String placa2 = sc.next();
					sc.nextLine();
					System.out.print("Digite o modelo do veículo: ");
					String modelo = sc.nextLine();
					System.out.print("Digite o nome do cliente: ");
					String nomeDoCliente = sc.nextLine();
					oficina.cadastrarVeiculo(placa2, modelo, nomeDoCliente);
					break;
				}				
			case 2:
				System.out.println("Cadastrar cliente");
				sc.nextLine();
				System.out.print("Digite o nome do cliente: ");
				String nome = sc.nextLine();
				oficina.cadastrarCliente(nome);
				break;
			case 3:
				System.out.println("Cadastrar veículo");
				System.out.print("Digite a placa do veículo: ");
				String placa2 = sc.next();
				sc.nextLine();
				System.out.print("Digite o modelo do veículo: ");
				String modelo = sc.nextLine();			
				System.out.print("Digite o nome do cliente: ");
				String nomeDoCliente = sc.nextLine();
				oficina.cadastrarVeiculo(placa2, modelo, nomeDoCliente);
				break;
			case 4:
				System.out.println("Imprimir todos os clientes cadastrados");
				oficina.imprimirClientes();
				break;
			case 5:
				System.out.println("Imprimir todos os veículos cadastrados"); 
    			System.out.println(oficina.imprimirVeiculos());
				break;
			case 6:
				System.out.println("Imprimir todas as ordens de serviço");
				oficina.imprimirOrdens();
				break;
			case 7:
				System.out.println("Alterar uma OS informando valor das peças, descrição e valor da mão de obra");
				System.out.print("ID da OS: ");
				int idOS = sc.nextInt();
    			System.out.print("Novo valor das peças (XXX,XX): ");
   				double novoValorPecas = sc.nextDouble();
    			System.out.print("Novo valor da mão de obra (XXX,XX): ");
    			double novoValorMaoDeObra = sc.nextDouble();
    			sc.nextLine();
    			System.out.print("Nova descrição da mão de obra: ");
    			String novaDescricao = sc.nextLine();
    			oficina.alterarValoresOS(idOS, novoValorPecas, novoValorMaoDeObra, novaDescricao);
				break;
			case 8:
				System.out.println("Alterar o status de OS");
				System.out.print("ID da OS: ");
				int id = sc.nextInt();

				OrdemServico os = oficina.imprimirOrdensId(id);
				if (os == null) {
					break;
				case 5:
					System.out.println("Imprimir todos os veículos cadastrados");
					System.out.println(oficina.imprimirVeiculos());
					break;
				case 6:
					System.out.println("Imprimir todas as ordens de serviço");
					oficina.imprimirOrdens();
					break;
				case 7:
					System.out.println("Alterar uma OS informando valor das peças, descrição e valor da mão de obra");
					System.out.println("Listando todas as ordens de serviço:");
    				oficina.imprimirOrdens(); 
   					System.out.print("Digite o ID da Ordem de Serviço que deseja alterar: ");
					int idOS = sc.nextInt();
					System.out.print("Novo valor das peças (XXX,XX): ");
					double novoValorPecas = sc.nextDouble();
					System.out.print("Novo valor da mão de obra (XXX,XX): ");
					double novoValorMaoDeObra = sc.nextDouble();
					sc.nextLine();
					System.out.print("Nova descrição da mão de obra: ");
					String novaDescricao = sc.nextLine();
					oficina.alterarValoresOS(idOS, novoValorPecas, novoValorMaoDeObra, novaDescricao);
					break;
				case 8:
					System.out.println("Alterar o status de OS");
					System.out.print("ID da OS: ");
					int id = sc.nextInt();

					OrdemServico os = oficina.imprimirOrdensId(id);
					if (os == null) {
						break;
					}

					System.out.print("Novo Status (1-ABERTA, 2-EM_ANDAMENTO, 3-CONCLUIDA): ");
					int novoStatusInt = sc.nextInt();
					Status novoStatus = novoStatusInt == 1 ? Status.ABERTA
							: novoStatusInt == 2 ? Status.EMANDAMENTO : Status.CONCLUIDA;

					oficina.alterarStatusOS(id, novoStatus);
					break;
				case 9:
					System.out.println("Imprimir ordens de serviço informando a placa do carro");
					System.out.println("Digite a placa do carro: ");
					String ordensPlaca = sc.nextLine();
					System.out.println(oficina.imprimirOrdensPlaca(ordensPlaca));
					break;
				case 10:
					System.out.print("Nome do cliente: ");
					sc.nextLine();
					String nomeCliente = sc.nextLine();
					System.err.println(oficina.imprimirOrdensCliente(nomeCliente));
					break;
				case 11:
					System.out.println("Imprimir os veículos de um cliente");
					oficina.imprimirClientes();
					sc.nextLine();
					System.out.print("Digite o nome do cliente que deseja consultar: ");
					String cliente = sc.nextLine();					
					System.out.println(oficina.imprimirVeiculosCliente(cliente));
					break;
				case 12:
					System.out.println("Imprimir as ordens de serviço por status");
					System.out.println("Status disponíveis: (ABERTA, EM ANDAMENTO, CONCLUIDA): ");
					sc.nextLine();					
					System.out.print("Digite o Status: ");
					String status = sc.nextLine();
					System.out.println(oficina.imprimirOrdensStatus(status));					
					break;
				case 13:
					System.out.println("Imprimir ordens de serviço de um período");
					sc.nextLine();
					System.out.print("Digite a data inicial do período (DD/MM/AAAA): ");
					LocalDate dataInicial = LocalDate.parse(sc.next(), formato);
					System.out.print("Digite a data final do período (DD/MM/AAAA): ");
					LocalDate dataFinal = LocalDate.parse(sc.next(), formato);
					System.out.println(oficina.imprimirOrdensPeriodo(dataInicial, dataFinal));					
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}
			System.out.println();
		} while (resp != 0);

		sc.close();
	}
}
