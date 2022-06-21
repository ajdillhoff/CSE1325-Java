import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    private String name;
    private LocalDate dob;

    public User(String name, String dob) {
        this.name = name;
        this.dob = LocalDate.parse(dob);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
