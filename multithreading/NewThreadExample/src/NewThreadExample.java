public class NewThreadExample {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.startThread();

        try {
            for (int i = 3; i > 0; i--) {
                System.out.printf("Main Thread: %d\n", i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.printf("%s interrupted!\n", Thread.currentThread());
        }
    }
}
