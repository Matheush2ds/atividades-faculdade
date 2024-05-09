import java.util.Scanner;

public class MenuFrase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String frase;
        int op, tamanho;

        do {
            System.out.println("\nMENU");
            System.out.println("1 - Imprime o comprimento da frase");
            System.out.println("2 - Imprime os dois primeiros e os dois ultimos caracteres da frase");
            System.out.println("3 - Imprime a frase espelhada");
            System.out.println("4 - Termina o algoritmo");
            System.out.print("OPCAO: ");
            op = scan.nextInt();
            scan.nextLine(); // limpar buffer

            switch (op) {
                case 1:
                    System.out.print("Digite uma frase: ");
                    frase = scan.nextLine();
                    tamanho = frase.length();
                    System.out.println("Numero de caracteres da frase: " + tamanho);
                    break;
                case 2:
                    System.out.print("Digite uma frase: ");
                    frase = scan.nextLine();
                    tamanho = frase.length() - 2;
                    System.out.println("Os dois primeiros caracteres: " + frase.substring(0, 2));
                    System.out.println("Os dois ultimos caracteres: " + frase.substring(tamanho));
                    break;
                case 3:
                    System.out.print("Digite uma frase: ");
                    frase = scan.nextLine();
                    tamanho = frase.length();
                    StringBuilder sb = new StringBuilder(frase);
                    System.out.print("Frase espelhada: ");
                    System.out.println(sb.reverse().toString());
                    break;
                case 4:
                    System.out.println("Fim do algoritmo");
                    break;
                default:
                    System.out.println("Opcao nao disponivel");
            }
        } while (op != 4);
    }
}
