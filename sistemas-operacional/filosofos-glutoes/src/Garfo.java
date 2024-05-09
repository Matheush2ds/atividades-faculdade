import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Garfo {
    private final Lock lock = new ReentrantLock();

    public boolean pegar() {
        return lock.tryLock();
    }

    public void liberar() {
        lock.unlock();
    }
}
