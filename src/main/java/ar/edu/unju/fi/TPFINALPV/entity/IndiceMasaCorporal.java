package ar.edu.unju.fi.TPFINALPV.entity;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Component
@Entity
@Table(name="IMC")
public class IndiceMasaCorporal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="fecha")
    private LocalTime fecha;
    
    @Column(name="estado")
    private boolean estado;

    @Column(name="peso")
    private float peso;

    @Autowired
    @JoinColumn(name="usuario")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull(message= "Debe seleccionar un usuario")
    private User usuario;


    public IndiceMasaCorporal() {
    }

    public IndiceMasaCorporal(Long id, LocalTime fecha, boolean estado, User usuario) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalTime fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public User getUsuario() {
        return this.usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public IndiceMasaCorporal id(Long id) {
        setId(id);
        return this;
    }

    public IndiceMasaCorporal fecha(LocalTime fecha) {
        setFecha(fecha);
        return this;
    }

    public IndiceMasaCorporal estado(boolean estado) {
        setEstado(estado);
        return this;
    }

    public IndiceMasaCorporal usuario(User usuario) {
        setUsuario(usuario);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", estado='" + isEstado() + "'" +
            ", usuario='" + getUsuario() + "'" +
            "}";
    }
    

    
    public float calcularIMC(){
        return (float) (this.peso/(Math.pow(this.usuario.getEstatura(),2)));
    }
    
    
}


// id
// date
// usuario
// estado