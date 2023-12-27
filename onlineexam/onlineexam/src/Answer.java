
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab-3_8
 */
public class Answer extends javax.swing.JFrame {
 JButton ar[] = new  JButton[GlobalData.alq.size()];

    int current = 0;
    int score =0;
    public Answer() {
        initComponents();
        setSize(800,600);
        load_question(current);
        buttonGroup1.add(rb1);
        buttonGroup1.add(rb2);
        buttonGroup1.add(rb3);
        buttonGroup1.add(rb4);
       
        int x=10,y=10;
        for(int i=0; i< GlobalData.alq.size(); i++)
        {
            ar[i] = new JButton((i+1)+"");
            ar[i].setBounds(x,y,50,40);
            jPanel1.add(ar[i]);
            jPanel1.repaint();
            x= x+50;
            final int k=1;
            ar[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    load_question(k);
                }
            });
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
    }
    BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    

 void load_question(int i)
{
   current = i;
 category.setText(GlobalData.categoryselected);
category.getText();
        rb1.setEnabled(false);
        rb2.setEnabled(false);
        rb3.setEnabled(false);
        rb4.setEnabled(false);
        optionA.setOpaque(false);
        optionB.setOpaque(false);
        optionC.setOpaque(false);
        optionD.setOpaque(false);
    String opt = GlobalData.alq.get(i).getUserans().trim();
         if(opt.equals(""))
         {
             buttonGroup1.clearSelection();
         }
        else
         {
             if(opt.equals("OptionA"))
             {
                 rb1.setSelected(true);
                 rb1.setEnabled(true);
                 optionA.setOpaque(true);
                 optionA.setBackground(java.awt.Color.red);
             }
             if(opt.equals("OptionB"))
             {
                 rb2.setSelected(true);
                 rb2.setEnabled(true);
                 optionB.setOpaque(true);
                 optionB.setBackground(java.awt.Color.red);
             }
             if(opt.equals("OptionC"))
             {
                 rb3.setSelected(true);
                 rb3.setEnabled(true);
                 optionC.setOpaque(true);
                 optionC.setBackground(java.awt.Color.red);
             }
             if(opt.equals("OptionD"))
             {
                 rb4.setSelected(true);
                 rb4.setEnabled(true);
                 optionD.setOpaque(true);
                 optionD.setBackground(java.awt.Color.red);
             }
         }
       String cans =GlobalData.alq.get(i).getCorrectanswer().trim();
       if(cans.equals("OptionA"))
       {
           optionA.setOpaque(true);
           optionA.setBackground(java.awt.Color.GREEN);
       }
       else if(cans.equals("OptionB"))
       {
           optionB.setOpaque(true);
           optionB.setBackground(java.awt.Color.GREEN);
       }
        else if(cans.equals("OptionC"))
       {
           optionC.setOpaque(true);
           optionC.setBackground(java.awt.Color.GREEN);
       } 
         else if(cans.equals("OptionD"))
       {
           optionD.setOpaque(true);
           optionD.setBackground(java.awt.Color.GREEN);
       }
         
         
        String q = GlobalData.alq.get(i).Question;
        question.setText(q);
        sno.setText((i+1)+"");
        optionA.setText(GlobalData.alq.get(i).OptionA);
        optionB.setText(GlobalData.alq.get(i).OptionB);
        optionC.setText(GlobalData.alq.get(i).OptionC);
        optionD.setText(GlobalData.alq.get(i).OptionD);
      
       
       
       
        if (current == 0) {
            previous.setEnabled(false);
        } else if (current == 14) {
            next.setEnabled(false);
        } else {
            previous.setEnabled(true);
            next.setEnabled(true);
            
        }
}
  void calculate()
        {
            for (int i =0; i < GlobalData.alq.size();i++)
            {
                String uans =GlobalData.alq.get(i).getUserans().trim();
                System.out.println("user:"+uans);
                String cans = GlobalData.alq.get(i).getCorrectanswer().trim();
                System.out.println("correct"+cans);
                if(uans.equals(cans))
                {
                    score++;
                    System.out.println("score"+score);
                }
            }
            System.out.println("final score"+score);
            Result er = new Result(score);
            er.setVisible(true);
            
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        rb4 = new javax.swing.JRadioButton();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        optionD = new javax.swing.JLabel();
        optionA = new javax.swing.JLabel();
        optionB = new javax.swing.JLabel();
        optionC = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();
        end = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        sno = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        category = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Question");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 110, 100, 20);

        question.setColumns(20);
        question.setRows(5);
        jScrollPane1.setViewportView(question);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 70, 570, 120);

        rb4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        rb4.setText("OptionD");
        rb4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(rb4);
        rb4.setBounds(80, 340, 120, 31);

        rb1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        rb1.setText("OptionA");
        rb1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(rb1);
        rb1.setBounds(80, 220, 100, 31);

        rb2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        rb2.setText("OptionB");
        rb2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(rb2);
        rb2.setBounds(80, 260, 120, 31);

        rb3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        rb3.setText("OptionC");
        rb3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(rb3);
        rb3.setBounds(80, 300, 120, 31);
        getContentPane().add(optionD);
        optionD.setBounds(190, 340, 260, 20);
        getContentPane().add(optionA);
        optionA.setBounds(190, 220, 260, 20);
        getContentPane().add(optionB);
        optionB.setBounds(190, 260, 260, 20);
        getContentPane().add(optionC);
        optionC.setBounds(190, 300, 260, 20);

        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time);
        time.setBounds(600, 10, 90, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Timer");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(550, 10, 50, 17);

        previous.setBackground(new java.awt.Color(102, 255, 204));
        previous.setText("Previous");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });
        getContentPane().add(previous);
        previous.setBounds(20, 420, 90, 23);

        next.setBackground(new java.awt.Color(102, 255, 204));
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next);
        next.setBounds(660, 420, 90, 23);

        end.setBackground(new java.awt.Color(102, 255, 204));
        end.setText("Exit");
        end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endActionPerformed(evt);
            }
        });
        getContentPane().add(end);
        end.setBounds(351, 540, 90, 30);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(160, 400, 470, 70);

        sno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(sno);
        sno.setBounds(80, 140, 50, 30);

        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(status);
        status.setBounds(540, 40, 200, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Category");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(220, 10, 100, 30);

        category.setBackground(new java.awt.Color(255, 255, 255));
        category.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        category.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(category);
        category.setBounds(330, 10, 110, 30);
        getContentPane().add(back);
        back.setBounds(0, 0, 810, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed

                     current = current+1;    
                     load_question(current);
             
    }//GEN-LAST:event_nextActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
         current = current-1;
        load_question(current);
            
    }//GEN-LAST:event_previousActionPerformed

    private void endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endActionPerformed
      calculate();

      
      dispose();    
    }//GEN-LAST:event_endActionPerformed

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
            java.util.logging.Logger.getLogger(Answer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Answer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Answer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Answer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start_test().setVisible(true);
            }
        });
    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel category;
    private javax.swing.JButton end;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton next;
    private javax.swing.JLabel optionA;
    private javax.swing.JLabel optionB;
    private javax.swing.JLabel optionC;
    private javax.swing.JLabel optionD;
    private javax.swing.JButton previous;
    private javax.swing.JTextArea question;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb4;
    private javax.swing.JLabel sno;
    private javax.swing.JLabel status;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
           




}
