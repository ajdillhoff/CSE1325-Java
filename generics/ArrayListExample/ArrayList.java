package ArrayListExample;

public class ArrayList {
    private final int DEFAULT_SIZE = 10;
    private Object[] elementData;
    private int numItems = 0;

    public ArrayList() {
        elementData = new Object[DEFAULT_SIZE];
    }

    public ArrayList(Object... o) {
        elementData = o;
    }

    public Object get(int i) {
        if (i >= 0 && i < numItems) {
            return elementData[i];
        } else {
            return null;
        }
    }

    public void add(Object o) {
        if (numItems + 1 > elementData.length) {
            // Resize
            Object[] temp = new Object[elementData.length + DEFAULT_SIZE];

            for (int i = 0; i < elementData.length; i++) {
                temp[i] = elementData[i];
            }

            temp[numItems++] = o;

            elementData = temp;
        } else {
            elementData[numItems++] = o;
        }
    }

    public int size() {
        return numItems;
    }

    public int capacity() {
        return elementData.length;
    }
}
