package com.precuperativa.clinica.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rut;
    private String nombre;
    private Date fecha_nacimiento;

//OneToMany citas
@OneToMany(mappedBy = "paciente",cascade=CascadeType.ALL ,fetch = FetchType.LAZY) 
//un paciente puede tener muchas citas
private List<CitaMedica> citasMedicas;



    // Constructor vacio
    public Paciente() {
    }

    // Constructor con atributos
    public Paciente(Long id, String rut, String nombre, Date fecha_nacimiento) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    // Getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

}
