package br.com.fiap.controlefinanceiro;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
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
    @FXML private CheckBox checkbox;
    @FXML private ListView<Financas> listViewPagar;
    @FXML private TextField textFieldPagar;

    private List<Financas> Lista = new ArrayList<>();
    private List<Financas> ListaNPago = new ArrayList<>();
  
    String[] listaCategorias =  {"Salário de funcionários","Contas de água e de luz","Empréstimos"};
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        choiceBoxCategoriaConta.getItems().addAll(listaCategorias);
    }

    public void cadastrar() {
        String  nome = textFieldNomeConta.getText();
        double  valor = Double.valueOf(textFieldValorConta.getText());
        int     data   = Integer.valueOf(textFieldDataDeVencimento.getText());
        String categoria =choiceBoxCategoriaConta.getValue();
        boolean pago = checkbox.isSelected();
        Financas financas = new Financas(nome, valor, data, categoria, pago);
        if(pago == false){
            ListaNPago.add(financas);
        }

        Lista.add(financas);

        limparFormulario();
       
        atualizarLista();
        }

    public void erro(String mensagem) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText(mensagem);
        alert.show();
    }

    public void ordenarCategoria() {
        Lista.sort((o1,o2) -> o1.getCategoriaConta().compareTo(o1.getCategoriaConta()));
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
        listViewPagar.getItems().clear();
        listViewPagar.getItems().addAll(ListaNPago);
    }

    private void limparFormulario(){
        textFieldNomeConta.setText("");
        textFieldValorConta.setText("");
        textFieldDataDeVencimento.setText("");
        choiceBoxCategoriaConta.setValue(null);
        checkbox.setSelected(false);
    }
    public void pagar(){
        int contaPagar = Integer.valueOf(textFieldPagar.getText());
        ListaNPago.remove(contaPagar -1);
        Financas pago =ListaNPago.get(contaPagar);
        pago.setContaPaga(true);
        Lista.add(pago);
        atualizarLista();
     }
}
