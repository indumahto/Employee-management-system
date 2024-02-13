package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Update_Details_Data extends JFrame implements ActionListener {
    JLabel update_employee_label, name_label, fname_label, age_label, dob_label, address_label, phone_label, email_label, education_label, job_post_label, aadhar_label, eeid_label, update_details_image_icon;
    JButton update_data_button, back_button;
    JPanel upper_panel_heading, right_panel_details_update, left_panel_image;
    JTextField name_text_filed, fname_text_filed, age_text_filed, dob_text_filed, address_text_filed, phone_text_filed, email_text_filed, education_text_filed, job_post_text_filed, aadhar_text_filed;
    Font heading_font, text_fonts;
    Choice employee_id_choice;

    Update_Details_Data() {
        super("Update Employee");
        setLocation(450, 50);
        setSize(950, 750);

        heading_font = new Font("Arial", Font.BOLD, 25);
        text_fonts = new Font("Arial", Font.BOLD, 18);
        employee_id_choice = new Choice();

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select eeid from employee";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                employee_id_choice.add(rest.getString("eeid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        update_employee_label = new JLabel("Update Employee");
        name_label = new JLabel("Name");
        fname_label = new JLabel("Father's Name");
        age_label = new JLabel("Age");
        dob_label = new JLabel("Date of Birth");
        address_label = new JLabel("Address");
        phone_label = new JLabel("Phone");
        email_label = new JLabel("Email");
        education_label = new JLabel("Education");
        job_post_label = new JLabel("Job Post");
        aadhar_label = new JLabel("Aadhar");
        eeid_label = new JLabel("Employee ID");

        name_text_filed = new JTextField();
        fname_text_filed = new JTextField();
        age_text_filed = new JTextField();
        dob_text_filed = new JTextField();
        address_text_filed = new JTextField();
        phone_text_filed = new JTextField();
        email_text_filed = new JTextField();
        education_text_filed = new JTextField();
        job_post_text_filed = new JTextField();
        aadhar_text_filed = new JTextField();

        update_data_button = new JButton("Update Data");
        back_button = new JButton("Back");

        update_employee_label.setHorizontalAlignment(JLabel.CENTER);

        update_data_button.addActionListener(this);
        back_button.addActionListener(this);

        update_employee_label.setFont(heading_font);
        name_label.setFont(text_fonts);
        fname_label.setFont(text_fonts);
        age_label.setFont(text_fonts);
        dob_label.setFont(text_fonts);
        address_label.setFont(text_fonts);
        phone_label.setFont(text_fonts);
        email_label.setFont(text_fonts);
        education_label.setFont(text_fonts);
        job_post_label.setFont(text_fonts);
        aadhar_label.setFont(text_fonts);
        eeid_label.setFont(text_fonts);
        employee_id_choice.setFont(text_fonts);

        name_text_filed.setFont(text_fonts);
        fname_text_filed.setFont(text_fonts);
        age_text_filed.setFont(text_fonts);
        dob_text_filed.setFont(text_fonts);
        address_text_filed.setFont(text_fonts);
        phone_text_filed.setFont(text_fonts);
        email_text_filed.setFont(text_fonts);
        education_text_filed.setFont(text_fonts);
        job_post_text_filed.setFont(text_fonts);
        aadhar_text_filed.setFont(text_fonts);

        update_data_button.setFont(text_fonts);
        back_button.setFont(text_fonts);

        update_data_button.setBackground(Color.black);
        back_button.setBackground(Color.red);

        update_data_button.setForeground(Color.white);
        back_button.setForeground(Color.white);

        upper_panel_heading = new JPanel();
        upper_panel_heading.setLayout(new GridLayout(1, 1, 10, 10));
        upper_panel_heading.add(update_employee_label);

        right_panel_details_update = new JPanel();
        right_panel_details_update.setLayout(new GridLayout(12, 2, 10, 10));

        right_panel_details_update.add(eeid_label);
        right_panel_details_update.add(employee_id_choice);
        right_panel_details_update.add(name_label);
        right_panel_details_update.add(name_text_filed);
        right_panel_details_update.add(fname_label);
        right_panel_details_update.add(fname_text_filed);
        right_panel_details_update.add(age_label);
        right_panel_details_update.add(age_text_filed);
        right_panel_details_update.add(dob_label);
        right_panel_details_update.add(dob_text_filed);
        right_panel_details_update.add(address_label);
        right_panel_details_update.add(address_text_filed);
        right_panel_details_update.add(phone_label);
        right_panel_details_update.add(phone_text_filed);
        right_panel_details_update.add(email_label);
        right_panel_details_update.add(email_text_filed);
        right_panel_details_update.add(education_label);
        right_panel_details_update.add(education_text_filed);
        right_panel_details_update.add(job_post_label);
        right_panel_details_update.add(job_post_text_filed);
        right_panel_details_update.add(aadhar_label);
        right_panel_details_update.add(aadhar_text_filed);
        right_panel_details_update.add(update_data_button);
        right_panel_details_update.add(back_button);

        left_panel_image = new JPanel();
        left_panel_image.setLayout(new GridLayout(1, 1, 10, 10));

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icon/empl_img.png"));
        Image img1 = img.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img1);
        update_details_image_icon = new JLabel(ic1);

        left_panel_image.add(update_details_image_icon);

        setLayout(new BorderLayout(10, 10));
        add(upper_panel_heading, "North");
        add(right_panel_details_update, "Center");
        add(left_panel_image, "West");

        employee_id_choice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    ConnectionClass obj2 = new ConnectionClass();
                    String eid = employee_id_choice.getSelectedItem();
                    String query = "select * from employee where eeid='" + eid + "'";
                    ResultSet rest1 = obj2.stm.executeQuery(query);
                    while (rest1.next()) {
                        name_text_filed.setText(rest1.getString("name"));
                        fname_text_filed.setText(rest1.getString("fname"));
                        age_text_filed.setText(rest1.getString("age"));
                        dob_text_filed.setText(rest1.getString("dob"));
                        address_text_filed.setText(rest1.getString("address"));
                        phone_text_filed.setText(rest1.getString("phone"));
                        email_text_filed.setText(rest1.getString("email"));
                        education_text_filed.setText(rest1.getString("education"));
                        job_post_text_filed.setText(rest1.getString("job_post"));
                        aadhar_text_filed.setText(rest1.getString("aadhar"));
                    }
                } catch (Exception exx) {
                    exx.printStackTrace();
                }
            }
        });
    }
    public void actionPerformed(ActionEvent e) {
        String id = employee_id_choice.getSelectedItem();
        String name = name_text_filed.getText();
        String fname = fname_text_filed.getText();
        String age = age_text_filed.getText();
        String dob = dob_text_filed.getText();
        String address = address_text_filed.getText();
        String phone = phone_text_filed.getText();
        String email = email_text_filed.getText();
        String education = education_text_filed.getText();
        String job_post = job_post_text_filed.getText();
        String aadhar = aadhar_text_filed.getText();

        if (e.getSource() == update_data_button) {
            try {
                ConnectionClass obj3 = new ConnectionClass();
                String query = "update employee set name='" + name + "',fname='" + fname + "',age='" + age + "',dob='" + dob + "',address='" + address + "',phone='" + phone + "',email='" + email + "',education='" + education + "',job_post='" + job_post + "',aadhar='" + aadhar + "' where eeid='" + id + "'";
                int aa = obj3.stm.executeUpdate(query);
                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "your data successfully updated");
                    this.setVisible(false);
                    new Update_Details_Data();
                } else {
                    JOptionPane.showMessageDialog(null, "Please!, Fill all details carefully");
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if (e.getSource() == back_button) {
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Update_Details_Data().setVisible(true);
    }
}
