package com.example.bibliotecaduoc.service;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Se usa para definir una clase como servicio en la capa de negocio
public class LibroService {

    @Autowired // Permite inyección automática de dependencias en Spring
    private LibroRepository libroRepository;

    public List<Libro> getLibros() { // Obtener los libros
        return libroRepository.obtenerLibros();
    }

    public Libro saveLibro(Libro libro) { // Guardar los libros
        return libroRepository.guardar(libro);
    }

    public Libro getLibroId(int id) { // Buscar libros por id
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro) { // Actualizar libros
        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id) { // Eliminar libros
        libroRepository.eliminar(id);
        return "Libro eliminado";
    }

    public int totalLibrosV1() {
        return libroRepository.obtenerLibros().size();
    }

    public int totalLibrosV2() {
        return libroRepository.totalLibros();
    }

    public long obtenerCantidadPorAnio(int anio) {
        // Validación básica de negocio
        if (anio < 0) return 0;

        return libroRepository.contarLibrosPorAnio(anio);
    }
}