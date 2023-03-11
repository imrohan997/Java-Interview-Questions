/**
 * Threading by implementing Runnable interface.
 */
public class MyThreadUsingRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 20; ++i) {
            System.out.println("Thread " + i);
        }
    }
}
