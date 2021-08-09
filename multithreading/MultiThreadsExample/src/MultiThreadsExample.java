import java.util.ArrayList;
import java.util.Scanner;

public class MultiThreadsExample {
    private ArrayList<ServerThread> threads;

    public MultiThreadsExample() {
        threads = new ArrayList<>();
    }

    public void showThreads() {
        System.out.printf("= Current threads =\n");
        for (var t : threads) {
            System.out.printf("Thread %d\n", t.getThreadId());
        }
    }

    public void startThread() {
        ServerThread thread = new ServerThread(threads.size());
        thread.start();
        threads.add(thread);
    }

    public void stopThread() {
        int threadId = -1;
        Scanner in = new Scanner(System.in);

        showThreads();

        System.out.printf("Enter thread ID: ");
        threadId = in.nextInt();

        if (threadId > 0 && threadId < threads.size()) {
            ServerThread t = threads.get(threadId);

            if (!t.isAlive()) {
                return;
            }

            t.setShouldRun(false);
            try {
                t.join();
                threads.remove(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopAllThreads() {
        for (var t : threads) {
            t.setShouldRun(false);
        }
    }

    public static void main(String[] args) {
        MultiThreadsExample multiThreadsExample = new MultiThreadsExample();
        Scanner in = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.printf("1. Start Thread\n");
            System.out.printf("2. Stop Thread\n");
            System.out.printf("3. Exit\n");
            System.out.printf("> ");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    multiThreadsExample.startThread();
                    break;
                case 2:
                    multiThreadsExample.stopThread();
                    break;
                case 3:
                    multiThreadsExample.stopAllThreads();
                    break;
                default:
                    System.out.printf("Not a valid selection.\n");
            }
        }
    }
}
