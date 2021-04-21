package Objects;

public class Artikel {
    private int artikelNr;
    private String artikelNamn;
    private int pris;


    public Artikel(int artikelNr, String artikelNamn, int pris) {
        this.artikelNr = artikelNr;
        this.artikelNamn = artikelNamn;
        this.pris = pris;
    }

    public int getArtikelNr() {
        return artikelNr;
    }

    public void setArtikelNr(int artikelNr) {
        this.artikelNr = artikelNr;
    }

    public String getArtikelNamn() {
        return artikelNamn;
    }

    public void setArtikelNamn(String artikelNamn) {
        this.artikelNamn = artikelNamn;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }
}
