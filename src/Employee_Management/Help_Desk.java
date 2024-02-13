package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Help_Desk extends JFrame implements ActionListener {

    JLabel raise_your_concern_label, select_employee_id_label, name_label, email_label, write_your_concern_label;
    JButton submit_button, close_button;
    JPanel heading_panel, details_filling_panel;
    JTextField name_text_field, email_text_field;
    JTextArea write_your_concern_text_area;
    Font heading_font, text_font;
    Choice employee_id_choice;

    Help_Desk() {
        super("Help Desk");
        setLocation(450, 50);
        setSize(950, 450);
        setResizable(false);

        heading_font = new Font("Arial", Font.BOLD, 25);
        text_font = new Font("Arial", Font.BOLD, 16);

        raise_your_concern_label = new JLabel("Raise Your Concern");
        select_employee_id_label = new JLabel("Select Employee ID");
        name_label = new JLabel("Name");
        email_label = new JLabel("Email");
        write_your_concern_label = new JLabel("Write Your Concern");

        name_text_field = new JTextField();
        email_text_field = new JTextField();
        
        write_your_concern_text_area = new JTextArea();
        JScrollPane concern = new JScrollPane(write_your_concern_text_area);
        JScrollPane concernScrollPane= new JScrollPane(write_your_concern_text_area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        write_your_concern_text_area.setEditable(true);
        write_your_concern_text_area.setSize(800, 400);

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

        raise_your_concern_label.setHorizontalAlignment(JLabel.CENTER);
        raise_your_concern_label.setFont(heading_font);
        select_employee_id_label.setFont(text_font);
        name_label.setFont(text_font);
        email_label.setFont(text_font);
        write_your_concern_label.setFont(text_font);

        employee_id_choice.setFont(text_font);

        name_text_field.setFont(text_font);
        email_text_field.setFont(text_font);
        write_your_concern_text_area.setFont(text_font);

        submit_button.setFont(text_font);
        close_button.setFont(text_font);

        name_text_field.setEditable(false);
        email_text_field.setEditable(false);

        heading_panel = new JPanel();
        heading_panel.setLayout(new GridLayout(1, 1, 10, 10));
        heading_panel.add(raise_your_concern_label);

        details_filling_panel = new JPanel();
        details_filling_panel.setLayout(new GridLayout(5, 2, 10, 10));

        details_filling_panel.add(select_employee_id_label);
        details_filling_panel.add(employee_id_choice);
        details_filling_panel.add(name_label);
        details_filling_panel.add(name_text_field);
        details_filling_panel.add(email_label);
        details_filling_panel.add(email_text_field);
        details_filling_panel.add(write_your_concern_label);
        details_filling_panel.add(write_your_concern_text_area);
        details_filling_panel.add(submit_button);
        details_filling_panel.add(close_button);

        setLayout(new BorderLayout(10,10));
        add(heading_panel, "North");
        add(concern,"Center");
        add(details_filling_panel, "Center");

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
            String eeid = employee_id_choice.getSelectedItem();
            String name = name_text_field.getText();
            String email = email_text_field.getText();
            String write_your_concern = write_your_concern_text_area.getText();

            try {
                ConnectionClass obj1 = new ConnectionClass();
                String q1 = "insert into help_desk values('" + eeid + "','" + name + "','" + email + "','" + write_your_concern + "')";
                int aa = obj1.stm.executeUpdate(q1);

                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Your concern successfully updated");
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
        new Help_Desk().setVisible(true);
    }
}
