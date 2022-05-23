/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fcfmprograweb.luggy_paginaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luisa
 */
@WebServlet(name = "addNServlet", urlPatterns = {"/addNServlet"})
public class addNServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addNServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addNServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
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
         response.sendRedirect(request.getContextPath() +"/addNota.jsp");
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
        request.setCharacterEncoding("UTF-8");
        int idUsuario =(int)request.getSession().getAttribute("IdUsuario");
        String contenido_ = request.getParameter("newNota");
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/luggy?useSSL=false&allowPublicLeyRetrieval=true", "root", "4&Yi3YXQQ#nx?iHo");
            
            PreparedStatement stmt =con.prepareStatement("INSERT INTO nota(idUsuarioFK,contenido) VALUES(?,?)");
            stmt.setInt(1,idUsuario);
            stmt.setString(2,contenido_);
            stmt.execute();
            con.close();
            System.out.print("Nota Creada, regresando al menú...");
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        response.sendRedirect(request.getContextPath() +"/LoginServlet");
        //request.getRequestDispatcher("LoginServlet").forward(request,response);
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
