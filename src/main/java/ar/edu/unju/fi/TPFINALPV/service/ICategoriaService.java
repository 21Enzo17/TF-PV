package ar.edu.unju.fi.TPFINALPV.service;

import ar.edu.unju.fi.TPFINALPV.entity.Categoria;

import java.util.List;

public interface ICategoriaService {
    /**
     * Metodo que permite guardar una categoria
     * @param categoria
     */
    public void saveCategoria(Categoria categoria);
    /**
     * Metodo que permite buscar una categoria por su id
     * @return categoria que coincida con el id
     */
    public Categoria buscarCategoria(Long id);

    /**
     * Metodo que permite eliminar una categoria por su id
     * @param id
     */
    public void eliminarCategoria(Long id);
    /**
     * Metodo que permite listar todas las categorias activas
     * @return lista de categorias activas
     */
    public List<Categoria> listarCategoriasActivas();
    /**
     * Metodo que permite obtener categorias
     * @return categoria
     */
    public Categoria getCategoria();
}
