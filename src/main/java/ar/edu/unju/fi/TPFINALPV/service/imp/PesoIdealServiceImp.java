package ar.edu.unju.fi.TPFINALPV.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFINALPV.entity.PesoIdeal;
import ar.edu.unju.fi.TPFINALPV.repository.PesoIdealRepository;
import ar.edu.unju.fi.TPFINALPV.service.IPesoIdealService;

import java.util.List;
import java.util.Optional;

@Service
public class PesoIdealServiceImp implements IPesoIdealService {
	
	@Autowired
	PesoIdealRepository pesoRepository;
	
	@Autowired
	PesoIdeal pesoIdeal;
	/**
	 * Método que retorna un objeto de la clase PesoIdeal.
	 */
	@Override
	public PesoIdeal getPesoIdeal() {
		// TODO Auto-generated method stub					
		return pesoIdeal;
	}

	/**
	 * Guarda un registro en el momento en que un Usuario hace una consulta
	 * de  su Peso ideal.
	 */
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

	/**
	 * Elimina un Registro generado por una consulta de Usuario, si conoces su id.
	 */
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

	/*
	 * Obten un Listado de los Rsgistros que se an Genearado por consultas de Peso Ideal.
	 */
	@Override
	public List<PesoIdeal> getListaPI() {
		// TODO Auto-generated method stub
		return pesoRepository.findByEstado(true);
	}
}
