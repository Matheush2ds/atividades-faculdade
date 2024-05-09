import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ArvoresERepeticao {
    public static void main(String[] args) {
        ArvoreAVL ArvoreAVL = new ArvoreAVL();

        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Arte Matheus\\cemmilnmr\\dados100_mil.txt"));
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                try {
                    long data = Long.parseLong(line.trim());
                    ArvoreAVL.insert(data);
                } catch (NumberFormatException e) {
                    System.err.println("Erro na linha " + lineNumber + ": Não foi possível converter para um número longo. Conteúdo da linha: " + line);
                }
                lineNumber++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long avlInsertStartTime = System.currentTimeMillis();

        long avlInsertEndTime = System.currentTimeMillis();
        System.out.println("Tempo de inserção com AVL: " + (avlInsertEndTime - avlInsertStartTime) + " ms");


        System.out.println("\nImpressão em ordem com AVL:");
        long avlPrintStartTime = System.currentTimeMillis();
        ArvoreAVL.printInOrder();
        long avlPrintEndTime = System.currentTimeMillis();
        System.out.println("Tempo de impressão em ordem com AVL: " + (avlPrintEndTime - avlPrintStartTime) + " ms");

        long[] dataArray = new long[100000];
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Arte Matheus\\cemmilnmr\\dados100_mil.txt"));
            String line;
            int index = 0;
            while ((line = br.readLine()) != null && index < 100000) {
                dataArray[index] = Long.parseLong(line.trim());
                index++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}