module br.com.fiap.controlefinanceiro {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.fiap.controlefinanceiro to javafx.fxml;
    exports br.com.fiap.controlefinanceiro;
}
