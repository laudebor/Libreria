package persistencia;

import entidades.Autor;
import java.util.List;

public class AutorDAO extends DAO<Autor> {

    
    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    @Override
    public void eliminar(Autor autor) {
        super.eliminar(autor);
    }

    @Override
    public void editar(Autor autor) {
        super.editar(autor);
    }

    public Autor buscarAutorId(Integer id) {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id")
                .setParameter("id", id).getSingleResult();
        desconectar();
        return autor;
    }

    public Autor buscarAutorNombre(String nombre) {

        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return autor;

    }

    public List<Autor> listarAutores() {

        conectar();
        List<Autor> autores = (List<Autor>) em.createQuery("SELECT a FROM Autor a").getResultList();
        desconectar();
        return autores;

    }

}
