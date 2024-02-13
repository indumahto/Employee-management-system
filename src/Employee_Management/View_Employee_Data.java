package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class View_Employee_Data implements ActionListener {

    JFrame display_employee_details_frame;
    JLabel employee_detail_label, employee_id_label, emp_id_data_label, name_label, name_data_label, fname_label, fname_data_label, address_label, address_data_label, mobile_label, mobile_data_label, email_label, email_data_label, education_label, education_data_label, job_post_label, job_post_data_label, background_image_label;
    String emp_id, name, father, address, phone, email, education, post, age, dob, aadhar;
    JButton print_button, cancel_button;
    ImageIcon Icon;

    View_Employee_Data(String Eid) {
        try {
            ConnectionClass obj = new ConnectionClass();
            String s = "select * from employee where eeid='" + Eid + "'";
            ResultSet rs = obj.stm.executeQuery(s);
            while (rs.next()) {
                name = rs.getString("name");
                father = rs.getString("fname");
                age = rs.getString("age");
                dob = rs.getString("dob");
                address = rs.getString("address");
                phone = rs.getString("phone");
                email = rs.getString("email");
                education = rs.getString("education");
                post = rs.getString("job_post");
                aadhar = rs.getString("aadhar");
                emp_id = rs.getString("eeid");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        display_employee_details_frame = new JFrame("Display Employee Details");
        display_employee_details_frame.setVisible(true);
        display_employee_details_frame.setSize(595, 642);
        display_employee_details_frame.setLocation(450, 200);
        display_employee_details_frame.setBackground(Color.white);
        display_employee_details_frame.setLayout(null);

        background_image_label = new JLabel();
        background_image_label.setBounds(0, 0, 595, 642);
        background_image_label.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icon/blue_background.jpg"));
        background_image_label.setIcon(img);

        employee_detail_label = new JLabel("Employee Detail");
        employee_detail_label.setBounds(170, 10, 250, 40);
        display_employee_details_frame.add(employee_detail_label);
        employee_detail_label.setFont(new Font("Airal", Font.BOLD, 28));
        background_image_label.add(employee_detail_label);
        display_employee_details_frame.add(background_image_label);

        employee_id_label = new JLabel("Employee Id:");
        employee_id_label.setBounds(150, 70, 120, 30);
        employee_id_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(employee_id_label);

        emp_id_data_label = new JLabel(emp_id);
        emp_id_data_label.setBounds(300, 70, 200, 30);
        emp_id_data_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(emp_id_data_label);

        name_label = new JLabel("Name:");
        name_label.setBounds(150, 120, 100, 30);
        name_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(name_label);

        name_data_label = new JLabel(name);
        name_data_label.setBounds(330, 120, 300, 30);
        name_data_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(name_data_label);

        fname_label = new JLabel("Father's Name:");
        fname_label.setBounds(150, 170, 200, 30);
        fname_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(fname_label);

        fname_data_label = new JLabel(father);
        fname_data_label.setBounds(330, 170, 300, 30);
        fname_data_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(fname_data_label);

        address_label = new JLabel("Address:");
        address_label.setBounds(150, 220, 100, 30);
        address_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(address_label);

        address_data_label = new JLabel(address);
        address_data_label.setBounds(330, 220, 300, 30);
        address_data_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(address_data_label);

        mobile_label = new JLabel("Mobile No:");
        mobile_label.setBounds(150, 270, 100, 30);
        mobile_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(mobile_label);

        mobile_data_label = new JLabel(phone);
        mobile_data_label.setBounds(330, 270, 300, 30);
        mobile_data_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(mobile_data_label);

        email_label = new JLabel("Email Id:");
        email_label.setBounds(150, 320, 100, 30);
        email_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(email_label);

        email_data_label = new JLabel(email);
        email_data_label.setBounds(330, 320, 300, 30);
        email_data_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(email_data_label);

        education_label = new JLabel("Education:");
        education_label.setBounds(150, 370, 100, 30);
        education_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(education_label);

        education_data_label = new JLabel(education);
        education_data_label.setBounds(330, 370, 300, 30);
        education_data_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(education_data_label);

        job_post_label = new JLabel("Job Post:");
        job_post_label.setBounds(150, 420, 100, 30);
        job_post_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(job_post_label);

        job_post_data_label = new JLabel(post);
        job_post_data_label.setBounds(330, 420, 300, 30);
        job_post_data_label.setFont(new Font("serif", Font.BOLD, 20));
        background_image_label.add(job_post_data_label);

        print_button = new JButton("Print");
        print_button.setBackground(Color.black);
        print_button.setForeground(Color.white);
        print_button.setBounds(160, 520, 100, 30);
        print_button.addActionListener(this);
        background_image_label.add(print_button);

        cancel_button = new JButton("Cancel");
        cancel_button.setBackground(Color.red);
        cancel_button.setForeground(Color.white);
        cancel_button.setBounds(350, 520, 100, 30);
        cancel_button.addActionListener(this);
        background_image_label.add(cancel_button);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == print_button) {
            JOptionPane.showMessageDialog(null, "Printed successfully");
            display_employee_details_frame.setVisible(false);
            new HomePage();
        }
        if (e.getSource() == cancel_button) {
            display_employee_details_frame.setVisible(false);
            new View_Employee();
        }
    }

    public static void main(String[] args) {
        new View_Employee_Data("Print Data");
    }
}
