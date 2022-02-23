package principal;

import persistencia.AutorDAO;
import serivicios.AutorServicio;
import serivicios.LibroServicio;

public class Main {

    public static void main(String[] args) {
        
//        AutorServicio as = new AutorServicio();
//        System.out.println(as.BuscarAutor("autor1").toString());
        
        LibroServicio ls = new LibroServicio();
        ls.crearLibro();
        
    }
    
}
