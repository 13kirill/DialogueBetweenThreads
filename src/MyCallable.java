import java.util.concurrent.Callable;

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        int i = 0;
        for (i = 0; i < 4; i++) {
            try {
                //for (i = 0; i < 3; i++) {
                    System.out.println("Новая задача для потока " + Thread.currentThread().getId());
                    Thread.sleep(2000);
                    System.out.printf("Задача у потока %s завершилась. \n", Thread.currentThread().getId());
               // }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Потоки завершились:" + Thread.currentThread().getName());
            }
        }
        return Thread.currentThread().getName() + i;
    }
}
