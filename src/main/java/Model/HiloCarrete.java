package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Esta clase se encargo del hilo para visulizar las imagenes
 */
public class HiloCarrete extends Thread {

    private ArrayList<File> imagenes;
    private Consumer<File> metodoImagenes;
    private Consumer<String> aviso;
    private Consumer<Integer> progress;
    private final Object lock = new Object();
    private boolean paused = false;
    private boolean running = true;
    private int inicio;

    /**
     * Contructor del hilo
     * 
     * @param x              //Todas las imagenes
     * @param metodoImagenes //Metodo que actuliza en la vista a traves de la
     *                       interfaz Consumer sin exponer la vista al modelo o
     *                       vicerversa
     * @param aviso          //Metodo para mostrar algun aviso ...
     * @param incio          //De donde comienza a mostrar imagenes
     * @param progress       //Metodo para actualizar la barra de progreso ...
     */
    public HiloCarrete(ArrayList<File> x, Consumer<File> metodoImagenes, Consumer<String> aviso, int incio,
            Consumer<Integer> progress) {
        this.imagenes = new ArrayList<>(x);
        this.metodoImagenes = metodoImagenes;
        this.aviso = aviso;
        this.inicio = incio;
        this.progress = progress;
    }

    /**
     * Run del hilo
     */
    @Override
    public void run() {
        try {
            while (running) {
                for (int i = 0; i < imagenes.size(); i++) {
                    // Sincronizacion para pausa/continuar/detener
                    if (!running)
                        break;
                    synchronized (lock) {
                        while (paused) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    // Index de la imagen a mostrar
                    int idx = (inicio + i) % imagenes.size();
                    // Mostrar imagen
                    metodoImagenes.accept(imagenes.get(idx));
                    // Actualizar progreso
                    progress.accept(idx);
                    // Mensaje
                    aviso.accept("Mostrando: " + imagenes.get(idx).getPath());
                    // Descanso
                    Thread.sleep(500); // Controla la velocidad de visualización
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Pausa
    public void pause() {
        synchronized (lock) {
            paused = true;
        }
    }

    // Continuar
    public void res() {
        synchronized (lock) {
            paused = false;
            lock.notify();
        }
    }

    // Matar hilos
    public void kill() {
        synchronized (lock) {
            running = false;
            paused = false;
            lock.notifyAll();
        }
    }
}
