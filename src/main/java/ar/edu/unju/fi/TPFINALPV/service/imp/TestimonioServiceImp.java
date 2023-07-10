package ar.edu.unju.fi.TPFINALPV.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFINALPV.entity.Testimonio;
import ar.edu.unju.fi.TPFINALPV.repository.ITestimonioRepository;
import ar.edu.unju.fi.TPFINALPV.service.ITestimonioService;
import ar.edu.unju.fi.TPFINALPV.service.IUserService;

@Service
public class TestimonioServiceImp implements ITestimonioService{
	
	@Autowired
	private ITestimonioRepository testimonioRepository;

	@Autowired
	private IUserService userService;
	
	@Override
	public List<Testimonio> getTestimonio() {
		return (List<Testimonio>) testimonioRepository.findAll();
	}

	@Override
	public List<Testimonio> getDisponibles() {
		return testimonioRepository.testimoniosDisponibles();
	}

	@Override
	public void addTestimonio(Testimonio testimonio) {
		testimonio.setEstado(true);
		testimonioRepository.save(testimonio);
		
	}

	@Override
	public void eliminarTestimonio(Testimonio testimonio) {
		testimonio.setEstado(false);
		testimonioRepository.save(testimonio);
		
	}

	@Override
	public Testimonio findTestimonioById(Long id) {
		return testimonioRepository.findById(id).orElse(null);
	}

	@Override
	public List<Testimonio> findByAutor(String autor) {
		return testimonioRepository.buscarPorAutor(autor);
	}

	
	
}
