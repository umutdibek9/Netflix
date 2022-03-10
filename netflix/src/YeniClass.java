
public class YeniClass {

    private int bolum;
    private int zaman;
    private int kullanici_id;
    private int program_id;

    public YeniClass(int bolum, int zaman, int kullanici_id, int program_id) {
        this.bolum = bolum;
        this.zaman = zaman;
        this.kullanici_id = kullanici_id;
        this.program_id = program_id;
    }

    public int getBolum() {
        return bolum;
    }

    public void setBolum(int bolum) {
        this.bolum = bolum;
    }

    public int getZaman() {
        return zaman;
    }

    public void setZaman(int zaman) {
        this.zaman = zaman;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public int getProgram_id() {
        return program_id;
    }

    public void setProgram_id(int program_id) {
        this.program_id = program_id;
    }
    
    
    


    
}
