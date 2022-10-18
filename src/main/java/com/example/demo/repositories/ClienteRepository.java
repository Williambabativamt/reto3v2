/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repositories;
import com.example.demo.model.Cliente;
import com.example.demo.model.Habitacion;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author brenk
 */
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    

    
}
