/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class GirisEkrani extends javax.swing.JFrame {
    
    Baglanti baglanti = new Baglanti();
    
    /**
     * Creates new form GirisEkrani
     */
    public GirisEkrani() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text_kullanici = new javax.swing.JTextField();
        text_sifre = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        button_giris = new javax.swing.JButton();
        button_kayit = new javax.swing.JButton();
        label_mesaj = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1198, 677));
        getContentPane().setLayout(null);

        text_kullanici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_kullaniciActionPerformed(evt);
            }
        });
        getContentPane().add(text_kullanici);
        text_kullanici.setBounds(470, 80, 190, 50);
        getContentPane().add(text_sifre);
        text_sifre.setBounds(470, 150, 190, 40);

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Verdana Pro Black", 0, 12)); // NOI18N
        jLabel1.setText("E-posta");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 80, 90, 40);

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setFont(new java.awt.Font("Verdana Pro Black", 0, 12)); // NOI18N
        jLabel3.setText("Sifre");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 150, 90, 40);

        button_giris.setText("Giris Yap");
        button_giris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_girisActionPerformed(evt);
            }
        });
        getContentPane().add(button_giris);
        button_giris.setBounds(680, 80, 120, 50);

        button_kayit.setText("Kayit Ol");
        button_kayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_kayitActionPerformed(evt);
            }
        });
        getContentPane().add(button_kayit);
        button_kayit.setBounds(680, 150, 120, 40);
        getContentPane().add(label_mesaj);
        label_mesaj.setBounds(490, 330, 190, 0);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resim.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-40, 0, 1250, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_kayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_kayitActionPerformed
        
        KayitEkrani kayit = new KayitEkrani();
        kayit.setVisible(true);
        setVisible(false);
        
        
        
        
    }//GEN-LAST:event_button_kayitActionPerformed

    private void button_girisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_girisActionPerformed
        
        label_mesaj.setText(" ");
        String mail=text_kullanici.getText();
        String parola=String.valueOf(text_sifre.getPassword());
        
        System.out.println(parola);
        
        boolean giris = baglanti.girisyap(mail, parola);
        int kullanici_id = baglanti.kullanici_id(mail);
        System.out.println("Kullanici id : " + kullanici_id);
        if(giris == true){
            label_mesaj.setText("Giris Basarili");
            Yonetim yonetim = new Yonetim(kullanici_id);
            yonetim.setVisible(true);
            baglanti.dbKapat();
            setVisible(false);
        }
        else{
            label_mesaj.setText("Tekrar Deneyiniz veya kayit olunuz");
        }
        
        
    }//GEN-LAST:event_button_girisActionPerformed

    private void text_kullaniciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_kullaniciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_kullaniciActionPerformed

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
            java.util.logging.Logger.getLogger(GirisEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GirisEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GirisEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GirisEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GirisEkrani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_giris;
    private javax.swing.JButton button_kayit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel label_mesaj;
    private javax.swing.JTextField text_kullanici;
    private javax.swing.JPasswordField text_sifre;
    // End of variables declaration//GEN-END:variables
}
