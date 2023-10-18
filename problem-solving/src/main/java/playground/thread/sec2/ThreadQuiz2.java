package playground.thread.sec2;

public class ThreadQuiz2 {

    public static void main(String[] args) {
        Thread thread = new Thread(new SleepingThread());
        thread.start();
        thread.interrupt();
    }

    private static class SleepingThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("An exception was caught: " + e);
                    return;
                }
            }
        }
    }
}
