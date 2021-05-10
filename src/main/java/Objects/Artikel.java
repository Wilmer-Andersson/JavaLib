package Objects;

public class Artikel {
    private int artikelNr;
    private String artikelNamn;

    public Artikel(){

    }

    public Artikel(int artikelNr, String artikelNamn) {
        this.artikelNr = artikelNr;
        this.artikelNamn = artikelNamn;
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

    class Bok extends Artikel{
        int laneTid;
        String lagerPlats;
        int antal;
        String genre;
        String språk;
        String utgivningsÅr;
        String förlag;
        String isbn;
        String författare;
        String upplaga;

        public int getLaneTid() {
            return laneTid;
        }

        public void setLaneTid(int laneTid) {
            this.laneTid = laneTid;
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

        public Bok(){ }

        public Bok(int laneTid, String lagerPlats, int antal, String genre, String språk, String utgivningsÅr, String förlag, String isbn, String författare, String upplaga) {
            this.laneTid = laneTid;
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

    public class Film extends Artikel{
        int laneTid;
        String lagerPlats;
        int antal;
        String genre;
        String språk;
        String utgivningsÅr;
        String regissör;

        public Film(){ }

        public Film(int laneTid, String lagerPlats, int antal, String genre, String språk, String utgivningsÅr, String regissör) {
            this.laneTid = laneTid;
            this.lagerPlats = lagerPlats;
            this.antal = antal;
            this.genre = genre;
            this.språk = språk;
            this.utgivningsÅr = utgivningsÅr;
            this.regissör = regissör;
        }

        public int getLaneTid() {
            return laneTid;
        }

        public void setLaneTid(int laneTid) {
            this.laneTid = laneTid;
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

    public class Tidsskrift extends Artikel{
        int laneTid;
        String lagerPlats;
        int antal;
        String genre;
        String språk;
        String utgivningsDatum;
        String ISSN;
        String källa;

        public Tidsskrift(int laneTid, String lagerPlats, int antal, String genre, String språk, String utgivningsDatum, String ISSN, String källa) {
            this.laneTid = laneTid;
            this.lagerPlats = lagerPlats;
            this.antal = antal;
            this.genre = genre;
            this.språk = språk;
            this.utgivningsDatum = utgivningsDatum;
            this.ISSN = ISSN;
            this.källa = källa;
        }

        public int getLaneTid() {
            return laneTid;
        }

        public void setLaneTid(int laneTid) {
            this.laneTid = laneTid;
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