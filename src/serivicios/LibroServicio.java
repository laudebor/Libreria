package serivicios;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.Scanner;

public final class LibroServicio extends CRUD{
    Scanner scan = new Scanner(System.in);
    public void crearLibro(){
        try{
            Libro libro = new Libro();
            System.out.println("----INGRESAR UN LIBRO A LA BASE DE DATOS----");
            System.out.print("Título: "); libro.setTitulo(scan.next());
            System.out.print("Año: "); libro.setAnio(scan.nextInt());
            System.out.print("Cantidad de ejemplares: "); libro.setEjemplares(scan.nextInt());
            System.out.print("Ejemplares prestados: "); libro.setEjemplaresPrestados(scan.nextInt());
            System.out.print("Ejemplares restantes: "); libro.setEjemplaresRestantes(scan.nextInt());
            Autor autor = new Autor();
            
            System.out.print("Autor: "); autor.setNombre(scan.next());
            autor.setAlta(true);
            libro.setAutor(autor);
            libro.setAlta(true);
            
            Editorial editorial = new Editorial();
            editorial.setAlta(true);
            System.out.print("Editorial: "); editorial.setNombre(scan.next());
            libro.setEditorial(editorial);
            
            super.guardar(libro);
        }catch(Exception e){
            System.out.println("Error en crearLibro");
            throw e;
        }
    }
    
}
