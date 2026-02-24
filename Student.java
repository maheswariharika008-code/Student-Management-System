import java.io.Serializable;

public class Student implements Serializable {
    private int studentId;
    private String studentName;
    private String gender;
    private String dob;
    private String phone;
    private String address;
    private int classId;

    public Student(int studentId, String studentName, String gender,
                   String dob, String phone, String address, int classId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.classId = classId;
    }

    public int getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public String getGender() { return gender; }
    public String getDob() { return dob; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public int getClassId() { return classId; }

    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setGender(String gender) { this.gender = gender; }
    public void setDob(String dob) { this.dob = dob; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    public void setClassId(int classId) { this.classId = classId; }
}
