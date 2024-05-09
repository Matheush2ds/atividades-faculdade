import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrdenacaoArquivo {

    public static void main(String[] args) {
        String caminhoArquivo = "D:\\Arte Matheus\\cemmilnmr\\dados100_mil.txt";

        try {
            long[] dados = lerDadosArquivo(caminhoArquivo);

            long inicio = System.currentTimeMillis();
            mergeSort(dados);
            long fim = System.currentTimeMillis();

            imprimirDadosOrdenados(dados);

            System.out.println("Tempo de execução: " + (fim - inicio) + " milissegundos");

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private static long[] lerDadosArquivo(String caminho) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        String linha;
        int tamanho = 100000; // Defina o tamanho do array conforme o número de elementos no arquivo
        long[] dados = new long[tamanho];
        int indice = 0;

        while ((linha = br.readLine()) != null && indice < tamanho) {
            dados[indice] = Long.parseLong(linha);
            indice++;
        }

        br.close();
        return dados;
    }

    private static void mergeSort(long[] array) {
        if (array.length > 1) {
            int meio = array.length / 2;
            long[] parteEsquerda = new long[meio];
            long[] parteDireita = new long[array.length - meio];

            System.arraycopy(array, 0, parteEsquerda, 0, meio);
            System.arraycopy(array, meio, parteDireita, 0, array.length - meio);

            mergeSort(parteEsquerda);
            mergeSort(parteDireita);

            merge(array, parteEsquerda, parteDireita);
        }
    }

    private static void merge(long[] array, long[] parteEsquerda, long[] parteDireita) {
        int i = 0, j = 0, k = 0;

        while (i < parteEsquerda.length && j < parteDireita.length) {
            if (parteEsquerda[i] < parteDireita[j]) {
                array[k++] = parteEsquerda[i++];
            } else {
                array[k++] = parteDireita[j++];
            }
        }

        while (i < parteEsquerda.length) {
            array[k++] = parteEsquerda[i++];
        }

        while (j < parteDireita.length) {
            array[k++] = parteDireita[j++];
        }
    }

    private static void imprimirDadosOrdenados(long[] array) {
        for (long valor : array) {
            System.out.println(valor);
        }
    }
}
