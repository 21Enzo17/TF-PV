package ar.edu.unju.fi.TPFINALPV.service;

import java.util.List;

import ar.edu.unju.fi.TPFINALPV.entity.Autor;


public interface IAutorService {

	public List<Autor> getAllAutores(); // Listar

    public List<Autor> getDisponibles(); // Listar Disponibles

    public void addAutor(Autor autor); // Modificar y Guardar

    public void eliminarAutor(Autor autor); //Eliminar
    
    public Autor findAutorById(Long id); // Buscar por ID
}
