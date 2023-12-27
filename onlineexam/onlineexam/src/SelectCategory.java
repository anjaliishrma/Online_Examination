
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lab-3_9
 */
public class SelectCategory extends javax.swing.JFrame {

   int Sno = 1;
   ArrayList<ExamQuestion> alexamques = new ArrayList<>();
    public SelectCategory() {
        initComponents();
        viewcategories();
        setSize(800,600);
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
        
    }


    void viewcategories() {
        mainpanel.removeAll();
        mainpanel.repaint();

        try {
            HttpResponse<String> response = Unirest.get("http://localhost:8888/Load").asString();
            if (response.getStatus() == 200) {
                String Res = response.getBody().trim();
                StringTokenizer st = new StringTokenizer(Res, ";;");
                System.out.println("res : " + Res);
                int count = st.countTokens();
                Categorypanel cp[] = new Categorypanel[count];
                int i = 0, x = 10, y = 10;
                mainpanel.setPreferredSize(new Dimension(1000, 500));
                while (st.hasMoreTokens()) {
                    String row = st.nextToken();
                    System.out.println(row);
                    StringTokenizer st2 = new StringTokenizer(row, "~");
                    String catname = st2.nextToken();
                    String Description = st2.nextToken();
                    String photo = st2.nextToken();

                    cp[i] = new Categorypanel();
                    cp[i].cpcatname.setText(catname);
                    cp[i].cpcatname.setFocusable(false);

                    BufferedImage bufferedimage, newimage = null;
                    ImageIcon icon = new ImageIcon("");
                    try {
                        URL url = new URL("http://localhost:8888/GetResource/" + photo);
                        System.out.println(url);
                        try {
                            bufferedimage = ImageIO.read(url);
                            newimage = resize(bufferedimage, 150, 150);
                            cp[i].setBounds(x, y, 200, 250);

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        icon = new ImageIcon(newimage);
                        cp[i].cpphoto.setIcon(icon);
                        
                        
                        MouseListener ml = null;
                        cp[i].addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                try {
                                    HttpResponse<String> response = Unirest.get("http://localhost:8888/FetchQuestionCategorywise")
                                            .queryString("catname",catname).asString();
                                     if(response.getStatus()==200)
                                     {
                                         String ans = response.getBody().trim();
                                        System.out.println(response);
            alexamques.clear();
            StringTokenizer st = new StringTokenizer(ans, ";;");
            int n = st.countTokens();
            for (int i = 1; i <= n; i++) {
                String row = st.nextToken();
                System.out.println(row);
                StringTokenizer st2 = new StringTokenizer(row, "~");
                String Qid = st2.nextToken();
                System.out.println(Qid);
                String Question = st2.nextToken();
                System.out.println(Question);
                String OptionA = st2.nextToken();
                System.out.println(OptionA);
                String OptionB = st2.nextToken();
                System.out.println(OptionB);
                String OptionC = st2.nextToken();
                System.out.println(OptionC);
                String OptionD = st2.nextToken();
                System.out.println(OptionD);
                String Correctanswer = st2.nextToken();
                System.out.println(Correctanswer);
  
                
                ExamQuestion obj = new ExamQuestion(Qid,Question,OptionA,OptionB,OptionC,OptionD,Correctanswer,Sno);
                alexamques.add(obj);
                Sno++;
            }
                                     }
                                
                                
                                } catch (UnirestException ex) {
                                    Logger.getLogger(SelectCategory.class.getName()).log(Level.SEVERE, null, ex);
                                }
                           GlobalData.alq = alexamques;
                           GlobalData.categoryselected = catname;
                            
                            
                            }
                            
                            
                            
                            
                         });

                    } catch (MalformedURLException ex) {
                        Logger.getLogger(SelectCategory.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    mainpanel.add(cp[i]);
                    repaint();
                    mainpanel.repaint();
                    cp[i].repaint();
                    x = x + 240;
                    y = 10;
                    i++;
                }
            }

        } catch (UnirestException ex) {
            Logger.getLogger(SelectCategory.class.getName()).log(Level.SEVERE, null, ex);
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
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select Category");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 70);

        jButton1.setBackground(new java.awt.Color(102, 255, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Take Test");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(320, 500, 140, 40);

        jScrollPane2.setBackground(new Color(0,0,0,65));
        jScrollPane2.setForeground(new Color(0,0,0,65));

        mainpanel.setBackground(new Color(50,50,50,65));
        mainpanel.setLayout(null);
        jScrollPane2.setViewportView(mainpanel);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(60, 130, 690, 340);

        back.setText("jLabel2");
        getContentPane().add(back);
        back.setBounds(-6, 0, 810, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             instructions in = new instructions();
              in.setVisible(true);             
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SelectCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
