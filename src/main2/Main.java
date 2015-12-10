package main2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main { 

    public static void main(String[] args) { 
        EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("introduccionJPA"); 
        EntityManager em = emf.createEntityManager(); 
        EntityTransaction tx = em.getTransaction(); 
         
        Pelicula pelicula = new Pelicula(); 
        pelicula.setTitulo("Pelicula uno"); 
        pelicula.setDuracion(142); 
         
        tx.begin(); 
        try { 
            em.persist(pelicula); 
            tx.commit(); 
        } catch(Exception e) { 
            tx.rollback();
        } 
         
        em.close(); 
        emf.close(); 
    } 
}
