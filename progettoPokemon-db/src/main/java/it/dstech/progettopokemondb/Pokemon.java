package it.dstech.progettopokemondb;


public class Pokemon {

	private String nome;
	private int	hp;
	private int attacco;
	private int difesa;
	private int velocita;
	private String evoluzione;
	public Pokemon(String nome, int hp, int attacco, int difesa, int velocita, String evoluzione) {
		super();
		this.nome = nome;
		this.hp = hp;
		this.attacco = attacco;
		this.difesa = difesa;
		this.velocita = velocita;
		this.evoluzione = evoluzione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttacco() {
		return attacco;
	}
	public void setAttacco(int attacco) {
		this.attacco = attacco;
	}
	public int getDifesa() {
		return difesa;
	}
	public void setDifesa(int difesa) {
		this.difesa = difesa;
	}
	public int getVelocita() {
		return velocita;
	}
	public void setVelocita(int velocita) {
		this.velocita = velocita;
	}
	public String getEvoluzione() {
		return evoluzione;
	}
	public void setEvoluzione(String evoluzione) {
		this.evoluzione = evoluzione;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((evoluzione == null) ? 0 : evoluzione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (evoluzione != other.evoluzione)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pokemon [nome=" + nome + ", Hp=" + hp + ", attacco=" + attacco + ", difesa=" + difesa
				+ ", velocita=" + velocita + ", evoluzione=" + evoluzione + "]";
	}
	

}
