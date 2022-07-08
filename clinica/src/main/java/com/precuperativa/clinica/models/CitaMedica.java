package com.precuperativa.clinica.models;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "citas_medicas")
public class CitaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Time hora;
    private String areaMedica;

    //ManyToOne Paciente
    @ManyToOne(fetch = FetchType.EAGER)
	//EAGER carga automaticamente las relaciones LAZY cuando ud. la quiere consumir
	@JoinColumn(name="paciente_id") //PK de la otra entidad, en este caso en cliente se llama id
    //un cliente puede tener muchas compras, pero las compras estaran asociadas a un cliente
    private Paciente paciente;


    // Constructor vacio

    public CitaMedica() {
    }

    // constructor con atributos

    public CitaMedica(Long id, Time hora, String areaMedica) {
        this.id = id;
        this.hora = hora;
        this.areaMedica = areaMedica;
    }

    // Getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getAreaMedica() {
        return areaMedica;
    }

    public void setAreaMedica(String areaMedica) {
        this.areaMedica = areaMedica;
    }

}
