package org.example.sepetuygulamasi1;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;



//ekmek ve cep telefonuna urun ekle
//satin al ve sil tuslarini yaz




public class SepetController implements Initializable{
    @FXML
    private ChoiceBox<String> SecimButonu1;

    @FXML
    private Pane tekstilPane;

    @FXML
    private CheckBox bedenXS, bedenS, bedenM, bedenL, bedenXL;

    @FXML
    private CheckBox checkKeten, checkIpek, checkPamuk, checkPolyester, checkYun, checkDeri;

    @FXML
    private CheckBox maviC,kotonC,ipekyolC,lcwaikikiC,defactoC,colinsC;

    @FXML
    private ListView<String> sonucEkrani;
    private List<TekstilUrun> butunUrunler = new ArrayList<>();
    private List<EkmekUrun> butunEkmekler = new ArrayList<>();
    private List<CepTelefonu> butunTelefonlar = new ArrayList<>();

    @FXML
    private ListView<String> sepetListesiGosterge;

    @FXML
    private TextArea ozellikAlani;



    @Override
    public void initialize(URL url, ResourceBundle rb){

        tekstilPane.setVisible(false);


        butunUrunler.add(new TekstilUrun("Pantolon-1","L","Keten","DeFacto",840));
        butunUrunler.add(new TekstilUrun("Pantolon-2","M","Keten","Ipekyol",760));
        butunUrunler.add(new TekstilUrun("Tisort","XL","Pamuk","Koton",300));
        butunUrunler.add(new TekstilUrun ("Gomlek","S","Ipek","Colin's",480));
        butunUrunler.add(new TekstilUrun("Kazak-1","M","Yun","LC Waikiki",550));
        butunUrunler.add(new TekstilUrun("Mont","L","Deri","Mavi",1340));
        butunUrunler.add(new TekstilUrun("Kazak-2","S","Deri","Koton",570));

        butunEkmekler.add(new EkmekUrun("Beyaz Ekmek",250,10));
        butunEkmekler.add(new EkmekUrun("Tam Buğday Ekmegi",200,15));
        butunEkmekler.add(new EkmekUrun("Çavdar Ekmegi",230,20));
        butunEkmekler.add(new EkmekUrun("Kepekli Ekmek",240,25));

        butunTelefonlar.add(new CepTelefonu("Samsung","Galaxy S25 Ultra","128GB \n6.9 inç Dynamic AMOLED 2X ekran \n" +
                "Snapdragon 8 Elite işlemci \n200MP ana kamera ve entegre S Pen",82000));
        butunTelefonlar.add(new CepTelefonu("Apple","iPhone 17","128GB \n6.3 inç Super Retina XDR ekran \n" +
                "A19 Bionic çip \n48MP ana kamera",78000));
        butunTelefonlar.add(new CepTelefonu("Xiaomi","Xiaomi 15 Ultra","128GB \nLeica 50MP Dörtlü Kamera \n" +
                "1TB Depolama opsiyonu \nSnapdragon 8 Elite çipi",80000));




        String[] secenekler = {"Tekstil","Cep Telefonu","Ekmek"};
        SecimButonu1.getItems().addAll(secenekler);
        SecimButonu1.setValue("Ürünler");

        sonucEkrani.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> {
            if (newValue !=null){
                ozellikleriGoster(newValue);
            }
        });

        SecimButonu1.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            tekstilPane.setVisible(false);
            sonucEkrani.getItems().clear();
            ozellikAlani.clear();

            ozellikAlani.setVisible(false);


