package ar.edu.unju.fi.TPFINALPV.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Entity
@Table(name = "INGREDIENTES")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @Column(name = "estado")
    private boolean estado;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "RECETA_INGREDIENTE",
            joinColumns = @JoinColumn(name = "ingrediente_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "receta_id_fk"))
    private List<Receta> recetas;

    public Ingrediente() {
        this.estado = true;
    }

    public Ingrediente(Long id, String nombre, List<Receta> recetas) {
        this.id = id;
        this.nombre = nombre;
        this.estado = true;
        this.recetas = recetas;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> receta) {
        this.recetas = receta;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                '}';
    }
}
