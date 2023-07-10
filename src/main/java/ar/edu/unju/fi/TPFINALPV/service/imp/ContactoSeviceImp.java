package ar.edu.unju.fi.TPFINALPV.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFINALPV.entity.Contacto;
import ar.edu.unju.fi.TPFINALPV.repository.ContactoRepository;
import ar.edu.unju.fi.TPFINALPV.service.IContactoService;
@Service
public class ContactoSeviceImp implements IContactoService {

	@Autowired
	private ContactoRepository contactoRepository;

	@Override
	public void crearContacto(Contacto contacto) {
			contacto.setEstado(true);
			contactoRepository.save(contacto);
	}

	@Override
	public void eliminarContacto(Long id) {
		List<Contacto> contactos= contactoRepository.findByEstado(true);
		Contacto contacto = new Contacto();
		for(Contacto emp: contactos) {
        	if(emp.getId()==id){
        		contacto= emp;
        		break;
        	}
        }
		contacto.setEstado(false);
		contactoRepository.save(contacto);
		
	}

	@Override
	public List<Contacto> getListaDeContactos() {
		List <Contacto> lista = contactoRepository.findByEstado(true); 
		return lista;
	}

}
