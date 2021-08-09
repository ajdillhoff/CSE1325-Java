class Queue {
    private int data;

    synchronized int getData() {
        System.out.printf("Retrieving %d\n", data);
        return data;
    }

    synchronized void setData(int data) {
        this.data = data;
        System.out.printf("Updating %d\n", data);
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

public class DataLoaderExample {
    public static void main(String[] args) {
        Queue queue = new Queue();
        DataLoader dataLoader = new DataLoader(queue);
        Client client = new Client(queue);

        dataLoader.thread.start();
        client.thread.start();
    }
}
