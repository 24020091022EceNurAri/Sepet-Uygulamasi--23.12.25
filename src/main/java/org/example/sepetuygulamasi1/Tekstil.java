package org.example.sepetuygulamasi1;

public class Tekstil {
    private String Tekstil;
}
class Beden{
    private String bedenDegeri;

    public Beden(String bedenDegeri){
        this.bedenDegeri = bedenDegeri;
    }

    public String getBedenDegeri(){
        return bedenDegeri;
    }
}

class Kumas{
    private String kumasTuru;

    public Kumas(String kumasTuru){
        this.kumasTuru = kumasTuru;
    }
    public String getKumasTuru(){
        return kumasTuru;
    }
}

class TekstilMarka{
    private String marka;

    public TekstilMarka(String marka){
        this.marka = marka;
    }
    public String getTekstilMarka(){
        return marka;
    }

}
class TekstilUrun{
    private String urunAdi;
    private String beden;
    private String kumas;
    private String marka;
    private double fiyat;

    public TekstilUrun(String urunAdi, String beden, String kumas, String marka,double fiyat){
        this.urunAdi = urunAdi;
        this.beden = beden;
        this.kumas = kumas;
        this.marka = marka;
        this.fiyat = fiyat;
    }

    public double kdvHesapla(){
        return this.fiyat * 0.1;
    }

    public String getUrunAdi(){ return urunAdi;}
    public String getBeden(){ return beden;}
    public String getKumas(){ return kumas;}
    public String getMarka(){ return marka;}
    public double getFiyat(){ return fiyat;}

}
