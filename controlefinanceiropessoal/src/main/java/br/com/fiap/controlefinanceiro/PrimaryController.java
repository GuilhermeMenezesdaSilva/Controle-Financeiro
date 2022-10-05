package br.com.fiap.controlefinanceiro;

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

public class PrimaryController implements Initializable {
    @FXML
    private TextField textFieldNomeConta;
    @FXML
    private TextField textFieldValorConta;
    @FXML
    private TextField textFieldDataDeVencimento;
    @FXML
    private ChoiceBox<String> choiceBoxCategoriaConta;
    @FXML
    private ListView<Financas> listViewFinancas;
    @FXML
    private CheckBox checkbox;
    @FXML
    private TextField textFieldPagar;

    private List<Financas> Lista = new ArrayList<>();
    int id = 0;

    String[] listaCategorias = { "Salário de funcionários", "Contas de água e de luz", "Empréstimos" };

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        choiceBoxCategoriaConta.getItems().addAll(listaCategorias);
    }

    public void cadastrar() {
        try {
            id += 1;
            String nome = textFieldNomeConta.getText();
            double valor = Double.valueOf(textFieldValorConta.getText());
            int data = Integer.valueOf(textFieldDataDeVencimento.getText());
            String categoria = choiceBoxCategoriaConta.getValue();
            boolean pago = checkbox.isSelected();
            Financas financas = new Financas(id, nome, valor, data, categoria, pago);
            System.out.println(id);
            Lista.add(financas);
            limparFormulario();
            atualizarLista();

        } catch (Exception e) {
            erro("Verifique as informações");
        }

    }

    public void erro(String mensagem) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText(mensagem);
        alert.show();
    }

    public void ordenarCategoria() {
        Lista.sort((o1, o2) -> o1.getCategoriaConta().compareTo(o1.getCategoriaConta()));
        atualizarLista();
    }

    public void ordenarData() {
        Lista.sort((o1, o2) -> Double.compare(o1.getDataPagamentoConta(), o2.getDataPagamentoConta()));
        atualizarLista();
    }

    public void ordenarValor() {
        Lista.sort((o1, o2) -> Double.compare(o1.getValorConta(), o2.getValorConta()));
        atualizarLista();
    }

    private void atualizarLista() {
        listViewFinancas.getItems().clear();
        listViewFinancas.getItems().addAll(Lista);
    }

    private void limparFormulario() {
        textFieldNomeConta.setText("");
        textFieldValorConta.setText("");
        textFieldDataDeVencimento.setText("");
        choiceBoxCategoriaConta.setValue(null);
        checkbox.setSelected(false);
    }

    public void mostrarPagar() {
        listViewFinancas.getItems().clear();
        for (int i = 0; i < Lista.size(); i++) {
            if (Lista.get(i).isContaPaga() == false)
                listViewFinancas.getItems().add(Lista.get(i));
        }
    }

    public void pagar() {
        for (int i = 0; i < Lista.size(); i++) {
            if (Lista.get(i).getId() == Integer.valueOf(textFieldPagar.getText())) {
                Lista.get(i).setContaPaga(true);
            }
        }
    }
}
