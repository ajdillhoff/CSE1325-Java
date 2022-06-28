interface Interface1 {
    default void action() {
        System.out.println("action() called in Interface1.");
    }
}
interface Interface2 {
    default void action() {
        System.out.println("action() called in Interface2.");
    }
}

/*
 * With no action defined, this program does not compile without errors.
 */
public class MultipleInheritanceExample implements Interface1, Interface2 {
    /*
     * This `action()` takes precedence over the implemented versions.
     */
    public void action() {
        System.out.println("Defines their own action as well.");

        Interface1.super.action(); // Call action for Interface1

        Interface2.super.action(); // Call action for Interface2
    }

    public static void main(String[] args) {
        MultipleInheritanceExample e = new MultipleInheritanceExample();
        e.action(); // Call this class's action
    }
}
