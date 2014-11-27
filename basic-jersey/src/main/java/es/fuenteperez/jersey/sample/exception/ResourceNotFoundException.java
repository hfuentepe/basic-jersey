package es.fuenteperez.jersey.sample.exception;

public class ResourceNotFoundException extends RuntimeException {
	private int codigo;

	public ResourceNotFoundException(int codigo, String mensaje) {
		super(mensaje);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
}
