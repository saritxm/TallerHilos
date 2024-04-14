package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.function.Consumer;

public class HiloCarrete extends Thread {

    private ArrayList<File> imagenes;
    private Consumer<File> metodoImagenes;
    private Consumer<String> aviso;
    private Consumer<Integer> progress;
    private final Object lock = new Object();
    private boolean paused = false;
    private boolean running = true;
    private int inicio;

    public HiloCarrete(ArrayList<File> x, Consumer<File> metodoImagenes, Consumer<String> aviso, int incio, Consumer<Integer> progress) {
        this.imagenes = new ArrayList<>(x);
        this.metodoImagenes = metodoImagenes;
        this.aviso = aviso;
        this.inicio = incio;
        this.progress = progress;
    }

    public HiloCarrete(ArrayList<File> aux, Consumer<File> metodoImagenes2, Consumer<String> aviso2, int inicio2,
            Object progress2) {
        //TODO Auto-generated constructor stub
    }

    public HiloCarrete(ArrayList<File> aux, Consumer<File> metodoImagenes2, Consumer<String> aviso2, int inicio2,
            Object progress2) {
        //TODO Auto-generated constructor stub
    }

    public HiloCarrete(ArrayList<File> aux, Consumer<File> metodoImagenes2, Consumer<String> aviso2, int inicio2,
            Object progress2) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        try {
            while (running) {
                for (int i = 0; i < imagenes.size(); i++) {
                    if(!running) break;
                    synchronized (lock) {
                        while (paused) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt(); 
                                return;
                            }
                           }   }
                    int idx = (inicio + i) % imagenes.size();
                    metodoImagenes.accept(imagenes.get(idx));
                    progress.accept(idx);
                    aviso.accept("Mostrando: " + imagenes.get(idx).getPath());
                    Thread.sleep(500); // Controla la velocidad de visualización
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void pause() {
        synchronized (lock) {
            paused = true;
        }
    }

    public void res() {
        synchronized (lock) {
            paused = false;
            lock.notify();
        }
    }

    public void kill() {
        synchronized (lock) {
            running = false;
            paused = false; 
            lock.notifyAll(); }}
}
