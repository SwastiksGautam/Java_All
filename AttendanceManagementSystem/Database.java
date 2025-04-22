import java.sql.*;

public class Database {
    static final String URL = "jdbc:mysql://localhost:3306/attendance_db";
    static final String USER = "root";
    static final String PASS = "";

    static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void addStudent(Student s) {
        try (Connection con = connect()) {
            PreparedStatement pst = con.prepareStatement("INSERT INTO students VALUES (?, ?)");
            pst.setInt(1, s.id);
            pst.setString(2, s.name);
            pst.executeUpdate();
            System.out.println("Student Added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void markAttendance(Attendance a) {
        try (Connection con = connect()) {
            PreparedStatement pst = con.prepareStatement("INSERT INTO attendance (student_id, date, present) VALUES (?, ?, ?)");
            pst.setInt(1, a.studentId);
            pst.setString(2, a.date);
            pst.setBoolean(3, a.present);
            pst.executeUpdate();
            System.out.println("Attendance Marked!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showAttendance() {
        try (Connection con = connect()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM attendance");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("student_id") +
                                   " | Date: " + rs.getDate("date") +
                                   " | Present: " + rs.getBoolean("present"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}