import javax.swing.*;
import java.awt.event.*;

public class GUIApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Attendance Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton addStudent = new JButton("Add Student");
        JButton markAttendance = new JButton("Mark Attendance");
        JButton showAttendance = new JButton("Show Attendance");

        addStudent.setBounds(100, 50, 200, 30);
        markAttendance.setBounds(100, 100, 200, 30);
        showAttendance.setBounds(100, 150, 200, 30);

        frame.add(addStudent);
        frame.add(markAttendance);
        frame.add(showAttendance);

        addStudent.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter Student ID:");
            String name = JOptionPane.showInputDialog("Enter Student Name:");
            Database.addStudent(new Student(Integer.parseInt(id), name));
        });

        markAttendance.addActionListener(e -> {
            String sid = JOptionPane.showInputDialog("Enter Student ID:");
            String date = JOptionPane.showInputDialog("Enter Date (yyyy-mm-dd):");
            String present = JOptionPane.showInputDialog("Present? (true/false):");
            Database.markAttendance(new Attendance(Integer.parseInt(sid), date, Boolean.parseBoolean(present)));
        });

        showAttendance.addActionListener(e -> {
            Database.showAttendance();
        });

        frame.setVisible(true);
    }
}