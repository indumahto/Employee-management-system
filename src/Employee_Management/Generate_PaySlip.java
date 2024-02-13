package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Generate_PaySlip extends JFrame implements ActionListener {

    JButton print_button, close_button;
    JLabel employee_id_label, month_label, year_label;
    JTextArea salary_slip_text_area;
    Choice employee_id_choice, month_choice, year_choice;
    JPanel fill_details_panel;
    Font text_font;

    Generate_PaySlip() {
        super("Generate Pay Slip");
        setSize(500, 500);
        setLocation(100, 100);
        setResizable(false);

        text_font = new Font("Arial", Font.BOLD, 16);

        employee_id_label = new JLabel("Employee ID");
        month_label = new JLabel("Month");
        year_label = new JLabel("Year");

        employee_id_label.setFont(text_font);
        month_label.setFont(text_font);
        year_label.setFont(text_font);

        employee_id_choice = new Choice();

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from employee";
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

        employee_id_choice.setFont(text_font);
        month_choice.setFont(text_font);
        year_choice.setFont(text_font);

        print_button = new JButton("Print");
        print_button.setBackground(Color.BLACK);
        print_button.setForeground(Color.WHITE);
        print_button.addActionListener(this);
        print_button.setFont(text_font);

        close_button = new JButton("Close");
        close_button.setBackground(Color.BLACK);
        close_button.setForeground(Color.WHITE);
        close_button.addActionListener(this);
        close_button.setFont(text_font);

        fill_details_panel = new JPanel();
        fill_details_panel.setLayout(new GridLayout(4, 2, 10, 10));
        fill_details_panel.add(employee_id_label);
        fill_details_panel.add(employee_id_choice);
        fill_details_panel.add(month_label);
        fill_details_panel.add(month_choice);
        fill_details_panel.add(year_label);
        fill_details_panel.add(year_choice);
        fill_details_panel.add(print_button);
        fill_details_panel.add(close_button);

        salary_slip_text_area = new JTextArea();
        JScrollPane sp = new JScrollPane(salary_slip_text_area);
        salary_slip_text_area.setEditable(false);
        salary_slip_text_area.setFont(text_font);

        setLayout(new BorderLayout());
        add(sp, "Center");
        add(fill_details_panel, "South");
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == print_button) {
            salary_slip_text_area.setText("----------------------Pay Slip---------------------");
            try {
                ConnectionClass obj1 = new ConnectionClass();
                String id = employee_id_choice.getSelectedItem();
                String month_year = month_choice.getSelectedItem() + " " + year_choice.getSelectedItem();
                String q1 = "select * from employee where eeid='" + id + "'";
                ResultSet rest1 = obj1.stm.executeQuery(q1);
                while (rest1.next()) {
                    salary_slip_text_area.append("\n\nEmployee Id : " + Integer.parseInt(rest1.getString("eeid")));
                    salary_slip_text_area.append("\nEmployee Name : " + rest1.getString("name"));
                    salary_slip_text_area.append("\nEmployee Email : " + rest1.getString("email"));
                    salary_slip_text_area.append("\n-------------------------------------------------\n\n");
                }
                String q2 = "select * from salary where month_year='" + month_year + "' and eeid='" + id + "'";
                ResultSet rest2 = obj1.stm.executeQuery(q2);
                if (rest2.next() == false) {
                    salary_slip_text_area.append("\n------------------------------------------------------------\n\n");
                    salary_slip_text_area.append("Record not found for this month and year.\n");
                    salary_slip_text_area.append("\n-------------------------------OR-----------------------------\n\n");
                    salary_slip_text_area.append("Please add Salary details of this month and year for the record.\n");
                } else {
                    salary_slip_text_area.append("\n\nHRA : " + Float.parseFloat(rest2.getString("hra")));
                    salary_slip_text_area.append("\nDA : " + Float.parseFloat(rest2.getString("da")));
                    salary_slip_text_area.append("\nMID : " + Float.parseFloat(rest2.getString("mid")));
                    salary_slip_text_area.append("\nPF : " + Float.parseFloat(rest2.getString("pf")));
                    salary_slip_text_area.append("\nBASIC SALARY : " + Float.parseFloat(rest2.getString("basic")));

                    salary_slip_text_area.append("\n-------------------------------------------------\n\n");
                    float gross_salary = Float.parseFloat(rest2.getString("hra")) + Float.parseFloat(rest2.getString("da")) + Float.parseFloat(rest2.getString("mid")) + Float.parseFloat(rest2.getString("pf")) + Float.parseFloat(rest2.getString("basic"));
                    double tax = (gross_salary * 2.1) / 100;
                    salary_slip_text_area.append("\nGross Salary : " + gross_salary);
                    salary_slip_text_area.append("\nTotal : " + gross_salary);
                    salary_slip_text_area.append("\nTax 2.1% of Salary : " + tax);
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
        new Generate_PaySlip().setVisible(true);
    }
}
