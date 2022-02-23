package persistencia;

import entidades.Editorial;
import java.util.List;

public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void editar(Editorial editorial) {
        super.editar(editorial); 
    }

    @Override
    public void eliminar(Editorial editorial) {
        super.eliminar(editorial); 
    }

    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial); 
    }
    
    public Editorial buscarEditorialNombre(String nombre){
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return editorial;
    }
    
    public Editorial buscarEditorialID(int id){
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id LIKE :id")
                .setParameter("id", id).getSingleResult();
        desconectar();
        return editorial;
    }
    
    public List<Editorial> listarEditoriales(){
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
        desconectar();
        return editoriales;
    }
    
    
    
    
    
}
