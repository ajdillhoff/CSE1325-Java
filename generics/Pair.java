/**
 * @version 1.01 2012-01-26
 * @author Cay Horstmann
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T val) {
        this.first = val;
    }

    public void setSecond(T val) {
        this.second = val;
    }
}
