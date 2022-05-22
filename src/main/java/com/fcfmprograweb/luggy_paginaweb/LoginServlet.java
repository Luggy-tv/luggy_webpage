/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fcfmprograweb.luggy_paginaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luisa
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        boolean userExists =false, passCorrect=false;
        
       String usuario = request.getParameter("usuarioLogin");
       String pass = request.getParameter("passwordLogin");
        System.out.println("Nombre"+usuario);
       try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/luggy?useSSL=false&allowPublicLeyRetrieval=true&characterEncoding=UTF8", "root", "4&Yi3YXQQ#nx?iHo");
                Statement stmt =con.createStatement();

                ResultSet rs= stmt.executeQuery("select usuario,contraseña from usuario;");
                while(rs.next()){
                    if(usuario.matches(rs.getString("usuario"))){
                        userExists=true;
                        if(pass.matches(rs.getString("contraseña"))){
                            passCorrect=true;
                        }
                    }
                }
                con.close();
       }
       catch(SQLException ex){
                    response.sendRedirect(request.getContextPath() +"/errorPage.jsp");
                    System.out.println("El error es =");
                    System.out.println(ex);
                    System.out.println("Error en la conexion con MYSQL");
            } 
            catch (ClassNotFoundException ex) {
                    response.sendRedirect(request.getContextPath() +"/errorPage.jsp");
                    System.out.println("ClassNotFoundException"+ex);
            }
        
            if(userExists && passCorrect){
                System.out.println("Iniciando sesion");
                response.sendRedirect(request.getContextPath() +"/menu.jsp");
            }else{
                System.out.println("Usuario o contraseña invalido");
                response.sendRedirect(request.getContextPath() +"/loginFail.jsp");
            }
        
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
