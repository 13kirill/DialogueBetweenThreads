public class MyThread extends Thread {
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(1000);
                System.out.println("Всем привет! " + getName());
            }
        } catch (InterruptedException err) {
            System.out.println(getName() + " пытались завершить, когда он спал");
            return;
        } finally {
            System.out.printf("%s завершен\n", getName());
        }
    }
}