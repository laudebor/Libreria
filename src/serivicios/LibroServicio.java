package serivicios;

import entidades.Libro;
import java.util.Scanner;
import persistencia.LibroDAO;

public class LibroServicio {

    private final LibroDAO dao;
    private final AutorServicio as;
    private final EditorialServicio es;
    Scanner scan = new Scanner(System.in);

    public LibroServicio() {
        this.dao = new LibroDAO();
        this.as = new AutorServicio();
        this.es = new EditorialServicio();
    }

    public void crearLibro() {

        Libro libro = new Libro();
        try {
            System.out.println("");
            System.out.println("----CARGAR NUEVO LIBRO----");
            System.out.println("");
            System.out.print("Título: ");
            libro.setTitulo(scan.next());
            System.out.print("Año: ");
            libro.setAnio(scan.nextInt());
            System.out.print("Cantidad de ejemplares: ");
            libro.setEjemplares(scan.nextInt());
            System.out.print("Ejemplares prestados: ");
            libro.setEjemplaresPrestados(scan.nextInt());
            System.out.print("Ejemplares restantes: ");
            libro.setEjemplaresRestantes(scan.nextInt());
            System.out.print("ID del autor: ");
            int idAutor = scan.nextInt();
            while (as.BuscarAutorID(idAutor)== null) {
                System.out.println("El autor ingresado no se encuentra en la base de datos. Ingréselo nuevamente");
                idAutor = scan.nextInt();
            }

            libro.setAutor(as.BuscarAutorID(idAutor));
            libro.setAlta(true);
            System.out.print("Nombre editorial: "); String nombreEditorial = scan.next();
            while (es.buscarEditorialNombre(nombreEditorial)==null) {
                System.out.print("La editorial ingresada no se encuentra en la base de datos. Ingrésela nuevamente");
                nombreEditorial = scan.next();
            }
            libro.setEditorial(es.buscarEditorialNombre(nombreEditorial));
                    
            dao.guardar(libro);
            System.out.println("");
            System.out.println("----LIBRO CARGADO CON ÉXITO----");
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarLibrosNombre() {
        System.out.println("");
        System.out.println("----BUSCAR LIBRO POR NOMBRE----");
        System.out.println("");
        System.out.print("Ingrese el título del libro que desea buscar: ");
        String nombre = scan.next();
        System.out.println("");
        try{
            for (Libro aux : dao.buscarLibroNombre(nombre)) {
            System.out.println(aux.toString());
            }
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        
    }
    
    public void mostrarLibros(){
        System.out.println("");
        System.out.println("----LIBROS DE LA BASE DE DATOS----");
        System.out.println("");
        try{
            for(Libro aux : dao.listarLibros()){
                System.out.println(aux.toString());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public void eliminarLibro(){
        System.out.println("");
        System.out.println("----ELIMINAR LIBRO----");
        System.out.println("");
        System.out.print("ISBN: "); int isbn = scan.nextInt();
        try{
            Libro libroEliminar = dao.buscarLibroISBN(isbn);
            System.out.println("Datos del libro a eliminar: ");
            System.out.println(libroEliminar.toString());
            dao.eliminar(libroEliminar);
            System.out.println("");
            System.out.println("----LIBRO ELIMINADO CON ÉXITO----");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void darBajaLibro(){
        System.out.println("");
        System.out.println("----DAR DE BAJA LIBRO----");
        System.out.println("");
        System.out.print("ISBN: "); int isbn = scan.nextInt();
        try{
            Libro libro = dao.buscarLibroISBN(isbn);
            libro.setAlta(Boolean.FALSE);
            dao.editar(libro);
            System.out.println("");
            System.out.println("----EL LIBRO ISBN: " + isbn + " SE HA DADO DE BAJA CORRECTAMENTE----");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }   
    }
    
    public void darAltaLibro(){
        System.out.println("");
        System.out.println("----DAR DE BAJA LIBRO----");
        System.out.println("");
        System.out.print("ISBN: "); int isbn = scan.nextInt();
        try{
            Libro libro = dao.buscarLibroISBN(isbn);
            libro.setAlta(Boolean.TRUE);
            dao.editar(libro);
            System.out.println("");
            System.out.println("----EL LIBRO ISBN: " + isbn + " SE HA DADO DE ALTA CORRECTAMENTE----");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
