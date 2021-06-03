import vo.Student;

import java.util.ArrayList;
import dao.StudentDao;

public class App {
    public static void main(String[] args) throws Exception {
        StudentDao dao = new StudentDao();
        Student s1 = dao.get("1001");
        if (s1 == null) {
            System.out.println("not found");
        } else {
            System.out.println(s1.toString());
        }
        ArrayList<Student> stuList = dao.query("gender", "ÄÐ");
        if (stuList.size() == 0) {
            System.out.println("not found");
        } else {
            for (Student student : stuList) {
                System.out.println(student.toString());
            }
        }
    }
}
