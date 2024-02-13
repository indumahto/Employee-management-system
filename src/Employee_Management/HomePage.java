package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener {
    
    JLabel image_icon_label;
    Font font_main_menu_bar;
    
    HomePage() {
        super("Employee Home Page");
        setLocation(0, 0);
        setSize(1550, 800);
        
        font_main_menu_bar = new Font("Lucida Fax", Font.BOLD, 20);
        
        ImageIcon home_page_background_image = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icon/HomePage.jpg"));
        Image img = home_page_background_image.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon image_icon_home = new ImageIcon(img);
        image_icon_label = new JLabel(image_icon_home);
        
        JMenuBar main_menu_bar = new JMenuBar();
        JMenu profile_menu = new JMenu("Profile");
        JMenuItem complete_profile_menu_under_profile = new JMenuItem("Complete Profile");
        JMenuItem view_profile_menu_under_profile = new JMenuItem("View Profile");
        
        JMenu manage_menu = new JMenu("Manage Details");
        JMenuItem update_details_menu_under_manage = new JMenuItem("Update Details");
        
        JMenu attendance_menu = new JMenu("Attendance");
        JMenuItem take_attendance_menu_under_attendance = new JMenuItem("Take Attendance");
        JMenuItem view_attendance_menu_under_attendance = new JMenuItem("View Attendance");
        
        JMenu leaves_menu = new JMenu("Leaves");
        JMenuItem apply_leaves_menu_under_leaves = new JMenuItem("Apply Leaves");
        JMenuItem view_leaves_menu_under_leaves = new JMenuItem("View Leaves");
        
        JMenu salary_menu = new JMenu("Salary");
        JMenuItem add_salary_menu_under_salary = new JMenuItem("Add Salary");
        JMenuItem generate_salary_slip_under_salary = new JMenuItem("Generate Salary Slip");
        
        JMenu training_menu = new JMenu("Training Details");
        JMenuItem update_completed_trainings_under_training_details = new JMenuItem("Update Completed Trainings");
        
        JMenu help_desk_menu = new JMenu("Help Desk");
        JMenuItem raise_your_concern_under_help_desk = new JMenuItem("Raise Your Concern");
        
        JMenu exit_menu = new JMenu("Exit");
        JMenuItem logout_menu_under_exit = new JMenuItem("Logout");
        
        JMenu delete_menu = new JMenu("Delete");
        JMenuItem delete_employee_menu_under_delete = new JMenuItem("Delete Employee");
        
        profile_menu.add(complete_profile_menu_under_profile);
        profile_menu.add(view_profile_menu_under_profile);
        manage_menu.add(update_details_menu_under_manage);
        attendance_menu.add(take_attendance_menu_under_attendance);
        attendance_menu.add(view_attendance_menu_under_attendance);
        leaves_menu.add(apply_leaves_menu_under_leaves);
        leaves_menu.add(view_leaves_menu_under_leaves);
        salary_menu.add(add_salary_menu_under_salary);
        salary_menu.add(generate_salary_slip_under_salary);
        training_menu.add(update_completed_trainings_under_training_details);
        help_desk_menu.add(raise_your_concern_under_help_desk);
        delete_menu.add(delete_employee_menu_under_delete);
        exit_menu.add(logout_menu_under_exit);
        
        main_menu_bar.add(profile_menu);
        main_menu_bar.add(manage_menu);
        main_menu_bar.add(attendance_menu);
        main_menu_bar.add(leaves_menu);
        main_menu_bar.add(salary_menu);
        main_menu_bar.add(training_menu);
        main_menu_bar.add(help_desk_menu);
        main_menu_bar.add(delete_menu);
        main_menu_bar.add(exit_menu);
        
        profile_menu.setFont(font_main_menu_bar);
        manage_menu.setFont(font_main_menu_bar);
        attendance_menu.setFont(font_main_menu_bar);
        leaves_menu.setFont(font_main_menu_bar);
        salary_menu.setFont(font_main_menu_bar);
        training_menu.setFont(font_main_menu_bar);
        help_desk_menu.setFont(font_main_menu_bar);
        delete_menu.setFont(font_main_menu_bar);
        exit_menu.setFont(font_main_menu_bar);
        
        main_menu_bar.setBackground(Color.BLACK);
        
        profile_menu.setForeground(Color.gray);
        manage_menu.setForeground(Color.gray);
        attendance_menu.setForeground(Color.gray);
        leaves_menu.setForeground(Color.gray);
        salary_menu.setForeground(Color.gray);
        training_menu.setForeground(Color.gray);
        help_desk_menu.setForeground(Color.gray);
        delete_menu.setForeground(Color.gray);
        exit_menu.setForeground(Color.red);
        
        complete_profile_menu_under_profile.setBackground(Color.black);
        view_profile_menu_under_profile.setBackground(Color.black);
        update_details_menu_under_manage.setBackground(Color.black);
        take_attendance_menu_under_attendance.setBackground(Color.black);
        view_attendance_menu_under_attendance.setBackground(Color.black);
        apply_leaves_menu_under_leaves.setBackground(Color.black);
        view_leaves_menu_under_leaves.setBackground(Color.black);
        add_salary_menu_under_salary.setBackground(Color.black);
        generate_salary_slip_under_salary.setBackground(Color.black);
        update_completed_trainings_under_training_details.setBackground(Color.black);
        raise_your_concern_under_help_desk.setBackground(Color.black);
        logout_menu_under_exit.setBackground(Color.black);
        delete_employee_menu_under_delete.setBackground(Color.black);
        
        complete_profile_menu_under_profile.setForeground(Color.yellow);
        view_profile_menu_under_profile.setForeground(Color.yellow);
        update_details_menu_under_manage.setForeground(Color.yellow);
        take_attendance_menu_under_attendance.setForeground(Color.yellow);
        view_attendance_menu_under_attendance.setForeground(Color.yellow);
        apply_leaves_menu_under_leaves.setForeground(Color.yellow);
        view_leaves_menu_under_leaves.setForeground(Color.yellow);
        add_salary_menu_under_salary.setForeground(Color.yellow);
        generate_salary_slip_under_salary.setForeground(Color.yellow);
        update_completed_trainings_under_training_details.setForeground(Color.yellow);
        raise_your_concern_under_help_desk.setForeground(Color.yellow);
        logout_menu_under_exit.setForeground(Color.yellow);
        delete_employee_menu_under_delete.setForeground(Color.yellow);
        
        complete_profile_menu_under_profile.addActionListener(this);
        view_profile_menu_under_profile.addActionListener(this);
        update_details_menu_under_manage.addActionListener(this);
        take_attendance_menu_under_attendance.addActionListener(this);
        view_attendance_menu_under_attendance.addActionListener(this);
        apply_leaves_menu_under_leaves.addActionListener(this);
        view_leaves_menu_under_leaves.addActionListener(this);
        add_salary_menu_under_salary.addActionListener(this);
        generate_salary_slip_under_salary.addActionListener(this);
        update_completed_trainings_under_training_details.addActionListener(this);
        raise_your_concern_under_help_desk.addActionListener(this);
        logout_menu_under_exit.addActionListener(this);
        delete_employee_menu_under_delete.addActionListener(this);
        
        setJMenuBar(main_menu_bar);
        add(image_icon_label);
    }
    
    public void actionPerformed(ActionEvent e) {
        String comnd = e.getActionCommand();
        if (comnd.equals("Complete Profile")) {
            new Add_Employee();
        } else if (comnd.equals("View Profile")) {
            new View_Employee();
        } else if (comnd.equals("Update Details")) {
            new Update_Details_Data().setVisible(true);
        } else if (comnd.equals("Take Attendance")) {
            new Employee_Attendance().setVisible(true);
        } else if (comnd.equals("View Attendance")) {
            new View_Attendance().setVisible(true);
        } else if (comnd.equals("Apply Leaves")) {
            new Apply_Leaves().setVisible(true);
        } else if (comnd.equals("View Leaves")) {
            new View_Leaves().setVisible(true);
        } else if (comnd.equals("Add Salary")) {
            new Salary().setVisible(true);
        } else if (comnd.equals("Generate Salary Slip")) {
            new Generate_PaySlip().setVisible(true);
        } else if (comnd.equals("Training Details")) {
            new Training_Details().setVisible(true);
        } else if (comnd.endsWith("Help Desk")) {
            new Help_Desk().setVisible(true);
        } else if (comnd.equals("Delete Employee")) {
            new Delete_Employee().setVisible(true);
        } else if (comnd.equals("Logout")) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new HomePage().setVisible(true);
    }
}
