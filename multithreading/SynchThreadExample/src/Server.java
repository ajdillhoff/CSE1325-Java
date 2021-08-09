public class Server {
    // Test the difference in this program by adding the synchronized keyword to this method.
    public void messageClient(String msg) {
        System.out.printf("[%s", msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.printf("Server thread interrupted.\n");
        }
        System.out.println("]");
    }
}
