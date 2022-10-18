/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

/**
 *
 * @author brenk
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "reserva")
public class Reserva {
 @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private Habitacion room;
 @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente client;
    private Date startDate;
    private Date devolutionDate;
    private Date fecha_creacion;
    private String status;
    
    @OneToMany(mappedBy = "reserva", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Calificacion> listCalificaciones = new ArrayList<>();

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int ID;

    public Habitacion getHabitacion() {
        return room;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.room = habitacion;
    }

    public Cliente getCliente() {
        return client;
    }

    public void setCliente(Cliente cliente) {
        this.client = cliente;
    }

    public Date getFecha_inicio() {
        return startDate;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.startDate = fecha_inicio;
    }

    public Date getFecha_entrega() {
        return devolutionDate;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.devolutionDate = fecha_entrega;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getID() {
        return ID;
    }

 
}
