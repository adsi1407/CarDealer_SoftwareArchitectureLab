/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.cardealer.servlet;

import co.com.cardealer.ejb.VehiculoFacadeLocal;
import co.com.cardealer.entity.Vehiculo;
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
public class VehiculoServlet extends HttpServlet {

    @EJB
    private VehiculoFacadeLocal vehiculoFacade;

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
                    
                    List<Vehiculo> vehiculos = vehiculoFacade.findAll();
                    request.getSession().setAttribute("vehiculos", vehiculos);
                    url = "listaVehiculos.jsp";
                    break;
                case "insert":{
                    
                    Vehiculo vehiculo = new Vehiculo();
                    vehiculo.setMatricula(request.getParameter("matricula"));
                    vehiculo.setPlaca(request.getParameter("placa"));
                    vehiculo.setMarca(request.getParameter("marca"));
                    vehiculo.setLinea(request.getParameter("linea"));
                    vehiculo.setModelo(Integer.parseInt(request.getParameter("modelo")));
                    vehiculo.setCilindraje(Double.parseDouble(request.getParameter("cilindraje")));
                    vehiculo.setClaseVehiculo(request.getParameter("claseVehiculo"));
                    vehiculo.setTipoCarroceria(request.getParameter("tipoCarroceria"));
                    vehiculo.setTipoCombustible(request.getParameter("tipoCombustible"));
                    vehiculoFacade.create(vehiculo);
                    url = "listaVehiculos.jsp";
                    break;
                    }
                case "update":{
                    
                    Vehiculo vehiculo = new Vehiculo();
                    vehiculo.setMatricula(request.getParameter("matricula"));
                    vehiculo.setPlaca(request.getParameter("placa"));
                    vehiculo.setMarca(request.getParameter("marca"));
                    vehiculo.setLinea(request.getParameter("linea"));
                    vehiculo.setModelo(Integer.parseInt(request.getParameter("modelo")));
                    vehiculo.setCilindraje(Double.parseDouble(request.getParameter("cilindraje")));
                    vehiculo.setClaseVehiculo(request.getParameter("claseVehiculo"));
                    vehiculo.setTipoCarroceria(request.getParameter("tipoCarroceria"));
                    vehiculo.setTipoCombustible(request.getParameter("tipoCombustible"));
                    vehiculoFacade.edit(vehiculo);
                    url = "listaVehiculos.jsp";
                    break;
                    }
                case "search":{
                    
                    Vehiculo vehiculo = vehiculoFacade.find(request.getParameter("matricula"));
                    request.getSession().setAttribute("vehiculo", vehiculo);
                    url = "detalleVehiculo.jsp";
                    break;
                }
                default:
                    break;
            }
            
            response.sendRedirect(url);
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
