import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

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

/*        ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");
        for (int i = 0; i < 4; i++) {
            new MyThread(threadGroup,"Поток " + (i+1)).start();

        }
        Thread.sleep(5000);
        threadGroup.interrupt();
        System.out.println("Все потоки завершены");
        */

        ExecutorService es = Executors.newFixedThreadPool(4);
        List<MyCallable> tasks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            tasks.add(new MyCallable());
        }

        List<Future<String>> futures = es.invokeAll(tasks);

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        String s = es.invokeAny(tasks);
        System.out.println("Последним завершился поток: " + s);

        es.shutdown();
    }
}

