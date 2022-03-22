import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");
        for (int i = 0; i < 4; i++) {
            new MyThread(threadGroup,"Поток " + i).start();

        }
        Thread.sleep(5000);
        threadGroup.interrupt();

    }
}

/*
    Создание потоков и добавление их в коллекцию.
    Работа с коллекциями потоков

    Collection<Thread> threads = new ArrayList<>(4);

        for (int i = 0; i < 4; i++) {
        threads.add(new MyThread("Thread name - " + i));
        }
        for (Thread thread : threads) {
        thread.start();
        }

        Thread.sleep(5000);
        for (Thread thread : threads) {
        thread.interrupt();
        }
        */