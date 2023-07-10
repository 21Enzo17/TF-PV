package ar.edu.unju.fi.TPFINALPV.service;

import java.util.List;

import ar.edu.unju.fi.TPFINALPV.entity.Testimonio;


public interface ITestimonioService {

    public List<Testimonio> getTestimonio(); //Listar
    
    public List<Testimonio> getDisponibles(); //ListarDisponibles

    public void addTestimonio(Testimonio testimonio); // Agregar y Modificar Testimonio

    public void eliminarTestimonio(Testimonio testimonio); // Eliminar Testimonio

    public Testimonio findTestimonioById(Long id); //Buscar Por ID
    
    public List<Testimonio> findByAutor(String autor); // Buscar Por Autor
}
