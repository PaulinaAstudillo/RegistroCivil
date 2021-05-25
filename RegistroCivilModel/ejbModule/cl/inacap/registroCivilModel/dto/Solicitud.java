package cl.inacap.registroCivilModel.dto;

public class Solicitud {
	
	private String rutCliente;
	private String nombreCliente;
	private String tipoSolicitud;
	private volatile int nroSolicitud;
	
	
	public String getRutCliente() {
		return rutCliente;
	}
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getTipoSolicitud() {
		return tipoSolicitud;
	}
	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	public int getNroSolicitud() {
		return nroSolicitud;
	}
	public void setNroSolicitud(int nroSolicitud) {
		this.nroSolicitud = nroSolicitud;
	}
}
