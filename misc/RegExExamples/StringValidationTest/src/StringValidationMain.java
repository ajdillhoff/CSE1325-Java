public class StringValidationMain {
    public static void main(String[] args) {
        // [NUMDICE]d[DICETYPE]
        String test = "d20+";

//        String[] tokens = test.split("d");

        if (test.charAt(test.length()) == '+') {
            int constant = 0;
        }

        if (test.matches("\\d*[d]\\d+[+]{0,1}\\d*")) {
            System.out.println("Valid String");
        } else {
            System.out.println("Invalid String.");
        }

//        for (var token : tokens) {
//            System.out.println(token);
//        }
    }
}
