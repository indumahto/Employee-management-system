package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class View_Attendance extends JFrame implements ActionListener {
    JTable employee_attendance_table;
    JButton search_employee_button;
    JTextField employee_id_text_field;
    JPanel search_employee_label_panel, employee_id_label_panel, combined_panel;
    String x[] = {"Employee ID", "Name", "Email", "First Half", "Second Half", "Date"};
    String y[][] = new String[20][6];
    int i = 0, j = 0;
    Font table_font, label_font;
    JLabel search_employee_label, employee_id_label;

    View_Attendance() {
        super("Employee Attendance Records");
        setSize(1480, 400);
        setLocation(0, 10);
        table_font = new Font("MS UI Gothic", Font.BOLD, 17);

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from attendance";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                y[i][j++] = rest.getString("eeid");
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("first_half");
                y[i][j++] = rest.getString("second_half");
                y[i][j++] = rest.getString("day_date");
                i++;
                j = 0;
            }
            employee_attendance_table = new JTable(y, x);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        employee_attendance_table.setBackground(Color.BLACK);
        employee_attendance_table.setForeground(Color.WHITE);
        employee_attendance_table.setFont(table_font);

        JScrollPane table_scrollbar = new JScrollPane(employee_attendance_table);

        label_font = new Font("Lucida fax", Font.BOLD, 25);

        search_employee_label = new JLabel("Search Employee");
        search_employee_label.setHorizontalAlignment(JLabel.CENTER);
        search_employee_label.setFont(label_font);
        search_employee_label.setForeground(Color.YELLOW);

        employee_id_label = new JLabel("Employee ID");
        employee_id_label.setFont(label_font);
        employee_id_label.setForeground(Color.GRAY);

        employee_id_text_field = new JTextField();
        employee_id_text_field.setFont(table_font);

        search_employee_button = new JButton("Search Employee");
        search_employee_button.setFont(table_font);
        search_employee_button.setBackground(Color.BLACK);
        search_employee_button.setForeground(Color.RED);
        search_employee_button.addActionListener(this);

        search_employee_label_panel = new JPanel();
        search_employee_label_panel.setLayout(new GridLayout(1, 1, 10, 10));
        search_employee_label_panel.add(search_employee_label);

        employee_id_label_panel = new JPanel();
        employee_id_label_panel.setLayout(new GridLayout(1, 3, 10, 10));
        employee_id_label_panel.add(employee_id_label);
        employee_id_label_panel.add(employee_id_text_field);
        employee_id_label_panel.add(search_employee_button);

        combined_panel = new JPanel();
        combined_panel.setLayout(new GridLayout(2, 1, 10, 10));
        combined_panel.add(search_employee_label_panel);
        combined_panel.add(employee_id_label_panel);

        search_employee_label_panel.setBackground(Color.BLACK);
        employee_id_label_panel.setBackground(Color.BLACK);
        combined_panel.setBackground(Color.BLACK);

        add(combined_panel, "South");
        add(table_scrollbar);
    }
    public void actionPerformed(ActionEvent e) {
        String eid = employee_id_text_field.getText();
        if (e.getSource() == search_employee_button) {
            new View_Attendance_Single(eid).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new View_Attendance().setVisible(true);
    }
}
