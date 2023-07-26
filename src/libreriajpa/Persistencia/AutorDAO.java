package libreriajpa.Persistencia;

import libreriajpa.Entidades.Autor;

public class AutorDAO extends DAO {

    public void guardarAutor(Autor a) {
        try {
            guardar(a);
        } catch (Exception e) {
            System.out.println("No se pudo guardar el autor");
        }
    }
    
    public void editarAutor(Long Id, String nombrenuevo) {
        try {
            Autor autor = em.find(Autor.class, Id);
            autor.setNombre(nombrenuevo);
            editar(autor);
            
        } catch (Exception e) {
            System.out.println("No se encontro ese nombre");
        }
    }
    
    public void eliminarAutor(Long Id){
        try {
            Autor autor = em.find(Autor.class, Id);
            eliminar(autor);
        } catch (Exception e) {
            System.out.println("No se puede eliminar");
        }
    }
    
    public void removerAutor(Long Id){
        try {
            Autor autor = em.find(Autor.class, Id);
            autor.setAlta(false);
            editar(autor);
        } catch (Exception e) {
            System.out.println("No se puede remover");
        }
    }
}
