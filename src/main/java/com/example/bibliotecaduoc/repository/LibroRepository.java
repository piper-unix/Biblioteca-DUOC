package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {
    //arreglo que guarda todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    //metodo
    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    //busca libros mediante id
    public Libro buscarPorId(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }
    //buscar libro por su isbn
    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
    public Libro guardar(Libro lib){
        listaLibros.add(lib);
        return lib;
    }
    public Libro actualizar(Libro lib){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i<listaLibros.size();i++){
            if (listaLibros.get(i).getId() == lib.getId()){
                id = lib.getId();
                idPosicion = i;
            }
        }
        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;
    }
    public void eliminar(int id){
        //alternativa 1
        Libro libro = buscarPorId(id);
        if (libro != null){
            listaLibros.remove(libro);

        }
        //alternativa 2
        int idPosicion = 0;
        for (int i = 0; i<listaLibros.size();i++){
            if (listaLibros.get(i).getId() == id){
                idPosicion = i;
                break;
            }
        }
         if (idPosicion > 0){
             listaLibros.remove(idPosicion);
        }

        //alternativa 3
        listaLibros.removeIf(x ->x.getId() == id);
    }

    public LibroRepository() {
        listaLibros.add(new Libro(1, "9788423353446", "1984", "Debolsillo", 1949, "George Orwell"));
        listaLibros.add(new Libro(2, "9788497594400", "Un mundo feliz", "Debolsillo", 1932, "Aldous Huxley"));
        listaLibros.add(new Libro(3, "9788435015691", "¿Sueñan los androides con ovejas eléctricas?", "Edhasa", 1968, "Philip K. Dick"));
        listaLibros.add(new Libro(4, "9788420650937", "El Anticristo", "Alianza Editorial", 1895, "Friedrich Nietzsche"));
        listaLibros.add(new Libro(5, "9788423351602", "Rebelión en la granja", "Debolsillo", 1945, "George Orwell"));
        listaLibros.add(new Libro(6, "9788467046045", "Frankenstein", "Austral", 1818, "Mary Shelley"));
        listaLibros.add(new Libro(7, "9788415618775", "La peste", "Edhasa", 1947, "Albert Camus"));
        listaLibros.add(new Libro(8, "9788448714093", "El cuervo", "Editorial Planeta", 1845, "Edgar Allan Poe"));
        listaLibros.add(new Libro(9, "9788420674209", "El guardián entre el centeno", "Alianza Editorial", 1951, "J.D. Salinger"));
        listaLibros.add(new Libro(10, "9788474442571", "Una temporada en el infierno", "Hiperión", 1873, "Arthur Rimbaud"));
    }

    public int totalLibros(){
        return listaLibros.size();
    }
    public long contarLibrosPorAnio(int anio){ //contar libros por año
        return listaLibros.stream()
                .filter(libro -> libro.getAnioPublicacion() == anio)
                .count();
    }
    public List<Libro> buscarPorAutor(String autor){
        return listaLibros.buscarPorAutos();
    }
}

