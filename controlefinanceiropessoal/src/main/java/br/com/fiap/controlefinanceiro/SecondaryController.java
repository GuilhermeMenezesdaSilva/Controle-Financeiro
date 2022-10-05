package br.com.fiap.controlefinanceiro;

import java.io.IOException;
import javafx.fxml.FXML;
import br.com.fiap.controlefinanceiro.SecondaryController;
public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    
    }
    
}