package libreriajpa.Servicio;

import java.util.Scanner;
import libreriajpa.Entidades.Editorial;
import libreriajpa.Persistencia.EditorialDAO;

public class EditorialServicio {

    EditorialDAO edao = new EditorialDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Editorial guardarEditorial() {
        try {
            
        Editorial ed = new Editorial ();
        System.out.println("Ingrese el nombre de la editorial");
        ed.setNombre(leer.next());
        ed.setAlta(true);
        edao.guardarEditorial(ed);
        return ed;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public void editarEditorial (){
        try {
            System.out.println("Ingrese el numero de id de la editorial");
            Long Id = leer.nextLong();
            System.out.println("Ingrese el nuevo nombre de la editorial");
            String nombrenuevo = leer.next();
            edao.editarEditorial(Id, nombrenuevo);
        } catch (Exception e) {
        }
    }
    
    public void eliminarEditorial () {
        try {
            System.out.println("Ingrese el numero de id de la editorial que desea eliminar");
            Long Id = leer.nextLong();
            edao.eliminarEditorial(Id);
        } catch (Exception e) {
        }
    }
    
    public void removerEditorial () {
        try {
            System.out.println("Ingrese el numero de id de la editorial que desea remover");
            Long Id = leer.nextLong();
            edao.removerEditorial(Id);
        } catch (Exception e) {
        }
    }
    
}
