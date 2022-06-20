

package pack1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class EnterKey extends javax.swing.JFrame {

    public static String keys;
    public String sendfrom,sendto,msg,filename,dat;
    public EnterKey() {
        initComponents();
        
        this.setTitle("Encrypted key ");
            this.setLocation(250, 130);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Enter Encryption Key");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Key :");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jButton1)))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            keys=jTextField1.getText().trim();
            
            DBConnect dbc = new DBConnect();
            Statement st = dbc.connect();
            
            String sql="select * from  encsharefiles where ky='"+keys+"' ; ";
            
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                //retrieving data 
                sendto=rs.getString("sendto");
                 sendfrom=rs.getString("sendfrom");
                
                msg=rs.getString("msg");
                filename=rs.getString("file");
                dat=rs.getString("dat");
                
             if(sendto.equalsIgnoreCase(LoginServ.u)){              
                
                  //JOptionPane.showMessageDialog(null,"Inside if "+LoginServ.u+"    "+sendto);
                
                DBConnect dbc1 = new DBConnect();
            Statement st1 = dbc1.connect();
            
            String sql1 = "insert into sharefiles(sendfrom,sendto,msg,file,dat)"
                     + "values"+"('"+sendfrom+"','"+sendto+"','"+msg+"','"+filename+"','"+dat+"');" ;
             int i1 =st1.executeUpdate(sql1);
             
             if(i1>0){
             
                 new Inbox().setVisible(true);
                 this.dispose();
                 
             } 
            }else{
            //Entering invalid data access cases in data base
                 
                 
                 DBConnect dbc2 = new DBConnect();
            Statement st2 = dbc2.connect();
            
            String culprit_username=LoginServ.u;
            String act_sender = sendfrom;
            String act_recvr=sendto;
            String dat_of_illegalaccess=new Date()+"";
            
            String sql2="insert into illegalusers(culprit_username,act_sender,act_recvr,dat)"
                    + "values('"+culprit_username+"','"+act_sender+"','"+act_recvr+"','"+dat_of_illegalaccess+"') ;";
            
            int i2=st2.executeUpdate(sql2);
                 
                 if(i2>0){
                   JOptionPane.showMessageDialog(null,"The message was for other user,you are not allowed to access data  !!!");
                   this.dispose();
                 }
            }
            
            }else{
            JOptionPane.showMessageDialog(null,"Invalid Key !!!");
                
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EnterKey.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(EnterKey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnterKey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnterKey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnterKey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnterKey().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
