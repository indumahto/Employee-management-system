package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Salary extends JFrame implements ActionListener {

    JLabel select_employee_id_label, name_label, email_label, hra_label, da_label, mid_label, pf_label, basic_salary_label, select_month_label, select_year_label, employee_salary_label, image_label;
    JTextField name_text_field, email_text_field, hra_text_field, da_text_field, mid_text_field, pf_text_field, basic_salary_text_field;
    Choice employee_id_choice, month_choice, year_choice;
    JButton submit_button, close_button;
    Font text_font, heading_font;
    JPanel details_panel, image_panel, heading_panel;

    Salary() {
        super("Salary");
        setLocation(100, 100);
        setSize(950, 750);
        setResizable(false);

        text_font = new Font("Arial", Font.BOLD, 18);
        heading_font = new Font("Arial", Font.BOLD, 25);

        select_employee_id_label = new JLabel("Select Employee ID");
        name_label = new JLabel("Name");
        email_label = new JLabel("Email");
        hra_label = new JLabel("HRA");
        da_label = new JLabel("DA");
        mid_label = new JLabel("MID");
        pf_label = new JLabel("PF");
        basic_salary_label = new JLabel("Basic Salary");
        select_month_label = new JLabel("Select Month");
        select_year_label = new JLabel("Select Year");
        employee_salary_label = new JLabel("Employee Salary");

        employee_salary_label.setHorizontalAlignment(JLabel.CENTER);

        employee_id_choice = new Choice();
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select eeid from employee";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                employee_id_choice.add(rest.getString("eeid"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        month_choice = new Choice();
        month_choice.add("January");
        month_choice.add("February");
        month_choice.add("March");
        month_choice.add("April");
        month_choice.add("May");
        month_choice.add("June");
        month_choice.add("July");
        month_choice.add("August");
        month_choice.add("September");
        month_choice.add("October");
        month_choice.add("November");
        month_choice.add("December");

        year_choice = new Choice();
        year_choice.add("2020");
        year_choice.add("2021");
        year_choice.add("2022");
        year_choice.add("2023");
        year_choice.add("2024");
        year_choice.add("2025");
        year_choice.add("2026");
        year_choice.add("2027");
        year_choice.add("2028");
        year_choice.add("2029");
        year_choice.add("2030");

        select_employee_id_label.setFont(text_font);
        name_label.setFont(text_font);
        email_label.setFont(text_font);
        hra_label.setFont(text_font);
        da_label.setFont(text_font);
        mid_label.setFont(text_font);
        pf_label.setFont(text_font);
        basic_salary_label.setFont(text_font);
        select_month_label.setFont(text_font);
        select_year_label.setFont(text_font);
        employee_salary_label.setFont(heading_font);

        employee_id_choice.setFont(text_font);
        month_choice.setFont(text_font);
        year_choice.setFont(text_font);

        name_text_field = new JTextField();
        email_text_field = new JTextField();
        hra_text_field = new JTextField();
        da_text_field = new JTextField();
        mid_text_field = new JTextField();
        pf_text_field = new JTextField();
        basic_salary_text_field = new JTextField();

        name_text_field.setFont(text_font);
        email_text_field.setFont(text_font);
        hra_text_field.setFont(text_font);
        da_text_field.setFont(text_font);
        mid_text_field.setFont(text_font);
        pf_text_field.setFont(text_font);
        basic_salary_text_field.setFont(text_font);

        name_text_field.setEditable(false);
        email_text_field.setEditable(false);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icon/salary.jpg"));
        Image img1 = img.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        image_label = new JLabel(img2);

        submit_button = new JButton("Submit");
        submit_button.setFont(text_font);
        submit_button.setBackground(Color.BLACK);
        submit_button.setForeground(Color.WHITE);
        submit_button.addActionListener(this);

        close_button = new JButton("Close");
        close_button.setFont(text_font);
        close_button.setBackground(Color.BLACK);
        close_button.setForeground(Color.WHITE);
        close_button.addActionListener(this);

        details_panel = new JPanel();
        details_panel.setLayout(new GridLayout(11, 2, 10, 10));
        details_panel.add(select_employee_id_label);
        details_panel.add(employee_id_choice);
        details_panel.add(name_label);
        details_panel.add(name_text_field);
        details_panel.add(email_label);
        details_panel.add(email_text_field);
        details_panel.add(hra_label);
        details_panel.add(hra_text_field);
        details_panel.add(da_label);
        details_panel.add(da_text_field);
        details_panel.add(mid_label);
        details_panel.add(mid_text_field);
        details_panel.add(pf_label);
        details_panel.add(pf_text_field);
        details_panel.add(basic_salary_label);
        details_panel.add(basic_salary_text_field);
        details_panel.add(select_month_label);
        details_panel.add(month_choice);
        details_panel.add(select_year_label);
        details_panel.add(year_choice);
        details_panel.add(submit_button);
        details_panel.add(close_button);

        image_panel = new JPanel();
        image_panel.setLayout(new GridLayout(1, 1, 10, 10));
        image_panel.add(image_label);

        heading_panel = new JPanel();
        heading_panel.setLayout(new GridLayout(1, 1, 10, 10));
        heading_panel.add(employee_salary_label);

        setLayout(new BorderLayout(30, 30));

        add(details_panel, "Center");
        add(image_panel, "West");
        add(heading_panel, "North");

        employee_id_choice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    ConnectionClass obj2 = new ConnectionClass();
                    String eid2 = employee_id_choice.getSelectedItem();
                    String q3 = "select * from employee where eeid='" + eid2 + "'";
                    ResultSet rest1 = obj2.stm.executeQuery(q3);
                    while (rest1.next()) {
                        name_text_field.setText(rest1.getString("name"));
                        email_text_field.setText(rest1.getString("email"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit_button) {
            String eeid = employee_id_choice.getSelectedItem();
            String name = name_text_field.getText();
            String email = email_text_field.getText();
            float hra = Float.parseFloat(hra_text_field.getText());
            float da = Float.parseFloat(da_text_field.getText());
            float mid = Float.parseFloat(mid_text_field.getText());
            float pf = Float.parseFloat(pf_text_field.getText());
            float basic = Float.parseFloat(basic_salary_text_field.getText());
            String month = month_choice.getSelectedItem() + " " + year_choice.getSelectedItem();

            try {
                ConnectionClass obj1 = new ConnectionClass();
                String q1 = "insert into salary values('" + 0 + "','" + eeid + "','" + name + "','" + email + "','" + hra + "','" + da + "','" + mid + "','" + pf + "','" + basic + "','" + month + "')";
                int aa = obj1.stm.executeUpdate(q1);
                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Your data has inserted Successfully");
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill the details carefully.");
                    this.setVisible(false);
                    this.setVisible(true);
                }
            } catch (Exception exx) {
                exx.printStackTrace();
            }
        }
        if (e.getSource() == close_button) {
            JOptionPane.showMessageDialog(null, "Are you sure?");
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Salary().setVisible(true);
    }
}
