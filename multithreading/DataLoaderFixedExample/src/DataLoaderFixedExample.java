class Queue {
    private int data;
    private boolean hasUpdated = false;

    synchronized int getData() {
        while (!hasUpdated) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Retrieving %d\n", data);
        hasUpdated = false;
        notify();
        return data;
    }

    synchronized void setData(int data) {
        while (hasUpdated) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.data = data;
        hasUpdated = true;
        System.out.printf("Updating %d\n", data);
        notify();
    }
}

class DataLoader implements Runnable {
    private Queue queue;
    public Thread thread;

    public DataLoader(Queue queue) {
        this.queue = queue;
        thread = new Thread(this, "DataLoader");
    }

    @Override
    public void run() {
        int i = 0;

        while (true) {
            queue.setData(i++);
        }
    }
}

class Client implements Runnable {
    private Queue queue;
    public Thread thread;

    public Client(Queue queue) {
        this.queue = queue;
        thread = new Thread(this, "Client");
    }

    @Override
    public void run() {
        while (true) {
            queue.getData();
        }
    }
}

public class DataLoaderFixedExample {
    public static void main(String[] args) {
        Queue queue = new Queue();
        DataLoader dataLoader = new DataLoader(queue);
        Client client = new Client(queue);

        dataLoader.thread.start();
        client.thread.start();
    }
}
