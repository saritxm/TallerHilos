package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.function.Consumer;

public class HiloCarrete extends Thread {

    private ArrayList<File> imagenes;
    private Consumer<File> metodoImagenes;
    private boolean running = true;

    public HiloCarrete(ArrayList<File> x, Consumer<File> metodoImagenes) {
        this.imagenes = new ArrayList<>(x);   
        this.metodoImagenes = metodoImagenes;
        run();
    }

    @Override
    public void run() {
        try {
            while (running) {
                for (File file : imagenes) {
                    metodoImagenes.accept(file);
                    System.out.println(file.getPath());
                    sleep(500);
                }  
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    public void pause(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resm(){
        notify();
    }

    public void kill(){
        running = false;
    }
}