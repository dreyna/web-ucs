/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pe.edu.cientifica.clase04.test;

import com.google.gson.Gson;
import pe.edu.cientifica.clase04.config.Conexion;
import pe.edu.cientifica.clase04.dao.RolDao;
import pe.edu.cientifica.clase04.daoImpl.RolDaoImpl;
import pe.edu.cientifica.clase04.entity.Rol;

/**
 *
 * @author Docente
 */
public class Test {
   private static RolDao rdao= new RolDaoImpl();
   private static Gson gson = new Gson();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //conectar();
        //listar();
        //crear();
        //update();
        //buscar();
        //eliminar();
    }
    public static void conectar(){
        if(Conexion.getConexion()!=null){
            System.out.println("Conectado");
        }else{
            System.out.println("No conectado");
        }
    }
    public static void listar(){
        System.out.println(gson.toJson(rdao.readAll()));
    }
    public static void crear(){
        System.out.println(gson.toJson(rdao.create(new Rol(0,"Gerente Marketing"))));
    }
    public static void update(){
        System.out.println(gson.toJson(rdao.update(new Rol(3,"Gerente RRHH"))));
    }
    public static void buscar(){
        System.out.println(gson.toJson(rdao.read(3)));
    }
    public static void eliminar(){
        System.out.println(gson.toJson(rdao.delete(3)));
    }
}
