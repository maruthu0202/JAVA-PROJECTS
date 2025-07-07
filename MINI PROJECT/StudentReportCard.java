import java.util.Scanner;

public class StudentReportCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Student Name");
        String name = sc.nextLine();

        System.out.println("Enter the Student RollNo");
        int rollno = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter the Student Class");
        String c = sc.nextLine();

        System.out.println("Enter the number of Subjects");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] sub = new String[n];
        int[] m = new int[n];
        int s = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Subject " + (i + 1) + " name:");
            sub[i] = sc.nextLine();

            System.out.println("Enter marks for " + sub[i] + ":");
            m[i] = sc.nextInt();
            sc.nextLine(); 
            s += m[i];
        }

        double avg = (double) s / n;
        char grade;

        if (avg >= 90)
            grade = 'A';
        else if (avg >= 70)
            grade = 'B';
        else if (avg >= 50)
            grade = 'C';
        else
            grade = 'U';

        String rm;
        switch (grade) {
            case 'A':
                rm = "Excellent";
                break;
            case 'B':
                rm = "Very Good";
                break;
            case 'C':
                rm = "Satisfactory";
                break;
            default:
                rm = "Needs Improvement";
        }

        System.out.println("\n--- Report Card ---");
        System.out.println("Name     : " + name);
        System.out.println("RollNo   : " + rollno);
        System.out.println("Class    : " + c);
        System.out.println("Subjects and Marks:");
        for (int i = 0; i < n; i++) {
            System.out.println("  " + sub[i] + ": " + m[i]);
        }
        System.out.println("Total Marks : " + s);
        System.out.println("Average     : " + avg);
        System.out.println("Grade       : " + grade);
        System.out.println("Remarks     : " + rm);

        sc.close();
    }
}
