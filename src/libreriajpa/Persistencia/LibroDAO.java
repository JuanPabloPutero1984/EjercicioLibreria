
package libreriajpa.Persistencia;

import java.util.List;
import javax.persistence.Query;
import libreriajpa.Entidades.Libro;


public class LibroDAO extends DAO{
public void guardarLibro(Libro l) {
        try {
            guardar(l);
        } catch (Exception e) {
            System.out.println("No se pudo guardar el libro");
        }
    }
    
    public void editarLibro(Long Id, String titulonuevo) {
        try {
            Libro libro = em.find(Libro.class,Id);
            libro.setTitulo(titulonuevo);
            editar(libro);
            
        } catch (Exception e) {
            System.out.println("No se encontro ese Id");
        }
    }
    
    public void eliminarLibro(Long Id){
        try {
            Libro libro = em.find(Libro.class, Id);
            eliminar(libro);
        } catch (Exception e) {
            System.out.println("No se puede eliminar");
        }
    }
    
    public void removerLibro(Long Id){
        try {
            Libro libro = em.find(Libro.class, Id);
            libro.setAlta(false);
            editar(libro);
        } catch (Exception e) {
            System.out.println("No se puede remover");
        }
    }
    
    public List consultaGeneral(String entidad, String atributo, String variable){
        String jpql = "SELECT e FROM " + entidad + " e WHERE e." + atributo + " LIKE :variable";
        Query query = em.createQuery(jpql);
        query.setParameter("variable", "%" + variable + "%");
        return query.getResultList();
    }
}
