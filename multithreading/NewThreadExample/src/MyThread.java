public class MyThread implements Runnable {
    private Thread t;

    public MyThread() {
        t = new Thread(this, "My New Thread");
        System.out.printf("Child thread created: %s\n", t);
    }

    public void startThread() {
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 3; i > 0; i--) {
                System.out.printf("MyThread: %d\n", i);
                Thread.sleep(333);
            }
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted!\n", t);
        }
    }
}
