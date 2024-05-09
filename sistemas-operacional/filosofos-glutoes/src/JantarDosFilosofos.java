public class JantarDosFilosofos {
    public static void main(String[] args) {
        Garfo[] garfos = new Garfo[5];
        for (int i = 0; i < 5; i++) {
            garfos[i] = new Garfo();
        }

        Filosofo[] filosofos = new Filosofo[5];
        for (int i = 1; i <= 5; i++) { // Começa de 1
            filosofos[i - 1] = new Filosofo(i, garfos[i - 1], garfos[i % 5]);
            new Thread(filosofos[i - 1]).start();
        }
    }
}