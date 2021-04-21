package Objects;

public class Artiklar
{
    private int _artikelID;
    public int getartikelID()
    {
        return this._artikelID;
    }
    public void setartikelID(int value)
    {
        this._artikelID = value;
    }

    private String _artikelTyp;
    public String getartikelTyp()
    {
        return this._artikelTyp;
    }
    public void setartikelTyp(String value)
    {
        this._artikelTyp = value;
    }

    private int _DVDID;
    public int getDVDID()
    {
        return this._DVDID;
    }
    public void setDVDID(int value)
    {
        this._DVDID = value;
    }

    private int _litteraturID;
    public int getlitteraturID()
    {
        return this._litteraturID;
    }
    public void setlitteraturID(int value)
    {
        this._litteraturID = value;
    }

    private int _laneTid;
    public int getlaneTid()
    {
        return this._laneTid;
    }
    public void setlaneTid(int value)
    {
        this._laneTid = value;
    }

    private byte _status;
    public byte getstatus()
    {
        return this._status;
    }
    public void setstatus(byte value)
    {
        this._status = value;
    }

    private String _genre;
    public String getgenre()
    {
        return this._genre;
    }
    public void setgenre(String value)
    {
        this._genre = value;
    }


    public Artiklar(int artikelID_,String artikelTyp_,int DVDID_,int litteraturID_,int laneTid_,byte status_,String genre_)
    {
        this._artikelID = artikelID_;
        this._artikelTyp = artikelTyp_;
        this._DVDID = DVDID_;
        this._litteraturID = litteraturID_;
        this._laneTid = laneTid_;
        this._status = status_;
        this._genre = genre_;
    }
}