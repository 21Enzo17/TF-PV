package ar.edu.unju.fi.TPFINALPV.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
@Table(name = "Registro Peso Ideal Usuarios")
public class PesoIdeal {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String usuario;

    @Column(name = "Fecha de consulta")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha=LocalDate.now();

    @Column(name = "Edad Usuario")
    private int edad;
    
    @Column(name = "peso ideal")
    private float valor;

    @Column(name = "Estado")
    private boolean estado=true;
    
    

	public PesoIdeal() {
		super();
	}

	public PesoIdeal(Long id, String usuario, LocalDate fecha, int edad, float valor, boolean estado) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.edad = edad;
		this.valor = valor;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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
