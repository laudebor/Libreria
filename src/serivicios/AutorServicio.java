package serivicios;

import entidades.Autor;
import java.util.Scanner;
import persistencia.AutorDAO;

public class AutorServicio {

    Scanner scan = new Scanner(System.in);
    private AutorDAO dao;

    public AutorServicio() {
        this.dao = new AutorDAO();
    }

    public Autor crearAutor() {
        System.out.println("----CARGAR NUEVO AUTOR----");
        Autor autor = new Autor();
        try {
            System.out.print("Nombre: ");
            autor.setNombre(scan.next());
            autor.setAlta(true);
            dao.guardar(autor);
            System.out.println("----AUTOR CARGADO CON ÉXITO----");
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void editarAutor() {
        System.out.println("----EDITAR AUTOR----");
        System.out.print("Ingrese el id del autor que desea editar: ");
        try {
            Autor autor = dao.buscarAutorId(scan.nextInt());
            System.out.print("Ingrese el nuevo nombre del autor: ");
            autor.setNombre(scan.next());
            dao.editar(autor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarAutorNombre() {
        try {
            System.out.println("----ELIMINAR AUTOR----");
            System.out.print("Ingrese el nombre del autor que desea eliminar: ");
            String nombre = scan.next();
            Autor autor = dao.buscarAutorNombre(nombre);
            dao.eliminar(autor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarAutores() {
        System.out.println("----AUTORES----");
        for (Autor aux : dao.listarAutores()) {
            System.out.println(aux.toString());
        }
    }

    public Autor BuscarAutor(String nombre) {
        try {
            return dao.buscarAutorNombre(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Autor BuscarAutorID(Integer id) {
        try {
            return dao.buscarAutorId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
