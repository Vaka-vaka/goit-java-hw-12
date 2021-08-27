package home_work.task2;

public class Main {
    public static void main(String[] args) {

        CustomThreadPoolExecutor customThreadPoolExecutor = new CustomThreadPoolExecutor(3);
        customThreadPoolExecutor.execute(new MyRunnable());
        customThreadPoolExecutor.shutdown();
    }

}
