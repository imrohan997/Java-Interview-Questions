public class Main {
    public static void main(String[] args) {
        /**
         * Threading by extending Thread class and Overriding run() method
         */
        MyThread thread1 = new MyThread();
        thread1.start();
        MyThread thread2 = new MyThread();
        thread2.start();

        /**
         * Threading implementation by using Runnable interface.
         */
        Thread thread11 =  new Thread(new MyThreadUsingRunnable());
        thread11.start();
        Thread thread12 = new Thread(new MyThreadUsingRunnable());
        thread12.start();

    }
}