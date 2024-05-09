package MegaSena;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequenciaMegaSena {
    public static void main(String[] args) {
        int[] numerosSorteados = {1, 15, 16, 25, 32, 36};
        List<Integer> listaNumeros = new ArrayList<>();

        for (int i = 0; i < 51000000; i++) {
            int numero = (int) (Math.random() * 60000000) + 1;
            listaNumeros.add(numero);
        }

        int sequenciaInicialPosicao = -1;
        int sequenciaInicialQuantidade = 0;
        for (int i = 0; i <= listaNumeros.size() - numerosSorteados.length; i++) {
            boolean encontrouSequencia = true;
            for (int j = 0; j < numerosSorteados.length; j++) {
                if (listaNumeros.get(i + j) != numerosSorteados[j]) {
                    encontrouSequencia = false;
                    break;
                }
            }
            if (encontrouSequencia) {
                sequenciaInicialPosicao = i;
                sequenciaInicialQuantidade++;
            }
        }

        Collections.reverse(listaNumeros);
        int sequenciaInversaPosicao = -1;
        int sequenciaInversaQuantidade = 0;
        for (int i = 0; i <= listaNumeros.size() - numerosSorteados.length; i++) {
            boolean encontrouSequencia = true;
            for (int j = 0; j < numerosSorteados.length; j++) {
                if (listaNumeros.get(i + j) != numerosSorteados[j]) {
                    encontrouSequencia = false;
                    break;
                }
            }
            if (encontrouSequencia) {
                sequenciaInversaPosicao = listaNumeros.size() - i - 1;
                sequenciaInversaQuantidade++;
            }
        }

        System.out.println("Sequência sorteada na ordem direta encontrada na posição: " + sequenciaInicialPosicao);
        System.out.println("Quantidade de vezes que a sequência aparece na ordem direta: " + sequenciaInicialQuantidade);
        System.out.println("Sequência sorteada na ordem inversa encontrada na posição: " + sequenciaInversaPosicao);
        System.out.println("Quantidade de vezes que a sequência aparece na ordem inversa: " + sequenciaInversaQuantidade);
    }
}
