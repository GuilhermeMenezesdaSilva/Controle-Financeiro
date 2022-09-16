package br.com.fiap.controlefinanceiro;

public class Financas{
    
    private String nomeConta;
    private double valorConta;
    private int dataPagamentoConta;
    private String categoriaConta;
    private boolean contaPaga;
    
    public Financas(String nomeConta, double valorConta, int dataPagamentoConta, String categoriaConta, boolean contaPaga) {
        this.nomeConta = nomeConta;
        this.valorConta = valorConta;
        this.dataPagamentoConta = dataPagamentoConta;
        this.categoriaConta = categoriaConta;
        this.contaPaga = contaPaga;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public double getValorConta() {
        return valorConta;
    }

    public void setValorConta(double valorConta) {
        this.valorConta = valorConta;
    }

    public int getDataPagamentoConta() {
        return dataPagamentoConta;
    }

    public void setDataPagamentoConta(int dataPagamentoConta) {
        this.dataPagamentoConta = dataPagamentoConta;
    }

    public String getCategoriaConta() {
        return categoriaConta;
    }

    public void setCategoriaConta(String categoriaConta) {
        this.categoriaConta = categoriaConta;
    }

    public boolean isContaPaga() {
        return contaPaga;
    }

    public void setContaPaga(boolean contaPaga) {
        this.contaPaga = contaPaga;
    }

    @Override
    public String toString() {
        return "Categoria: " + categoriaConta + ", contaPaga: " + contaPaga + ", dataPagamentoConta: " + dataPagamentoConta + ", nomeConta: " + nomeConta + ", valorConta: " + valorConta ;
    }

}