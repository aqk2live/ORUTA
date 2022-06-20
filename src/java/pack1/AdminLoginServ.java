
package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginServ extends HttpServlet {
    
    public static  String msg="";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DBConnect dbc = new DBConnect();
           Statement st =  dbc.connect();
        
           
            try {
            
            String username = request.getParameter("inputtext1");
            String passwd = request.getParameter("inputtext2");
            if(username.equals("Admin101")){
            
           String sql="select * from user_details where passwd='"+passwd+"' ;"; 
           ResultSet rs = st.executeQuery(sql);
            
           if(rs.next()){
              
               RequestDispatcher rd = request.getRequestDispatcher("AdminWindow.jsp");
               rd.forward(request, response);               
           
           }
           else{
           msg="Wrong password !!!";
            RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
               rd.include(request, response);           
           msg="";
           }
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminLoginServ.class.getName()).log(Level.SEVERE, null, ex);
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
