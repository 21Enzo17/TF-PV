package ar.edu.unju.fi.TPFINALPV.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Entity
@Table(name = "RECETAS")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id_fk")
    private Categoria categoria;
    @Column(name = "ingredientes")
    @ManyToMany(mappedBy = "recetas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingrediente> ingredientes;
    @Column(name = "preparacion")
    @NotBlank(message = "La preparación no puede estar vacía")
    private String preparacion;
    @Column(name = "imagen")
    @NotBlank(message = "Debe seleccionar una imagen")
    private String imagen;
    @Column(name = "estado")
    private boolean estado;

    public Receta() {
        this.estado = true;
    }

    public Receta(Long id, String nombre, Categoria categoria, List<Ingrediente> ingredientes, String preparacion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.imagen = imagen;
        this.estado = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", preparacion='" + preparacion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", estado=" + estado +
                '}';
    }
}
