package ar.edu.unju.fi.TPFINALPV.service;
import ar.edu.unju.fi.TPFINALPV.entity.Contacto;
import java.util.List;
public interface IContactoService {
	 /**
     * Crea un nuevo contacto.
     *
     * @param contacto 
     */
	void crearContacto(Contacto contacto);
	/**
     * Elimina un contacto por su ID.
     *
     * @param id 
     */
	void eliminarContacto(Long id);
	
	/**
     * Obtiene la lista de contactos.
     *
     * @return lista de contactos
     */
	public List<Contacto> getListaDeContactos();
	
}






