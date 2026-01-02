class Thrd extends Thread{

    public void run(){
        System.out.println("Thread " + Thread.currentThread().getName() + "is running");
    }
}

public class MyThread{

    public static void main(String[] args) {
        
        Thread t = new Thread( new Thrd());
        t.start();
    }
}