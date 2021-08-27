package home_work.task2;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    public CustomThreadPoolExecutor(int sThread) {
        super(sThread, sThread, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    @Override
    public void execute(Runnable command) {
        int countAnnotations = command.getClass().getAnnotation(Repeat.class).count();
        while (countAnnotations-- > 0) {
            super.execute(command);
        }
    }

}
