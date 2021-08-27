package home_work.task1;

public class Main {
    public static void main(String[] args) {

        Water water = new Water();

        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    water.oxygen(releaseOxygen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                try {
                    water.hydrogen(releaseHydrogen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
