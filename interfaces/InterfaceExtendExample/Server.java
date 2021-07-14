package InterfaceExtendExample;

public class Server implements Report {
    public Server() {}

    @Override
    public void callback(String msg) {
        System.out.println("Callback Interface: " + msg);
    }

    @Override
    public void report(String msg) {
        System.out.println("Report Interface: " + msg);
    }
}
