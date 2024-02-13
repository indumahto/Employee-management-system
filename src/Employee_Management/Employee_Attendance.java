package Employee_Management;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Employee_Attendance extends JFrame implements ActionListener {
    JLabel select_employee_label, name_label, email_label, first_half_label, second_half_label;
    Choice select_employee_id_choice, first_half_attendance_choice, second_half_attendance_choice;
    JButton submit_button, close_button;
    JTextField first_half_text_field, second_half_text_field;
    Font text_font;
    JPanel employee_attendance_panel;

    Employee_Attendance() {
        super("Employee Attendance");
        setSize(450, 300);
        setLocation(300, 200);
        setResizable(false);
        text_font = new Font("senserif", Font.BOLD, 15);

        select_employee_label = new JLabel("Select Employee ID");
        name_label = new JLabel("Name");
        email_label = new JLabel("Email");
        first_half_label = new JLabel("First Half");
        second_half_label = new JLabel("Second Half");

        select_employee_label.setFont(text_font);
        name_label.setFont(text_font);
        email_label.setFont(text_font);
        first_half_label.setFont(text_font);
        second_half_label.setFont(text_font);

        first_half_text_field = new JTextField();
        second_half_text_field = new JTextField();

        first_half_text_field.setFont(text_font);
        second_half_text_field.setFont(text_font);

        first_half_text_field.setEditable(false);
        second_half_text_field.setEditable(false);

        first_half_attendance_choice = new Choice();
        first_half_attendance_choice.add("Present");
        first_half_attendance_choice.add("Absent");

        second_half_attendance_choice = new Choice();
        second_half_attendance_choice.add("Present");
        second_half_attendance_choice.add("Absent");

        first_half_attendance_choice.setFont(text_font);
        second_half_attendance_choice.setFont(text_font);

        submit_button = new JButton("Submit");
        close_button = new JButton("Close");

        submit_button.setBackground(Color.BLACK);
        submit_button.setForeground(Color.WHITE);

        close_button.setBackground(Color.BLACK);
        close_button.setForeground(Color.WHITE);

        submit_button.addActionListener(this);
        close_button.addActionListener(this);

        select_employee_id_choice = new Choice();

        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "select * from employee";
            ResultSet rest = obj.stm.executeQuery(query);
            while (rest.next()) {
                select_employee_id_choice.add(rest.getString("eeid"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        employee_attendance_panel = new JPanel();
        employee_attendance_panel.setLayout(new GridLayout(6, 2, 10, 10));
        employee_attendance_panel.add(select_employee_label);
        employee_attendance_panel.add(select_employee_id_choice);
        employee_attendance_panel.add(name_label);
        employee_attendance_panel.add(first_half_text_field);
        employee_attendance_panel.add(email_label);
        employee_attendance_panel.add(second_half_text_field);
        employee_attendance_panel.add(first_half_label);
        employee_attendance_panel.add(first_half_attendance_choice);
        employee_attendance_panel.add(second_half_label);
        employee_attendance_panel.add(second_half_attendance_choice);
        employee_attendance_panel.add(submit_button);
        employee_attendance_panel.add(close_button);

        add(employee_attendance_panel);

        select_employee_id_choice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    ConnectionClass obj2 = new ConnectionClass();
                    String eid = select_employee_id_choice.getSelectedItem();
                    String query = "select * from employee where eeid='" + eid + "'";

                    System.out.println(query);

                    ResultSet rest1 = obj2.stm.executeQuery(query);
                    while (rest1.next()) {
                        first_half_text_field.setText(rest1.getString("name"));
                        second_half_text_field.setText(rest1.getString("email"));
                    }
                } catch (Exception exx) {
                    exx.printStackTrace();
                }
            }
        });
    }
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == submit_button) {
            String ch_eid = select_employee_id_choice.getSelectedItem();
            String ch_first_half = first_half_attendance_choice.getSelectedItem();
            String ch_second_half = second_half_attendance_choice.getSelectedItem();
            String name = first_half_text_field.getText();
            String email = second_half_text_field.getText();
            String dt = new java.util.Date().toString();

            try {
                ConnectionClass obj1 = new ConnectionClass();
                String query = "insert into attendance values('" + ch_eid + "','" + name + "','" + email + "','" + ch_first_half + "','" + ch_second_half + "','" + dt + "')";
                obj1.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Inserted");
                setVisible(false);
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
        if (ev.getSource() == close_button) {
            JOptionPane.showMessageDialog(null, "Are you sure to close?");
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Employee_Attendance().setVisible(true);
    }
}
