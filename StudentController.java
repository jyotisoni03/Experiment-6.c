import java.sql.*;
import java.util.*;

public class StudentController {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "your_password");
        StudentDAO dao = new StudentDAO(con);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student\n2. View Students\n3. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    dao.addStudent(new Student(0, name, age));
                    System.out.println("Student added!");
                    break;
                case 2:
                    List<Student> list = dao.getAllStudents();
                    for (Student s : list)
                        System.out.println(s.getId() + " | " + s.getName() + " | " + s.getAge());
                    break;
                case 3:
                    con.close();
                    System.exit(0);
            }
        }
    }
}
