/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class KullaniciYonetim {
    
    private int program_id;
    private String program_adi;
    private String program_turu;
    private String program_tipi;
    private int bolum_sayisi;
    private int izlenen_bolum;
    private int izlenen_zaman;

    public KullaniciYonetim() {
    }

    public KullaniciYonetim(int program_id,String program_adi, String program_turu, String program_tipi, int bolum_sayisi, int izlenen_bolum, int izlenen_zaman) {
        this.program_id = program_id;
        this.program_adi = program_adi;
        this.program_turu = program_turu;
        this.program_tipi = program_tipi;
        this.bolum_sayisi = bolum_sayisi;
        this.izlenen_bolum = izlenen_bolum;
        this.izlenen_zaman = izlenen_zaman;
    }

    public int getProgram_id() {
        return program_id;
    }

    public void setProgram_id(int program_id) {
        this.program_id = program_id;
    }
    
    /**
     * @return the program_adi
     */
    public String getProgram_adi() {
        return program_adi;
    }

    /**
     * @param program_adi the program_adi to set
     */
    public void setProgram_adi(String program_adi) {
        this.program_adi = program_adi;
    }

    /**
     * @return the program_turu
     */
    public String getProgram_turu() {
        return program_turu;
    }

    /**
     * @param program_turu the program_turu to set
     */
    public void setProgram_turu(String program_turu) {
        this.program_turu = program_turu;
    }

    /**
     * @return the program_tipi
     */
    public String getProgram_tipi() {
        return program_tipi;
    }

    /**
     * @param program_tipi the program_tipi to set
     */
    public void setProgram_tipi(String program_tipi) {
        this.program_tipi = program_tipi;
    }

    /**
     * @return the bolum_sayisi
     */
    public int getBolum_sayisi() {
        return bolum_sayisi;
    }

    /**
     * @param bolum_sayisi the bolum_sayisi to set
     */
    public void setBolum_sayisi(int bolum_sayisi) {
        this.bolum_sayisi = bolum_sayisi;
    }

    /**
     * @return the izlenen_bolum
     */
    public int getIzlenen_bolum() {
        return izlenen_bolum;
    }

    /**
     * @param izlenen_bolum the izlenen_bolum to set
     */
    public void setIzlenen_bolum(int izlenen_bolum) {
        this.izlenen_bolum = izlenen_bolum;
    }

    /**
     * @return the izlenen_zaman
     */
    public int getIzlenen_zaman() {
        return izlenen_zaman;
    }

    /**
     * @param izlenen_zaman the izlenen_zaman to set
     */
    public void setIzlenen_zaman(int izlenen_zaman) {
        this.izlenen_zaman = izlenen_zaman;
    }

    
    
    
    
    
    
    
}
