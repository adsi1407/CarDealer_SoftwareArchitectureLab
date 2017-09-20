/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.cardealer.servlet;

import co.com.cardealer.ejb.TipoIdentificacionFacadeLocal;
import co.com.cardealer.entity.TipoIdentificacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DAVID
 */
public class TipoIdentificacionServlet extends HttpServlet {

    @EJB
    private TipoIdentificacionFacadeLocal tipoIdentificacionFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String action = request.getParameter("action");
            String url = "index.jsp";
            
            if (null != action) switch (action) {
                case "list":
                    
                    List<TipoIdentificacion> tiposIdentificacion = tipoIdentificacionFacade.findAll();
                    request.getSession().setAttribute("tiposIdentificacion", tiposIdentificacion);
                    url = "listaTiposIdentificacion.jsp";
                    break;
                case "search":{
                    
                    TipoIdentificacion tipoIdentificacion = tipoIdentificacionFacade.find(request.getParameter("codigo"));
                    request.getSession().setAttribute("tipoIdentificacion", tipoIdentificacion);
                    url = "tipoIdentificacion.jsp";
                    break;
                }
                default:
                    break;
            }
        } finally {
            
            out.close();
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
