
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sharma
 */
public class testing extends javax.swing.JFrame {
     int perc = Integer.parseInt(GlobalData.Percentage);
mytablemodel tm = new mytablemodel();
    /**
     * Creates new form testing
     */
    public testing() {
            initComponents();
            setVisible(true);
            setSize(800,600);
            jTable1.setModel(tm);
            User.setText(GlobalData.nameofuser);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
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
            void photo(){
        String Photo = GlobalData.Photo;
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
                        lb.setIcon(icon);
  
                    }catch (MalformedURLException ex) {
                        Logger.getLogger(SelectCategory.class.getName()).log(Level.SEVERE, null, ex);
                    
}
    }
 class mytablemodel extends AbstractTableModel
   {

        @Override
        public int getRowCount() {
          return 1;
        }

        @Override
        public int getColumnCount() {
         return 5;   
        }

        @Override
        public Object getValueAt(int i, int j) {
        if(j==0)
        {
            return GlobalData.categoryselected;
        }
        else if (j==1)
        {
            return GlobalData.alq.size();
        }
          else if(j==2)
        {
            return GlobalData.Score;
        }
          else if (j==3)
                  {
                       return GlobalData.Percentage;
                  }
          else if(j==4)
          {
              if(perc <= 50)
              {
                  return ("Poor!!!");
              }
              else if(perc > 50)
              {
                  return ("Average");
              }
              else if(perc > 70)
              {
                  return ("Good");
              }
              else{
              return null;
              }
          }
        else
                {
            return null;
                }
        }
        @Override
        public String getColumnName(int j)
        {
            String col[] = { "Category","Total","Score","Percentage%","Remarks"};
            return col[j];
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

        lb = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        photo = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(lb);
        lb.setBounds(510, 100, 180, 170);

        User.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        User.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(User);
        User.setBounds(400, 0, 400, 70);

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(410, 300, 380, 190);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icon.png"))); // NOI18N
        jPanel1.add(photo);
        photo.setBounds(0, 90, 400, 330);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 600);
        getContentPane().add(back);
        back.setBounds(4, 0, 800, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(testing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel User;
    private javax.swing.JLabel back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel photo;
    // End of variables declaration//GEN-END:variables
}
