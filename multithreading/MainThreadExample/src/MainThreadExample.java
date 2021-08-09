public class MainThreadExample {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.printf("This thread: %s\n", t);

        t.setName("Main Thread");
        System.out.printf("This thread (updated): %s\n", t);

        try {
            for (int i = 3; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Liftoff!");
    }
}
