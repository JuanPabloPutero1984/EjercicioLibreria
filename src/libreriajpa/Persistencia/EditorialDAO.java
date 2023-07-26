
package libreriajpa.Persistencia;

import libreriajpa.Entidades.Editorial;




public class EditorialDAO extends DAO{
public void guardarEditorial(Editorial ed) {
        try {
            guardar(ed);
        } catch (Exception e) {
            System.out.println("No se pudo guardar la editorial");
        }
    }
    
    public void editarEditorial(Long Id, String nombrenuevo) {
        try {
            Editorial editorial = em.find(Editorial.class, Id);
            editorial.setNombre(nombrenuevo);
            editar(editorial);
            
        } catch (Exception e) {
            System.out.println("No se encontro ese Id");
        }
    }
    
    public void eliminarEditorial(Long Id){
        try {
            Editorial editorial = em.find(Editorial.class, Id);
            eliminar(editorial);
        } catch (Exception e) {
            System.out.println("No se puede eliminar");
        }
    }
    
    public void removerEditorial(Long Id){
        try {
            Editorial editorial = em.find(Editorial.class, Id);
            editorial.setAlta(false);
            editar(editorial);
        } catch (Exception e) {
            System.out.println("No se puede remover");
        }
    }
}
