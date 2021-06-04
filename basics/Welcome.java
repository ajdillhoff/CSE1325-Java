public class Welcome {
    public static void main(String[] args) {
        String msg = "Welcome to CSE 1325.";
        System.out.println(msg);

        for (int i = 0; i < msg.length(); i++) {
            System.out.print("=");
        }

        System.out.println();
    }
}
