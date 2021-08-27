package home_work.task1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Water {

    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    private final Semaphore hydrogen = new Semaphore(2);
    private final Semaphore oxygen = new Semaphore(1);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();
        releaseHydrogen.run();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        hydrogen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire();
        releaseOxygen.run();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        oxygen.release();
    }

}
