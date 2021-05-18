package Objects;

public class Artikel {
    private int artikelNr;
    private String artikelNamn;
    private int laneTid;

    public Artikel(){

    }

    public Artikel(int artikelNr, String artikelNamn, int laneTid) {
        this.artikelNr = artikelNr;
        this.artikelNamn = artikelNamn;
        this.laneTid = laneTid;
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

    public int getLaneTid() { return laneTid; }

    public void setLaneTid(int laneTid) { this.laneTid = laneTid; }

    public static class Bok extends Artikel{



        String lagerPlats;
        int antal;
        String genre;
        String språk;
        String utgivningsÅr;
        String förlag;
        String isbn;
        String författare;
        String upplaga;

        public String getLagerPlats() {
            return lagerPlats;
        }

        public void setLagerPlats(String lagerPlats) {
            this.lagerPlats = lagerPlats;
        }

        public int getAntal() {
            return antal;
        }

        public void setAntal(int antal) {
            this.antal = antal;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String getSpråk() {
            return språk;
        }

        public void setSpråk(String språk) {
            this.språk = språk;
        }

        public String getUtgivningsÅr() {
            return utgivningsÅr;
        }

        public void setUtgivningsÅr(String utgivningsÅr) {
            this.utgivningsÅr = utgivningsÅr;
        }

        public String getFörlag() {
            return förlag;
        }

        public void setFörlag(String förlag) {
            this.förlag = förlag;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getFörfattare() {
            return författare;
        }

        public void setFörfattare(String författare) {
            this.författare = författare;
        }

        public String getUpplaga() {
            return upplaga;
        }

        public void setUpplaga(String upplaga) {
            this.upplaga = upplaga;
        }

        public Bok(){

        }

        public Bok(int artikelNr,String artikelnamn,int laneTid,String lagerPlats, int antal, String genre, String språk, String utgivningsÅr, String förlag, String isbn, String författare, String upplaga) {
            super(artikelNr,artikelnamn,laneTid);
            this.lagerPlats = lagerPlats;
            this.antal = antal;
            this.genre = genre;
            this.språk = språk;
            this.utgivningsÅr = utgivningsÅr;
            this.förlag = förlag;
            this.isbn = isbn;
            this.författare = författare;
            this.upplaga = upplaga;
        }
    }

    public static class Film extends Artikel{
        String lagerPlats;
        int antal;
        String genre;
        String språk;
        String utgivningsÅr;
        String regissör;

        public Film(){ }

        public Film(int artikelNr,String artikelnamn,int laneTid, String lagerPlats, int antal, String genre, String språk, String utgivningsÅr, String regissör) {
            super(artikelNr,artikelnamn,laneTid);
            this.lagerPlats = lagerPlats;
            this.antal = antal;
            this.genre = genre;
            this.språk = språk;
            this.utgivningsÅr = utgivningsÅr;
            this.regissör = regissör;
        }

        public String getLagerPlats() {
            return lagerPlats;
        }

        public void setLagerPlats(String lagerPlats) {
            this.lagerPlats = lagerPlats;
        }

        public int getAntal() {
            return antal;
        }

        public void setAntal(int antal) {
            this.antal = antal;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String getSpråk() {
            return språk;
        }

        public void setSpråk(String språk) {
            this.språk = språk;
        }

        public String getUtgivningsÅr() {
            return utgivningsÅr;
        }

        public void setUtgivningsÅr(String utgivningsÅr) {
            this.utgivningsÅr = utgivningsÅr;
        }

        public String getRegissör() {
            return regissör;
        }

        public void setRegissör(String regissör) {
            this.regissör = regissör;
        }
    }

    public static class Tidsskrift extends Artikel{
        String lagerPlats;
        int antal;
        String genre;
        String språk;
        String utgivningsDatum;
        String ISSN;
        String källa;

        public Tidsskrift() {  }

        public Tidsskrift(int artikelNr,String artikelnamn,int laneTid, String lagerPlats, int antal, String genre, String språk, String utgivningsDatum, String ISSN, String källa) {
            super(artikelNr,artikelnamn,laneTid);
            this.lagerPlats = lagerPlats;
            this.antal = antal;
            this.genre = genre;
            this.språk = språk;
            this.utgivningsDatum = utgivningsDatum;
            this.ISSN = ISSN;
            this.källa = källa;
        }

        public String getLagerPlats() {
            return lagerPlats;
        }

        public void setLagerPlats(String lagerPlats) {
            this.lagerPlats = lagerPlats;
        }

        public int getAntal() {
            return antal;
        }

        public void setAntal(int antal) {
            this.antal = antal;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String getSpråk() {
            return språk;
        }

        public void setSpråk(String språk) {
            this.språk = språk;
        }

        public String getUtgivningsDatum() {
            return utgivningsDatum;
        }

        public void setUtgivningsDatum(String utgivningsDatum) {
            this.utgivningsDatum = utgivningsDatum;
        }

        public String getISSN() {
            return ISSN;
        }

        public void setISSN(String ISSN) {
            this.ISSN = ISSN;
        }

        public String getKälla() {
            return källa;
        }

        public void setKälla(String källa) {
            this.källa = källa;
        }
    }

}