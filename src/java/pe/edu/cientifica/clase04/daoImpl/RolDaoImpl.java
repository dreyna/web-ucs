
package pe.edu.cientifica.clase04.daoImpl;

/**
 *
 * @author Docente
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.cientifica.clase04.config.Conexion;
import pe.edu.cientifica.clase04.dao.RolDao;
import pe.edu.cientifica.clase04.entity.Rol;


/**
 *
 * @author alum.fial1
 */
public class RolDaoImpl implements RolDao{
    //private CallableStatement cst;
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Rol r) {
        int x =0;
        String SQL ="INSERT INTO rol (nombre) values(?)";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, r.getNomrol());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }
    @Override
    public int update(Rol r) {
        int x = 0;
        String SQL ="UPDATE rol set nombre=? WHERE idrol=?";
        //UPDATE `rol` SET `nombre` = 'Gerente Finanzas' WHERE `rol`.`idrol` = 3;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, r.getIdr());
            ps.setString(2, r.getNomrol());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }
    @Override
    public int delete(int key) {//call eliminarRol(11)
        String SQL ="delete from rol where idrol=?";
        boolean p = false;
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareCall(SQL);
            ps.setInt(1, key);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;        
    }

    @Override
    public Rol read(int key) {
        String SQL ="select *from rol where idrol=?";
        Rol r = new Rol();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, key);
            rs = ps.executeQuery();
            while(rs.next()){
               r.setIdr(rs.getInt("idrol"));
               r.setNomrol(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+ e);
        }
        //call searchId(4);
        return r;        
    }

    @Override
    public List<Rol> readAll() {
        List<Rol> datos = new ArrayList<>();
        String SQL ="select *from rol";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Rol r = new Rol();
                r.setIdr(rs.getInt("idrol"));
                r.setNomrol(rs.getString("nombre"));
                datos.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return datos;
    }

    @Override
    public boolean search(String rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
