public class No {

    public int valor;

    // Ponteiros da árvore binária
    public No noEsquerda;
    public No noDireita;

    // Ponteiros usados na lista dupla
    public No proximo;
    public No anterior;

    // Construtor
    public No(int valor) {
        this.valor = valor;
        this.noEsquerda = null;
        this.noDireita = null;
        this.proximo = null;
        this.anterior = null;
    }
}