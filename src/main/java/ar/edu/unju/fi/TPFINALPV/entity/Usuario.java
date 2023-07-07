package ar.edu.unju.fi.TPFINALPV.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Component
@Entity
@Table
public class Usuario {
    private String nombre;
    private LocalDate FechaNacimiento;
    private float estatura;
    private boolean estado;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechaNacimiento() {
        return FechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }
    public float getEstatura() {
        return estatura;
    }
    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public Usuario(String nombre, LocalDate fechaNacimiento, float estatura, boolean estado) {
        this.nombre = nombre;
        FechaNacimiento = fechaNacimiento;
        this.estatura = estatura;
        this.estado = estado;
    }
    public Usuario() {
    }


}
