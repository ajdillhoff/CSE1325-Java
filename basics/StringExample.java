/**
 * Shows commonly used String methods.
 * @version 1.0 2021-06-03
 * @author Alex Dillhoff
 */
public class StringExample {
    public static void main(String[] args) {
        // An empty string
        String str = "";

        String welcome = "Welcome to CSE1325!";

        // Selecting a single character
        System.out.println(welcome.charAt(11));

        // Return a substring starting at character 11 and ending just before character 18
        String classCode = welcome.substring(11, 18);
        System.out.println(classCode);

        // Concatenate two strings
        String message = "We are taking ";
        System.out.println(message + classCode);

        // Combine a variable number of strings.
        // Note that we are using a static method directly from the String class.
        String csvLine = String.join(",", "1000", "User1", "user@domain.com", "securePassword!");
        System.out.println(csvLine);

        // Using concatenation and substrings to "modify" a string.
        welcome = "We'll all pass " + welcome.substring(11, 18);
        System.out.println(welcome);

        // String equality in Java
        // Incorrect: using "==" to compare two Strings
        // This only checks if the objects are stored at the same location!
        boolean isEqual = (welcome == str);

        // Correct: using one of the class methods
        isEqual = "CSE1325".equals(classCode);
        System.out.println(isEqual);

        // Another useful equality method
        isEqual = classCode.equalsIgnoreCase("cse1325");
        System.out.println(isEqual);

        // Empty strings have a length of 0, so they can be checked using
        boolean isEmpty = (str.length() == 0);
        System.out.println(isEqual);

        // Since a String instance is an object, it can also take on the value null.
        // However, attempting to use a class method on a null object will result in an error.
        // Always check if the object is null FIRST.
        String nullStr = null;
        if (nullStr != null && nullStr.length() == 0) {
            System.out.println("An empty string.");
        }

        // Building strings
        StringBuilder builder = new StringBuilder();
        // Append a single character
        builder.append(welcome.charAt(0));
        // Append a string
        builder.append("ait!");

        // Produce a String object from the StringBuilder object
        String immutableResult = builder.toString();

        System.out.println(immutableResult);
    }
}
