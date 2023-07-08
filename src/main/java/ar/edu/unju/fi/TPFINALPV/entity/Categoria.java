package ar.edu.unju.fi.TPFINALPV.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Table(name = "CATEGORIAS")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    @NotBlank(message = "Debe ingresar un nombre")
    private String nombre;
    @OneToMany(mappedBy = "categoria",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Receta> recetas;
    @Column(name = "estado")
    private boolean estado;

    public Categoria() {
        this.estado = true;
    }

    public Categoria(Long id, String nombre, List<Receta> recetas, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.recetas = recetas;
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

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                '}';
    }
}
