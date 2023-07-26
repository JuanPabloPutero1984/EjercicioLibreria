
package libreriajpa.Servicio;

import java.util.List;
import java.util.Scanner;
import libreriajpa.Entidades.Autor;
import libreriajpa.Entidades.Editorial;
import libreriajpa.Entidades.Libro;
import libreriajpa.Persistencia.LibroDAO;


public class LibroServicio {
    LibroDAO ldao = new LibroDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorServicio as1 = new AutorServicio();
    EditorialServicio eds1 = new EditorialServicio();
    
    public void guardarLibro (){
        try {
        Libro l = new Libro();
        System.out.println("Ingrese el titulo de su libro");
        l.setTitulo(leer.next());
        System.out.println("De que año es el libro");
        l.setAnio(leer.nextInt());
        System.out.println("Cuantos ejemplares tiene el libro");
        l.setEjemplares(leer.nextInt());
        System.out.println("Cuantos ejemplares se han prestado");
        l.setEjemplaresPrestados(leer.nextInt());
        l.setEjemplaresRestantes(l.getEjemplares()-l.getEjemplaresPrestados());
        l.setAlta(true);
        System.out.println("Ingrese ISBN");
        l.setIsbn(leer.nextLong());
        
        System.out.println("Ingrese el nombre del autor");
        String autor = leer.next();
        Boolean autornoencontrado = true;
        List<Autor> autores = ldao.consultaGeneral("Autor","nombre", autor);
        for (Autor aux : autores) {
            if (aux.getNombre().equalsIgnoreCase(autor)) {
                l.setAutor(aux);
                autornoencontrado=false;
            }
            
        }
            System.out.println("Busco el autor");
        if (autornoencontrado) {
            System.out.println("El autor no se encontro, desea registrarlo? S/N");
            String respuesta = leer.next();
            if (respuesta.equalsIgnoreCase("s")) {
                Autor a1 = as1.guardarAutor();
                l.setAutor(a1);
            }
        }
        
        System.out.println("Ingrese el nombre de la editorial");
        String editorial = leer.next();
        Boolean editorialnoencontrada = true;
        List<Editorial> editoriales = ldao.consultaGeneral("Editorial", "nombre", editorial);
        for (Editorial aux : editoriales) {
            if (aux.getNombre().equalsIgnoreCase(editorial)) {
                l.setEditorial(aux);
                editorialnoencontrada=false;
            }
        }
        if (editorialnoencontrada) {
            System.out.println("La editorial no se encontro, desea registrarla? S/N");
            String respuesta = leer.next();
            if (respuesta.equalsIgnoreCase("s")) {
                Editorial e1 = eds1.guardarEditorial();
                l.setEditorial(e1);
            }
        }
        ldao.guardarLibro(l);
        } catch(Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void editarLibro() {
        try {
        System.out.println("Ingrese el ID del autor que quiere editar");
        Long id = leer.nextLong();
        System.out.println("Ingrese el titulo nuevo del libro");
        String titulonuevo = leer.next();
        ldao.editarLibro(id, titulonuevo);
        } catch (Exception e) {
        }
    }
    
    public void eliminarLibro() {
        try {
            System.out.println("Ingrese el ID del libro que quiere eliminar");
            Long id = leer.nextLong();
            ldao.eliminarLibro(id);
        } catch (Exception e) {
        }
    }
    
    public void removerLibro() {
        try {
            System.out.println("Ingrese el ID del libro que quiere remover");
            Long id = leer.nextLong();
            ldao.removerLibro(id);
        } catch (Exception e) {
        }
    }
    
    
}
