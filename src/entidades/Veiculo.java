package entidades;

	public class Veiculo {
		private String placa;
		private String modelo;
		private Cliente cliente;
		private static int geradorId;
		private int id;

		public Veiculo(String placa, String modelo, Cliente cliente) {
			geradorId++;
			this.id = geradorId;
			this.placa = placa;
			this.modelo = modelo;
			this.cliente = cliente;
		}

		public String getPlaca() {
			return placa;
		}

		public void setPlaca(String placa) {
			this.placa = placa;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public static int getGeradorId() {
			return geradorId;
		}

		public int getId() {
			return id;
		}

		public String toString() {
			return "Veículo\n" + " Placa= " + placa + ", Modelo= " + modelo + ", Cliente= " + cliente + ", ID= " + id;
		}

	}


	
