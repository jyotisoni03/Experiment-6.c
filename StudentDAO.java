import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection con;

    public StudentDAO(Connection con) {
        this.con = con;
    }

    public void addStudent(Student s) throws SQLException {
        String query = "INSERT INTO student(name, age) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, s.getName());
        ps.setInt(2, s.getAge());
        ps.executeUpdate();
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");
        while (rs.next()) {
            list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age")));
        }
        return list;
    }
}
