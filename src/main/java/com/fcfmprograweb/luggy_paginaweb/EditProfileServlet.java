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
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luisa
 */
@WebServlet(name = "EditProfileServlet", urlPatterns = {"/EditProfileServlet"})
public class EditProfileServlet extends HttpServlet {

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
            out.println("<title>Servlet EditProfileServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditProfileServlet at " + request.getContextPath() + "</h1>");
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
            
            classUsuario oldUsuario =(classUsuario) request.getSession().getAttribute("usuario");
            int idUsuario =(int)request.getSession().getAttribute("IdUsuario");
            String nomUsuario= oldUsuario.getUsuario();
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String fechanac = request.getParameter("fechanac");
            String correo = request.getParameter("correoElectronico");
            String pass = request.getParameter("password");

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/luggy?useSSL=false&allowPublicLeyRetrieval=true", "root", "4&Yi3YXQQ#nx?iHo");
                PreparedStatement stmt =con.prepareStatement("UPDATE usuario SET contraseña = ?, nombres = ? , apellidos = ? , mail = ? , fechaNac = ? WHERE idUsuario = ?");

                stmt.setString(1, pass);
                stmt.setString(2, nombres);
                stmt.setString(3, apellidos);
                stmt.setString(4,correo);
                stmt.setString(5, fechanac);
                stmt.setInt(6, idUsuario);

                stmt.execute();
                con.close();
                System.out.println("Datos enviados a sql");
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
            HttpSession miSesion = request.getSession();
            classUsuario updateusuario =new classUsuario();
            
            
            updateusuario.setIdUsuario(idUsuario);
            updateusuario.setUsuario(nomUsuario);
            updateusuario.setContraseña(pass);
            updateusuario.setNombres(nombres);
            updateusuario.setApellidos(apellidos);
            updateusuario.setMail(correo);
            updateusuario.setFechaNac(fechanac);
            
            miSesion.setAttribute("usuario",updateusuario);
            miSesion.setAttribute("IdUsuario",updateusuario.getIdUsuario());
            
            response.sendRedirect(request.getContextPath() +"/menu.jsp");
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
