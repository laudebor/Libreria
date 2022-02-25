package principal;

//import serivicios.AutorServicio;
//import serivicios.EditorialServicio;
import serivicios.LibroServicio;

public class Main {

    public static void main(String[] args) {
        
        Menu menu = new Menu();
        //menu.Ejecucion();
        
//        AutorServicio as = new AutorServicio();
        LibroServicio ls = new LibroServicio();
        ls.crearLibro();
        //ls.buscarLibroISBN();
//        EditorialServicio es = new EditorialServicio();
        
        //ls.crearLibro();
        //ls.mostrarLibros();
        //ls.darBajaLibro();
        //ls.darAltaLibro();
        //ls.buscarLibrosNombre();
        //ls.buscarLibroISBN();
        //ls.buscarLibrosNombreAutor();
        //ls.buscarLibrosNombreEditorial();
        //ls.eliminarLibro(); NO FUNCIONA
        
        //as.BuscarAutorID();
        //as.BuscarAutoresNombre();
        //as.crearAutor();
        //as.editarAutor();
        //as.mostrarAutores();
        //as.darBajaAutor();
        //as.darAltaAutor();
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
