package view;

import model.Arvore;

public class App {
    public static void main(String[] args) {

        Arvore arvore = new Arvore();

        arvore.adicionar(10);
        arvore.adicionar(8);
        arvore.adicionar(12);
        arvore.adicionar(20);
        arvore.adicionar(4);
        arvore.adicionar(7);
        arvore.adicionar(3);
        arvore.adicionar(18);

        System.out.println("\n\n RESPOSTA A: O número de nós é "
                + arvore.contarNoEsquerda() + "\n");

        Arvore arvore2 = new Arvore();

        arvore2.adicionar(555);
        arvore2.adicionar(333);
        arvore2.adicionar(111);
        arvore2.adicionar(444);
        arvore2.adicionar(888);
        arvore2.adicionar(999);

        System.out.println("\n\n RESPOSTA B\n");

        arvore2.percorrerPreOrdem(arvore2.getRaiz(), "");

    }
}
