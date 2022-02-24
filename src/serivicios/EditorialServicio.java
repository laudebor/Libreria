package serivicios;

import entidades.Editorial;
import java.util.Scanner;
import persistencia.EditorialDAO;

public class EditorialServicio {
    
    private final EditorialDAO dao;
    Scanner scan = new Scanner(System.in);

    public EditorialServicio() {
        this.dao = new EditorialDAO();
    }
    
    
    
    public Editorial crearEditorial(){
        System.out.println("");
        System.out.println("----CARGAR NUEVA EDITORIAL----");
        System.out.println("");
        Editorial editorial = new Editorial();
        try{
            System.out.print("Nombre: "); editorial.setNombre(scan.next());
            editorial.setAlta(true);
            dao.guardar(editorial);
            System.out.println("");
            System.out.println("----EDITORIAL CARGADA CON ÉXITO----");
            return editorial;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void editarEditorial(){
        System.out.println("");
        System.out.println("----EDITAR EDITORIAL----");
        System.out.println("");
        try{
            System.out.print("Ingrese el id de la editorial a editar: "); int id = scan.nextInt();
            Editorial editorial = dao.buscarEditorialID(id);
            System.out.print("Ingrese el nuevo nombre para la editorial de id " + id + ": "); String nombre = scan.next();
            editorial.setNombre(nombre);
            dao.editar(editorial);
            System.out.println("");
            System.out.println("----EDITORIAL EDITADA CON ÉXITO----");
            System.out.println("");
            System.out.println(editorial.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Editorial buscarEditorialNombre(String nombre){
        try{
            return dao.buscarEditorialNombre(nombre);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void buscarEditorialNombre(){
        System.out.println("");
        System.out.println("----BUSCAR EDITORIAL POR NOMBRE----");
        System.out.println("");
        System.out.print("Nombre editorial: "); String nombre = scan.next();
        try{
            System.out.println("");
            System.out.println(dao.buscarEditorialNombre(nombre));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void buscarEditorialId(){
        System.out.println("");
        System.out.println("----BUSCAR EDITORIAL POR ID----");
        System.out.println("");
        System.out.print("Id editorial: "); int id = scan.nextInt();
        try{
            System.out.println("");
            System.out.println(dao.buscarEditorialID(id));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void darBajaEditorial(){
        System.out.println("");
        System.out.println("----DAR DE BAJA EDITORIAL----");
        System.out.println("");
        System.out.print("Nombre: "); String nombre = scan.next();
        try{
            Editorial editorial = dao.buscarEditorialNombre(nombre);
            editorial.setAlta(Boolean.FALSE);
            dao.editar(editorial);   
            System.out.println("");
            System.out.println("----LA EDITORIAL " + nombre.toUpperCase() + " SE HA DADO DE BAJA CORRECTAMENTE----");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void darAltaEditorial(){
        System.out.println("");
        System.out.println("----DAR ALTA EDITORIAL----");
        System.out.println("");
        System.out.print("Nombre: "); String nombre = scan.next();
        try{
            Editorial editorial = dao.buscarEditorialNombre(nombre);
            editorial.setAlta(Boolean.TRUE);
            dao.editar(editorial);
            System.out.println("");
            System.out.println("----LA EDITORIAL " + nombre.toUpperCase() + " SE HA DADO DE ALTA CORRECTAMENTE----");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public void mostrarEditoriales(){
        System.out.println("");
        System.out.println("----EDITORIALES----");
        System.out.println("");
        try{
            for(Editorial aux : dao.listarEditoriales()){
                System.out.println(aux.toString());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void eliminarEditorial(){
        System.out.println("");
        System.out.println("----ELIMINAR EDITORIAL----");
        System.out.println("");
        System.out.print("Id editorial: "); int id = scan.nextInt();
        try{
            dao.eliminar(dao.buscarEditorialID(id));
            System.out.println("");
            System.out.println("----EDITORIAL ELIMINADA CON ÉXITO----");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
