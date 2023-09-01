package model;

public class Arvore {

    No raiz;
    int somaNoEsquerda;

    public Arvore() {
        raiz = null;
    }

    // Insere um novo nó na árvore.
    private void insert(No no, No filho) {
        if (raiz == null) {
            raiz = no; // Se a árvore estiver vazia, o nó inserido se torna a raiz.
        } else {
            if (no.dado < filho.dado) {
                if (filho.esquerda == null) {
                    filho.esquerda = no; // Se o nó inserido for menor que o nó atual, insere à esquerda.
                } else {
                    insert(no, filho.esquerda);
                }
            }
            if (no.dado >= filho.dado) {
                if (filho.direita == null) {
                    filho.direita = no; // Se o nó inserido for maior ou igual, insere à direita.
                } else {
                    insert(no, filho.direita);
                }
            }
        }
    }

    // Adiciona um novo valor à árvore.
    public void adicionar(int dado) {
        No no = new No();
        no.dado = dado;
        no.esquerda = null;
        no.direita = null;
        insert(no, raiz); // Chama o método de inserção privado.
    }

    public No getRaiz() {
        return raiz;
    }

    // Realiza um percurso em ordem na árvore.
    public void percorrerEmOrdem(No no) {
        if (no != null) {
            percorrerEmOrdem(no.getfilhoEsquerda());
            System.out.println(no.getDado());
            percorrerEmOrdem(no.getfilhoDireita());
        }
    }

    // PERGUNTA A
    // Conta o número de nós à esquerda de cada nó.
    private void contarNoEsquerda(No no) {
        if (no == null)
            return;
        No esquerda = no.getfilhoEsquerda();
        if (esquerda != null) {
            somaNoEsquerda++;
            contarNoEsquerda(esquerda);
        }
        contarNoEsquerda(no.getfilhoDireita());
    }

    // Retorna a contagem de nós à esquerda.
    public int contarNoEsquerda() {
        somaNoEsquerda = 0;
        contarNoEsquerda(raiz);
        return somaNoEsquerda;
    }

    // PERGUNTA B
    // Realiza um percurso pré-ordem na árvore.
    public void percorrerPreOrdem(No atual, String espacos) {
        System.out.print(espacos);
        if (atual != null) {
            System.out.println(atual.getDado());

            String novosEspacos = espacos + "  ";
            percorrerPreOrdem(atual.getfilhoEsquerda(), novosEspacos);
            percorrerPreOrdem(atual.getfilhoDireita(), novosEspacos);
        } else {
            System.out.println("-");
        }
    }
}
