
public class Kullanici {
    
    private int id;
    private String program;
    private String program_tipi;
    private int bolum_sayisi;
    private int program_uzunlugu;
    private int program_puan;
    private String program_tur;

    public Kullanici() {

    }

    
    public Kullanici(int id, String program, String program_tipi, int bolum_sayisi, int program_uzunlugu, int program_puan,String program_tur) {
        this.id = id;
        this.program = program;
        this.program_tipi = program_tipi;
        this.bolum_sayisi = bolum_sayisi;
        this.program_uzunlugu = program_uzunlugu;
        this.program_puan = program_puan;
        this.program_tur= program_tur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram_tipi() {
        return program_tipi;
    }

    public void setProgram_tipi(String program_tipi) {
        this.program_tipi = program_tipi;
    }

    public int getBolum_sayisi() {
        return bolum_sayisi;
    }

    public void setBolum_sayisi(int bolum_sayisi) {
        this.bolum_sayisi = bolum_sayisi;
    }

    public int getProgram_uzunlugu() {
        return program_uzunlugu;
    }

    public void setProgram_uzunlugu(int program_uzunlugu) {
        this.program_uzunlugu = program_uzunlugu;
    }

    public int getProgram_puan() {
        return program_puan;
    }

    public void setProgram_puan(int program_puan) {
        this.program_puan = program_puan;
    }

    public String getProgram_tur() {
        return program_tur;
    }

    public void setProgram_tur(String program_tur) {
        this.program_tur = program_tur;
    }
    
    
    
    
    
}
