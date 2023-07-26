
package libreriajpa.Servicio;

import java.util.Scanner;
import libreriajpa.Entidades.Autor;
import libreriajpa.Persistencia.AutorDAO;


public class AutorServicio {
    AutorDAO ad = new AutorDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public Autor guardarAutor() {
        try {
            
        Autor a1 = new Autor();
        System.out.println("Ingrese el nombre del autor");
        a1.setNombre(leer.next());
        a1.setAlta(true);
        ad.guardarAutor(a1);
        return a1;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    
    public void editarAutor(){
        try {
            System.out.println("Ingrese el ID del autor");
            Long Id = leer.nextLong();
            System.out.println("Ingrese el nombre del autor editado");
            String nombrenuevo = leer.next();
            ad.editarAutor(Id, nombrenuevo);
        } catch (Exception e) {
        }
    }
    
    public void eliminarAutor(){
        try {
            System.out.println("Ingrese el ID del autor");
            Long Id = leer.nextLong();
            ad.eliminarAutor(Id);
        } catch (Exception e) {
        }
    }
    
    public void removerAutor(){
        try {
            System.out.println("Ingrese el ID del autor");
            Long Id = leer.nextLong();
            ad.removerAutor(Id);
        } catch (Exception e) {
        }
    }
}
