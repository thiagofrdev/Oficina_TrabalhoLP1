package aplicacao;

import java.util.Date;
import java.util.Scanner;

import controle.Controle;
import entidades.OrdemServico;
import enums.Status;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controle oficina = new Controle();

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
					   (5) Imprimir todos os veículos cadastrados"
					   (6) Imprimir todas as ordens de serviço"
					   (7) Alterar uma OS informando valor das peças, descrição e valor da mão de obra"
					   (8) Alterar o status de uma OS informando o ID e o status"
					   (9) Imprimir ordens de serviço informando a placa do carro"
					  (10) Imprimir ordens de serviço informando o nome do cliente"
					  (11) Imprimir os veículos de um cliente"
					  (12) Imprimir as ordens de serviço por status"
					  (13) Imprimir ordens de serviço de um períod"

						""");
			System.out.println();
			System.out.println("O que deseja? ");
			resp = sc.nextInt();

			switch (resp) {
			case 0:
				System.out.println("Saindo do sistema...");
				break;
			case 1:
				System.out.println("Criar ordem de serviço");
				System.out.print("Valor das peças: ");
				double valorPecas = sc.nextDouble();
				System.out.print("Valor da mão de obra: ");
				double valorMaoDeObra = sc.nextDouble();
				sc.nextLine();
				System.out.print("Placa do veículo: ");
				String placa = sc.nextLine();
				System.out.print("Descrição da mão de obra: ");
				String descricao = sc.nextLine();
				System.out.print("Status (1-ABERTA, 2-EM_ANDAMENTO, 3-CONCLUIDA): ");
				int statusInt = sc.nextInt();
				sc.nextLine();
				Status status = statusInt == 1 ? Status.ABERTA
						: statusInt == 2 ? Status.EMANDAMENTO : Status.CONCLUIDA;

				Date data=new Date();
				oficina.criarOS(data, valorPecas, valorMaoDeObra, oficina.getVeiculo(placa), descricao, status);
				System.out.println("Ordem de Serviço cadastrada!!!");
				break;
			case 2:
				System.out.println("Cadastrar cliente");
				sc.nextLine();
				System.out.print("Digite o nome do cliente: ");
				String nome = sc.nextLine();
				oficina.cadastrarCliente(nome);
				System.out.println("Cliente cadastrado!!!");
				break;
			case 3:
				System.out.println("Cadastrar veículo");
				break;
			case 4:
				System.out.println("Imprimir todos os clientes cadastrados");
				oficina.imprimirClientes();
				break;
			case 5:
				System.out.println("Imprimir todos os veículos cadastrados");

				break;
			case 6:
				System.out.println("Imprimir todas as ordens de serviço");
				oficina.imprimirOrdens();
				break;
			case 7:
				System.out.println("Alterar uma OS informando valor das peças, descrição e valor da mão de obra");

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
				Status novoStatus = 
					novoStatusInt == 1 ? Status.ABERTA :
					novoStatusInt == 2 ? Status.EMANDAMENTO :
					Status.CONCLUIDA;

				oficina.alterarStatusOS(id, novoStatus);
				break;
			case 9:
				System.out.println("Imprimir ordens de serviço informando a placa do carro");

				break;
			case 10:
				System.out.println("Imprimir ordens de serviço informando o nome do cliente");

				break;
			case 11:
				System.out.println("Imprimir os veículos de um cliente");

				break;
			case 12:
				System.out.println("Imprimir as ordens de serviço por status");

				break;
			case 13:
				System.out.println("Imprimir ordens de serviço de um período");

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
