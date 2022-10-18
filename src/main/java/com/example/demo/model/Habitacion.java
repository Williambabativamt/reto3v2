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
@Table(name = "habitacion")
public class Habitacion {
    
    private String name;
    
    private String hotel;
    
    private int stars;
    
    private String description;
    
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Mensaje> listMensaje = new ArrayList<>();
    
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Reserva> listReserva = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "gamaId")
    private Gama category;
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment") 
    private int id;

    public String getNumero() {
        return name;
    }

    public void setNumero(String numero) {
        this.name = numero;
    }

    public String getNombre() {
        return hotel;
    }

    public void setNombre(String nombre) {
        this.hotel = nombre;
    }

    public int getEstrellas() {
        return stars;
    }

    public void setEstrellas(int estrellas) {
        this.stars = estrellas;
    }

    public String getDescripcion() {
        return description;
    }

    public void setDescripcion(String descripcion) {
        this.description = descripcion;
    }

    public int getID() {
        return id;
    }

    public Gama getGama() {
        return category;
    }

    public void setGama(Gama gama) {
        this.category = gama;
    }
    
}
