/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Gama;

/**
 *
 * @author brenk
 */
// This will be AUTO IMPLEMENTED by Spring into a Bean called gamaRepository
// CRUD refers Create, Read, Update, Delete
public interface GamaRepository extends CrudRepository<Gama, Integer> {
    
}
