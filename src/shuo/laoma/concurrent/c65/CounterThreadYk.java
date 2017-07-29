package shuo.laoma.concurrent.c65;

public class CounterThreadYk extends Thread {
    private static int counter = 0;
    
    @Override
    public void run() {
        try {
            Thread.sleep((int)(Math.random()*100));
        } catch (InterruptedException e) {
        }
        counter ++;
    }


    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        Thread[] threads = new Thread[num];
        for(int i=0; i<num; i++){
            threads[i] = new CounterThreadYk();
            threads[i].start();
        }
        
        for(int i=0; i<num; i++){
            threads[i].join();
        }
        
        System.out.println(counter);
    }
}
