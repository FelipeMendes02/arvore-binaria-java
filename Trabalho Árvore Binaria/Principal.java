import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Arvore minhaArvore = new Arvore();

        int opcao;
        int valor;

        System.out.println("=================================================");
        System.out.println("             ÁRVORE BINÁRIA EM JAVA");
        System.out.println("=================================================");
        System.out.println("Trabalho - Estrutura de Dados");
        System.out.println("Sistema utilizando Orientação a Objetos");
        System.out.println("e alocação dinâmica de memória.");
        System.out.println("=================================================");

        do {

            System.out.println("\n");
            System.out.println("=============== MENU PRINCIPAL =================");
            System.out.println("1  - Inserir elemento");
            System.out.println("2  - Buscar elemento");
            System.out.println("3  - Imprimir árvore em ordem crescente");
            System.out.println("4  - Imprimir árvore em ordem decrescente");
            System.out.println("5  - Contar quantidade de elementos");
            System.out.println("6  - Somar elementos da árvore");
            System.out.println("7  - Procurar maior elemento");
            System.out.println("8  - Procurar menor elemento");
            System.out.println("9  - Imprimir folhas");
            System.out.println("10 - Imprimir nós que não são folhas");
            System.out.println("11 - Remover elemento");
            System.out.println("12 - Calcular altura da árvore");
            System.out.println("13 - Mostrar profundidade de cada nó");
            System.out.println("0  - Encerrar programa");
            System.out.println("=================================================");

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:

                    System.out.println("\n***** INSERÇÃO DE ELEMENTOS *****");
                    System.out.println("Digite valores para inserir.");
                    System.out.println("Digite -999 para parar.");

                    valor = sc.nextInt();

                    while (valor != -999) {

                        minhaArvore.InsereNovoNo(valor);

                        System.out.println("Valor inserido com sucesso!");

                        System.out.print("\nDigite outro valor: ");
                        valor = sc.nextInt();
                    }

                    break;

                case 2:

                    System.out.println("\n***** BUSCA NA ÁRVORE *****");
                    System.out.print("Digite o valor que deseja buscar: ");

                    valor = sc.nextInt();

                    if (minhaArvore.ProcuraValor(valor)) {

                        System.out.println("Valor encontrado na árvore!");

                    } else {

                        System.out.println("Valor NÃO encontrado!");
                    }

                    break;

                case 3:

                    System.out.println("\n***** ÁRVORE EM ORDEM CRESCENTE *****");

                    if (minhaArvore.Raiz == null) {

                        System.out.println("Árvore vazia!");

                    } else {

                        minhaArvore.ImprimeArvore(minhaArvore.Raiz);
                    }

                    System.out.println();

                    break;

                case 4:

                    System.out.println("\n***** ÁRVORE EM ORDEM DECRESCENTE *****");

                    if (minhaArvore.Raiz == null) {

                        System.out.println("Árvore vazia!");

                    } else {

                        minhaArvore.ImprimeArvoreDecrescente(minhaArvore.Raiz);
                    }

                    System.out.println();

                    break;

                case 5:

                    System.out.println("\n***** QUANTIDADE DE ELEMENTOS *****");

                    System.out.println("Quantidade total de elementos: "
                            + minhaArvore.ContarElementos(minhaArvore.Raiz));

                    break;

                case 6:

                    System.out.println("\n***** SOMA DOS ELEMENTOS *****");

                    System.out.println("Soma total dos elementos: "
                            + minhaArvore.SomarElementos(minhaArvore.Raiz));

                    break;

                case 7:

                    System.out.println("\n***** MAIOR ELEMENTO *****");

                    if (minhaArvore.Raiz == null) {

                        System.out.println("Árvore vazia!");

                    } else {

                        System.out.println("Maior elemento da árvore: "
                                + minhaArvore.ProcurarMaiorElemento(minhaArvore.Raiz));
                    }

                    break;

                case 8:

                    System.out.println("\n***** MENOR ELEMENTO *****");

                    if (minhaArvore.Raiz == null) {

                        System.out.println("Árvore vazia!");

                    } else {

                        System.out.println("Menor elemento da árvore: "
                                + minhaArvore.ProcurarMenorElemento(minhaArvore.Raiz));
                    }

                    break;

                case 9:

                    System.out.println("\n***** FOLHAS DA ÁRVORE *****");

                    if (minhaArvore.Raiz == null) {

                        System.out.println("Árvore vazia!");

                    } else {

                        minhaArvore.ImprimirFolhas(minhaArvore.Raiz);
                    }

                    System.out.println();

                    break;

                case 10:

                    System.out.println("\n***** NÓS QUE NÃO SÃO FOLHAS *****");

                    if (minhaArvore.Raiz == null) {

                        System.out.println("Árvore vazia!");

                    } else {

                        minhaArvore.ImprimirNaoFolhas(minhaArvore.Raiz);
                    }

                    System.out.println();

                    break;

                case 11:

                    System.out.println("\n***** REMOÇÃO DE ELEMENTOS *****");

                    if (minhaArvore.Raiz == null) {

                        System.out.println("Árvore vazia!");

                    } else {

                        System.out.print("Digite o valor que deseja remover: ");

                        valor = sc.nextInt();

                        // Verifica se o valor existe antes de remover
                        if (minhaArvore.ProcuraValor(valor)) {

                            minhaArvore.Raiz =
                                    minhaArvore.RemoverNo(minhaArvore.Raiz, valor);

                            System.out.println("Valor removido com sucesso!");

                            System.out.println("\nÁrvore após remoção:");

                            minhaArvore.ImprimeArvore(minhaArvore.Raiz);

                            System.out.println();

                        } else {

                            System.out.println("O valor informado não existe na árvore!");
                        }
                    }

                    break;

                case 12:

                    System.out.println("\n***** ALTURA DA ÁRVORE *****");

                    System.out.println("Altura da árvore: "
                            + minhaArvore.Altura(minhaArvore.Raiz));

                    break;

                case 13:

                    System.out.println("\n***** PROFUNDIDADE DE CADA NÓ *****");

                    if (minhaArvore.Raiz == null) {

                        System.out.println("Árvore vazia!");

                    } else {

                        minhaArvore.ImprimirProfundidadeDeCadaNo(
                                minhaArvore.Raiz, 0);
                    }

                    break;

                case 0:

                    System.out.println("\n=================================================");
                    System.out.println("           PROGRAMA ENCERRADO COM SUCESSO");
                    System.out.println("=================================================");

                    break;

                default:

                    System.out.println("\nOpção inválida!");
                    System.out.println("Escolha uma opção válida do menu.");
            }

        } while (opcao != 0);

        sc.close();
    }
}