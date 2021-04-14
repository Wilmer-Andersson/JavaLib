package brains;

public class Artikel {
    private int artikelNr;
    private String artikelNamn;
    private int pris;

    public Artikel(int aNr, String aN, int p){
        this.artikelNr = aNr;
        this.artikelNamn = aN;
        this.pris = p;
    }

    public void setArtikelNr(int aNR){
        this.artikelNr = aNR;
    }

    public int getArtikelNr(){
        return this.artikelNr;
    }

    public void setArtikelNamn(String aN){
        this.artikelNamn = aN;
    }

    public String getArtikelNamn(){
        return this.artikelNamn;
    }

    public void setPris(int p){
        this.pris = p;
    }

    public int getPris(){
        return this.pris;
    }
}
