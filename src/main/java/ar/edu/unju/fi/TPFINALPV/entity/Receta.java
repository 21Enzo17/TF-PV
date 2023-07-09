package ar.edu.unju.fi.TPFINALPV.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

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
    @NotNull(message = "Debe seleccionar una categoría")
    private Categoria categoria;
    @Column(name = "ingredientes")
    @NotNull(message = "Debe seleccionar al menos un ingrediente")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "RECETA_INGREDIENTE",
            joinColumns = @JoinColumn(name = "receta_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id_fk"))
    private List<Ingrediente> ingredientes;
    @Column(name = "preparacion")
    @NotBlank(message = "La preparación no puede estar vacía")
    private String preparacion;
    @Column(name = "descripcion")
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "estado")
    private boolean estado;

    public Receta() {
        this.estado = true;
    }

    public Receta(Long id, String nombre, Categoria categoria, List<Ingrediente> ingredientes, String preparacion, String descripcion, String imagen, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.estado = estado;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", ingredientes=" + ingredientes +
                ", preparacion='" + preparacion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", estado=" + estado +
                '}';
    }
}
