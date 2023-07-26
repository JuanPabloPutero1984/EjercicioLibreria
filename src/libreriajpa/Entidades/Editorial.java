
package libreriajpa.Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Editorial implements Serializable{
    private String nombre;
    private Boolean alta;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer Id;

    public Editorial() {
    }

    public Editorial(String nombre, Boolean alta, Integer Id) {
        this.nombre = nombre;
        this.alta = alta;
        this.Id = Id;
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

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Editorial{" + "nombre=" + nombre + ", alta=" + alta + ", Id=" + Id + '}';
    }
    
}
