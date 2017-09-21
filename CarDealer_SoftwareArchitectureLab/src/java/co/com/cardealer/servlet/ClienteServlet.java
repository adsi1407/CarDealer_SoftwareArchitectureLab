/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.cardealer.servlet;

import co.com.cardealer.ejb.ClienteFacadeLocal;
import co.com.cardealer.entity.Cliente;
import co.com.cardealer.entity.ClientePK;
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
public class ClienteServlet extends HttpServlet {

    @EJB
    private ClienteFacadeLocal clienteFacade;

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
                    List<Cliente> clientes = clienteFacade.findAll();
                    request.getSession().setAttribute("clientes", clientes);
                    url = "listaClientes.jsp";
                    break;
                case "insert":{
                    Cliente cliente = new Cliente();
                    cliente.setNombre(request.getParameter("nombre"));
                    cliente.setApellido(request.getParameter("apellido"));
                    cliente.setTelefono(request.getParameter("telefono"));
                    cliente.setEmail(request.getParameter("email"));
                    cliente.setDireccion(request.getParameter("direccion"));
                    clienteFacade.create(cliente);
                    url = "listaClientes.jsp";
                    break;
                    }
                case "update":{
                    Cliente cliente = new Cliente();
                    cliente.setNombre(request.getParameter("nombre"));
                    cliente.setApellido(request.getParameter("apellido"));
                    cliente.setTelefono(request.getParameter("telefono"));
                    cliente.setEmail(request.getParameter("email"));
                    cliente.setDireccion(request.getParameter("direccion"));
                    clienteFacade.edit(cliente);
                    url = "listaClientes.jsp";
                    break;
                    }
                case "search":{
                    
                    ClientePK clientePk = new ClientePK();
                    clientePk.setTipoIdentificacion(Integer.parseInt(request.getParameter("tipoIdentificacion")));
                    clientePk.setNumeroIdentificacion(request.getParameter("numeroIdentificacion"));
                    Cliente cliente = clienteFacade.find(clientePk);
                    request.getSession().setAttribute("cliente", cliente);
                    url = "detalleCliente.jsp";
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
