
package com.mycompany.titosrestobar.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//clase con generico para aplicar a las entity que voy a usar
//abstract class es para no poder instanciarse fuera del DAO (persistencia)
public abstract class PersistenceJpa<T>{

    protected EntityManagerFactory emf;
    protected EntityManager em;
    
    public PersistenceJpa(){
        emf = Persistence.createEntityManagerFactory("TitosRestobarJPA");
        em = emf.createEntityManager();
    }
    
    protected void connect(){
        if(!em.isOpen()) 
            em = emf.createEntityManager();
    }
    
    protected void disconnect(){
        if(em.isOpen())
            em.close();
    }
    
    protected void create(T object){
        try{
            connect();
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Error al crear el objeto" + e.getMessage());
            if(em.getTransaction().isActive());
               em.getTransaction().rollback();
        }finally{
            disconnect();
        }
    }
    
    protected void update(T object){
        try{
            connect();
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Error al actualizar el objeto" + e.getMessage());
            if(em.getTransaction().isActive());
               em.getTransaction().rollback();
        }finally{
            disconnect();
        }
        
    }
    
    protected void delete(T object){
        try{
            connect();
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Error al eliminar el objeto" + e.getMessage());
            if(em.getTransaction().isActive());
               em.getTransaction().rollback();
        }finally{
            disconnect();
        }
        
    }
}
