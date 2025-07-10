import java.util.Scanner;

public class PasswordChecker {

    public static boolean hasUpper(String str) {
        return str.matches(".*[A-Z].*");
    }

    public static boolean hasLower(String str) {
        return str.matches(".*[a-z].*");
    }

    public static boolean hasDigit(String str) {
        return str.matches(".*[0-9].*");
    }

    public static boolean hasSpecial(String str) {
        return str.matches(".*[^a-zA-Z0-9].*");
    }

    public static void printPasswordInstructions() {
        System.out.println("\n🔐 How to Make Your Password Stronger:");
        System.out.println(" - At least 8 characters long");
        System.out.println(" - At least 1 uppercase letter (A–Z)");
        System.out.println(" - At least 1 lowercase letter (a–z)");
        System.out.println(" - At least 1 digit (0–9)");
        System.out.println(" - At least 1 special character (e.g. !, @, #, $, etc.)");
        System.out.println("✅ Example: Strong@123, A1b2C3d4$, MyPass#2024\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        boolean hasUpper = hasUpper(password);
        boolean hasLower = hasLower(password);
        boolean hasDigit = hasDigit(password);
        boolean hasSpecial = hasSpecial(password);
        int length = password.length();
        System.out.println("\nPassword Analysis:");
        System.out.println("Length: " + length);
        System.out.println("Contains Uppercase: " + (hasUpper ? "Yes" : "No"));
        System.out.println("Contains Lowercase: " + (hasLower ? "Yes" : "No"));
        System.out.println("Contains Digit: " + (hasDigit ? "Yes" : "No"));
        System.out.println("Contains Special Character: " + (hasSpecial ? "Yes" : "No"));
        if (length >= 8 && hasUpper && hasLower && hasDigit && hasSpecial) {
            System.out.println("Password Strength: STRONG");
        } else if (length >= 6) {
            System.out.println("Password Strength: MODERATE");
            System.out.println("\nSuggestions to improve:");
            if (!hasUpper) System.out.println(" - Add at least one uppercase letter.");
            if (!hasLower) System.out.println(" - Add at least one lowercase letter.");
            if (!hasDigit) System.out.println(" - Add at least one digit.");
            if (!hasSpecial) System.out.println(" - Add at least one special character.");
            if (length < 8) System.out.println(" - Increase length to at least 8 characters.");
            printPasswordInstructions();
        } else {
            System.out.println("Password Strength: WEAK");
            System.out.println("\nYour password is too short. Minimum 6 characters required.");
            printPasswordInstructions();
        }
        sc.close();
    }
}
