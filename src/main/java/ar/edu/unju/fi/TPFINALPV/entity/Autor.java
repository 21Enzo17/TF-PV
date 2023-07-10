package ar.edu.unju.fi.TPFINALPV.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "AUTOR")
public class Autor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="autor_id")
	private Long id;
	
	@Column(name="autor_name")
	@NotBlank(message="El nombre no puede estar vacío")
	@Size(min=5,max=25,message = "El nombre debe ser mayor a 5 caracteres y menor a 25 caracteres")
	private String nombre;
	
	@Column(name="autor_state")
	private boolean estado;
	
	@OneToMany(mappedBy = "autor")
	private List<Testimonio> testimonios;

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

	public Autor(Long id, String nombre, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Autor() {
		super();
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
	
	
}
