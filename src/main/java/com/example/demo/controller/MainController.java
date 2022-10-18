/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.repositories.GamaRepository;
import com.example.demo.model.Gama;
import com.example.demo.model.Habitacion;
import com.example.demo.model.Cliente;
import com.example.demo.model.Administrador;
import com.example.demo.model.Mensaje;
import com.example.demo.model.Reserva;
import com.example.demo.model.Calificacion;
import com.example.demo.repositories.AdministradorRepository;
import com.example.demo.repositories.CalificacionRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.HabitacionRepository;
import com.example.demo.repositories.MensajeRepository;
import com.example.demo.repositories.ReservaRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/**
 *
 * @author brenk
 */
@Controller // This means that this class is a Controller// This means URL's start with /demo (after Application path)
@RequestMapping(path="/api")
public class MainController {
    @Autowired
    private GamaRepository gamaRepository;

    @PostMapping(path="/Category/save") // Map ONLY POST Requests
    public @ResponseBody String addNewGama (@RequestParam String name, @RequestParam String description) {
      Gama g = new Gama();
      g.setNombre(name);
      g.setDescripcion(description);
      gamaRepository.save(g);
      return "Saved";
    }

    @GetMapping(path="/Category/all")
    public @ResponseBody Iterable<Gama> getAllUsers() {
      return gamaRepository.findAll();
    }
    
    @Autowired
    private HabitacionRepository habitacionRepository;
    
    @PostMapping(path="/Room/save") // Map ONLY POST Requests
    public @ResponseBody String addNewHabitacion (@RequestParam String name, @RequestParam String hotel, @RequestParam int stars, @RequestParam String description, @RequestParam Gama category) {
      Habitacion h = new Habitacion();
      h.setNombre(hotel);
      h.setNumero(name);
      h.setDescripcion(description);
      h.setEstrellas(stars);
      h.setGama(category);
      habitacionRepository.save(h);
      return "Saved";
    }

    @GetMapping(path="/Room/all")
    public @ResponseBody Iterable<Habitacion> getAllHabitaciones() {
      return habitacionRepository.findAll();
    }
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @PostMapping(path="/Client/save") // Map ONLY POST Requests
    public @ResponseBody String addNewCliente (@RequestParam String name, @RequestParam String email, @RequestParam int age, @RequestParam String password) {
      Cliente c = new Cliente();
      c.setNombre(name);
      c.setCorreo(email);
      c.setEdad(age);
      c.setContrasena(password);
      
      clienteRepository.save(c);
      return "Saved";
    }

    @GetMapping(path="/Client/all")
    public @ResponseBody Iterable<Cliente> getAllCliente() {
      return clienteRepository.findAll();
    }
    
    @Autowired
    private MensajeRepository mensajeRepository;
    
    @PostMapping(path="/Message/save") // Map ONLY POST Requests
    public @ResponseBody String addNewMensaje (@RequestParam String messageText, @RequestParam Habitacion room, @RequestParam Cliente client) {
      Mensaje m = new Mensaje();
      m.setCliente(client);
      m.setHabitacion(room);
      m.setTexto(messageText);
      mensajeRepository.save(m);
      return "Saved";
    }

    @GetMapping(path="/Message/all")
    public @ResponseBody Iterable<Mensaje> getAllMensajes() {
      return mensajeRepository.findAll();
    }
   @Autowired
    private ReservaRepository reservaRepository;
    
    @PostMapping(path="/Reservation/save") // Map ONLY POST Requests
    public @ResponseBody String addNewReserva (@RequestParam String startDate,@RequestParam String devolutionDate, @RequestParam Habitacion room, @RequestParam Cliente client) throws Exception {
      Reserva r = new Reserva();
      r.setCliente(client);
      r.setHabitacion(room);
      Date startDate_format = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);      
      r.setFecha_inicio(startDate_format);
      Date devolutionDate_format = new SimpleDateFormat("yyyy-MM-dd").parse(devolutionDate);  
      r.setFecha_entrega(devolutionDate_format);
      String status = "created";
      r.setStatus(status);
      Date fecha_creacion = new Date();
      r.setFecha_creacion(fecha_creacion);
      reservaRepository.save(r);
      return "Saved";
    }

    @GetMapping(path="/Reservation/all")
    public @ResponseBody Iterable<Reserva> getAllReservas() {
      return reservaRepository.findAll();
    }
    
    @Autowired
    private CalificacionRepository calificacionRepository;
    
    @PostMapping(path="/Score/save") // Map ONLY POST Requests
    public @ResponseBody String addNewCalificacion (@RequestParam String mensaje, @RequestParam int valor, @RequestParam Reserva reserva_id) throws Exception {
      Calificacion c = new Calificacion();
      c.setMensaje(mensaje);
      c.setValor(valor);
      c.setReserva(reserva_id);
      calificacionRepository.save(c);
      return "Saved";
    }

    @GetMapping(path="/Score/all")
    public @ResponseBody Iterable<Calificacion> getAllCalificaciones() {
      return calificacionRepository.findAll();
    }
    
    private AdministradorRepository administradorRepository;
    
    @PostMapping(path="/Admin/save") // Map ONLY POST Requests
    public @ResponseBody String addNewAdministrador (@RequestParam String name, @RequestParam String email, @RequestParam String password) {
      Administrador a = new Administrador();
      a.setNombre(name);
      a.setCorreo(email);
      a.setContrasena(password);
      
      administradorRepository.save(a);
      return "Saved";
    }

    @GetMapping(path="/Admin/all")
    public @ResponseBody Iterable<Administrador> getAllAdministrador() {
      return administradorRepository.findAll();
    }
     
}
