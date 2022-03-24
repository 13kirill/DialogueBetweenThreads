import java.util.concurrent.Callable;

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Новый поток: " + Thread.currentThread().getId());
                Thread.sleep(2000);
                System.out.println(("Поток завершился: " + Thread.currentThread().getId()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Потоки завершились:" + Thread.currentThread().getName());
        }
        return Thread.currentThread().getName();
    }
}
