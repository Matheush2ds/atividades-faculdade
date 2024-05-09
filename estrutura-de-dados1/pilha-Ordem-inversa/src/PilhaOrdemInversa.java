import java.util.Stack;

public class PilhaOrdemInversa {

    public static void main(String[] args) {

        String string1 = "UM CIENTISTA DA COMPUTACAO DEVE RESOLVER OS PROBLEMAS LOGICAMENTE";
        String string2 = "ESARF ATERCES ODALERAHCAB ME AICNEIC AD OACATUPMOC FI ONAIOG SUPMAC SOHNIRROM HE MU SOD SEROHLEM SOSRUC ED OACATUPMOC OD ODATSE ED SAIOG";

        System.out.println("String 1: " + inverterPalavras(string1));
        System.out.println("String 2: " + inverterPalavras(string2));
    }

    public static String inverterPalavras(String string) {
        Stack<Character> pilha = new Stack<>();
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (Character.isLetter(c)) {
                pilha.push(c);
            } else {
                while (!pilha.isEmpty()) {
                    resultado.append(pilha.pop());
                }
                resultado.append(c);
            }
        }

        while (!pilha.isEmpty()) {
            resultado.append(pilha.pop());
        }

        // Inverter as letras de cada palavra
        String[] palavras = resultado.toString().split(" ");
        resultado.setLength(0); // Limpar o StringBuilder
        for (int i = 0; i < palavras.length; i++) {
            StringBuilder palavraInvertida = new StringBuilder(palavras[i]);
            resultado.append(palavraInvertida.reverse());
            if (i != palavras.length - 1) {
                resultado.append(" ");
            }
        }

        return resultado.toString();
    }
}
