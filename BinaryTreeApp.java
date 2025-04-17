import java.util.Scanner;

public class BinaryTreeApp {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=== MENU ÁRVORE BINÁRIA ===");
            System.out.println("1. Inserir elemento");
            System.out.println("2. Remover elemento");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Impressão in-ordem");
            System.out.println("5. Impressão pré-ordem");
            System.out.println("6. Impressão pós-ordem");
            System.out.println("7. Verificar se é estritamente binária");
            System.out.println("8. Verificar se é completa");
            System.out.println("9. Verificar se é cheia");
            System.out.println("10. Altura (nível) da árvore");
            System.out.println("11. Grau de um nó");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.print("Digite o valor: ");
                    tree.insert(sc.nextInt());
                }
                case 2 -> {
                    System.out.print("Digite o valor a remover: ");
                    tree.delete(sc.nextInt());
                }
                case 3 -> {
                    System.out.print("Digite o valor para buscar: ");
                    int val = sc.nextInt();
                    System.out.println(tree.search(val) ? "Encontrado!" : "Não encontrado.");
                }
                case 4 -> {
                    System.out.print("In-ordem: ");
                    tree.inOrder();
                }
                case 5 -> {
                    System.out.print("Pré-ordem: ");
                    tree.preOrder();
                }
                case 6 -> {
                    System.out.print("Pós-ordem: ");
                    tree.postOrder();
                }
                case 7 -> System.out.println(tree.isStrictlyBinary() ? "Sim, é estritamente binária." : "Não é estritamente binária.");
                case 8 -> System.out.println(tree.isComplete() ? "Sim, é completa." : "Não é completa.");
                case 9 -> System.out.println(tree.isFull() ? "Sim, é cheia." : "Não é cheia.");
                case 10 -> System.out.println("Altura (nível): " + tree.getLevel());
                case 11 -> {
                    System.out.print("Digite o valor do nó: ");
                    int grau = tree.getDegree(sc.nextInt());
                    if (grau == -1) System.out.println("Nó não encontrado.");
                    else System.out.println("Grau do nó: " + grau);
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }
}
