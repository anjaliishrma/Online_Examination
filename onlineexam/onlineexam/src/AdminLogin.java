
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lab-3_8
 */
public class AdminLogin extends javax.swing.JFrame {

    /**
     * Creates new form AdminLogin
     */
    public AdminLogin() {
        initComponents();
        setSize(800,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/pictures/adm.png"));
            BufferedImage newimg = resize(img ,back.getWidth(),back.getHeight());
            back.setIcon(new ImageIcon(newimg));
        } catch (IOException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfusername = new javax.swing.JTextField();
        pfpassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bt = new javax.swing.JButton();
        msg = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        photo = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(400, 0, 400, 60);

        tfusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfusernameActionPerformed(evt);
            }
        });
        getContentPane().add(tfusername);
        tfusername.setBounds(410, 230, 350, 30);
        getContentPane().add(pfpassword);
        pfpassword.setBounds(410, 320, 350, 30);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(410, 180, 110, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(410, 280, 100, 28);

        bt.setBackground(new java.awt.Color(255, 153, 0));
        bt.setText("Login");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(550, 490, 110, 40);

        msg.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        msg.setForeground(new java.awt.Color(255, 255, 255));
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(msg);
        msg.setBounds(0, 320, 800, 50);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/im.png"))); // NOI18N
        jPanel1.add(photo);
        photo.setBounds(-50, 100, 450, 330);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 600);
        getContentPane().add(back);
        back.setBounds(0, 0, 800, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfusernameActionPerformed

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        try {
            
           String username = tfusername.getText().trim();
           String password = pfpassword.getText();
            /////   ##code //////
            if (username.equals("") || password.equals(""))
            {
                JOptionPane.showMessageDialog(this, "username/password is must");
            } else 
            {
                try
                {
                HttpResponse<String> res = Unirest.get("http://localhost:8888/AdminLogin")
                        .queryString("username", username)
                        .queryString("password", password).asString();
                String response = res.getBody();
                if (response.equals("success")) 
                {
                    JOptionPane.showMessageDialog(rootPane, "Login Success");
                     Adminhome obj = new Adminhome(username);
                } else if(response.equals("failed"))
                {
                    
                    msg.setText("!!!WRONG USERNAME&&PASSWORD!!!"
                                   + "Wait for few seconds");
                    for(int i=0; i<=2;i++)
                    {
                    
                    Thread.sleep(3000);
                    }
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Login failed");
                }
                }
                catch (UnirestException ex)
                {
                    ex.printStackTrace();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btActionPerformed

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
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel msg;
    private javax.swing.JPasswordField pfpassword;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
