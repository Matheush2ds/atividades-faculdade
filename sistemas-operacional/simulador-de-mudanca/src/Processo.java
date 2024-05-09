import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Processo {
    private int PID;
    private int TP;
    private int CP;
    private String EP;
    private int NES;
    private int N_CPU;

    public Processo(int PID, int TP) {
        this.PID = PID;
        this.TP = TP;
        this.CP = 0;
        this.EP = "PRONTO";
        this.NES = 0;
        this.N_CPU = 0;
    }

    public int getPID() {
        return PID;
    }

    public int getTP() {
        return TP;
    }

    public void executar() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true))) {
            Random rand = new Random();
            int quantum = 1000;

            while (CP < TP) {
                for (int i = 0; i < quantum; i++) {
                    CP++;
                    N_CPU++;
                    if (rand.nextDouble() < 0.05) {
                        bloquear();
                        break;
                    }
                }
                if (CP < TP) {
                    trocarContexto("PRONTO", writer);
                } else {
                    terminar(writer);
                }
            }
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    private void bloquear() {
        NES++;
        Random rand = new Random();
        if (rand.nextDouble() < 0.3) {
            trocarContexto("PRONTO");
        } else {
            trocarContexto("BLOQUEADO");
        }
    }

    private void trocarContexto(String novoEstado) {
        
    }

    private void trocarContexto(String novoEstado, PrintWriter writer) {
        writer.println("Troca de Contexto: Processo " + PID + " " + EP + " >>> " + novoEstado);
        EP = novoEstado;
    }

    private void terminar(PrintWriter writer) {
        writer.println("Processo " + PID + " terminou.");
    }
}
