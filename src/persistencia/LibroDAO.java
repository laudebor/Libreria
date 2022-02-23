
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
           conectar();
           List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :nombre")
                   .setParameter("nombre", nombre).getResultList();
           desconectar();
           return libros;
   }
   
   public Libro buscarLibroISBN(int isbn){
       conectar();
       Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn").setParameter("isbn", isbn).getSingleResult();
       desconectar();
       return libro;
   }
   
   public List<Libro> listarLibros(){
       conectar();
       List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
       desconectar();
       return libros;
   }
    
//   public void eliminarPorISBN(int isbn){
//       Libro libro = buscarLibroISBN(isbn);
//       eliminar(libro);
//   }
    
}
