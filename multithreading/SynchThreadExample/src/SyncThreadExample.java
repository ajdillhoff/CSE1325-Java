public class SyncThreadExample {
    public static void main(String[] args) {
        Server server = new Server();
        ServerThread thread1 = new ServerThread(server, "Communicating via ID1");
        ServerThread thread2 = new ServerThread(server, "Communicating via ID2");
        ServerThread thread3 = new ServerThread(server, "Communicating via ID3");

        thread1.thread.start();
        thread2.thread.start();
        thread3.thread.start();

        // Call `join` to wait for threads to complete.
        try {
            thread1.thread.join();
            thread2.thread.join();
            thread3.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
