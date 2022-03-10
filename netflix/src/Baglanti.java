
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Baglanti {

   private String url="jdbc:sqlite";
  
    private String dbName=":db/netflix.db";

    private String driver="org.sqlite.JDBC";
    
    private Connection connection=null;
    
    private Statement statement=null;
    
    private PreparedStatement preparedStatement=null;
    
    public Baglanti() {
       
       
          try {
        Class.forName(driver).newInstance();
        connection=DriverManager.getConnection(url+dbName);
        System.out.println("Basarili");
    } catch (Exception ex) {
        Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("Basarisiz");
    }                  
         
    }
    
    public void dbKapat(){
        
        try {
            connection.close();    
        } catch (Exception e) {
        
        }
        
    }
    
    public int fonk_sure(int program_id,int kullanici_id){
        
        String sorgu = "select program_zamani from kullanici_program where kullanici_id=? and program_id=?";
      
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setInt(1, kullanici_id);
            preparedStatement.setInt(2, program_id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next() == true){
                return rs.getInt("program_zamani");
            }
            else{
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
        
        
    }
    
    public int[] fonk5(int id){
        
        String sorgu = "select bolum_sayisi , program_uzunlugu from program where id = ?";
        int bilgi[] = new int[2];
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next() == true){
                bilgi[0] = rs.getInt("bolum_sayisi");
                bilgi[1] = rs.getInt("program_uzunlugu");
                return bilgi;
            }
            else{
                return bilgi;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return bilgi;
        }
                
                
    }
    
    public void kullanici_yenileme(int kullanici_id,int program_id,int program_zamani,int bolum,int puan){
        
        String sorgu = "Update kullanici_program set program_zamani = ? , bolum = ? , puan = ? where kullanici_id = ? and program_id = ?";
        
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setInt(1 , program_zamani);
            preparedStatement.setInt(2 , bolum);
            preparedStatement.setInt(3 , puan);
            preparedStatement.setInt(4 , kullanici_id);
            preparedStatement.setInt(5 , program_id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void kullanici_kayit(int kullanici_id,int program_id,int program_zamani,int bolum,int puan){
        
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String sorgu="Insert Into kullanici_program (kullanici_id,program_id,program_tarihi,program_zamani,bolum,puan) VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement=connection.prepareStatement(sorgu);
            preparedStatement.setInt(1, kullanici_id);
            preparedStatement.setInt(2, program_id);
            preparedStatement.setString(3, dateFormat.format(currentDate));
            preparedStatement.setInt(4, program_zamani);
            preparedStatement.setInt(5, bolum);
            preparedStatement.setInt(6, puan);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean empty_button(int kullanici_id,int program_id){
        
        String sorgu = "select * from kullanici_program where kullanici_id=? and program_id=?";
      
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setInt(1, kullanici_id);
            preparedStatement.setInt(2, program_id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next() == true){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
    
    public int kullanici_id(String mail){
        
        String sorgu = "select * from kullanici where mail=?";
        int kullanicci=0;
        
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1, mail);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next() == true){
                kullanicci = rs.getInt("kullanicinin_id");
                return kullanicci;
            }
            else{
                return kullanicci;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return kullanicci;
        }
                
    }
    
    public boolean empty(int kullanicci){
        
        String sorgu = "select * from kullanici_program where kullanici_id=? ";
      
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setInt(1, kullanicci);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next() == true){
                return false;
            }
            else{
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
                
    }
    
    public ArrayList<YeniClass> fonk(int kullanici_id){
        
        ArrayList<YeniClass> temp = new ArrayList<YeniClass>();
        String sorgu = "select kullanici_id , program_id , program_zamani , bolum from kullanici_program where kullanici_id=?";
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setInt(1, kullanici_id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next() == true){
                int bolum = rs.getInt("bolum");
                int program_zamani = rs.getInt("program_zamani");
                int kullanici = rs.getInt("kullanici_id");
                int program = rs.getInt("program_id");
                temp.add(new YeniClass(bolum,program_zamani,kullanici,program));
            }
            return temp;
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<KullaniciYonetim> kullanici_tablo(String ara){
        
        String sorgu = "select id , program , program_tipi , bolum_sayisi ,"
                + "  tur_ismi"
              + " from program , program_tur , tur where id = program_id and tur_id = id_tur and (program LIKE ? or tur_ismi LIKE ?)";
        ArrayList<KullaniciYonetim> temp = new ArrayList<KullaniciYonetim>();
        int i;
        int j;
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1, "%" + ara + "%");
            preparedStatement.setString(2, "%" + ara + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {  
                int program_id = rs.getInt("id");
                String program_adi = rs.getString("program");
                String program_turu = rs.getString("tur_ismi");
                String program_tipi = rs.getString("program_tipi");
                int bolum_sayisi = rs.getInt("bolum_sayisi");
                temp.add(new KullaniciYonetim(program_id,program_adi,program_turu,program_tipi,bolum_sayisi,1,0));
            }
            for(i=0;i<temp.size();i++){
                for(j=i;j<temp.size();j++){
                    if(temp.get(i).getProgram_adi().equals(temp.get(j).getProgram_adi()) && i!=j){
                        temp.get(i).setProgram_turu(temp.get(i).getProgram_turu() + " , "+ temp.get(j).getProgram_turu());
                        temp.remove(j);
                        j--;
                    }
                }
            }
            return temp;
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public void yenikayit(String kullanici_adi,String sifre,String mail,String dogum_tarihi){
        
        String sorgu="Insert Into kullanici (kullanici_adi,sifre,mail,dogum_tarihi) VALUES(?,?,?,?)";
        try {
            preparedStatement=connection.prepareStatement(sorgu);
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, sifre);
            preparedStatement.setString(3, mail);
            preparedStatement.setString(4, dogum_tarihi);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<Kullanici> programtablo(int secilen_turler[]){
        
        String sorgu = "select id , program , program_tipi , bolum_sayisi ,program_uzunlugu , program_puan ,"
                + " tur_id , tur_ismi"
              + " from program , program_tur , tur where id = program_id and tur_id = id_tur and (tur_id=? or tur_id=? or tur_id=?)"
                + "order by program_puan desc";
        ArrayList<Kullanici> temp = new ArrayList<Kullanici>();
        int i , j , p ;
        i=0;
        j=0;
        p=0;
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setInt(1, secilen_turler[0]);
            preparedStatement.setInt(2, secilen_turler[1]);
            preparedStatement.setInt(3, secilen_turler[2]);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if(i<2 && secilen_turler[0]==rs.getInt("tur_id")){
                    int id = rs.getInt("id");
                    String program = rs.getString("program");
                    String program_tipi = rs.getString("program_tipi");
                    int bolum_sayisi = rs.getInt("bolum_sayisi");
                    int program_uzunlugu = rs.getInt("program_uzunlugu");
                    int program_puan = rs.getInt("program_puan");
                    String tur_ismi = rs.getString("tur_ismi");
                    temp.add(new Kullanici(id,program,program_tipi,bolum_sayisi,program_uzunlugu,program_puan,tur_ismi));
                    i++;
                }
                if(j<2 && secilen_turler[1]==rs.getInt("tur_id")){
                    int id = rs.getInt("id");
                    String program = rs.getString("program");
                    String program_tipi = rs.getString("program_tipi");
                    int bolum_sayisi = rs.getInt("bolum_sayisi");
                    int program_uzunlugu = rs.getInt("program_uzunlugu");
                    int program_puan = rs.getInt("program_puan");
                    String tur_ismi = rs.getString("tur_ismi");
                    temp.add(new Kullanici(id,program,program_tipi,bolum_sayisi,program_uzunlugu,program_puan,tur_ismi));
                    j++;
                }
                if(p<2 && secilen_turler[2]==rs.getInt("tur_id")){
                    int id = rs.getInt("id");
                    String program = rs.getString("program");
                    String program_tipi = rs.getString("program_tipi");
                    int bolum_sayisi = rs.getInt("bolum_sayisi");
                    int program_uzunlugu = rs.getInt("program_uzunlugu");
                    int program_puan = rs.getInt("program_puan");
                    String tur_ismi = rs.getString("tur_ismi");
                    temp.add(new Kullanici(id,program,program_tipi,bolum_sayisi,program_uzunlugu,program_puan,tur_ismi));
                    p++;
                }
            } 
            return temp;
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public boolean mail_adresi_kayit(String mail){
        
        String sorgu = "select * from kullanici where mail=?";
      
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1, mail);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next() == true){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
    
    public boolean kullanici_kayit(String kullanici){
        
        String sorgu = "select * from kullanici where kullanici_adi=?";
      
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1, kullanici);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next() == true){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
    
    public boolean girisyap(String mail,String parola){
        
        String sorgu = "select * from kullanici where mail=? and sifre=?";
      
        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1, mail);
            preparedStatement.setString(2, parola);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next() == true){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
    
    public static void main(String[] args) {
        
        Baglanti baglanti = new Baglanti();
        
    }
    
}
