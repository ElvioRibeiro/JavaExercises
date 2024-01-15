package model;

public class Arvore {
    private No raiz;
    private int somaNoEsquerda;

    public Arvore() {
        raiz = null;
    }

    // Insert a new node into the tree.
    private void insert(No pai, No novo) {
        if (raiz == null) {
            raiz = novo; // If the tree is empty, the new node becomes the root.
        } else {
            if (novo.getDado() < pai.getDado()) {
                if (pai.getFilhoEsquerda() == null) {
                    pai.setFilhoEsquerda(novo); // If the new node is smaller, insert to the left.
                } else {
                    insert(pai.getFilhoEsquerda(), novo);
                }
            } else {
                if (pai.getFilhoDireita() == null) {
                    pai.setFilhoDireita(novo); // If the new node is greater or equal, insert to the right.
                } else {
                    insert(pai.getFilhoDireita(), novo);
                }
            }
        }
    }

    // Add a new value to the tree.
    public void adicionar(int dado) {
        No novoNo = new No(dado);
        insert(raiz, novoNo);
    }

    public No getRaiz() {
        return raiz;
    }

    // Traverse the tree in-order.
    public void percorrerEmOrdem(No no) {
        if (no != null) {
            percorrerEmOrdem(no.getFilhoEsquerda());
            System.out.println(no.getDado());
            percorrerEmOrdem(no.getFilhoDireita());
        }
    }

    // Question A
    // Count the number of nodes to the left of each node.
    private void contarNoEsquerda(No no) {
        if (no == null)
            return;
        
        No esquerda = no.getFilhoEsquerda();
        if (esquerda != null) {
            somaNoEsquerda++;
            contarNoEsquerda(esquerda);
        }
        contarNoEsquerda(no.getFilhoDireita());
    }

    // Return the count of nodes to the left.
    public int contarNoEsquerda() {
        somaNoEsquerda = 0;
        contarNoEsquerda(raiz);
        return somaNoEsquerda;
    }

    // Question B
    // Traverse the tree in pre-order.
    public void percorrerPreOrdem(No atual, String espacos) {
        System.out.print(espacos);
        if (atual != null) {
            System.out.println(atual.getDado());

            String novosEspacos = espacos + "  ";
            percorrerPreOrdem(atual.getFilhoEsquerda(), novosEspacos);
            percorrerPreOrdem(atual.getFilhoDireita(), novosEspacos);
        } else {
            System.out.println("-");
        }
    }
}
