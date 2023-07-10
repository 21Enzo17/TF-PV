package ar.edu.unju.fi.TPFINALPV.entity;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Objects;

@Component
@Entity
@Table(name="USER")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    @NotBlank(message="El nombre no puede estar vacio")
    @Size(min=3,max=25,message = "El nombre debe ser mayor o igual a 3 caracteres y menor a 25")
    private String nombre;

    @Column(name="apellido")
    @NotBlank(message="El apellido no puede estar vacio")
    @Size(min=3,max=25,message = "El apellido debe ser mayor o igual a 3 caracteres y menor a 25")
    private String apellido;

    @Column(name="email")
    @Email
    @NotBlank
    private String email;

    @Column(name="fecha_nac")
    @Past(message = "La fecha debe ser anterior a la fecha actual")
    @NotNull(message = "Introduzca una fecha de nacimiento valida")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecha;

    @Column(name = "telefono")
    @NotBlank(message = "Debe ingresar un teléfono")
    @Size(min = 8, message = "El teléfono debe tener al menos 8 digitos")
    @Pattern(regexp = "[+]?(?:[1-9]\\d*|0)(?:\\s[1-9]\\d*)*", message = "El teléfono debe tener numeros del 1 al 9")
    private String telefono;

    @Column(name="sexo")
    @NotNull
    private char sexo;
    
    @Column(name="estatura")
    @NotNull(message = "Debe introducir su estatura")
    @Positive(message = "Debe introducir su estatura")
    private float estatura;

    @Column(name="permisos")
    @NotNull(message = "Debe ingresar una opcion")
    private boolean permisos;

    @OneToMany(mappedBy = "usuario")
    private List<IndiceMasaCorporal> indiceMasaCorporal;



    public User() {
    }

    public User(Long id, String nombre, String apellido, String email, LocalDate fecha, String telefono, char sexo, float estatura, boolean permisos, List<IndiceMasaCorporal> indiceMasaCorporal) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fecha = fecha;
        this.telefono = telefono;
        this.sexo = sexo;
        this.estatura = estatura;
        this.permisos = permisos;
        this.indiceMasaCorporal = indiceMasaCorporal;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public float getEstatura() {
        return this.estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public boolean isPermisos() {
        return this.permisos;
    }

    public boolean getPermisos() {
        return this.permisos;
    }

    public void setPermisos(boolean permisos) {
        this.permisos = permisos;
    }

    public List<IndiceMasaCorporal> getIndiceMasaCorporal() {
        return this.indiceMasaCorporal;
    }

    public void setIndiceMasaCorporal(List<IndiceMasaCorporal> indiceMasaCorporal) {
        this.indiceMasaCorporal = indiceMasaCorporal;
    }

    public User id(Long id) {
        setId(id);
        return this;
    }

    public User nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public User apellido(String apellido) {
        setApellido(apellido);
        return this;
    }

    public User email(String email) {
        setEmail(email);
        return this;
    }

    public User fecha(LocalDate fecha) {
        setFecha(fecha);
        return this;
    }

    public User telefono(String telefono) {
        setTelefono(telefono);
        return this;
    }

    public User sexo(char sexo) {
        setSexo(sexo);
        return this;
    }

    public User estatura(float estatura) {
        setEstatura(estatura);
        return this;
    }

    public User permisos(boolean permisos) {
        setPermisos(permisos);
        return this;
    }

    public User indiceMasaCorporal(List<IndiceMasaCorporal> indiceMasaCorporal) {
        setIndiceMasaCorporal(indiceMasaCorporal);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", email='" + getEmail() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", sexo='" + getSexo() + "'" +
            ", estatura='" + getEstatura() + "'" +
            ", permisos='" + isPermisos() + "'" +
            ", indiceMasaCorporal='" + getIndiceMasaCorporal() + "'" +
            "}";
    }

    
    
    public float pulgadaCm(float pulgadas){
        return (float) (pulgadas*2.54);
    }

    public void SetUserNull(User user) {
        this.id = null;
        this.nombre = null;
        this.apellido = null;
        this.email = null;
        this.fecha = null;
        this.telefono = null;
        this.sexo = 'n';
        this.estatura = 0;
        this.indiceMasaCorporal = null;
        this.permisos = false;
    }
    
    public float getPesoIdeal() {
    	
    	Period periodo = Period.between(fecha, LocalDate.now());
		int edad=periodo.getYears();			
		float pi=(estatura-100.0f)+(((float)edad/10.0f)*0.9f);			
		return pi;
    	
    }
    
    public int getEdad() {
    	
    	Period periodo = Period.between(fecha, LocalDate.now());
		int edad=periodo.getYears();
		return edad;
    	
    }
    
}
