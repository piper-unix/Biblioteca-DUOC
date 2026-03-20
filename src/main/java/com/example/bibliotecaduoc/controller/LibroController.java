package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro) {
        return libroService.saveLibro(libro);
    }

    // Corregido: Tenías un carácter extraño "¨" antes de {id}
    @GetMapping("/{id}")
    public Libro buscarLibro(@PathVariable int id) {
        return libroService.getLibroId(id);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro) {
        // Es buena práctica asegurar que el ID del objeto coincida con el de la URL
        libro.setId(id);
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("/{id}")
    public String eliminarLibro(@PathVariable int id) {
        return libroService.deleteLibro(id);
    }

    //  El total de libros
    @GetMapping("/total")
    public int totalLibrosv2() {
        return libroService.totalLibrosV2();
    }

    @GetMapping("/conteo/{anio}")
    public String obtenerTotalPorAnio(@PathVariable int anio) {
        long total = libroService.obtenerCantidadPorAnio(anio);
        return "El total de libros publicados en el año " + anio + " es: " + total;
    }
}