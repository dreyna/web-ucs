
package pe.edu.cientifica.clase04.dao;

import java.util.List;
import pe.edu.cientifica.clase04.entity.Rol;

/**
 *
 * @author Docente
 */
public interface RolDao {
    int create(Rol r);
    int update(Rol r);
    int delete(int key);
    Rol read(int key);
    List<Rol> readAll();
    boolean search(String rol);
}
