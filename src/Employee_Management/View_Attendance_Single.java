package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class View_Attendance_Single extends JFrame {
    JTable employee_attendance_table;
    String x[] = {"Employee ID", "Name", "Email", "First Half", "Second Half", "Date"};
    String y[][] = new String[20][6];
    int i = 0, j = 0;
    Font table_font;
    int count = 0;

    View_Attendance_Single(String eid) {
        super("Searched Employee Attendance Record");
        setSize(1480, 400);
        setLocation(0, 10);
        table_font = new Font("MS UI Gothic", Font.BOLD, 17);

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from attendance where eeid='" + eid + "'";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                count++;
                y[i][j++] = rest.getString("eeid");
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("first_half");
                y[i][j++] = rest.getString("second_half");
                y[i][j++] = rest.getString("day_date");
                i++;
                j = 0;
            }
            if (count == 0) {
                JOptionPane.showMessageDialog(null, "No Record Found.");
            } else {
                employee_attendance_table = new JTable(y, x);
                employee_attendance_table.setBackground(Color.BLACK);
                employee_attendance_table.setForeground(Color.WHITE);
                employee_attendance_table.setFont(table_font);
                setSize(1480, 400);
                setLocation(0, 10);
                JScrollPane table_scrollbar = new JScrollPane(employee_attendance_table);
                add(table_scrollbar);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
