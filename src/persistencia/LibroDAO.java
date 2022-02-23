
package persistencia;

import entidades.Libro;
import java.util.List;

public final class LibroDAO extends DAO<Libro>{

    @Override
    public void editar(Libro libro) {
        super.editar(libro); 
    }

    @Override
    public void eliminar(Libro libro) {
        super.eliminar(libro); 
    }

    @Override
    public void guardar(Libro libro) {
        super.guardar(libro); 
    }
    
   public List<Libro> buscarLibroNombre(String nombre){
       try{
           conectar();
           List<Libro> libros = (List<Libro>) em.createQuery("SELECT l FROM Libro l WHERE l.nombre LIKE :nombre")
                   .setParameter("nombre", nombre).getResultList();
           return libros;
       }catch(Exception e){
           System.out.println("Error en buscarlibroNombre");
           throw e;
       }
   }
    
    
}
