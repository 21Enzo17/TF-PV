package ar.edu.unju.fi.TPFINALPV.service;

import ar.edu.unju.fi.TPFINALPV.entity.Categoria;

import java.util.List;

public interface ICategoriaService {
    public void saveCategoria(Categoria categoria);
    public Categoria buscarCategoria(Long id);
    public void eliminarCategoria(Long id);
    public List<Categoria> listarCategoriasActivas();
    public Categoria getCategoria();
}
