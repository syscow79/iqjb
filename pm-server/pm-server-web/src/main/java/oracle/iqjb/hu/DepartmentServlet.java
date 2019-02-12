/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.iqjb.hu.exception.MyException;
import oracle.iqjb.hu.facade.DepartmentSessionService1;
import oracle.iqjb.hu.pm.dm.Department;
import oracle.iqjb.hu.pm.intf.message.AddDepartmentRequest;
import oracle.iqjb.hu.pm.intf.message.AddDepartmentResponse;

/**
 *
 * @author oracle
 */
@WebServlet(name = "DepartmentServlet", urlPatterns = {"/DepartmentServlet"})
public class DepartmentServlet extends HttpServlet {

    @EJB
    private DepartmentSessionService1 departmentSessionService1;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DepartmentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DepartmentServlet at " + request.getContextPath() + "</h1>");

            AddDepartmentRequest addDepartmentRequest = new AddDepartmentRequest("department10");
            try {
                AddDepartmentResponse addDepartmentResponse = 
                        departmentSessionService1.addDepartment(addDepartmentRequest);
            } catch (MyException ex) {
                Logger.getLogger(DepartmentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            out.println("</body>");
            out.println("</html>");
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
