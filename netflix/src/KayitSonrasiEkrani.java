
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class KayitSonrasiEkrani extends javax.swing.JFrame {

    boolean array[];
    DefaultTableModel model;
    Baglanti islemler = new Baglanti();
    
    public KayitSonrasiEkrani() {
        initComponents();
        System.out.println("Yanlis yer");
    }
    public KayitSonrasiEkrani(boolean arr[]) {
        initComponents();
        array = arr;
        model=(DefaultTableModel) text_tablo.getModel();
        kayit_sonrasi_filmler();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void kayit_sonrasi_filmler(){
        
        Kullanici program=new Kullanici();
        ArrayList<Kullanici> kullanici = new ArrayList<Kullanici>();
        model.setRowCount(0);
        int secilen_turler[]=new int[3];
        int i,j;
        j=0;
        for(i=0;i<10;i++){
            if(array[i]==true){
                if(i>=7){
                    System.out.println(i+2);
                   secilen_turler[j]=i+2;
                }
                else{
                secilen_turler[j]=i+1;
                }
                j++;
            }
        }
        
        kullanici = islemler.programtablo(secilen_turler);
        model.setRowCount(0);
        for(i=0;i<kullanici.size();i++){
           Object[] eklenecek = {kullanici.get(i).getId(),kullanici.get(i).getProgram(),kullanici.get(i).getProgram_tipi()
                   ,kullanici.get(i).getBolum_sayisi(),kullanici.get(i).getProgram_uzunlugu(),kullanici.get(i).getProgram_puan()
                 , kullanici.get(i).getProgram_tur()};
           model.addRow(eklenecek);
        }
        
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        text_tablo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1022, 640));
        getContentPane().setLayout(null);

        text_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Program", "Program Tipi", "Bolum Sayisi", "Program Uzunlugu", "Program Puan", "Program Tur"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        text_tablo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_tabloKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(text_tablo);
        if (text_tablo.getColumnModel().getColumnCount() > 0) {
            text_tablo.getColumnModel().getColumn(0).setResizable(false);
            text_tablo.getColumnModel().getColumn(1).setResizable(false);
            text_tablo.getColumnModel().getColumn(2).setResizable(false);
            text_tablo.getColumnModel().getColumn(3).setResizable(false);
            text_tablo.getColumnModel().getColumn(4).setResizable(false);
            text_tablo.getColumnModel().getColumn(5).setResizable(false);
            text_tablo.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 210, 870, 320);

        jLabel1.setFont(new java.awt.Font("Verdana Pro Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SIZIN ICIN ONERİLEN BAZI FİLMLER");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 40, 430, 70);

        jButton1.setFont(new java.awt.Font("Verdana Pro Black", 0, 18)); // NOI18N
        jButton1.setText("Giris Ekranina Git");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 130, 310, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resim50.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1010, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        islemler.dbKapat();
        GirisEkrani giris_ekrani = new GirisEkrani();
        giris_ekrani.setVisible(true);
        setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void text_tabloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_tabloKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_text_tabloKeyReleased

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
            java.util.logging.Logger.getLogger(KayitSonrasiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KayitSonrasiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KayitSonrasiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KayitSonrasiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KayitSonrasiEkrani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable text_tablo;
    // End of variables declaration//GEN-END:variables
}
