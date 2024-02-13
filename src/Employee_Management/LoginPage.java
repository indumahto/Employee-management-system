package Employee_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener {

    JFrame login_frame;
    JLabel username_label, password_label;
    JTextField username_text_field;
    JPasswordField password_text_field;
    JButton login_button, close_button;

    LoginPage() {
        login_frame = new JFrame("Login");
        login_frame.setBackground(Color.white);
        login_frame.setLayout(null);

        username_label = new JLabel("UserName");
        username_label.setBounds(40, 20, 100, 30);
        login_frame.add(username_label);

        password_label = new JLabel("Password");
        password_label.setBounds(40, 70, 100, 30);
        login_frame.add(password_label);

        username_text_field = new JTextField();
        username_text_field.setBounds(150, 20, 150, 30);
        login_frame.add(username_text_field);

        password_text_field = new JPasswordField();
        password_text_field.setBounds(150, 70, 150, 30);
        login_frame.add(password_text_field);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icon/lock.png"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 20, 150, 150);
        login_frame.add(l3);

        login_button = new JButton("Login");
        login_button.setBackground(Color.BLACK);
        login_button.setBounds(40, 140, 120, 30);
        login_button.addActionListener(this);
        login_button.setForeground(Color.white);
        login_frame.add(login_button);

        close_button = new JButton("Close");
        close_button.setBackground(Color.BLACK);
        close_button.setBounds(180, 140, 120, 30);
        close_button.addActionListener(this);
        close_button.setForeground(Color.white);
        login_frame.add(close_button);
        
        login_frame.getContentPane();
        login_frame.setVisible(true);
        login_frame.setSize(500, 240);
        login_frame.setLocation(400, 300);
    }

    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == login_button) {
            try {
                ConnectionClass obj = new ConnectionClass();
                String name = username_text_field.getText();
                String pass = password_text_field.getText();
                String q = "select 8 from logindata where username='" + name + "' and password='" + pass + "'";
                ResultSet rs = obj.stm.executeQuery(q);
                if (rs.next()) {
                    new HomePage().setVisible(true);
//                    System.out.println("Login.");
                    login_frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "You have entered wrong Username and Password !");
                    login_frame.setVisible(false);
                    login_frame.setVisible(true);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (ee.getSource() == close_button) {
            this.login_frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
