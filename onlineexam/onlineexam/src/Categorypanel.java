/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sharma
 */
public class Categorypanel extends javax.swing.JPanel {

    /**
     * Creates new form Categorypanel
     */
    public Categorypanel() {
        initComponents();
        setSize(200,250);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cpphoto = new javax.swing.JLabel();
        cpcatname = new javax.swing.JLabel();

        setLayout(null);

        cpphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(cpphoto);
        cpphoto.setBounds(28, 21, 140, 160);

        cpcatname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(cpcatname);
        cpcatname.setBounds(30, 200, 140, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel cpcatname;
    public javax.swing.JLabel cpphoto;
    // End of variables declaration//GEN-END:variables
}