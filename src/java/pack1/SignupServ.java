
package pack1;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SignupServ extends HttpServlet {
    
      public static String cloudpath="";
    File cloudfolder;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignupServ</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupServ at " + request.getContextPath() + "</h1>");
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
        
          cloudfolder=new File("C:\\Oruta");
         cloudfolder.mkdir();  
        cloudpath=cloudfolder.getAbsolutePath();
        try {
            PrintWriter pw =response.getWriter();
            String uname = request.getParameter("username");
            String passwd = request.getParameter("password");
            String fname = request.getParameter("firstname");
            String lname=  request.getParameter("lastname");
            String fullname=  fname+" "+lname;
            String gender = request.getParameter("gender");
            String phno = request.getParameter("phno");
            String email = request.getParameter("emailid");
            String address = request.getParameter("address");
            String post="cloud user";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/secure_cloud","root","pass");
          
          String sql = "INSERT INTO user_details("+"username,"+"passwd,"+"name,"+"gender,"+"phno,"+"email,"+"address,"+"post)"+"values(?, ?, ?, ?, ?, ?, ?, ?)";
          PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
          
               
          
            pstmt.setString(1,uname);
            pstmt.setString(2, passwd);
            pstmt.setString(3, fullname);
            pstmt.setString(4, gender);
            pstmt.setString(5, phno);
            pstmt.setString(6, email);
            pstmt.setString(7, address);
            pstmt.setString(8, post);
           
            int i=pstmt.executeUpdate();
            
            if(i>0){
            
            RequestDispatcher req=request.getRequestDispatcher("SignupSuccess.jsp"); 
                req.forward(request, response);
                
               File mycloud=new File(cloudfolder.getAbsolutePath(),uname+" Cloud");
               mycloud.mkdir();
               
                
                //JOptionPane.showMessageDialog(new JFrame(),"Account  successfully created!!!");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(SignupServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignupServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
     JOptionPane.showMessageDialog(null,ex);
         //   msg="Possible reasons are username already exists o ";
            RequestDispatcher rd = request.getRequestDispatcher("SignupFailed.jsp");
            rd.forward(request,response);
            
            
        } catch (ServletException ex) {
            Logger.getLogger(SignupServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
