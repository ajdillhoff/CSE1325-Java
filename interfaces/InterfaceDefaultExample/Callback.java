package InterfaceDefaultExample;

public interface Callback {
    void callback(String msg);
    default void otherMethod() {
        System.out.println("Callback Interface: A default method.");
    }
}
