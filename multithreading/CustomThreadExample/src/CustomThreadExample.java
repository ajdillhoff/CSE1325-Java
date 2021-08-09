public class CustomThreadExample {
    public static void main(String[] args) {
        CustomThread customThread = new CustomThread();

        customThread.start();

        try {
            for (int i = 3; i > 0; i--) {
                System.out.printf("Main thread: %d\n", i);
                Thread.sleep(333);
            }
        } catch (InterruptedException e) {
            System.out.printf("Main thread interrupted!\n");
        }

        try {
            customThread.join();
        } catch (InterruptedException e) {
            System.out.printf("Main thread interrupted!\n");
        }

        System.out.printf("Main thread exiting...\n");
    }
}
