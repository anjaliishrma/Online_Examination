
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab-3_9
 */
public class Result extends javax.swing.JFrame {
    int score;
    int percent;
    

    public Result() {
        initComponents();
        
    }
   
    
    Result(int Score)
    {
     initComponents();
     setSize(800,600);
     score = Score;
        username.setText(GlobalData.nameofuser);
        username.getText();
        category.setText(GlobalData.categoryselected);
        category.getText();
        total.setText(GlobalData.alq.size()+"");
         int t = Integer.parseInt(total.getText());
        obtained.setText(score+"");
       
        percent = (score*100)/t;
        percentage.setStringPainted(true);
        
        percentage.setValue(percent);
        percentage.setString(percent+"%");
        if(percent <50)
        {
            percentage.setOpaque(true);
            percentage.setForeground(Color.WHITE);
            percentage.setBackground(Color.RED);
        }
        else
        {
                 percentage.setOpaque(true);
                 percentage.setForeground(Color.WHITE);
            percentage.setBackground(Color.GREEN);
        }
        
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         setResizable(false);
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/pictures/back.jpg"));
            BufferedImage newimg = resize(img ,back.getWidth(),back.getHeight());
            back.setIcon(new ImageIcon(newimg));
        } catch (IOException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
      GlobalData.Score = score+"";
      GlobalData.Percentage = percent+"";
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
        jLabel2 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        obtained = new javax.swing.JLabel();
        category = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        percentage = new javax.swing.JProgressBar();
        exit = new javax.swing.JButton();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Result");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 50);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Category");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 160, 220, 50);

        lb.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Total Questions");
        getContentPane().add(lb);
        lb.setBounds(30, 230, 220, 50);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Marks Obtained");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 300, 220, 50);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Percentage ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 370, 220, 50);

        obtained.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        obtained.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(obtained);
        obtained.setBounds(270, 320, 340, 40);

        category.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        category.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(category);
        category.setBounds(270, 180, 340, 40);

        total.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(total);
        total.setBounds(270, 250, 340, 40);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Username");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 90, 220, 50);

        username.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(username);
        username.setBounds(270, 100, 340, 40);
        getContentPane().add(percentage);
        percentage.setBounds(270, 380, 350, 30);

        exit.setBackground(new java.awt.Color(102, 255, 204));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(340, 510, 130, 30);
        getContentPane().add(back);
        back.setBounds(0, 0, 810, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
      String Username = username.getText();
      String Category = category.getText();
      String Total    = total.getText();
      String Obtained = obtained.getText();
      String Percentage = percent+"";
        try {
                  HttpResponse<String> res = Unirest.get("http://localhost:8888/Result")
                            .queryString("Username",Username)
                          .queryString("Category",Category)
                          .queryString("Total",Total)
                          .queryString("Obtained",Obtained)
                          .queryString("Percentage",Percentage).asString();
                  String response = res.getBody();
//                  if (response.equals("success")) 
//                {
//                    JOptionPane.showMessageDialog(this, "Result Stored Successfully");
//                } else 
//                {
//                    JOptionPane.showMessageDialog(this, "Failed!!!!");
//                }
               }
               catch (UnirestException ex) {
                 Logger.getLogger(Add_category.class.getName()).log(Level.SEVERE, null, ex);
               }    
        testing vr = new testing();
        vr.setVisible(true);
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Result().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel category;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel obtained;
    private javax.swing.JProgressBar percentage;
    private javax.swing.JLabel total;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
