package es.fuenteperez.jersey.sample.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class ApiError {
	
	public ApiError() {
		super();
	}
	
	private int codigo;
	private String mensaje;
	
	public ApiError(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
