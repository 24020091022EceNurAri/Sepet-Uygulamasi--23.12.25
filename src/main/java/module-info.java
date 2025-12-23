module org.example.sepetuygulamasi1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.sepetuygulamasi1 to javafx.fxml;
    exports org.example.sepetuygulamasi1;
}