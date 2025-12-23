package org.example.sepetuygulamasi1;

public class CepTelefonu {
    private String marka;
    private String model;
    private String telefonOzelligi;
    private double fiyat;

    public CepTelefonu(String marka,String model, String telefonOzelligi, double fiyat){
        this.marka = marka;
        this.model = model;
        this.telefonOzelligi = telefonOzelligi;
        this.fiyat = fiyat;
    }
    public double kdvHesapla(){
        return this.fiyat * 0.18;
    }
    public String getMarka(){ return marka;}
    public String getModel(){ return model;}
    public String getTelefonOzelligi(){ return telefonOzelligi;}
    public double getFiyat(){ return fiyat;}
}
