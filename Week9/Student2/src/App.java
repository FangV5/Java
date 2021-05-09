import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(
                "请输入学生基本信息（每个学生一行，输入格式为“学号，姓名，性别”，如“001，张三，男”，当输入“end”时结束输入）及学生成绩：（每个成绩一行，输入格式为“学号，课程名称，成绩”，如“001，Java，90”，当输入“end”时结束输入）");
        StudentDao dao = new StudentDao();
        ArrayList<Student> students = dao.studentRead();
        ArrayList<Result> results = dao.statis(students);
        dao.display(students, results);
    }
}
