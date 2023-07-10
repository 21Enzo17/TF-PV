package ar.edu.unju.fi.TPFINALPV.entity;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "TESTIMONIO")
public class Testimonio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="testimonio_id")
	private Long id;
	
	
	@Column(name="testimonio_title")
	@NotBlank(message="El titulo no puede estar vacío")
	@Size(min=5,max=25,message = "El titulo debe ser mayor a 5 caracteres y menor a 25 caracteres")
	private String titulo;
	
	@Column(name = "testimonio_description")
	@NotBlank(message="La descripción no puede estar vacía")
	@Size(min=5,max=550,message = "La descripción debe ser mayor a 5 caracteres y menor a 500 caracteres")
	private String descripcion;
	
	@Column(name="testimonio_date")
    private LocalDate fecha;
	
    @Autowired
    @JoinColumn(name="autor_id")
    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @NotNull(message = "Debe seleccionar un autor")
	private Autor autor;
	
	@Column(name="testimonio_state")
	private boolean estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Testimonio() {
		super();
	}

	public Testimonio(Long id,
			@NotBlank(message = "El titulo no puede estar vacío") @Size(min = 5, max = 25, message = "El titulo debe ser mayor a 5 caracteres y menor a 25 caracteres") String titulo,
			@NotBlank(message = "La descripción no puede estar vacía") @Size(min = 5, max = 550, message = "La descripción debe ser mayor a 5 caracteres y menor a 500 caracteres") String descripcion,
			LocalDate fecha, @NotNull(message = "Debe seleccionar un autor") Autor autor, boolean estado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.autor = autor;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Testimonio [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", Autor=" + autor
				+ ", estado=" + estado + "]";
	}
	
	
	
}
