package InterfaceExample;

public class Client implements Callback {
    public Client() {}

    @Override
    public void callback(String msg) {
        System.out.println("Callback Interface: " + msg);
    }
}
