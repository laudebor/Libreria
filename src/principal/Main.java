package principal;

import serivicios.AutorServicio;
import serivicios.EditorialServicio;
import serivicios.LibroServicio;

public class Main {

    public static void main(String[] args) {
        
        AutorServicio as = new AutorServicio();
        LibroServicio ls = new LibroServicio();
        EditorialServicio es = new EditorialServicio();
        
        //ls.crearLibro();
        //ls.mostrarLibros();
        //ls.darBajaLibro();
        //ls.darAltaLibro();
        //ls.buscarLibrosNombre();
        //ls.eliminarLibro(); NO FUNCIONA
        
        //as.BuscarAutorID();
        //as.BuscarAutoresNombre();
        //as.crearAutor();
        //as.editarAutor();
        //as.mostrarAutores();
        //as.eliminarAutorId(); NO FUNCIONA
        
        //es.crearEditorial();
        //es.buscarEditorialNombre();
        //es.darBajaEditorial();
        //es.darAltaEditorial();
        //es.editarEditorial();
        //es.buscarEditorialId();
        //es.mostrarEditoriales();
        //es.eliminarEditorial(); NO FUNCIONA
    }
    
}
