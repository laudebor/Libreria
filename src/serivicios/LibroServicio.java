package serivicios;

import entidades.Libro;
//import java.util.List;
import java.util.Scanner;
import persistencia.LibroDAO;

public class LibroServicio {

    private final LibroDAO dao;
    private final AutorServicio as;
    Scanner scan = new Scanner(System.in);

    public LibroServicio() {
        this.dao = new LibroDAO();
        this.as = new AutorServicio();
    }

    public void crearLibro() {

        Libro libro = new Libro();
        try {
            System.out.println("----CARGAR NUEVO LIBRO----");
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
            System.out.print("Nombre del autor: ");
            String nombreAutor = scan.next();
            while (as.BuscarAutor(nombreAutor) == null) {
                System.out.println("El autor ingresado no se encuentra en la base de datos. Ingréselo nuevamente");
                nombreAutor = scan.next();
            }

            libro.setAutor(as.BuscarAutor(nombreAutor));
            libro.setAlta(true);
            libro.setEditorial(null);

            dao.guardar(libro);
            System.out.println("----LIBRO CARGADO CON ÉXITO----");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarLibrosNombre() {
        
        System.out.println("----BUSCAR LIBRO POR NOMBRE----");
        System.out.print("Ingrese el título del libro que desea buscar: ");
        String nombre = scan.next();
        try{
            for (Libro aux : dao.buscarLibroNombre(nombre)) {
            System.out.println(aux.toString());
            }
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
        
    }
    
    public void mostrarLibros(){
        System.out.println("----LIBROS DE LA BASE DE DATOS----");
        try{
            for(Libro aux : dao.listarLibros()){
                System.out.println(aux.toString());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public void eliminarLibro(){
        System.out.println("----ELIMINAR LIBRO----");
        System.out.print("ISBN: "); int isbn = scan.nextInt();
        try{
            Libro libroEliminar = dao.buscarLibroISBN(isbn);
            System.out.println("Datos del libro a eliminar: ");
            System.out.println(libroEliminar.toString());
            dao.eliminar(libroEliminar);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void darBajaLibro(){
        System.out.println("----DAR DE BAJA LIBRO----");
        System.out.print("ISBN: "); int isbn = scan.nextInt();
        try{
            Libro libro = dao.buscarLibroISBN(isbn);
            libro.setAlta(Boolean.FALSE);
            dao.editar(libro);
            System.out.println("----EL LIBRO ISBN: " + isbn + " SE HA DADO DE BAJA CORRECTAMENTE----");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }   
    }
    
    public void darAltaLibro(){
        System.out.println("----DAR DE BAJA LIBRO----");
        System.out.print("ISBN: "); int isbn = scan.nextInt();
        try{
            Libro libro = dao.buscarLibroISBN(isbn);
            libro.setAlta(Boolean.TRUE);
            dao.editar(libro);
            System.out.println("----EL LIBRO ISBN: " + isbn + " SE HA DADO DE ALTA CORRECTAMENTE----");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
