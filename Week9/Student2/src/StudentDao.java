import java.util.ArrayList;
import java.util.Scanner;

public class StudentDao {
    public ArrayList<Student> studentRead() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        Scanner scan = new Scanner(System.in);
        String data = "";
        data = scan.nextLine();
        while (!data.equals("end")) {
            String stuArray[] = data.split(",|，");
            Student student = new Student(stuArray[0], stuArray[1], stuArray[2]);
            studentList.add(student);
            data = scan.nextLine();
        }
        data = "";
        data = scan.nextLine();
        while (!data.equals("end")) {
            String scoreArray[] = data.split(",|，");
            Score score = new Score(scoreArray[1], Double.parseDouble(scoreArray[2]));
            for (Student student : studentList) {
                if (student.getId().equals(scoreArray[0])) {
                    student.addScore(score);
                }
            }
            data = scan.nextLine();
        }
        return studentList;
    }

    public ArrayList<Result> statis(ArrayList<Student> studentList) {
        ArrayList<Result> resultList = new ArrayList<Result>();
        for (Student student : studentList) {
            for (Score score : student.getScoreList()) {
                int index = query(resultList, score.getSubject());
                if (index != -1) {
                    Result oldResult = resultList.get(index);
                    oldResult.setSumScore(oldResult.getSumScore() + score.getScore());
                    oldResult.setCount(oldResult.getCount() + 1);
                } else {
                    Result result = new Result(score.getSubject(), score.getScore(), 1);
                    resultList.add(result);
                }
            }
        }
        return resultList;
    }

    private int query(ArrayList<Result> resultList, String subject) {
        int ret = -1;
        for (int i = 0; i < resultList.size(); i++) {
            Result result = resultList.get(i);
            if (result.getSubject().equals(subject)) {
                ret = i;
                break;
            }
        }
        return ret;
    }

    public void display(ArrayList<Student> studentList, ArrayList<Result> resultList) {
        System.out.println("按学生统计：");
        System.out.println("学号    姓名    性别    平均分");
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
        System.out.println("按课程统计：");
        System.out.println("课程    平均分");
        for (Result result : resultList) {
            System.out.println(result.toString());
        }
    }
}
