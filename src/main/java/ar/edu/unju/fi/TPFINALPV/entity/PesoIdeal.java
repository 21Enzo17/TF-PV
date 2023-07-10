package ar.edu.unju.fi.TPFINALPV.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Registro Peso Ideal Usuarios")
public class PesoIdeal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name="usuario")
	private String usuario;

	@Column(name = "Fecha de consulta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	@Column(name = "Edad Usuario")
	private int edad;

	@Column(name = "Estatura")
	private float estatura;

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	@Column(name = "peso ideal")
	private float valor;

	@Column(name = "Estado")
	private boolean estado = true;

	public PesoIdeal() {
		super();
	}

	public PesoIdeal(String usuario, int edad, float estatura, float valor) {
		super();
		this.usuario = usuario;
		this.edad = edad;
		this.estatura = estatura;
		this.valor = valor;
		this.fecha = LocalDate.now();
		this.estado = true;
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

	@Override
	public String toString() {
		return "PesoIdeal [id=" + id + ", usuario=" + usuario + ", fecha=" + fecha + ", edad=" + edad + ", estatura="
				+ estatura + ", valor=" + valor + ", estado=" + estado + "]";
	}

}
