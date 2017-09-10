package it.polito.tdp.zaino;

public class Pezzo {

	private final int peso;
	private final int costo;
	private final String nome;
	
	public Pezzo(int peso, int costo, String nome) {
		super();
		this.peso = peso;
		this.costo = costo;
		this.nome = nome;
	}

	/**
	 * @return the peso
	 */
	public int getPeso() {
		return peso;
	}

	/**
	 * @return the costo
	 */
	public int getCosto() {
		return costo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pezzo other = (Pezzo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s [peso=%d - costo=%d]", getNome(), getPeso(), getCosto());
	}
	
	
	
}
