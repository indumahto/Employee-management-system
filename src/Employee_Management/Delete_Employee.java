package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Delete_Employee extends JFrame implements ActionListener {

    JTable employee_table;
    JButton delete_Employee_button;
    JTextField employee_id_text_field;
    JPanel heading_panel, delete_employee_panel, combined_panel;
    String x[] = {"Employee ID", "Name", "Email", "Age", "Date of Birth", "Post"};
    String y[][] = new String[20][6];
    int i = 0, j = 0;
    Font text_font, heading_font;
    JLabel delete_employee_label, employee_id_label;

    Delete_Employee() {
        super("All Employee Records for Delete");
        setSize(1480, 400);
        setLocation(0, 10);
        text_font = new Font("MS UI Gothic", Font.BOLD, 17);

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from employee";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                y[i][j++] = rest.getString("eeid");
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("age");
                y[i][j++] = rest.getString("dob");
                y[i][j++] = rest.getString("job_post");
                i++;
                j = 0;
            }
            employee_table = new JTable(y, x);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        employee_table.setBackground(Color.BLACK);
        employee_table.setForeground(Color.WHITE);
        employee_table.setFont(text_font);

        JScrollPane table_scrollbar = new JScrollPane(employee_table);

        heading_font = new Font("Lucida Fax", Font.BOLD, 25);

        delete_employee_label = new JLabel("Delete any Employee");
        delete_employee_label.setHorizontalAlignment(JLabel.CENTER);
        delete_employee_label.setFont(heading_font);
        delete_employee_label.setForeground(Color.YELLOW);

        employee_id_label = new JLabel("Employee ID");
        employee_id_label.setFont(heading_font);
        employee_id_label.setForeground(Color.GRAY);

        employee_id_text_field = new JTextField();
        employee_id_text_field.setFont(text_font);

        delete_Employee_button = new JButton("Delete Employee");
        delete_Employee_button.setFont(text_font);
        delete_Employee_button.setBackground(Color.BLACK);
        delete_Employee_button.setForeground(Color.WHITE);
        delete_Employee_button.addActionListener(this);

        heading_panel = new JPanel();
        heading_panel.setLayout(new GridLayout(1, 1, 10, 10));
        heading_panel.add(delete_employee_label);

        delete_employee_panel = new JPanel();
        delete_employee_panel.setLayout(new GridLayout(1, 3, 10, 10));
        delete_employee_panel.add(employee_id_label);
        delete_employee_panel.add(employee_id_text_field);
        delete_employee_panel.add(delete_Employee_button);

        combined_panel = new JPanel();
        combined_panel.setLayout(new GridLayout(2, 1, 10, 10));
        combined_panel.add(heading_panel);
        combined_panel.add(delete_employee_panel);

        heading_panel.setBackground(Color.BLACK);
        delete_employee_panel.setBackground(Color.BLACK);
        combined_panel.setBackground(Color.BLACK);

        add(combined_panel, "South");
        add(table_scrollbar);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete_Employee_button) {
            String eid = employee_id_text_field.getText();

            try {
                ConnectionClass obj = new ConnectionClass();
                String q = "delete from employee where eeid='" + eid + "'";
                String q1 = "delete from apply_leave where eid='" + eid + "'";
                String q2 = "delete from attendance where eeid='" + eid + "'";
                String q3 = "delete from salary where eeid='" + eid + "'";
                int res = obj.stm.executeUpdate(q);

                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Your Data Successfully Deleted");
                    obj.stm.executeUpdate(q1);
                    obj.stm.executeUpdate(q2);
                    obj.stm.executeUpdate(q3);
                    this.setVisible(false);
                    new Delete_Employee().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, Cann't Delete !");
                    this.setVisible(false);
                    new Delete_Employee().setVisible(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Delete_Employee().setVisible(true);
    }
}
