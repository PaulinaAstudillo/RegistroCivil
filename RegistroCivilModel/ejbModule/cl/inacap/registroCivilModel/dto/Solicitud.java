package cl.inacap.registroCivilModel.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class Solicitud {
	
	private String rutCliente;
	private String nombreCliente;
	private String tipoSolicitud;
	private AtomicInteger nroSolicitud;
	
	
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
	public AtomicInteger getNroSolicitud() {
		return nroSolicitud;
	}
	public void setNroSolicitud(AtomicInteger nroSolicitud) {
		this.nroSolicitud = nroSolicitud;
	}
}
