package ObjectEqualityExample;

public class User {
    private int id = 0;

    public User(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        // If they're identical, they're equal.
        if (this == o) return true;

        // If `o` is null or of a different class, they're certainly not equal
        if (o == null || getClass() != o.getClass()) return false;

        // They're equal if the IDs are the same
        return id == ((User) o).id;
    }
}
