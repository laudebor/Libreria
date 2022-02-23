package serivicios;

import entidades.Editorial;
import java.util.Scanner;
import persistencia.EditorialDAO;

public class EditorialServicio {
    
    private EditorialDAO dao;
    Scanner scan = new Scanner(System.in);

    public EditorialServicio() {
        this.dao = new EditorialDAO();
    }
    
    
    
    public Editorial crearEditorial(){
        System.out.println("----CARGAR NUEVA EDITORIAL----");
        Editorial editorial = new Editorial();
        try{
            System.out.print("Nombre: "); editorial.setNombre(scan.next());
            editorial.setAlta(true);
            dao.guardar(editorial);
            System.out.println("----EDITORIAL CARGADA CON ÉXITO----");
            return editorial;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void editarEditorial(){
        System.out.println("----EDITAR EDITORIAL----");
        try{
            System.out.print("Ingrese el id de la editorial a editar: "); int id = scan.nextInt();
            Editorial editorial = dao.buscarEditorialID(id);
            System.out.print("Ingrese el nuevo nombre para la editorial de id " + id + ": "); String nombre = scan.next();
            editorial.setNombre(nombre);
            dao.editar(editorial);
            System.out.println("----EDITORIAL EDITADA CON ÉXITO----");
            System.out.println(editorial.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Editorial buscarEditorialNombre(){
        Editorial editorial = new Editorial();
        System.out.println("----BUSCAR EDITORIAL POR NOMBRE----");
        System.out.print("Nombre editorial: "); String nombre = scan.next();
        try{
            editorial = dao.buscarEditorialNombre(nombre);
            System.out.println(editorial.toString());
            return editorial;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void darBajaEditorial(){
        System.out.println("----DAR DE BAJA EDITORIAL----");
        System.out.print("Nombre: "); String nombre = scan.next();
        try{
            Editorial editorial = dao.buscarEditorialNombre(nombre);
            editorial.setAlta(Boolean.FALSE);
            dao.editar(editorial);   
            System.out.println("----LA EDITORIAL " + nombre.toUpperCase() + " SE HA DADO DE BAJA CORRECTAMENTE----");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void darAltaEditorial(){
        System.out.println("----DAR ALTA EDITORIAL----");
        System.out.print("Nombre: "); String nombre = scan.next();
        try{
            Editorial editorial = dao.buscarEditorialNombre(nombre);
            editorial.setAlta(Boolean.TRUE);
            dao.editar(editorial);
            System.out.println("----LA EDITORIAL " + nombre.toUpperCase() + " SE HA DADO DE ALTA CORRECTAMENTE----");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    
}
