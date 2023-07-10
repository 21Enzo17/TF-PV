package ar.edu.unju.fi.TPFINALPV.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.TPFINALPV.entity.PesoIdeal;
import ar.edu.unju.fi.TPFINALPV.repository.PesoIdealRepository;
import ar.edu.unju.fi.TPFINALPV.service.IPesoIdealService;
import java.util.List;
import java.util.Optional;


public class PesoIdealMySql implements IPesoIdealService {
	
	@Autowired
	PesoIdealRepository pesoRepository;
	
	@Autowired
	PesoIdeal pesoIdeal;
	
	@Override
	public PesoIdeal getPesoIdeal() {
		// TODO Auto-generated method stub
		return pesoIdeal;
	}

	@Override
	public void guardar(PesoIdeal registroPesoIdeal) {
		// TODO Auto-generated method stub
		registroPesoIdeal.setEstado(true);
		pesoRepository.save(registroPesoIdeal);
		
	}

	@Override
	public void modificar(PesoIdeal registroPesoIdeal) {
		// TODO Auto-generated method stub
		pesoRepository.save(registroPesoIdeal);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		Optional<PesoIdeal> usuario = pesoRepository.findById(id);
		if (usuario.isPresent()) {
		    PesoIdeal u = usuario.get();
		    u.setEstado(false);;
		    pesoRepository.save(u);
		}
	}
}
