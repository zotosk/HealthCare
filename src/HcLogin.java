import AboutHC.AboutHC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;

public class HcLogin extends javax.swing.JFrame {
    
    Connection con = null;
    PreparedStatement p_statement = null;
    ResultSet res = null;
    
    /**
     * Creates new form HcLogin
     */
    public HcLogin() {
        initComponents();
        failedMsg1.setVisible(false);
        successMsg.setVisible(false);   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        labelUsername = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        hospital = new javax.swing.JLabel();
        care = new javax.swing.JLabel();
        successMsg = new javax.swing.JLabel();
        failedMsg1 = new javax.swing.JLabel();
        panel2Locked = new javax.swing.JPanel();
        timerField = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital Care");
        setBackground(new java.awt.Color(153, 102, 0));
        setPreferredSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setToolTipText("username");
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 250, 30));

        password.setToolTipText("password");
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 250, 30));

        labelUsername.setText("Username");
        getContentPane().add(labelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 98, 27));

        labelPassword.setText("Password");
        getContentPane().add(labelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 98, 27));

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 170, 30));

        jPanel1.setBackground(new java.awt.Color(234, 244, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Health-Care3.png"))); // NOI18N
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 130, 100));

        hospital.setBackground(new java.awt.Color(249, 249, 249));
        hospital.setFont(new java.awt.Font("Segoe UI", 1, 33)); // NOI18N
        hospital.setForeground(new java.awt.Color(133, 159, 220));
        hospital.setText("Hospital");
        jPanel1.add(hospital, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 130, 80));

        care.setFont(new java.awt.Font("Segoe UI", 1, 33)); // NOI18N
        care.setForeground(new java.awt.Color(0, 102, 204));
        care.setText("Care");
        jPanel1.add(care, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 88, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 110));

        successMsg.setBackground(new java.awt.Color(0, 153, 102));
        successMsg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        successMsg.setForeground(new java.awt.Color(255, 255, 255));
        successMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        successMsg.setText("Login Successful !");
        successMsg.setOpaque(true);
        getContentPane().add(successMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 600, 40));

        failedMsg1.setBackground(new java.awt.Color(255, 102, 102));
        failedMsg1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        failedMsg1.setForeground(new java.awt.Color(255, 255, 255));
        failedMsg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        failedMsg1.setText("Login Failed.Username or password is incorrect !");
        failedMsg1.setOpaque(true);
        getContentPane().add(failedMsg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 600, 40));

        panel2Locked.setBackground(new java.awt.Color(255, 255, 255));
        panel2Locked.add(timerField);

        getContentPane().add(panel2Locked, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 600, 330));

        jMenu1.setText("About");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Exit");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public int countUser = 0;
    public int countAttempt = 2;
    private String getUserNameCurrent;
    
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:       
        HcLogs printLogs = new HcLogs();
        String inputUsername = null;
        String inputPassword = null;
        try {
            String user_name = username.getText().trim();
            String pass_word = password.getText().trim();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalcare","localhost","");
            String sql = "SELECT * FROM users WHERE username ='"+user_name+"' and password = '"+pass_word+"'";
            p_statement = con.prepareStatement(sql);
            res = p_statement.executeQuery();

            while(res.next()){
                countUser = countUser + 1;
                inputUsername = res.getString("username");
                inputPassword = res.getString("password");
            }       
            if(countUser == 1 && inputUsername.equals(username.getText()) && inputPassword.equals(password.getText())){                
                getUserNameCurrent = username.getText();
                getUserName_LogedIn();
                
                //show messages
                successMsg.setVisible(true);
                failedMsg1.setVisible(false);
                JOptionPane.showMessageDialog(null,"Login Success!","Login",JOptionPane.INFORMATION_MESSAGE);
                //#method to get current userloing with buffering(hc_logs pckage)                            
                printLogs.showLogs(getUserNameCurrent,countUser);
                //#display the main frame
                HcForm showTheMainForm = new HcForm();
                showTheMainForm.userLogedIn.setText("User : " + inputUsername);
                showTheMainForm.setVisible(true);               
            }
            
            else{
                failedMsg1.setVisible(true);
                JOptionPane.showMessageDialog(null,"Login failed");
                username.setText("");
                password.setText("");
                failedMsg1.setVisible(false);
                countAttempt--;
             
                if(countAttempt == 0){                   
                    username.setEnabled(false);
                    password.setEnabled(false);
                    JOptionPane.showMessageDialog(null,"Try again in 3sec"); 
                    
                    Thread.sleep(3000);            
                    username.setEnabled(true);
                    password.setEnabled(true);
                }
                if(countAttempt == -4){
                    username.setEnabled(false);
                    password.setEnabled(false);
                    JOptionPane.showMessageDialog(null,"Try again in 10sec");
                    
                    Thread.sleep(10000);
                    username.setEnabled(true);
                    password.setEnabled(true);
                }
            }
        } catch (SQLException | InterruptedException ex) {
            Logger.getLogger(HcLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                res.close();
                p_statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(HcLogin.class.getName()).log(Level.SEVERE, null, ex);
            }          
        } 
    }//GEN-LAST:event_loginActionPerformed
    
    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        AboutHC abShow = new AboutHC();
        abShow.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked
   
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
            
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");   
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HcLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HcLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HcLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HcLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HcLogin().setVisible(true);           
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel care;
    private javax.swing.JLabel failedMsg1;
    private javax.swing.JLabel hospital;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JButton login;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panel2Locked;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel successMsg;
    private javax.swing.JLabel timerField;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
    
    
    private String userNameCurrent;
    public void getUserName_LogedIn() {
        userNameCurrent = getUserNameCurrent;
        //System.out.println(userNameCurrent); 
        
        
    }
}
