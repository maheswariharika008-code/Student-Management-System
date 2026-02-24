import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentManagementSystem extends JFrame {

    public StudentManagementSystem() {

        setTitle("Student Management System");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1,10,10));

        JButton addBtn = new JButton("Add Student");
        JButton viewBtn = new JButton("View Students");
        JButton updateBtn = new JButton("Update Student");
        JButton deleteBtn = new JButton("Delete Student");

        add(addBtn);
        add(viewBtn);
        add(updateBtn);
        add(deleteBtn);

        addBtn.addActionListener(e -> new AddWindow());
        viewBtn.addActionListener(e -> new ViewWindow());
        updateBtn.addActionListener(e -> new UpdateWindow());
        deleteBtn.addActionListener(e -> new DeleteWindow());

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentManagementSystem();
    }
}
class AddWindow extends JFrame {

    public AddWindow() {

        setTitle("Add Student");
        setSize(400,400);
        setLayout(new GridLayout(8,2));

        JTextField id = new JTextField();
        JTextField name = new JTextField();
        JTextField gender = new JTextField();
        JTextField dob = new JTextField();
        JTextField phone = new JTextField();
        JTextField address = new JTextField();
        JTextField classId = new JTextField();

        JButton addBtn = new JButton("Add");

        add(new JLabel("ID")); add(id);
        add(new JLabel("Name")); add(name);
        add(new JLabel("Gender")); add(gender);
        add(new JLabel("DOB")); add(dob);
        add(new JLabel("Phone")); add(phone);
        add(new JLabel("Address")); add(address);
        add(new JLabel("Class ID")); add(classId);
        add(addBtn);

        addBtn.addActionListener(e -> {

            java.util.List<Student> list = StudentFileHandler.readStudents();

            list.add(new Student(
                    Integer.parseInt(id.getText()),
                    name.getText(),
                    gender.getText(),
                    dob.getText(),
                    phone.getText(),
                    address.getText(),
                    Integer.parseInt(classId.getText())
            ));

            StudentFileHandler.writeStudents(list);

            JOptionPane.showMessageDialog(this,"Student Added Successfully");
        });

        setVisible(true);
    }
}


class ViewWindow extends JFrame {

    public ViewWindow() {

        setTitle("View Students");
        setSize(700,400);

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(
                new String[]{"ID","Name","Gender","DOB","Phone","Address","Class ID"}
        );

        JTable table = new JTable(model);

        java.util.List<Student> list = StudentFileHandler.readStudents();

        for(Student s : list) {
            model.addRow(new Object[]{
                    s.getStudentId(),
                    s.getStudentName(),
                    s.getGender(),
                    s.getDob(),
                    s.getPhone(),
                    s.getAddress(),
                    s.getClassId()
            });
        }

        add(new JScrollPane(table));
        setVisible(true);
    }
}
class UpdateWindow extends JFrame {

    public UpdateWindow() {

        setTitle("Update Student");
        setSize(400,300);
        setLayout(new GridLayout(4,2));

        JTextField id = new JTextField();
        JTextField name = new JTextField();
        JButton updateBtn = new JButton("Update");

        add(new JLabel("Student ID")); add(id);
        add(new JLabel("New Name")); add(name);
        add(updateBtn);

        updateBtn.addActionListener(e -> {

            java.util.List<Student> list = StudentFileHandler.readStudents();
            int sid = Integer.parseInt(id.getText());

            for(Student s : list) {
                if(s.getStudentId() == sid) {
                    s.setStudentName(name.getText());
                }
            }

            StudentFileHandler.writeStudents(list);

            JOptionPane.showMessageDialog(this,"Student Updated Successfully");
        });

        setVisible(true);
    }
}
class DeleteWindow extends JFrame {

    public DeleteWindow() {

        setTitle("Delete Student");
        setSize(300,200);
        setLayout(new GridLayout(2,2));

        JTextField id = new JTextField();
        JButton deleteBtn = new JButton("Delete");

        add(new JLabel("Student ID")); add(id);
        add(deleteBtn);

        deleteBtn.addActionListener(e -> {

            java.util.List<Student> list = StudentFileHandler.readStudents();
            int sid = Integer.parseInt(id.getText());

            list.removeIf(s -> s.getStudentId() == sid);

            StudentFileHandler.writeStudents(list);

            JOptionPane.showMessageDialog(this,"Student Deleted Successfully");
        });

        setVisible(true);
    }
}
