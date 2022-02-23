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
            return editorial;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
}
