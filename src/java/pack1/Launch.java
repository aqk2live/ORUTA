
package pack1;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdulquader
 */
public class Launch extends javax.swing.JFrame {

   static String username=LoginServ.u;
    JFileChooser jf;
   static String cdir;
   // static Launch l = new Launch();
   int rows;
    
    public Launch() {
        initComponents();
        

       //  disabling maximize button of window
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
       // dispose();
       // setVisible(true);
        setResizable(false);
        
        
        jf=jFileChooser1;
        this.setLocation(220, 100);
        setTitle(username+" Cloud");
        jMenu1.setText(username);
       // if(jFileChooser1.getCurrentDirectory().getName()=="MyCloud"){
      // jFileChooser1.changeToParentDirectory();
       //cdir=jFileChooser1.getCurrentDirectory().getAbsolutePath();
       // }
        
        
        cdir="C:\\Oruta";
        
       // cdir=jFileChooser1.getCurrentDirectory().getAbsolutePath(); 
        //JOptionPane.showMessageDialog(null, cdir);
        File mycloud = new File(cdir,username+" Cloud");
       if(CreteFile.filename!=null){
        } else  {
            mycloud.mkdir();
       }
        jFileChooser1.setCurrentDirectory(mycloud);
       cdir=jFileChooser1.getCurrentDirectory().getAbsolutePath();  
       // jFileChooser1.AP
       // JFileChooser input = new JFileChooser();
   // int result = jFileChooser1.showSaveDialog(this);
    //if ( JFileChooser.APPROVE_OPTION==0) {
    //createFile();
      //  System.out.println("Open is clicked");
    //} else if (JFileChooser.CANCEL_OPTION==1) {
    //System.out.println("Cancel was selected");
    //}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jFileChooser1 = new javax.swing.JFileChooser();
        create_file = new javax.swing.JButton();
        OpenFile = new javax.swing.JButton();
        delete_file = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 482));
        getContentPane().setLayout(null);

        jFileChooser1.setBackground(new java.awt.Color(0, 255, 255));
        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Users\\Abdulquader\\Documents\\NetBeansProjects\\Secure_Cloud"));
        jFileChooser1.setDialogTitle("My Cloud");
        getContentPane().add(jFileChooser1);
        jFileChooser1.setBounds(10, 80, 800, 397);

        create_file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack1/create-file icon.png"))); // NOI18N
        create_file.setText("Create File");
        create_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_fileActionPerformed(evt);
            }
        });
        getContentPane().add(create_file);
        create_file.setBounds(50, 10, 170, 60);

        OpenFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack1/openfile.png"))); // NOI18N
        OpenFile.setText("Open File");
        OpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileActionPerformed(evt);
            }
        });
        getContentPane().add(OpenFile);
        OpenFile.setBounds(320, 10, 180, 60);

        delete_file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pack1/delete-file-icon.png"))); // NOI18N
        delete_file.setText("Delete File");
        delete_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_fileActionPerformed(evt);
            }
        });
        getContentPane().add(delete_file);
        delete_file.setBounds(610, 10, 170, 60);

        jMenu2.setText("Inbox");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Show Inbox");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Share");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Share File");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Help");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Get Help");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu1.setText("Logout");

        jMenuItem2.setText("Logout !!!");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void create_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_fileActionPerformed
       
         new CreteFile().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_create_fileActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void OpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileActionPerformed
        try {
             File selected_file=jFileChooser1.getSelectedFile();
             
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+selected_file);
        } catch (IOException ex) {
            Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OpenFileActionPerformed

    private void delete_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_fileActionPerformed
       try {
           File selected_file=jFileChooser1.getSelectedFile();
           //JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+selected_file.getName()+" ?");
           //JOptionPane.showMessageDialog(null,JOptionPane.YES_OPTION);
           
           //deleting from DB Table
           
           DBConnect dbc = new DBConnect();
           Statement st = dbc.connect();
           String sql="delete from userfiles where filename='"+selected_file.getName()+"' and username='"+LoginServ.u+"' ;";
            rows =st.executeUpdate(sql);
           
           if(selected_file.delete()&&rows>0){
               JOptionPane.showMessageDialog(null, selected_file.getName()+" successfully deleted !!! ");
               
               new Launch().setVisible(true);
               this.dispose();
           }else{
           JOptionPane.showMessageDialog(null, selected_file.getName()+" - Error in deleting file !!! ");
           }
           
           
           // if(JOptionPane.OK_OPTION){
           
           //}
       } catch (SQLException ex) {
           Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_delete_fileActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      
       new  Inbox().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       
        new ShareWindow().setVisible(true);
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Launch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Launch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Launch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Launch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LaunchServ.l.setVisible(true); 
                
                new Launch().setVisible(true);
                //.
                //int result;
                //result = new Launch().jFileChooser1.showOpenDialog(null);
    //switch (result) {
    //case JFileChooser.APPROVE_OPTION:
      //try{
        //System.out.println("Approve (Open or Save) was clicked");
      
      //}
      //catch(Exception e){
      //JOptionPane.showMessageDialog(null,"Error");
      //}
      //break;
    //case JFileChooser.CANCEL_OPTION:
      //System.out.println("Cancel or the close-dialog icon was clicked");
      //break;
    //case JFileChooser.ERROR_OPTION:
      //System.out.println("Error");
      //break;
    //}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OpenFile;
    private javax.swing.JButton create_file;
    private javax.swing.JButton delete_file;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
