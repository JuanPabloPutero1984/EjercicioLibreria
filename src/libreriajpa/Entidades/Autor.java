
package libreriajpa.Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor implements Serializable{
    private String nombre;
    private Boolean alta;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ID;

    public Autor() {
    }

    public Autor(String nombre, Boolean alta, Integer ID) {
        this.nombre = nombre;
        this.alta = alta;
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Autor{" + "nombre=" + nombre + ", alta=" + alta + ", ID=" + ID + '}';
    }
    
}
