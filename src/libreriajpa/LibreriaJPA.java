
package libreriajpa;

import java.util.Scanner;
import libreriajpa.Servicio.AutorServicio;
import libreriajpa.Servicio.EditorialServicio;
import libreriajpa.Servicio.LibroServicio;


public class LibreriaJPA {

   
    public static void main(String[] args) {
        AutorServicio as1 = new AutorServicio();
        EditorialServicio es1 = new EditorialServicio();
        LibroServicio ls1 = new LibroServicio();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Boolean menu = true;
        
        do {
            System.out.println("Bievenido al menu de opciones"
                    + "\n1-crear libro"
                    + "\n2-editar libro"
                    + "\n3-eliminar libro"
                    + "\n4-remover libro"
                    + "\n5-Salir");
            int rta = leer.nextInt();
            
            switch (rta) {
                case 1:
                    ls1.guardarLibro();
                    break;
                case 2:
                    ls1.editarLibro();
                    break;
                case 3:
                    ls1.eliminarLibro();
                    break;
                case 4:
                    ls1.removerLibro();
                    break;
                case 5:
                    menu=false;
                    break;
                default:
                    System.out.println("Inrese una opcion valida");
            }
        } while (menu);
        
    }

}
