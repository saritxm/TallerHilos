package Model;

public class HiloCarrete extends Thread {

    public HiloCarrete() {
        
    }

    @Override
    public void run() {
        
    }

    public void pause(){
        try {
            wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void resm(){
        interrupt();
    }
}