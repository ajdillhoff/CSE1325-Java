class Process1 {
    synchronized void work1(Process2 process2) {
        String name = Thread.currentThread().getName();
        System.out.printf("%s started work in work1\n", name);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s is attempting to acquire resource 2.\n", name);
        process2.getResource();
    }

    synchronized void getResource() {
        System.out.printf("Acquired resource 2.\n");
    }
}

class Process2 {
    synchronized void work2(Process1 process1) {
        String name = Thread.currentThread().getName();
        System.out.printf("%s started work in work2\n", name);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s is attempting to acquire resource 1.\n", name);
        process1.getResource();
    }

    synchronized void getResource() {
        System.out.printf("Acquired resource 1.\n");
    }
}

public class DeadlockExample implements Runnable {
    private Process1 process1;
    private Process2 process2;
    private Thread thread;

    public DeadlockExample() {
        process1 = new Process1();
        process2 = new Process2();
        Thread.currentThread().setName("MainThread");
        thread = new Thread(this, "RaceThread");
    }

    void start() {
        thread.start();
        process1.work1(process2);
        System.out.printf("Returned to main thread.\n");
    }

    @Override
    public void run() {
        process2.work2(process1);
        System.out.printf("In race thread.\n");
    }

    public static void main(String[] args) {
        DeadlockExample deadlockExample = new DeadlockExample();
        deadlockExample.start();
    }
}
