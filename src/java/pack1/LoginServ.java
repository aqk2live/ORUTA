
package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServ extends HttpServlet {

     public  static String u="";
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServ</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServ at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            PrintWriter pw =response.getWriter();
             u = request.getParameter("inputtext1");
            String p = request.getParameter("inputtext2");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/secure_cloud","root","pass");
            String query ="select * from user_details where username=? "+"and passwd=? ";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            pst.setString(1,u);
            pst.setString(2, p);
            ResultSet rs = (ResultSet) pst.executeQuery();
            if(rs.next()){
               if(u.equals("Admin101")){
                    RequestDispatcher req=request.getRequestDispatcher("AdminWindow.jsp"); 
                req.forward(request, response);
               }else{
                RequestDispatcher req=request.getRequestDispatcher("Launch.jsp"); 
                req.forward(request, response);
               }
                
            }
            else{
             RequestDispatcher req=request.getRequestDispatcher("Wrongidpaswd.jsp"); 
                req.forward(request, response);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(LoginServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LoginServ.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
