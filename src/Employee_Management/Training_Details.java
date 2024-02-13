package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Training_Details extends JFrame implements ActionListener {

    JLabel update_completed_training_label, select_employee_id_label, name_label, email_label, start_date_label, end_date_label, training_name_label, traininig_image_label;
    JButton submit_button, close_button;
    JPanel heading_panel, details_filling_panel, image_panel;
    JTextField name_text_field, email_text_field, start_date_text_field, end_date_text_field;
    Font heading_font, text_font;
    Choice employee_id_choice, training_name_choice;

    Training_Details() {
        super("Training_Details");
        setLocation(450, 50);
        setSize(950, 450);
        setResizable(false);

        heading_font = new Font("Arial", Font.BOLD, 25);
        text_font = new Font("Arial", Font.BOLD, 16);

        update_completed_training_label = new JLabel("Update Completed Trainings");
        select_employee_id_label = new JLabel("Select Employee ID");
        name_label = new JLabel("Name");
        email_label = new JLabel("Email");
        start_date_label = new JLabel("Start date");
        end_date_label = new JLabel("End Date");
        training_name_label = new JLabel("Training Name");

        name_text_field = new JTextField();
        email_text_field = new JTextField();
        start_date_text_field = new JTextField();
        end_date_text_field = new JTextField();

        submit_button = new JButton("Submit");
        close_button = new JButton("Close");

        submit_button.addActionListener(this);
        close_button.addActionListener(this);

        submit_button.setBackground(Color.BLACK);
        submit_button.setForeground(Color.WHITE);
        close_button.setBackground(Color.RED);
        close_button.setForeground(Color.WHITE);

        employee_id_choice = new Choice();
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "Select eeid from employee";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                employee_id_choice.add(rest.getString("eeid"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        training_name_choice = new Choice();
        training_name_choice.add("Orientation Training");
        training_name_choice.add("Onboarding Training");
        training_name_choice.add("Compliance Training");
        training_name_choice.add("Technical Training");
        training_name_choice.add("Soft-Skils Training");
        training_name_choice.add("Team Management Training");
        training_name_choice.add("Quality Assurance Training");

        update_completed_training_label.setHorizontalAlignment(JLabel.CENTER);
        update_completed_training_label.setFont(heading_font);
        select_employee_id_label.setFont(text_font);
        name_label.setFont(text_font);
        email_label.setFont(text_font);
        start_date_label.setFont(text_font);
        end_date_label.setFont(text_font);
        training_name_label.setFont(text_font);

        employee_id_choice.setFont(text_font);
        training_name_choice.setFont(text_font);

        name_text_field.setFont(text_font);
        email_text_field.setFont(text_font);
        start_date_text_field.setFont(text_font);
        end_date_text_field.setFont(text_font);

        submit_button.setFont(text_font);
        close_button.setFont(text_font);

        name_text_field.setEditable(false);
        email_text_field.setEditable(false);

        heading_panel = new JPanel();
        heading_panel.setLayout(new GridLayout(1, 1, 10, 10));
        heading_panel.add(update_completed_training_label);

        details_filling_panel = new JPanel();
        details_filling_panel.setLayout(new GridLayout(7, 2, 10, 10));

        details_filling_panel.add(select_employee_id_label);
        details_filling_panel.add(employee_id_choice);
        details_filling_panel.add(name_label);
        details_filling_panel.add(name_text_field);
        details_filling_panel.add(email_label);
        details_filling_panel.add(email_text_field);
        details_filling_panel.add(start_date_label);
        details_filling_panel.add(start_date_text_field);
        details_filling_panel.add(end_date_label);
        details_filling_panel.add(end_date_text_field);
        details_filling_panel.add(training_name_label);
        details_filling_panel.add(training_name_choice);
        details_filling_panel.add(submit_button);
        details_filling_panel.add(close_button);

        image_panel = new JPanel();
        image_panel.setLayout(new GridLayout(1, 1, 10, 10));

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icon/training.jpg"));
        Image img1 = img.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img1);
        traininig_image_label = new JLabel(ic1);

        image_panel.add(traininig_image_label);

        setLayout(new BorderLayout(10, 10));
        add(heading_panel, "North");
        add(details_filling_panel, "West");
        add(image_panel, "Center");

        employee_id_choice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    ConnectionClass obj2 = new ConnectionClass();
                    String eid = employee_id_choice.getSelectedItem();
                    String q2 = "select * from employee where eeid='" + eid + "'";
                    ResultSet rest1 = obj2.stm.executeQuery(q2);
                    while (rest1.next()) {
                        name_text_field.setText(rest1.getString("name"));
                        email_text_field.setText(rest1.getString("email"));
                    }
                } catch (Exception exx) {
                    exx.printStackTrace();
                }
            }
        });
    }

    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == submit_button) {
            String eid = employee_id_choice.getSelectedItem();
            String name = name_text_field.getText();
            String email = email_text_field.getText();
            String start_date = start_date_text_field.getText();
            String end_date = end_date_text_field.getText();
            String training_name = training_name_choice.getSelectedItem();

            try {
                ConnectionClass obj1 = new ConnectionClass();
                String q1 = "insert into training_details values('" + eid + "','" + name + "','" + email + "','" + start_date + "','" + end_date + "','" + training_name + "')";
                int aa = obj1.stm.executeUpdate(q1);

                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Your data successfully updated");
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all details carefully");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (ev.getSource() == close_button) {
            JOptionPane.showMessageDialog(null, "Are you sure to close?");
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Training_Details().setVisible(true);
    }
}
