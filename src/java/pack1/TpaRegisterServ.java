
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
import static pack1.SignupServ.cloudpath;

public class TpaRegisterServ extends HttpServlet {

    
      public static String cloudpath="";
    File cloudfolder;
    public static String fullname;
   
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
             fullname=  fname+" owned by "+lname;
            String gender = request.getParameter("gender");
            String phno = request.getParameter("phno");
            String email = request.getParameter("emailid");
            String address = request.getParameter("address");
            String post="Auditor";
            
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
            
            RequestDispatcher req=request.getRequestDispatcher("TpaRegisterSuccess.jsp"); 
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
    }

   
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
