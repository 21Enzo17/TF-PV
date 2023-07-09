package ar.edu.unju.fi.TPFINALPV.entity;

import java.text.DecimalFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;



@Component
@Entity
@Table(name="IMC")
public class IndiceMasaCorporal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="fecha")
    private LocalDate fecha;
    
    @Column(name="estado")
    private boolean estado;

    @Column(name="peso")
    @NotNull(message = "Ingrese un peso correcto")
    @Positive(message = "Ingrese un peso correcto")
    private float peso;

    @Autowired
    @JoinColumn(name="usuario")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull(message= "Debe seleccionar un usuario")
    private User usuario;



    

    public IndiceMasaCorporal() {
    }

    public IndiceMasaCorporal(Long id, LocalDate fecha, boolean estado, float peso, User usuario) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.peso = peso;
        this.usuario = usuario;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
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

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
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

    public IndiceMasaCorporal fecha(LocalDate fecha) {
        setFecha(fecha);
        return this;
    }

    public IndiceMasaCorporal estado(boolean estado) {
        setEstado(estado);
        return this;
    }

    public IndiceMasaCorporal peso(float peso) {
        setPeso(peso);
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
            ", peso='" + getPeso() + "'" +
            ", usuario='" + getUsuario() + "'" +
            "}";
    }
    


    
    public String calcularIMC(){
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format((this.peso/(Math.pow((this.usuario.getEstatura()/100),2))));
    }

    public String estadoImc(){
        String mensaje;
        if((this.peso/(Math.pow((this.usuario.getEstatura()/100),2)))<18.5){
            mensaje="Esta por debajo de su peso ideal";
        }else{
            if((this.peso/(Math.pow((this.usuario.getEstatura()/100),2)))>=18.5 && (this.peso/(Math.pow((this.usuario.getEstatura()/100),2)))<=25.0){
                mensaje="Esta en su peso normal";
            }else{
                mensaje="Tiene Sobrepeso.";
            }
        }
        return mensaje;
    }
    
    
}

