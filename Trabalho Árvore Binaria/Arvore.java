public class Arvore {

    public No Raiz;

    public Arvore() {
        Raiz = null;
    }

    public void InsereNovoNo(int valor){

        No novoNo = new No(valor);

        if (Raiz == null){
            Raiz = novoNo;
            System.out.println("Nó inserido na profundidade 0");
        }
        else{

            No buscar = Raiz;
            No pontoInsercao = null;

            int profundidade = 0;

            while(buscar != null){

                pontoInsercao = buscar;

                if(valor < buscar.valor){
                    buscar = buscar.noEsquerda;
                }
                else if(valor > buscar.valor){
                    buscar = buscar.noDireita;
                }
                else{
                    System.out.println("Valor duplicado!");
                    return;
                }

                profundidade++;
            }

            if(valor < pontoInsercao.valor){
                pontoInsercao.noEsquerda = novoNo;
            }
            else{
                pontoInsercao.noDireita = novoNo;
            }

            System.out.println("Nó inserido na profundidade " + profundidade);
        }
    }  

    public boolean ProcuraValor(int valor){

        boolean achou = false;

        if(Raiz == null){
            return false;
        }

        else{
            No buscar  = Raiz;
            while((!achou) && (buscar != null)){
                if(buscar.valor == valor){
                    achou = true;
                }
                else if (valor < buscar.valor){
                    buscar = buscar.noEsquerda;
                }
                else buscar = buscar.noDireita;
            }

            return achou;
        }
    }

    public void ImprimeArvore(No raiz){
        if(raiz != null){
            ImprimeArvore(raiz.noEsquerda);
            System.out.print(raiz.valor + " ");
            ImprimeArvore(raiz.noDireita);
        }
    }

    public void ImprimeArvoreDecrescente(No raiz) {
        if (raiz != null) {
            ImprimeArvoreDecrescente(raiz.noDireita);
            System.out.print(raiz.valor + " ");
            ImprimeArvoreDecrescente(raiz.noEsquerda);
        }
    }

    public int ContarElementos(No raiz) {
        if (raiz == null) {
            return 0;
        }
        return 1 + ContarElementos(raiz.noEsquerda) + ContarElementos(raiz.noDireita);
    }

    public int SomarElementos(No raiz) {
        if (raiz == null) {
            return 0;
        }
        return raiz.valor + SomarElementos(raiz.noEsquerda) + SomarElementos(raiz.noDireita);
    }

    public int ProcurarMaiorElemento(No raiz) {
        if (raiz == null) {
            throw new IllegalArgumentException("A árvore está vazia.");
        }
        while (raiz.noDireita != null) {
            raiz = raiz.noDireita;
        }
        return raiz.valor;
    }

    public int ProcurarMenorElemento(No raiz) {
        if (raiz == null) {
            throw new IllegalArgumentException("A árvore está vazia.");
        }
        while (raiz.noEsquerda != null) {
            raiz = raiz.noEsquerda;
        }
        return raiz.valor;
    }

    public void ImprimirFolhas(No raiz) {
        if (raiz != null) {
            if (raiz.noEsquerda == null && raiz.noDireita == null) {
                System.out.print(raiz.valor + " ");
            }
            ImprimirFolhas(raiz.noEsquerda);
            ImprimirFolhas(raiz.noDireita);
        }
    }

    public void ImprimirNaoFolhas(No raiz) {
        if (raiz != null) {
            if (raiz.noEsquerda != null || raiz.noDireita != null) {
                System.out.print(raiz.valor + " ");
            }
            ImprimirNaoFolhas(raiz.noEsquerda);
            ImprimirNaoFolhas(raiz.noDireita);
        }
    }

    public No RemoverNo(No raiz, int valor) {
        if (raiz == null) {
            return null;
        }
        if (valor < raiz.valor) {
            raiz.noEsquerda = RemoverNo(raiz.noEsquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.noDireita = RemoverNo(raiz.noDireita, valor);
        } else {
            // Caso 1: Nó sem filhos
            if (raiz.noEsquerda == null && raiz.noDireita == null) {
                return null;
            }
            // Caso 2: Nó com apenas um filho
            else if (raiz.noEsquerda == null) {
                return raiz.noDireita;
            } else if (raiz.noDireita == null) {
                return raiz.noEsquerda;
            }
            // Caso 3: Nó com dois filhos
            else {
                raiz.valor = ProcurarMenorElemento(raiz.noDireita);
                raiz.noDireita = RemoverNo(raiz.noDireita, raiz.valor);
            }
        }
        return raiz;
    }

    public int Altura(No raiz) {
        if (raiz == null) {
            return -1;
        }
        int alturaEsquerda = Altura(raiz.noEsquerda);
        int alturaDireita = Altura(raiz.noDireita);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public void ImprimirProfundidadeDeCadaNo(No raiz, int profundidade) {
        if (raiz != null) {
            System.out.println("Valor: " + raiz.valor + ", Profundidade: " + profundidade);
            ImprimirProfundidadeDeCadaNo(raiz.noEsquerda, profundidade + 1);
            ImprimirProfundidadeDeCadaNo(raiz.noDireita, profundidade + 1);
        }
    }
}
