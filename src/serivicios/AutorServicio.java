package serivicios;

import entidades.Autor;
import java.util.Scanner;
import persistencia.AutorDAO;

public class AutorServicio {

    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    private final AutorDAO dao;

    public AutorServicio() {
        this.dao = new AutorDAO();
    }

    public Autor crearAutor() {
        System.out.println("");
        System.out.println("----CARGAR NUEVO AUTOR----");
        System.out.println("");
        Autor autor = new Autor();
        try {
            System.out.print("Nombre: ");
            autor.setNombre(scan.next());
            autor.setAlta(true);
            dao.guardar(autor);
            System.out.println("");
            System.out.println("----AUTOR CARGADO CON ÉXITO----");
            System.out.println("");
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void editarAutor() {
        System.out.println("");
        System.out.println("----EDITAR AUTOR----");
        System.out.println("");
        System.out.print("Ingrese el id del autor que desea editar: ");
        try {
            Autor autor = dao.buscarAutorId(scan.nextInt());
            System.out.println("");
            System.out.print("Ingrese el nuevo nombre del autor: ");
            autor.setNombre(scan.next());
            dao.editar(autor);
            System.out.println("");
            System.out.println("----AUTOR EDITADO CON ÉXITO----");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarAutorId() {
        try {
            System.out.println("");
            System.out.println("----ELIMINAR AUTOR----");
            System.out.println("");
            System.out.print("Ingrese el id del autor que desea eliminar: ");
            int id = scan.nextInt();
            System.out.println("");
            Autor autor = dao.buscarAutorId(id);
            dao.eliminar(autor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarAutores() {
        System.out.println("");
        System.out.println("----AUTORES----");
        System.out.println("");
        for (Autor aux : dao.listarAutores()) {
            System.out.println(aux.toString());
        }
    }

    // 8) Búsqueda de un Autor por nombre.
    
    public void BuscarAutoresNombre() {
        System.out.println("");
        System.out.println("----BUSCAR AUTOR POR NOMBRE----");
        System.out.println("");
        System.out.print("Nombre: "); String nombre = scan.next();
        System.out.println("");
        try {
            for(Autor aux : dao.buscarAutorNombre(nombre)){
                System.out.println(aux.toString());
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
    }

    public void BuscarAutorID() {
        System.out.println("");
        System.out.println("----BUSCAR AUTOR POR ID----");
        System.out.println("");
        System.out.print("ID autor: "); int id = scan.nextInt();
        System.out.println("");
        try {
            System.out.println(dao.buscarAutorId(id).toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Autor BuscarAutorID(int id){
        try {
            return dao.buscarAutorId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void darBajaAutor(){
        System.out.println("");
        System.out.println("----DAR DE BAJA UN AUTOR-----");
        System.out.println("");
        try{
            System.out.print("ID autor: "); int id = scan.nextInt();
            System.out.println("");
            Autor autor = dao.buscarAutorId(id);
            autor.setAlta(Boolean.FALSE);
            dao.editar(autor);
            System.out.println("");
            System.out.println("----EL AUTOR ID: " + id + " SE HA DADO DE BAJA CORRECTAMENTE----");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void darAltaAutor(){
        System.out.println("");
        System.out.println("----DAR DE ALTA UN AUTOR-----");
        System.out.println("");
        try{
            System.out.print("ID autor: "); int id = scan.nextInt();
            System.out.println("");
            Autor autor = dao.buscarAutorId(id);
            autor.setAlta(Boolean.TRUE);
            dao.editar(autor);
            System.out.println("");
            System.out.println("----EL AUTOR ID: " + id + " SE HA DADO DE ALTA CORRECTAMENTE----");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
