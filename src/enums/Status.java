package enums;

public enum Status {
	ABERTA("Aberta"), EMANDAMENTO("Em andamento"), CONCLUIDA("Concluída");

	private String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return descricao;
	}
}
