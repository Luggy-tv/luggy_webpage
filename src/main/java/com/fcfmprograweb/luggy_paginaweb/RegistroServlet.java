/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fcfmprograweb.luggy_paginaweb;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luisa
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class RegistroServlet extends HttpServlet {

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
            out.println("<title>Servlet RegistroServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistroServlet at " + request.getContextPath() + "</h1>");
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
            boolean freeUser=true;
        
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String fechanac = request.getParameter("fechanac");
            String correo = request.getParameter("correoElectronico");
            String usuario = request.getParameter("nombreDeUsuario");
            String pass = request.getParameter("password");
            
            //InputStream inputStream = null;
            
            System.out.println("Este es el nombre: "+nombres);
            System.out.println("Este es el apellido: "+apellidos);
            System.out.println("Este es el usuario: "+usuario);
            
            /*Part filePart = request.getPart("imagenPerfil");
            if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            }*/
            
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/luggy?useSSL=false&allowPublicLeyRetrieval=true&characterEncoding=UTF8", "root", "4&Yi3YXQQ#nx?iHo");
                Statement stmt =con.createStatement();

                ResultSet rs= stmt.executeQuery("select usuario from usuario;");
                while(rs.next()){
                    if(usuario.matches(rs.getString("usuario"))){
                        freeUser=false;
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
            
            if(!freeUser){
                System.out.println("Datos NO enviados");
                     response.sendRedirect(request.getContextPath() +"/registroFail.jsp");
            }
            else{
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/luggy?useSSL=false&allowPublicLeyRetrieval=true", "root", "4&Yi3YXQQ#nx?iHo");
                    PreparedStatement stmt =con.prepareStatement("INSERT INTO usuario(usuario,contraseña,nombres,apellidos,mail,fechaNac) VALUES(?,?,?,?,?,?)");
                    stmt.setString(1, usuario);
                    stmt.setString(2, pass);
                    stmt.setString(3, nombres);
                    stmt.setString(4, apellidos);
                    stmt.setString(5,correo);
                    stmt.setString(6, fechanac);

                    stmt.execute();
                    con.close();
                    System.out.println("Datos enviados a sql");
                     response.sendRedirect(request.getContextPath() +"/registroExito.jsp");
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
            }
            //?useSSL=false&allowPublicLeyRetrieval=true
            
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
