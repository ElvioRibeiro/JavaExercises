package model;

public class No {

    int dado;
    No esquerda;
    No direita;

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public No getfilhoEsquerda() {
        return esquerda;
    }

    public void setfilhoEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getfilhoDireita() {
        return direita;
    }

    public void setfilhoDireita(No direita) {
        this.direita = direita;
    }

}
