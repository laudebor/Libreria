package serivicios;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.Scanner;
import persistencia.AutorDAO;
import persistencia.LibroDAO;

public class LibroServicio{
    
    private LibroDAO dao;
    private AutorServicio as;
    Scanner scan = new Scanner(System.in);
    
    public LibroServicio() {
        this.dao = new LibroDAO();
    }
    
    public void crearLibro(){
        
            Libro libro = new Libro();
            System.out.println("----CARGAR NUEVO LIBRO----");
            System.out.print("Título: "); libro.setTitulo(scan.next());
            System.out.print("Año: "); libro.setAnio(scan.nextInt());
            System.out.print("Cantidad de ejemplares: "); libro.setEjemplares(scan.nextInt());
            System.out.print("Ejemplares prestados: "); libro.setEjemplaresPrestados(scan.nextInt());
            System.out.print("Ejemplares restantes: "); libro.setEjemplaresRestantes(scan.nextInt());
            System.out.print("ID Autor: "); Integer IDAutor = scan.nextInt();
            
            //Autor autor = as.BuscarAutorID(IDAutor);
            libro.setAlta(true);
            
            libro.getAutor().setAlta(true);
            libro.getAutor().setId(IDAutor);
            System.out.print("Nombre del autor: "); libro.getAutor().setNombre(scan.next());
            //Editorial editorial = new Editorial();
            //editorial.setAlta(true);
            //System.out.print("Editorial: "); editorial.setNombre(scan.next());
            libro.setEditorial(null);
            
            dao.guardar(libro);
            System.out.println("----LIBRO CARGADO CON ÉXITO----");
        
    }
    
    public void mostrarLibrosNombre(){
        System.out.println("----BUSCAR LIBRO POR NOMBRE----");
        System.out.print("Ingrese el nombre del libro que desea buscar: "); String nombre = scan.next();
        for(Libro aux : dao.buscarLibroNombre(nombre)){
            System.out.println(aux.toString());
        }
    }
    
}
