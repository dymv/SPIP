/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dymsha.spip.lab1;

import com.dymsha.spip.lab1.core.Area;
import com.dymsha.spip.lab1.core.HitChecker;
import com.dymsha.spip.lab1.core.shape.OurPoint;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eugene
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
            /*
             * TODO output your page here. You may use following sample code.
             */
            
            RequestParser requestParser = new RequestParser(request);
            Lab1AreaFactory lab1AreaFactory = new Lab1AreaFactory();
            Area lab1Area = lab1AreaFactory.produceArea(requestParser.getR());
            HitChecker hitChecker = new HitChecker();
                        
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lab.1</title>");  
            out.println("<link href='style.css' rel='stylesheet' type='text/css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<img src="+request.getRequestURL().substring(0, request.getRequestURL().lastIndexOf("/"))+"/var.png><br>");
            out.println("Your Points:<br>");
            out.println("<b>x:</b> "+requestParser.getX()+"<br>");
            out.println("<b>y:</b> "+requestParser.getY()+"<br>");
            out.println("<b>R:</b> "+requestParser.getR()+"<br>");
            out.println("<hr>");
            if (hitChecker.checkPoint(lab1Area, new OurPoint(requestParser.getX(), requestParser.getY()))) {
                out.println("<i style='background:#d5f8d5;'>Success! Area contains the point!</i>");
            } else {
                out.println("<i style='background:#fedbd2'>Failure! Area does not contain the point.</i>");
            }
            out.println("<a href="+request.getRequestURL().substring(0, request.getRequestURL().lastIndexOf("/"))+"><i>Again?</i></a>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
