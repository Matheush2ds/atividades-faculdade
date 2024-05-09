import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Filosofo implements Runnable {
    private final int id;
    private final Garfo garfoEsquerdo;
    private final Garfo garfoDireito;
    private EstadoFilosofo estado = EstadoFilosofo.PENSANDO;

    public Filosofo(int id, Garfo garfoEsquerdo, Garfo garfoDireito) {
        this.id = id;
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando.");
        Thread.sleep(1000);
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comendo.");
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();

                if (garfoEsquerdo.pegar() && garfoDireito.pegar()) {
                    estado = EstadoFilosofo.COMENDO;
                    System.out.println("Filósofo " + id + " começou a comer.");
                    comer();
                    System.out.println("Filósofo " + id + " terminou de comer.");

                    garfoDireito.liberar();
                    garfoEsquerdo.liberar();
                    estado = EstadoFilosofo.PENSANDO;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public EstadoFilosofo getEstado() {
        return estado;
    }
}