            if("Tekstil".equals(newValue)){
                tekstilPane.setVisible(true);
            }else if("Ekmek".equals(newValue)){
                ozellikAlani.setVisible(true);
                for (EkmekUrun ekmek : butunEkmekler){
                    sonucEkrani.getItems().add(ekmek.getEkmekTuru() );
                }
            }else if("Cep Telefonu".equals(newValue)){
                ozellikAlani.setVisible(true);
                for(CepTelefonu tel : butunTelefonlar){
                    sonucEkrani.getItems().add(tel.getMarka()+" "+ tel.getModel() );
                }
            }
        });
    }

    @FXML
    private void ozellikleriGoster(String secilenSatir){
        String kategori = SecimButonu1.getValue();
        ozellikAlani.clear();

        if("Cep Telefonu".equals(kategori)){
            for(CepTelefonu tel : butunTelefonlar){
                if(secilenSatir.contains(tel.getMarka()) && secilenSatir.contains(tel.getModel())){
                    ozellikAlani.setText("---Telefon Özellikleri--- \n\n"+
                            "Marka: " + tel.getMarka() + "\n"+
                            "Model: " + tel.getModel() + "\n"+
                            "Ozellik: " + tel.getTelefonOzelligi() + "\n"+
                            "Fiyat: " + tel.getFiyat() + "TL");
                    return;
                }
            }
        }else if ("Ekmek".equals(kategori)){
            for(EkmekUrun urun : butunEkmekler){
                if (secilenSatir.contains(urun.getEkmekTuru())){
                    ozellikAlani.setText("GRAMAJ: " +urun.getGramaj() + " g" + "\n"+
                            "Fiyat: " +urun.getFiyat() +" TL");
                    return;
                }
            }
        }
    }

    @FXML
    public void filtereleButonunaTiklandi(){

        sonucEkrani.getItems().clear();

        List<String> secilenBedenler = new ArrayList<>();
        if (bedenXS.isSelected()) secilenBedenler.add("XS");
        if (bedenS.isSelected()) secilenBedenler.add("S");
        if (bedenM.isSelected()) secilenBedenler.add("M");
        if (bedenL.isSelected()) secilenBedenler.add("L");
        if (bedenXL.isSelected()) secilenBedenler.add("XL");

        List<String> secilenKumas = new ArrayList<>();
        if(checkPamuk.isSelected()) secilenKumas.add("Pamuk");
        if(checkKeten.isSelected()) secilenKumas.add("Keten");
        if(checkIpek.isSelected()) secilenKumas.add("Ipek");
        if(checkPolyester.isSelected()) secilenKumas.add("Polyester");
        if(checkYun.isSelected()) secilenKumas.add("Yun");
        if(checkDeri.isSelected()) secilenKumas.add("Deri");

        List<String> secilenMarkalar = new ArrayList<>();
        if(maviC != null && maviC.isSelected()) secilenMarkalar.add("Mavi");
        if(ipekyolC != null && ipekyolC.isSelected()) secilenMarkalar.add("Ipekyol");
        if(defactoC != null && defactoC.isSelected()) secilenMarkalar.add("DeFacto");
        if(colinsC != null && colinsC.isSelected()) secilenMarkalar.add("Colin's");
        if(kotonC != null && kotonC.isSelected()) secilenMarkalar.add("Koton");
        if(lcwaikikiC != null && lcwaikikiC.isSelected()) secilenMarkalar.add("LC Waikiki");

        boolean filtreVarMi =!secilenBedenler.isEmpty() || !secilenKumas.isEmpty() || !secilenMarkalar.isEmpty();
        for (TekstilUrun urun : butunUrunler){
            boolean bedenUygun = secilenBedenler.isEmpty() || secilenBedenler.contains(urun.getBeden());
            boolean kumasUygun = secilenKumas.isEmpty() || secilenKumas.contains(urun.getKumas());
            boolean markaUygun = secilenMarkalar.isEmpty() || secilenMarkalar.contains(urun.getMarka());

            if(!filtreVarMi || (bedenUygun && kumasUygun && markaUygun)){
                sonucEkrani.getItems().add(urun.getUrunAdi() + " | " + urun.getMarka() + " | " + urun.getKumas()+ " | " + urun.getBeden() + " | " + urun.getFiyat() + " TL");
            }


        }
            if(sonucEkrani.getItems().isEmpty()){
                sonucEkrani.getItems().add("Eslesen urun bulunamadi.");

            }
    }
     private void toplamKdvGuncelle(){
        double toplamKdv = 0;
        for(String satir : sepetListesiGosterge.getItems()){
            try {
                if (satir.contains("KDV: ")) {
                    String[] parcalar = satir.split("KDV: ");
                    String kdvDegeriStr = parcalar[1].replace("TL", "").replace(" ","").replace(",",".");
                    toplamKdv += Double.parseDouble(kdvDegeriStr);
                }
            } catch(Exception e) {
                System.out.println("Satır hatasi: " + satir);
            }
        }
        ozellikAlani.setText("Toplam KDV: " + String.format("%.2f", toplamKdv) + " TL");
    }


    @FXML
    public void sepeteEkleButonunaTiklandi(){
        String secilenUrunMetni = sonucEkrani.getSelectionModel().getSelectedItem();
        String kategori = SecimButonu1.getValue();
        double hesaplananKdv = 0;


        if(secilenUrunMetni != null) {
            if("Ekmek".equals(kategori)){
                for(EkmekUrun e : butunEkmekler){
                    if(secilenUrunMetni.contains(e.getEkmekTuru())) hesaplananKdv = e.kdvHesapla();
                }
            }else if("Cep Telefonu".equals(kategori)){
                for(CepTelefonu t : butunTelefonlar){
                    if(secilenUrunMetni.contains(t.getMarka())) hesaplananKdv = t.kdvHesapla();
                }
            }else if("Tekstil".equals(kategori)){
                for(TekstilUrun urun : butunUrunler){
                    if(secilenUrunMetni.contains(urun.getUrunAdi())) hesaplananKdv = urun.kdvHesapla();
                }
            }else {

            }
            String kdvMetni = String.format(java.util.Locale.US, "%.2f", hesaplananKdv);
            String sepetSatiri = secilenUrunMetni + " | KDV: " + kdvMetni + " TL";
            sepetListesiGosterge.getItems().add(sepetSatiri);


        }

    }

    @FXML
    public void sepettenSilButonunaTiklandi(){
        String seciliItem = sepetListesiGosterge.getSelectionModel().getSelectedItem();
        if(seciliItem != null){
            sepetListesiGosterge.getItems().remove(seciliItem);
        }
    }

    @FXML
    public void satinAlButonunaTiklandi(){
        if (sepetListesiGosterge.getItems().isEmpty()) {
            ozellikAlani.setVisible(true);
            ozellikAlani.setText("Sepetiniz boş! Önce ürün ekleyin.");
            return;
        }
        double genelToplamKdv = 0;
        for (String satir : sepetListesiGosterge.getItems()){
            try{
                if(satir.contains("KDV: ")){
                    String kdvParcasi = satir.split("KDV: ")[1];
                    String rakamStr = kdvParcasi.split(" ")[0].trim();
                    rakamStr = rakamStr.replace(",", ".");
                    genelToplamKdv += Double.parseDouble(rakamStr);
                }
            }catch(Exception e){
                System.out.println("Hesaplama hatası: "+ e.getMessage());
            }
        }
        ozellikAlani.setVisible(true);
        String mesaj = "Satın Alma Başarılı\nÖdenen Toplam KDV: " + String.format(java.util.Locale.US, "%.2f", genelToplamKdv) + " TL";
        ozellikAlani.setText(mesaj);
        sepetListesiGosterge.getItems().clear();

    }
}



