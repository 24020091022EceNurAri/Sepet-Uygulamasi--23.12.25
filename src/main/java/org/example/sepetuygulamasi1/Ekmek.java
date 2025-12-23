package org.example.sepetuygulamasi1;

public class Ekmek {
    private String Ekmek;
}

// gramaj-ekmektürü-fiyat

class EkmekTurleri{
    private String ekmekTuru;

    public EkmekTurleri(String ekmekTuru){
        this.ekmekTuru = ekmekTuru;
    }
    public String getEkmekTuru(){
        return ekmekTuru;
    }
}
class GramajMiktari{
    private double gramaj;
    public GramajMiktari(double gramaj){
        this.gramaj = gramaj;
    }
    public double getGramaj(){
        return gramaj;
    }
}

class EkmekUrun{
    private String ekmekTuru;
    private double gramaj;
    private double fiyat;

    public EkmekUrun(String ekmekTuru, double gramaj, double fiyat){
        this.ekmekTuru = ekmekTuru;
        this.gramaj = gramaj;
        this.fiyat = fiyat;
    }

    public double kdvHesapla(){
        return 0;
    }

    public String getEkmekTuru(){ return ekmekTuru; }
    public double getGramaj(){ return gramaj; }
    public double getFiyat(){ return fiyat;}
}