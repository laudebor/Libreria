package principal;

import persistencia.LibroDAO;
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
        //es.crearEditorial();
        //ls.eliminarLibro();
        //ls.darBajaLibro();
        //es.crearEditorial();
        es.editarEditorial();
    }
    
}
