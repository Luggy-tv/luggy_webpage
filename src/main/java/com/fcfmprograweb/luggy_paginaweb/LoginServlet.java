package com.fcfmprograweb.luggy_paginaweb;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        request.setCharacterEncoding("UTF-8");
        System.out.println("DoGet del servlet de inicio sesion");
       
        
         
        HttpSession miSesion = request.getSession();
        classUsuario usuario=(classUsuario)request.getSession().getAttribute("usuario");
        int numNotas=0;

        miSesion.setAttribute("usuario",usuario);
        miSesion.setAttribute("IdUsuario",usuario.getIdUsuario());

        System.out.println("Iniciando sesion y recolectando notas");

        boolean hayNotas= false;
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/luggy?useSSL=false&allowPublicLeyRetrieval=true&characterEncoding=UTF8", "root", "4&Yi3YXQQ#nx?iHo");
           Statement stmt =con.createStatement();
           ResultSet rs= stmt.executeQuery("SELECT idNota,idUsuarioFK FROM nota");
             while(rs.next()){
                 if(usuario.getIdUsuario()==rs.getInt("idUsuarioFK")){
                     hayNotas= true;
                 }
             }
             con.close();
        }
        catch(Exception ex){
                  System.out.println(ex);
              }

       //Obtiene las notas existentes del usuario de la base de datos.
        if(hayNotas){
            ArrayList<classNota> listaNotas = new ArrayList<>();
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/luggy?useSSL=false&allowPublicLeyRetrieval=true&characterEncoding=UTF8", "root", "4&Yi3YXQQ#nx?iHo");
                Statement stmt =con.createStatement();
                ResultSet rs= stmt.executeQuery("SELECT idNota,idUsuarioFK,createDateN,contenido,activa from nota where activa =1;");
                while(rs.next()){
                    if( usuario.getIdUsuario()==rs.getInt("idUsuarioFK")){
                        classNota nota= new classNota();
                        nota.setIdNota(rs.getInt("idNota"));
                        nota.setUsuarioFK(rs.getInt("idUsuarioFK"));
                        nota.setFechaCreacion(rs.getString("createDateN"));
                        nota.setContenido(rs.getString("contenido"));
                        nota.setActiva(rs.getBoolean("activa"));
                        listaNotas.add(nota);
                        numNotas=numNotas+1;

                    }
                }
                System.out.println("Notas agregadas a la lista");
                con.close();
            }
            catch(ClassNotFoundException | SQLException ex)
            {
                response.sendRedirect(request.getContextPath() +"/errorPage.jsp");
                System.out.println("El error es =");
                System.out.println(ex);
                System.out.println("Error en la conexion con MYSQL");
            }  
            miSesion.setAttribute("numNotas",numNotas);
            miSesion.setAttribute("listaNotas",listaNotas);
            response.sendRedirect(request.getContextPath() +"/menu.jsp");
        }
        else
        {
        ArrayList<classNota> listaNotas = new ArrayList<>();
        miSesion.setAttribute("numNotas",numNotas);
        miSesion.setAttribute("listaNotas",listaNotas);
        System.out.println("Sesion reiniciada redireccionando...");
        //request.getRequestDispatcher("menu.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath() +"/menu.jsp");
        }

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
        classUsuario usuario=new classUsuario();
        
        request.setCharacterEncoding("UTF-8");
        boolean userExists =false, passCorrect=false;
        
        //Define las variables usuario y contraseña que se mandaron desde el form de index.html 
        String sUsuario = request.getParameter("usuarioLogin");
        String pass = request.getParameter("passwordLogin");
       
        //una pequeña impresion a la consola para ver el usuario
        System.out.println("Nombre "+sUsuario);
       
        //Aqui verificamos si el usuario existe si es asi dos flags son levantadas positivas userExist y passCorrect
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/luggy?useSSL=false&allowPublicLeyRetrieval=true&characterEncoding=UTF8", "root", "4&Yi3YXQQ#nx?iHo");
            Statement stmt =con.createStatement();

            ResultSet rs= stmt.executeQuery("select idusuario,usuario,contraseña,nombres,apellidos,mail,fechaNac from usuario;");
            while(rs.next()){
                if(sUsuario.matches(rs.getString("usuario"))){
                    userExists=true;
                    if(pass.matches(rs.getString("contraseña"))){
                        passCorrect=true;
                    }
                    if(userExists&&passCorrect){
                        usuario.setIdUsuario(rs.getInt("idUsuario"));
                        usuario.setUsuario(rs.getString("usuario"));
                        usuario.setContraseña(rs.getString("contraseña"));
                        usuario.setNombres(rs.getString("nombres"));
                        usuario.setApellidos(rs.getString("apellidos"));
                        usuario.setMail(rs.getString("mail"));
                        usuario.setFechaNac(rs.getString("fechaNac"));
                    }
                }
            }
            con.close();
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            response.sendRedirect(request.getContextPath() +"/errorPage.jsp");
            System.out.println("El error es =");
            System.out.println(ex);
            System.out.println("Error en la conexion con MYSQL");
        } 
        
        
        //Aqui checamos si las dos flags existen si hay usuario y la contraseña es correcta entonces se crea la sesion de http
        if(userExists && passCorrect){       
             HttpSession miSesion = request.getSession();
            int numNotas=0;
            
            miSesion.setAttribute("usuario",usuario);
            miSesion.setAttribute("IdUsuario",usuario.getIdUsuario());
            
            System.out.println("Iniciando sesion y recolectando notas");
            
            boolean hayNotas= false;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/luggy?useSSL=false&allowPublicLeyRetrieval=true&characterEncoding=UTF8", "root", "4&Yi3YXQQ#nx?iHo");
                Statement stmt =con.createStatement();
                ResultSet rs= stmt.executeQuery("SELECT idNota,idUsuarioFK FROM nota");
                  while(rs.next()){
                      if(usuario.getIdUsuario()==rs.getInt("idUsuarioFK")){
                          hayNotas= true;
                      }
                  }
                  con.close();
            }
            catch(Exception ex){
                       System.out.println(ex);
                   }
            
            //Obtiene las notas existentes del usuario de la base de datos.
            if(hayNotas){
                ArrayList<classNota> listaNotas = new ArrayList<>();
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/luggy?useSSL=false&allowPublicLeyRetrieval=true&characterEncoding=UTF8", "root", "4&Yi3YXQQ#nx?iHo");
                    Statement stmt =con.createStatement();
                    ResultSet rs= stmt.executeQuery("SELECT idNota,idUsuarioFK,createDateN,contenido,activa from nota where activa =1;");
                    while(rs.next()){
                        if( usuario.getIdUsuario()==rs.getInt("idUsuarioFK")){
                            classNota nota= new classNota();
                            nota.setIdNota(rs.getInt("idNota"));
                            nota.setUsuarioFK(rs.getInt("idUsuarioFK"));
                            nota.setFechaCreacion(rs.getString("createDateN"));
                            nota.setContenido(rs.getString("contenido"));
                            nota.setActiva(rs.getBoolean("activa"));
                            listaNotas.add(nota);
                            numNotas=numNotas+1;
                            
                        }
                    }
                    con.close();
                }
                catch(ClassNotFoundException | SQLException ex)
                {
                    response.sendRedirect(request.getContextPath() +"/errorPage.jsp");
                    System.out.println("El error es =");
                    System.out.println(ex);
                    System.out.println("Error en la conexion con MYSQL");
                }  
                miSesion.setAttribute("numNotas",numNotas);
                miSesion.setAttribute("listaNotas",listaNotas);
                response.sendRedirect(request.getContextPath() +"/menu.jsp");
            }
            else
            {
            ArrayList<classNota> listaNotas = new ArrayList<>();
            miSesion.setAttribute("numNotas",numNotas);
            miSesion.setAttribute("listaNotas",listaNotas);
            System.out.println("Sesion inicada redireccionando...");
            //request.getRequestDispatcher("menu.jsp").forward(request,response);
            response.sendRedirect(request.getContextPath() +"/menu.jsp");
            }
        
        }
        else{
            System.out.println("Usuario o contraseña invalido");
            response.sendRedirect(request.getContextPath() +"/loginFail.jsp");
        }
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
