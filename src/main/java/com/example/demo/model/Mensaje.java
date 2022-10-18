/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

/**
 *
 * @author brenk
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "mensaje")
public class Mensaje {
    
    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private Habitacion room;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente client;
    
    private String messageText;
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;

    public int getID() {
        return id;
    }

    public Habitacion getHabitacion() {
        return room;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.room = habitacion;
    }

    public String getTexto() {
        return messageText;
    }

    public void setTexto(String texto) {
        this.messageText = texto;
    }

    public Cliente getCliente() {
        return client;
    }

    public void setCliente(Cliente cliente) {
        this.client = cliente;
    }
    
    
}
