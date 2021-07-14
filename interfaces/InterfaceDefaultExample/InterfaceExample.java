package InterfaceDefaultExample;

public class InterfaceExample {
    public static void main(String[] args) {
        Client c = new Client();
        Server s = new Server();

        Object[] objects = {
                c, s
        };

        for (var o : objects) {
            if (o instanceof Callback) {
                Callback cb = (Callback) o;
                cb.callback(cb.getClass().getName() + " implements the interface!");
                cb.otherMethod();
            }
        }
    }
}
