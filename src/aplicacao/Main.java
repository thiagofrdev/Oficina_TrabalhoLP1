package aplicacao;

import java.util.Date;
import java.util.Scanner;

import controle.Controle;
import enums.Status;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controle oficina = new Controle();

		int resp;
		do {
			System.out.print("SELECIONE UMA OPÇÃO:\r\n" 
					+ "(0) Sair\r\n" 
					+ "(1) Criar ordem de serviço\r\n" 
					+ "(2) Cadastrar cliente\r\n"
					+ "(3) Cadastrar veículo\r\n" 
					+ "(4) Imprimir todos os clientes cadastrados\r\n"
					+ "(5) Imprimir todos os veículos cadastrados\r\n" 
					+ "(6) Imprimir todas as ordens de serviço\r\n"
					+ "(7) Alterar uma OS informando valor das peças, descrição e valor da mão de obra\r\n"
					+ "(8) Alterar o status de uma OS informando o ID e o status\r\n"
					+ "(9) Imprimir ordens de serviço informando a placa do carro\r\n"
					+ "(10) Imprimir ordens de serviço informando o nome do cliente\r\n"
					+ "(11) Imprimir os veículos de um cliente\r\n" 
					+ "(12) Imprimir as ordens de serviço por status\r\n"
					+ "(13) Imprimir ordens de serviço de um período\n");
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
				System.out.println("Alterar o status de uma OS informando o Id e o status");

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
