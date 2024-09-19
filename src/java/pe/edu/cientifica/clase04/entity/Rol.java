
package pe.edu.cientifica.clase04.entity;

/**
 *
 * @author Docente
 */
public class Rol {
    private int idr;
    private String nomrol;

    public Rol() {
    }

    public Rol(String nomrol) {
        this.nomrol = nomrol;
    }

    public Rol(int idr, String nomrol) {
        this.idr = idr;
        this.nomrol = nomrol;
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getNomrol() {
        return nomrol;
    }

    public void setNomrol(String nomrol) {
        this.nomrol = nomrol;
    }
    
}
