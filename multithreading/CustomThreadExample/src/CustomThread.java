public class CustomThread extends Thread {
    public CustomThread() {
        super("Custom Thread");
        System.out.printf("Child thread created: %s\n", this);
    }

    public void run() {
        try {
            for (int i = 3; i > 0; i--) {
                System.out.printf("Child thread: %d\n", i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.printf("%s interrupted!\n", this);
        }

        System.out.printf("%s completed.\n", this);
    }
}
