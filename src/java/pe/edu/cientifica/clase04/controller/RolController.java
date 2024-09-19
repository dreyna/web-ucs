package pe.edu.cientifica.clase04.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cientifica.clase04.dao.RolDao;
import pe.edu.cientifica.clase04.daoImpl.RolDaoImpl;
import pe.edu.cientifica.clase04.entity.Rol;

/**
 *
 * @author Docente
 */
public class RolController extends HttpServlet {

    private static RolDao rd = new RolDaoImpl();
    private static Gson g = new Gson();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int op = Integer.parseInt(request.getParameter("opc"));
        switch (op) {
            case 1 ->
                out.println(g.toJson(rd.readAll()));
            case 2 ->
                out.println(g.toJson(rd.read(Integer.parseInt(request.getParameter("id")))));
            case 3 -> {
                Rol rol = new Rol(request.getParameter("nombrerol"));
                rd.create(rol);
            }
            case 4 -> {
                Rol ro = new Rol(Integer.parseInt(request.getParameter("id")), request.getParameter("nomrol"));
                rd.update(ro);
            }
            case 5 ->
                rd.delete(Integer.parseInt(request.getParameter("id")));

        }    
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
