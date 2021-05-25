package cl.inacap.registroCivilModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.registroCivilModel.dto.Solicitud;

@Local
public interface SolicitudesDAOLocal {
	
	void save(Solicitud solicitud);
	List<Solicitud> getAll();
	void delete(Solicitud solicitud);
	List<Solicitud> filterByTipoSolicitud(String tipoSolicitud);
	List<Solicitud> filterByNombreCliente(String nombreCliente);

}
