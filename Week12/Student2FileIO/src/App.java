import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        StudentDao dao = new StudentDao();
        ArrayList<Student> students = dao.studentXlsRead();
        ArrayList<Result> results = dao.statis(students);
        dao.display(students, results);
    }
}
