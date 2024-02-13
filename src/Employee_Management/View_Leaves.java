package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class View_Leaves extends JFrame implements ActionListener {

    JTable employee_leaves_table;
    JButton search_button;
    JTextField employee_id_text_field;
    JPanel search_employee_label_panel, employee_id_label_panel, combined_panel;
    String x[] = {"Employee Id", "Name", "Email", "Start Date", "End Date", "Reason", "Apply Date"};
    String y[][] = new String[20][7];
    int i = 0, j = 0;
    Font text_font, heading_font;
    JLabel search_employee_label, employee_id_label;

    View_Leaves() {
        super("All Employees Leave Records");
        setSize(1480, 400);
        setLocation(0, 10);
        text_font = new Font("MS UI Gothic", Font.BOLD, 17);

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from apply_leave";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                y[i][j++] = rest.getString("eid");
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("start_date");
                y[i][j++] = rest.getString("end_date");
                y[i][j++] = rest.getString("reason");
                y[i][j++] = rest.getString("apply_date");
                i++;
                j = 0;
            }
            employee_leaves_table = new JTable(y, x);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        JScrollPane table_scrollbar = new JScrollPane(employee_leaves_table);
        employee_leaves_table.setBackground(Color.BLACK);
        employee_leaves_table.setForeground(Color.WHITE);
        employee_leaves_table.setFont(text_font);

        heading_font = new Font("Lucida Fax", Font.BOLD, 25);

        search_employee_label = new JLabel("Search Employee");
        search_employee_label.setHorizontalAlignment(JLabel.CENTER);
        search_employee_label.setFont(heading_font);
        search_employee_label.setForeground(Color.YELLOW);

        employee_id_label = new JLabel("Employee ID");
        employee_id_label.setFont(heading_font);
        employee_id_label.setForeground(Color.GRAY);

        employee_id_text_field = new JTextField();
        employee_id_text_field.setFont(text_font);

        search_button = new JButton("Search");
        search_button.setFont(text_font);
        search_button.setBackground(Color.BLACK);
        search_button.setForeground(Color.RED);
        search_button.addActionListener(this);

        search_employee_label_panel = new JPanel();
        search_employee_label_panel.setLayout(new GridLayout(1, 1, 10, 10));
        search_employee_label_panel.add(search_employee_label);

        employee_id_label_panel = new JPanel();
        employee_id_label_panel.setLayout(new GridLayout(1, 3, 10, 10));
        employee_id_label_panel.add(employee_id_label);
        employee_id_label_panel.add(employee_id_text_field);
        employee_id_label_panel.add(search_button);

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
        if (e.getSource() == search_button) {
            new View_leave_single(eid).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new View_Leaves().setVisible(true);
    }
}
