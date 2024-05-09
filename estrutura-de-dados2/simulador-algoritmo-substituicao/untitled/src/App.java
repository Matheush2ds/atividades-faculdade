import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        int[][] swap = new int[100][6];
        int[][] ram = new int[10][6];
        Queue<Integer> fifoQueue = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            swap[i] = new int[]{i, i + 1, random.nextInt(50) + 1, 0, 0, random.nextInt(9900) + 100};
        }

        for (int i = 0; i < 10; i++) {
            int idx = random.nextInt(100);
            ram[i] = Arrays.copyOf(swap[idx], 6);
            fifoQueue.offer(i);
        }

        int clockPointer = 0;
        int[] aging = new int[10];

        for (int instr = 1; instr <= 1000; instr++) {
            int pageRequested = random.nextInt(100) + 1;
            boolean found = false;

            for (int j = 0; j < ram.length; j++) {
                if (ram[j][1] == pageRequested) {
                    ram[j][3] = 1;

                    if (random.nextDouble() < 0.3) {
                        ram[j][2] += 1;
                        ram[j][4] = 1;
                    }

                    found = true;
                    break;
                }
            }

            if (!found) {
                int pageReplaced;
                if (!fifoQueue.isEmpty()) {
                    pageReplaced = fifoQueue.poll();
                } else {
                    pageReplaced = clockReplacement(ram, clockPointer);
                    clockPointer = (clockPointer + 1) % ram.length;
                }

                ram[pageReplaced] = Arrays.copyOf(swap[pageRequested - 1], 6);
                fifoQueue.offer(pageReplaced);
                aging[pageReplaced] = ram[pageReplaced][5];
            }

            if (instr % 10 == 0) {
                for (int j = 0; j < ram.length; j++) {
                    ram[j][3] = 0;
                }
            }

            for (int j = 0; j < ram.length; j++) {
                if (ram[j][4] == 1) {
                    swap[ram[j][0]] = new int[]{ram[j][0], ram[j][1], ram[j][2], 0, 0, swap[ram[j][0]][5]};
                }
            }
        }

        System.out.println("Swap no final:");
        for (int[] row : swap) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nRAM no final após 1000 instruções:");
        for (int[] row : ram) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int clockReplacement(int[][] ram, int pointer) {
        int initialPointer = pointer;
        while (true) {
            if (ram[pointer][3] == 0) {
                return pointer;
            } else {
                ram[pointer][3] = 0;
            }
            pointer = (pointer + 1) % ram.length;
            if (pointer == initialPointer) {
                return pointer;
            }
        }
    }
}
