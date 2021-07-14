package RollInitiativeExample;

import java.util.Comparator;

public class ArrayIndexComparator implements Comparator<Integer> {
    private final Integer[] array;

    public ArrayIndexComparator(Integer[] array) {
        this.array = array;
    }

    public Integer[] createIndexArray() {
        Integer[] indices = new Integer[array.length];

        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        return indices;
    }

    @Override
    public int compare(Integer idx1, Integer idx2) {
        return array[idx2].compareTo(array[idx1]);
    }
}
