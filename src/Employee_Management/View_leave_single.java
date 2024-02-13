package Employee_Management;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class View_leave_single extends JFrame {

    JTable employee_leaves_table;
    String x[] = {"Employee Id", "Name", "Email", "Start Date", "End Date", "Reason", "Apply Date"};
    String y[][] = new String[20][7];
    int i = 0, j = 0;
    Font text_font;
    int count = 0;

    View_leave_single(String eid) {
        super("Particular Employee Leave Record");
        text_font = new Font("MS UI Gothic", Font.BOLD, 17);

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from apply_leave where eid='" + eid + "'";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                y[i][j++] = rest.getString("eid");
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("start_date");
                y[i][j++] = rest.getString("end_date");
                y[i][j++] = rest.getString("reason");
                y[i][j++] = rest.getString("apply_date");
                i++;
                j = 0;
                count++;
            }
            if (count == 0) {
                JOptionPane.showMessageDialog(null, "No records found.");

            } else {
                employee_leaves_table = new JTable(y, x);
                JScrollPane table_scrollbar = new JScrollPane();
                employee_leaves_table.setBackground(Color.BLACK);
                employee_leaves_table.setForeground(Color.WHITE);
                employee_leaves_table.setFont(text_font);
                setSize(1480, 400);
                setLocation(0, 10);
                add(table_scrollbar);
                add(employee_leaves_table);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
