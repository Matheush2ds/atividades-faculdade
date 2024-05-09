//360
import java.util.Scanner;

public class Horoscopo {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int dia;
        int mes;

        do {
            System.out.print("Digite a data de nascimento (ddmm) ou 9999 para sair: ");
            String data = scan.next();

            if (data.equals("9999")) {
                break;
            }

            dia = Integer.parseInt(data.substring(0, 2));
            mes = Integer.parseInt(data.substring(2));

            String signo = "";

            switch (mes) {
                case 1 -> {
                    if (dia <= 20) {
                        signo = "Capricórnio";
                    } else {
                        signo = "Aquário";
                    }
                }
                case 2 -> {
                    if (dia <= 19) {
                        signo = "Aquário";
                    } else {
                        signo = "Peixes";
                    }
                }
                case 3 -> {
                    if (dia <= 20) {
                        signo = "Peixes";
                    } else {
                        signo = "Áries";
                    }
                }
                case 4 -> {
                    if (dia <= 20) {
                        signo = "Áries";
                    } else {
                        signo = "Touro";
                    }
                }
                case 5 -> {
                    if (dia <= 20) {
                        signo = "Touro";
                    } else {
                        signo = "Gêmeos";
                    }
                }
                case 6 -> {
                    if (dia <= 20) {
                        signo = "Gêmeos";
                    } else {
                        signo = "Câncer";
                    }
                }
                case 7 -> {
                    if (dia <= 21) {
                        signo = "Câncer";
                    } else {
                        signo = "Leão";
                    }
                }
                case 8 -> {
                    if (dia <= 22) {
                        signo = "Leão";
                    } else {
                        signo = "Virgem";
                    }
                }
                case 9 -> {
                    if (dia <= 22) {
                        signo = "Virgem";
                    } else {
                        signo = "Libra";
                    }
                }
                case 10 -> {
                    if (dia <= 22) {
                        signo = "Libra";
                    } else {
                        signo = "Escorpião";
                    }
                }
                case 11 -> {
                    if (dia <= 21) {
                        signo = "Escorpião";
                    } else {
                        signo = "Sagitário";
                    }
                }
                case 12 -> {
                    if (dia <= 21) {
                        signo = "Sagitário";
                    } else {
                        signo = "Capricórnio";
                    }
                }
                default -> System.out.println("Data inválida!");
            }

            System.out.println("Seu signo é " + signo);

        } while (true);

        System.out.println("Programa encerrado.");

    }
}