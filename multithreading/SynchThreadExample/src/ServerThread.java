public class ServerThread implements Runnable {
    private String message;
    private Server server;
    public Thread thread;

    public ServerThread(Server server, String message) {
        this.server = server;
        this.message = message;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        server.messageClient(message);
    }
}
