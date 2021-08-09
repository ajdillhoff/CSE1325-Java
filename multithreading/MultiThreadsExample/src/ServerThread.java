public class ServerThread extends Thread {
    private int id;
    private boolean shouldRun = true;

    public ServerThread(int id) {
        this.id = id;
        System.out.printf("Spawning thread %d: %s\n", id, this);
    }

    public int getThreadId() {
        return this.id;
    }

    public void setShouldRun(boolean shouldRun) {
        this.shouldRun = shouldRun;
    }

    @Override
    public void run() {
        try {
            while (shouldRun) {
                System.out.printf("Thread %d: Listening...\n", id);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.printf("Thread %d interrupted!\n", id);
        }
    }
}
