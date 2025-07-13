import java.sql.*;
import java.util.*;

public class StudentLogs {
    static Scanner sc = new Scanner(System.in);
    static final String URL = "jdbc:mysql://localhost:3306/student_log";
    static final String USER = "root";
    static final String PASS = "1234";
    static Connection conn;

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Database Connected Successfully");

            while (true) {
                System.out.println("\n----------------------Student Logs-----------------------");
                System.out.println("1 - Add Student");
                System.out.println("2 - Remove Student");
                System.out.println("3 - Search Student");
                System.out.println("4 - View All Students");
                System.out.println("5 - Update Student");
                System.out.println("6 - Exit");
                System.out.print("Enter your Choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> deleteStudent();
                    case 3 -> searchStudent();
                    case 4 -> viewStudents();
                    case 5 -> updateStudent();
                    case 6 -> {
                        System.out.println("✅ Exiting Student Log System.");
                        System.exit(0);
                    }
                    default -> System.out.println("❌ Invalid choice. Please select between 1 and 6.");
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed or SQL error.");
            e.printStackTrace();
        }
    }

    static void addStudent() throws SQLException {
        sc.nextLine(); // clear buffer
        System.out.print("Enter Student Roll Number: ");
        String rollNumber = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Gender (M/F/O): ");
        char gender = sc.nextLine().charAt(0);

        System.out.print("Enter Student Class: ");
        String studentClass = sc.nextLine();

        System.out.print("Enter Contact Number: ");
        long contact = sc.nextLong();

        String insertQuery = "INSERT INTO students (roll_number, name, gender, class, contact) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
        insertStmt.setString(1, rollNumber);
        insertStmt.setString(2, name);
        insertStmt.setString(3, String.valueOf(gender));
        insertStmt.setString(4, studentClass);
        insertStmt.setLong(5, contact);
        insertStmt.executeUpdate();

        System.out.println("✅ Student added successfully.");
    }

    static void deleteStudent() throws SQLException {
        System.out.print("Enter Student ID to delete: ");
        int idToDelete = sc.nextInt();

        String deleteQuery = "DELETE FROM students WHERE id = ?";
        PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
        deleteStmt.setInt(1, idToDelete);
        int rowsDeleted = deleteStmt.executeUpdate();

        if (rowsDeleted > 0)
            System.out.println("✅ Student deleted.");
        else
            System.out.println("❌ Student not found.");
    }

    static void searchStudent() throws SQLException {
        System.out.print("Enter Student ID to search: ");
        int idToSearch = sc.nextInt();

        String searchQuery = "SELECT * FROM students WHERE id = ?";
        PreparedStatement searchStmt = conn.prepareStatement(searchQuery);
        searchStmt.setInt(1, idToSearch);
        ResultSet rs = searchStmt.executeQuery();

        if (rs.next()) {
            System.out.println("\nStudent Details:");
            System.out.println("ID       : " + rs.getInt("id"));
            System.out.println("Roll No  : " + rs.getString("roll_number")); // ✅ Fixed
            System.out.println("Name     : " + rs.getString("name"));
            System.out.println("Gender   : " + rs.getString("gender"));
            System.out.println("Class    : " + rs.getString("class"));
            System.out.println("Contact  : " + rs.getLong("contact"));
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    static void viewStudents() throws SQLException {
        String viewQuery = "SELECT * FROM students";
        PreparedStatement viewStmt = conn.prepareStatement(viewQuery);
        ResultSet rs = viewStmt.executeQuery();

        System.out.println("\nID\tRoll No\t\tName\t\tGender\tClass\t\tContact");
        System.out.println("-------------------------------------------------------------");
        while (rs.next()) {
            System.out.printf("%d\t%s\t\t%s\t\t%s\t%s\t\t%d\n",
                    rs.getInt("id"),
                    rs.getString("roll_number"),  // ✅ Fixed
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getString("class"),
                    rs.getLong("contact"));
        }
    }

    static void updateStudent() throws SQLException {
        System.out.print("Enter Student ID to update: ");
        int updateId = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter new Roll Number: ");
        String rollNumber = sc.nextLine();

        System.out.print("Enter new Name: ");
        String name = sc.nextLine();

        System.out.print("Enter new Gender (M/F/O): ");
        char gender = sc.nextLine().charAt(0);

        System.out.print("Enter new Class: ");
        String studentClass = sc.nextLine();

        System.out.print("Enter new Contact Number: ");
        long contact = sc.nextLong();

        String updateQuery = "UPDATE students SET roll_number = ?, name = ?, gender = ?, class = ?, contact = ? WHERE id = ?";
        PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
        updateStmt.setString(1, rollNumber);
        updateStmt.setString(2, name);
        updateStmt.setString(3, String.valueOf(gender));
        updateStmt.setString(4, studentClass);
        updateStmt.setLong(5, contact);
        updateStmt.setInt(6, updateId);

        int rowsUpdated = updateStmt.executeUpdate();
        if (rowsUpdated > 0)
            System.out.println("✅ Student updated successfully.");
        else
            System.out.println("❌ Student not found.");
    }
}
