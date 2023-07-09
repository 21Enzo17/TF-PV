package ar.edu.unju.fi.TPFINALPV.service;
import ar.edu.unju.fi.TPFINALPV.entity.Contacto;
import java.util.List;
public interface IContactoService {
	
	void crearContacto(Contacto contacto);

	void eliminarContacto(Long id);
	
	public List<Contacto> getListaDeContactos();
	
}






