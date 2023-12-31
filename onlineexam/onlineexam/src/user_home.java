
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab-3_8
 */
public class user_home extends javax.swing.JFrame {

    /**
     * Creates new form user_home
     */
    String uname;
    public user_home() {
        initComponents();
        setSize(800,600);
    }
      user_home(String Username)
    {
          initComponents();
        uname = Username;
        lbusername.setText("Welcome: " + uname);
        setVisible(true);
        setSize(800, 600);
        setResizable(false);
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         BufferedImage img;
        try {
            img = ImageIO.read(new File("src/pictures/user.jpg"));
            BufferedImage newimg = resize(img ,back.getWidth(),back.getHeight());
            back.setIcon(new ImageIcon(newimg));
        } catch (IOException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        photo();
    }
      BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
void photo() 
{
        try {
           HttpResponse<String> response = Unirest.get("http://localhost:8888/uload")
                   .queryString("Username",uname).asString();
         
            if (response.getStatus() == 200) {
                String Res = response.getBody().trim();
                StringTokenizer st = new StringTokenizer(Res, ";;");
                System.out.println("res : " + Res);
                 while (st.hasMoreTokens()) {
                    String row = st.nextToken();
                    System.out.println(row);
                    StringTokenizer st2 = new StringTokenizer(row, "~");
                    String Photo = st2.nextToken();
                    GlobalData.Photo = Photo;
                   BufferedImage bufferedimage, newimage = null;
                    ImageIcon icon = new ImageIcon("");
                    try {
                        URL url = new URL("http://localhost:8888/GetResource/" + Photo);
                        System.out.println(url);
                        try {
                            bufferedimage = ImageIO.read(url);
                            newimage = resize(bufferedimage, 150, 150);

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        icon = new ImageIcon(newimage);
                        photo.setIcon(icon);
  
            }catch (MalformedURLException ex) {
                        Logger.getLogger(SelectCategory.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            }
        } catch (UnirestException ex) {
            Logger.getLogger(user_home.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbusername = new javax.swing.JLabel();
        view = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        option = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        photo1 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbusername.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        lbusername.setForeground(new java.awt.Color(255, 255, 255));
        lbusername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbusername);
        lbusername.setBounds(400, 80, 400, 80);

        view.setBackground(new java.awt.Color(255, 153, 0));
        view.setText("OK");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        getContentPane().add(view);
        view.setBounds(570, 460, 100, 40);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User home");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(410, 0, 390, 60);
        getContentPane().add(photo);
        photo.setBounds(520, 180, 170, 130);

        option.setBackground(new java.awt.Color(255, 153, 0));
        option.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        option.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Option", "Change Password", "Start Test", "View Results" }));
        option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionActionPerformed(evt);
            }
        });
        getContentPane().add(option);
        option.setBounds(470, 360, 280, 30);

        jPanel1.setBackground(new Color(255,153,0,50));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        photo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/log.png"))); // NOI18N
        jPanel1.add(photo1);
        photo1.setBounds(0, 200, 400, 160);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 600);
        getContentPane().add(back);
        back.setBounds(-6, 0, 810, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        Object Select = option.getSelectedItem();
        if(Select.toString().equals("Start Test"))
        {
            SelectCategory obj = new SelectCategory();
            obj.setVisible(true);
        }
        else if(Select.toString().equals("Change Password"))
        {
            user_change_password obj = new user_change_password(uname);
            obj.setVisible(true);
        }
        else if(Select.toString().equals("View Results"))
        {
            View_result obj = new View_result();
        }
    }//GEN-LAST:event_viewActionPerformed

    private void optionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionActionPerformed
        
    }//GEN-LAST:event_optionActionPerformed

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
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_home().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbusername;
    private javax.swing.JComboBox option;
    private javax.swing.JLabel photo;
    private javax.swing.JLabel photo1;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
