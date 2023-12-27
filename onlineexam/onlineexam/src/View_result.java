
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
 * @author Lab-3_8
 */
public class View_result extends javax.swing.JFrame {
 ArrayList<result> alresult = new ArrayList<>();
      mytablemodel tm = new mytablemodel(); 
    /**
     * Creates new form View_result
     */
    public View_result() {
        initComponents();
        setSize(800,600);
        setVisible(true);
       jTable1.setModel(tm);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
            name.setText(GlobalData.nameofuser);
            BufferedImage img;
            try {
                img = ImageIO.read(new File("src/pictures/user.jpg"));
                BufferedImage newimg = resize(img ,back.getWidth(),back.getHeight());
                back.setIcon(new ImageIcon(newimg));
            } catch (IOException ex) {
                Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        photo();
        loadcatname();
    }
          BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
   
      void loadcatname()
    {
        try
        {
             HttpResponse<String> res = Unirest.get("http://localhost:8888/Getcategory").asString();
             String data = res.getBody().trim();
             StringTokenizer st = new StringTokenizer(data,"~");
             while(st.hasMoreTokens())
             {
                 String Name = st.nextToken();
                 category.addItem(Name);

              
             }
             
         
        }
             catch (Exception ex)
                     {
                     ex.printStackTrace();
                     }
                
    }
   class mytablemodel extends AbstractTableModel
   {

        @Override
        public int getRowCount() {
          return alresult.size();
        }

        @Override
        public int getColumnCount() {
         return 4;   
        }

        @Override
        public Object getValueAt(int i, int j) {
        if(j==0)
        {
            return alresult.get(i).Resultid;
        }
          else if(j==1)
        {
            return alresult.get(i).Total;
        }
          else if (j==2)
                  {
                       return alresult.get(i).Obtained;
                  }
                else if (j==3)
                  {
                       return alresult.get(i).Percentage;
                  }
        else
                {
            return null;
                }
        }
        @Override
        public String getColumnName(int j)
        {
            String col[] = {"Resultid" , "Total","Obtained","Percentage%"};
            return col[j];
        }
       
   }
 void arrayLoader(String Category)
    {
        try
        {
            String Username = GlobalData.nameofuser;
             HttpResponse<String> res = Unirest.get("http://localhost:8888/viewresult")
                     .queryString("Username",Username)
                     .queryString("Category",Category).asString();
             String data = res.getBody().trim();
             StringTokenizer st = new StringTokenizer(data,";;");
             while(st.hasMoreTokens())
             {
                 String row = st.nextToken();
                 StringTokenizer stcol = new StringTokenizer(row,"~");
                 String Resultid = stcol.nextToken();
                 String Total = stcol.nextToken();
                 String Obtained = stcol.nextToken();
                 String Percentage = stcol.nextToken();
                 alresult.add(new result(Resultid, Total,Obtained,Percentage));
             }
             
                 tm.fireTableDataChanged();   
             
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
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
                        l.setIcon(icon);
  
                    }catch (MalformedURLException ex) {
                        Logger.getLogger(SelectCategory.class.getName()).log(Level.SEVERE, null, ex);
                    
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        category = new javax.swing.JComboBox<String>();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        photo = new javax.swing.JLabel();
        l = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(410, 360, 380, 190);

        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });
        getContentPane().add(category);
        category.setBounds(410, 280, 250, 40);

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(700, 290, 55, 23);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icon.png"))); // NOI18N
        jPanel1.add(photo);
        photo.setBounds(0, 90, 400, 330);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 600);
        getContentPane().add(l);
        l.setBounds(510, 120, 180, 130);

        lb.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("View Result");
        getContentPane().add(lb);
        lb.setBounds(400, 0, 400, 40);

        name.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(name);
        name.setBounds(400, 50, 400, 50);
        getContentPane().add(back);
        back.setBounds(-6, 0, 810, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String name = (String) category.getSelectedItem();
        arrayLoader(name);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryActionPerformed

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
            java.util.logging.Logger.getLogger(View_result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_result().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel l;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel name;
    private javax.swing.JLabel photo;
    // End of variables declaration//GEN-END:variables
class result
{

    String Resultid;
    String Total;
    String Obtained;
    String Percentage;    
    result( String Resultid,String Total,String Obtained,String Percentage)
    {
        this.Resultid = Resultid;
        this.Total = Total;
        this.Obtained = Obtained;
        this.Percentage = Percentage;
    }
    
}
}
