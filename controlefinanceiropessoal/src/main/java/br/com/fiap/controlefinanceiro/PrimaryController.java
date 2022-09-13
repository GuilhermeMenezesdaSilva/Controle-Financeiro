package br.com.fiap.controlefinanceiro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML private TextField textFieldNomeConta;
    @FXML private TextField textFieldValorConta;
    @FXML private TextField textFieldDataDeVencimento;
    @FXML private TextField textFieldCategoriaConta;

    @FXML private ListView<Financas> listView;
    private List<Financas> Lista = new ArrayList<>();
    
    public void cadastrar() {
        String  nome            = textFieldNomeConta.getText();
        double  valor           = Double.valueOf(textFieldValorConta.getText());
        int     data            = Integer.valueOf(textFieldDataDeVencimento.getText());
        String  categoria       = textFieldCategoriaConta.getText();
        
        textFieldNomeConta.setText("");
        textFieldValorConta.setText("");
        textFieldDataDeVencimento.setText("");
        textFieldCategoriaConta.setText("");

        Financas financas = new Financas(nome, valor, data, categoria, false);
        Lista.add(financas);
        System.out.println(financas);
       
    }
}
