
package libreriajpa.Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class DAO {
    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaJPAPU");
    protected EntityManager em;

    protected void conectar() {
        if (!em.isOpen()) {
            em = emf.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void guardar (Object objeto) {
        try {
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
        desconectar();
        }
    }

    protected void editar(Object objeto) {
        try {
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
        desconectar();
        }
    }

    protected void eliminar(Object objeto) {
        try {
        conectar();
        em.getTransaction().begin();
        em.remove(em.merge(objeto));
        em.getTransaction().commit();
        desconectar(); 
        } catch (Exception e) {
            System.out.println(e);
        } finally{
        desconectar();
        }
    }
}

