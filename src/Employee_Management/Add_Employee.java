package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Add_Employee implements ActionListener {
    JLabel add_employee_background_image,new_employee_details_label,name_label,fname_label,age_label,dob_label,address_label,phone_label,email_label,education_label,job_post_label,aadhar_label,eeId_label,id13;
    JFrame add_employee_frame;
    JTextField t,name_text_field,fname_text_field,age_text_field,dob_text_field,address_text_field,phone_text_field,email_text_field,education_text_field,job_post_text_field,aadhar_text_field,eeId_text_field,t12,t13;
    JButton submit_button,cancel_button;
    
    Add_Employee() {
        add_employee_frame=new JFrame("Add Employee");
        add_employee_frame.setBackground(Color.white);
        add_employee_frame.setLayout(null);
         
        add_employee_background_image=new JLabel();
        add_employee_background_image.setBounds(0,0,900,600);
        add_employee_background_image.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icon/add_emp.jpg"));
        Image lock_img_icon=img.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(lock_img_icon);
        add_employee_background_image.setIcon(img1);
        
        new_employee_details_label=new JLabel("New Employee Details");
        new_employee_details_label.setBounds(280,30,500,50);
        new_employee_details_label.setFont(new Font("Airal",Font.BOLD,30));
        new_employee_details_label.setForeground(Color.black);
        add_employee_background_image.add(new_employee_details_label);
        add_employee_frame.add(add_employee_background_image);
        
        name_label=new JLabel("Name: ");
        name_label.setBounds(50,150,200,30);
        name_label.setFont(new Font("Arial",Font.BOLD,20));
        add_employee_background_image.add(name_label);
        
        name_text_field=new JTextField();
        name_text_field.setBounds(200,150,150,30);
        add_employee_background_image.add(name_text_field);
        
        fname_label=new JLabel("Father's Name: ");
        fname_label.setBounds(450,150,200,30);
        fname_label.setFont(new Font("Arial",Font.BOLD,20));
        add_employee_background_image.add(fname_label);
        
        fname_text_field=new JTextField();
        fname_text_field.setBounds(600,150,150,30);
        add_employee_background_image.add(fname_text_field);
        
        age_label=new JLabel("Age: ");
        age_label.setBounds(50,200,200,30);
        age_label.setFont(new Font("Arial",Font.BOLD,20));
        add_employee_background_image.add(age_label);
        
        age_text_field=new JTextField();
        age_text_field.setBounds(200,200,150,30);
        add_employee_background_image.add(age_text_field);
        
        dob_label=new JLabel("Date of Birth: ");
        dob_label.setBounds(450,200,200,30);
        dob_label.setFont(new Font("Arial",Font.BOLD,20));
        add_employee_background_image.add(dob_label);
        
        dob_text_field=new JTextField();
        dob_text_field.setBounds(600,200,150,30);
        add_employee_background_image.add(dob_text_field);  
        
        address_label=new JLabel("Address: ");
        address_label.setBounds(50,250,200,30);
        address_label.setFont(new Font("Arial",Font.BOLD,20));
        add_employee_background_image.add(address_label);
        
        address_text_field=new JTextField();
        address_text_field.setBounds(200,250,150,30);
        add_employee_background_image.add(address_text_field);  
        
        phone_label=new JLabel("Phone: ");
        phone_label.setBounds(450,250,200,30);
        phone_label.setFont(new Font("Arial",Font.BOLD,20));
        add_employee_background_image.add(phone_label);
        
        phone_text_field=new JTextField();
        phone_text_field.setBounds(600,250,150,30);
        add_employee_background_image.add(phone_text_field);  
        
        email_label=new JLabel("Email Id: ");
        email_label.setBounds(50,300,200,30);
        email_label.setFont(new Font("Arial",Font.BOLD,20));
        add_employee_background_image.add(email_label);
        
        email_text_field=new JTextField();
        email_text_field.setBounds(200,300,150,30);
        add_employee_background_image.add(email_text_field);  
        
        education_label=new JLabel("Education: ");
        education_label.setBounds(450,300,200,30);
        education_label.setFont(new Font("Arial",Font.BOLD,20));
        add_employee_background_image.add(education_label);
        
        education_text_field=new JTextField();
        education_text_field.setBounds(600,300,150,30);
        add_employee_background_image.add(education_text_field);
        
        job_post_label=new JLabel("Job Post: ");
        job_post_label.setBounds(50,350,200,30);
        job_post_label.setFont(new Font("Arial",Font.BOLD,20));
        add_employee_background_image.add(job_post_label);
        
        job_post_text_field=new JTextField();
        job_post_text_field.setBounds(200,350,150,30);
        add_employee_background_image.add(job_post_text_field);  
        
        aadhar_label=new JLabel("Aadhar No: ");
        aadhar_label.setBounds(450,350,200,30);
        aadhar_label.setFont(new Font("Arial",Font.BOLD,20));
        add_employee_background_image.add(aadhar_label);
        
        aadhar_text_field=new JTextField();
        aadhar_text_field.setBounds(600,350,150,30);
        add_employee_background_image.add(aadhar_text_field);  
        
        eeId_label=new JLabel("Employee Id: ");
        eeId_label.setBounds(50,400,200,30);
        eeId_label.setFont(new Font("Arial",Font.BOLD,20));
        add_employee_background_image.add(eeId_label);
        
        eeId_text_field=new JTextField();
        eeId_text_field.setBounds(200,400,150,30);
        add_employee_background_image.add(eeId_text_field);  
        
        submit_button=new JButton("Submit");
        submit_button.setBackground(Color.black);
        submit_button.setForeground(Color.white);
        submit_button.setBounds(250,500,150,40);
        
        add_employee_background_image.add(submit_button);
        
        cancel_button=new JButton("Cancel");
        cancel_button.setBackground(Color.red);
        cancel_button.setForeground(Color.white);
        cancel_button.setBounds(450,500,150,40);
        
        add_employee_background_image.add(cancel_button);
        
        submit_button.addActionListener(this);
        cancel_button.addActionListener(this);
        
        add_employee_frame.setVisible(true);
        add_employee_frame.setSize(900,600);
        add_employee_frame.setLocation(300,100);
    }
    public void actionPerformed(ActionEvent e) {
        String name=name_text_field.getText();
        String fname=fname_text_field.getText();
        String age=age_text_field.getText();
        String dob=dob_text_field.getText();
        String address=address_text_field.getText();
        String phone=phone_text_field.getText();
        String email=email_text_field.getText();
        String education=education_text_field.getText();
        String job_post=job_post_text_field.getText();
        String aadhar=aadhar_text_field.getText();
        String eeid=eeId_text_field.getText();
        
        if(e.getSource()==submit_button) {
            try {
                ConnectionClass obj=new ConnectionClass();
                String query="insert into employee value('"+name+"','"+fname+"','"+age+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+job_post+"','"+aadhar+"','"+eeid+"')";
                System.out.print("Printing query"+query);
                obj.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                add_employee_frame.setVisible(false);
                new HomePage();
            }
            catch(Exception ex) {
                System.out.print("The error is: "+ex);
            }
        }
        if(e.getSource()==cancel_button) {
            add_employee_frame.setVisible(false);
            new HomePage();
        }
    }
    public static void main(String[] args){
        new Add_Employee();
    }
}
