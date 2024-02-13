package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class View_Employee implements ActionListener {

    JFrame view_employee_frame;
    JTextField employee_id_text_field;
    JLabel view_employee_background_image, employee_id_label;
    JButton search_button, cancel_button;

    View_Employee() {
        view_employee_frame = new JFrame("View Employee");
        view_employee_frame.setBackground(Color.green);
        view_employee_frame.setLayout(null);

        view_employee_background_image = new JLabel();
        view_employee_background_image.setBounds(0, 0, 500, 270);
        view_employee_background_image.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icon/view_emp.jpg"));
        Image img1 = img.getImage().getScaledInstance(700, 370, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img1);
        view_employee_background_image.setIcon(ic1);

        employee_id_label = new JLabel("Employee ID");
        employee_id_label.setVisible(true);
        employee_id_label.setBounds(40, 60, 250, 30);
        employee_id_label.setForeground(Color.white);
        Font F1 = new Font("Airal", Font.BOLD, 30);
        employee_id_label.setFont(F1);
        view_employee_background_image.add(employee_id_label);
        view_employee_frame.add(view_employee_background_image);

        employee_id_text_field = new JTextField();
        employee_id_text_field.setBounds(240, 60, 220, 30);
        view_employee_background_image.add(employee_id_text_field);

        search_button = new JButton("Search");
        search_button.setBounds(140, 150, 100, 30);
        search_button.addActionListener(this);
        view_employee_background_image.add(search_button);

        cancel_button = new JButton("Cancel");
        cancel_button.setBackground(Color.red);
        cancel_button.setForeground(Color.white);
        cancel_button.addActionListener(this);
        cancel_button.setBounds(260, 150, 100, 30);
        view_employee_background_image.add(cancel_button);

        view_employee_frame.setSize(500, 270);
        view_employee_frame.setLocation(450, 250);
        view_employee_frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search_button) {
            view_employee_frame.setVisible(false);
            new View_Employee_Data(employee_id_text_field.getText());
        }
        if (e.getSource() == cancel_button) {
            view_employee_frame.setVisible(false);
            new HomePage();
        }
    }
    public static void main(String[] args) {
        new View_Employee();
    }
}
