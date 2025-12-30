import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class PasswordStrengthChecker {
    
    // Regex patterns for different checks
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[!@#$%^&*(),.?\":{}|<>_\\-+=\\[\\]\\\\\\/'`~;]");
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueChecking = true;
        
        while (continueChecking) {
            displayMenu();
            
            System.out.print("\nEnter password to test: ");
            String password = scanner.nextLine();
            
            if (password.isEmpty()) {
                System.out.println("\n⚠ Password cannot be empty! Please try again.\n");
                continue;
            }
            
            PasswordResult result = checkPasswordStrength(password);
            displayResult(result);
            
            System.out.print("\nTest another password? (y/n): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            
            if (!choice.equals("y") && !choice.equals("yes")) {
                continueChecking = false;
                System.out.println("\nThank you for using Password Strength Checker!");
            }
            System.out.println();
        }
        
        scanner.close();
    }
    
    /**
     * Display welcome menu and instructions
     */
    private static void displayMenu() {
        System.out.println("=".repeat(60));
        System.out.println("        PASSWORD STRENGTH CHECKER");
        System.out.println("=".repeat(60));
        System.out.println("Security Recommendations:");
        System.out.println("  • Minimum 8 characters (12+ recommended)");
        System.out.println("  • Mix of uppercase and lowercase letters");
        System.out.println("  • At least one number");
        System.out.println("  • At least one special character (!@#$%^&* etc.)");
        System.out.println("  • Avoid common words and patterns");
        System.out.println("=".repeat(60));
    }
    
    /**
     * Check password strength based on security criteria
     * @param password The password to analyze
     * @return PasswordResult object containing analysis
     */
    public static PasswordResult checkPasswordStrength(String password) {
        PasswordResult result = new PasswordResult();
        result.password = password;
        result.length = password.length();
        
        // Check length
        if (result.length >= 12) {
            result.score += 2;
            result.addStrength("✓ Good length (12+ characters)");
        } else if (result.length >= 8) {
            result.score += 1;
            result.addStrength("✓ Acceptable length (8-11 characters)");
        } else {
            result.addWeakness("✗ Too short (minimum 8 characters required)");
        }
        
        // Check for uppercase letters
        if (UPPERCASE_PATTERN.matcher(password).find()) {
            result.score += 1;
            result.hasUppercase = true;
            result.addStrength("✓ Contains uppercase letters");
        } else {
            result.addWeakness("✗ Missing uppercase letters");
        }
        
        // Check for lowercase letters
        if (LOWERCASE_PATTERN.matcher(password).find()) {
            result.score += 1;
            result.hasLowercase = true;
            result.addStrength("✓ Contains lowercase letters");
        } else {
            result.addWeakness("✗ Missing lowercase letters");
        }
        
        // Check for digits
        if (DIGIT_PATTERN.matcher(password).find()) {
            result.score += 1;
            result.hasDigit = true;
            result.addStrength("✓ Contains numbers");
        } else {
            result.addWeakness("✗ Missing numbers");
        }
        
        // Check for special characters
        if (SPECIAL_CHAR_PATTERN.matcher(password).find()) {
            result.score += 1;
            result.hasSpecialChar = true;
            result.addStrength("✓ Contains special characters");
        } else {
            result.addWeakness("✗ Missing special characters");
        }
        
        // Check for common passwords
        String[] commonPasswords = {"password", "123456", "qwerty", "admin", 
                                   "letmein", "welcome", "monkey", "abc123", 
                                   "password123", "12345678"};
        for (String common : commonPasswords) {
            if (password.toLowerCase().contains(common)) {
                result.score = 0;
                result.addWeakness("✗ Contains common password pattern - HIGHLY INSECURE!");
                break;
            }
        }
        
        // Check for sequential characters
        if (hasSequentialChars(password)) {
            result.score = Math.max(0, result.score - 1);
            result.addWeakness("✗ Contains sequential characters (e.g., abc, 123)");
        }
        
        // Determine strength level
        if (result.score >= 5) {
            result.strength = "STRONG";
            result.strengthColor = "🟢";
        } else if (result.score >= 3) {
            result.strength = "MODERATE";
            result.strengthColor = "🟡";
        } else {
            result.strength = "WEAK";
            result.strengthColor = "🔴";
        }
        
        return result;
    }
    
    /**
     * Check for sequential characters
     */
    private static boolean hasSequentialChars(String password) {
        String lower = password.toLowerCase();
        for (int i = 0; i < lower.length() - 2; i++) {
            char c1 = lower.charAt(i);
            char c2 = lower.charAt(i + 1);
            char c3 = lower.charAt(i + 2);
            
            if (c2 == c1 + 1 && c3 == c2 + 1) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Display the password analysis results
     */
    private static void displayResult(PasswordResult result) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println(result.strengthColor + " Password Strength: " + result.strength);
        System.out.println("Score: " + result.score + "/6");
        System.out.println("Password Length: " + result.length + " characters");
        System.out.println("=".repeat(60));
        
        if (!result.strengths.isEmpty()) {
            System.out.println("\nStrengths:");
            for (String strength : result.strengths) {
                System.out.println("  " + strength);
            }
        }
        
        if (!result.weaknesses.isEmpty()) {
            System.out.println("\nWeaknesses:");
            for (String weakness : result.weaknesses) {
                System.out.println("  " + weakness);
            }
        }
        
        System.out.println("\nRecommendation:");
        if (result.strength.equals("STRONG")) {
            System.out.println("  ✓ This password meets security requirements!");
        } else if (result.strength.equals("MODERATE")) {
            System.out.println("  ⚠ Password is acceptable but could be stronger");
        } else {
            System.out.println("  ✗ This password is too weak - please strengthen it");
        }
    }
}

/**
 * Result class to store password analysis
 */
class PasswordResult {
    String password;
    int length;
    int score = 0;
    String strength;
    String strengthColor = "";
    boolean hasUppercase = false;
    boolean hasLowercase = false;
    boolean hasDigit = false;
    boolean hasSpecialChar = false;
    
    List<String> strengths = new ArrayList<>();
    List<String> weaknesses = new ArrayList<>();
    
    void addStrength(String message) {
        strengths.add(message);
    }
    
    void addWeakness(String message) {
        weaknesses.add(message);
    }
}
