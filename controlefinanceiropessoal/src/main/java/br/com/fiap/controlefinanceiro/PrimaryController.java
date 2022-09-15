package br.com.fiap.controlefinanceiro;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class PrimaryController implements Initializable{
    @FXML private TextField textFieldNomeConta;
    @FXML private TextField textFieldValorConta;
    @FXML private TextField textFieldDataDeVencimento;
    @FXML private ChoiceBox<String> choiceBoxCategoriaConta;
    @FXML private ListView<Financas> listViewFinancas;  

    private List<Financas> Lista = new ArrayList<>();
  
    String[] listaCategorias =  {"Salário de funcionários","Contas de água e de luz","Empréstimos"};
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        choiceBoxCategoriaConta.getItems().addAll(listaCategorias);
    }

    public void cadastrar() {
        var contas = carregarInfos();
        if(contas == null){erro("as informações estão erradas");}
        Lista.add(contas);
        System.out.println(Lista);
        limparFormulario();
       
        listViewFinancas.getItems().add(contas);
        atualizarLista();
    }

    public Financas carregarInfos(){
        try{
            String  nome = textFieldNomeConta.getText();
            double  valor = Double.valueOf(textFieldValorConta.getText());
            if (valor<=0){throw new IOException("");}
            int     data   = Integer.valueOf(textFieldDataDeVencimento.getText());
            String categoria =choiceBoxCategoriaConta.getValue();
            Financas financas = new Financas(nome, valor, data, categoria, false);
            return financas;
        }catch(IOException e){
            return null;
        }
    }

    public void erro(String mensagem) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText(mensagem);
        alert.show();
    }

    public void ordenarCategoria() {
       // Lista.sort((o1,o2) -> String.(o1.getCategoriaConta(), o2.getCategoriaConta()));
        atualizarLista();
    }

    public void ordenarData() { 
        Lista.sort((o1,o2) -> Double.compare(o1.getDataPagamentoConta(), o2.getDataPagamentoConta()));
        atualizarLista();
    }

    public void ordenarValor() {
        Lista.sort((o1,o2) -> Double.compare(o1.getValorConta(), o2.getValorConta()));
        atualizarLista();
    }

    private void atualizarLista(){
        listViewFinancas.getItems().clear();
        listViewFinancas.getItems().addAll(Lista);
    }

    private void limparFormulario(){
        textFieldNomeConta.setText("");
        textFieldValorConta.setText("");
        textFieldDataDeVencimento.setText("");
    }

}
