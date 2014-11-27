package es.fuenteperez.jersey.sample.exception;

public class RepositoryException extends RuntimeException {
	private int codigo;

	public RepositoryException(int codigo, String mensaje) {
		super(mensaje);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
}
