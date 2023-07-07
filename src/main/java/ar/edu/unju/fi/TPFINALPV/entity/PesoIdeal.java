package ar.edu.unju.fi.TPFINALPV.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;

@Component
@Entity
@Table(name="Registro Peso Ideal Usuarios")
public class PesoIdeal {

    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private Usuario usuario;

    @Column(name="Fecha de consulta")
	@Past(message="No puede ser posterior a la actualidad")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fecha;
    
    @Column(name="Edad Usuario")
    private int edad;
    
    @Column(name="Estatura usuario")
    private float estatura;

    @Column(name="peso ideal")
    private float valor;

    @Column(name="Estado")
    private boolean estado;

    public PesoIdeal(Long id, Usuario usuario,
            @Past(message = "No puede ser posterior a la actualidad") LocalDate fecha, int edad, float estatura,
            float valor, boolean estado) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.edad = edad;
        this.estatura = estatura;
        this.valor = valor;
        this.estado = estado;
    }

    public PesoIdeal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}
