package main2;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mi_tabla")
public class Usuario {
    @Id
    @Basic(optional=false)
    private int dni;
    @Basic(optional=false)
    private String nombre;
    
    /*
     * Getters y setters.
     */
    
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
