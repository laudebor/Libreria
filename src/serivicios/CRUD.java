package serivicios;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class CRUD {
    
    EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
    
    public void conectar(){
        if(!em.isOpen()){
            em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        }
    }
    
    public void desconectar(){
        if(em.isOpen()){
            em.close();
        }
    }
    
    public void guardar(Object objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    public void eliminar(Object objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    public void editar(Object objeto){
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    
}
