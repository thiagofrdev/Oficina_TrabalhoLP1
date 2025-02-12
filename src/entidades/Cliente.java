package entidades;

public class Cliente {
	private String nome;
	private static int geradorId;
	private int id;

	public Cliente() {
	}

	public Cliente(String nome) {
		geradorId++;
		this.id = geradorId;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static int getGeradorId() {
		return geradorId;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "ID: " + id + "\nNome: " + nome + "\n";
	}

}
