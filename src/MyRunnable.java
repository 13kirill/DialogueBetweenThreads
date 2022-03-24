public class MyRunnable implements Runnable{
    @Override
    public void run() {
System.out.println("Runnable поток - " + Thread.currentThread().getName());
    }
}
