import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class StudentDao {
    public ArrayList<Student> studentRead() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        try {
            String data = "";
            File studentFile = new File("../student.txt");
            FileReader studentFR = new FileReader(studentFile);
            BufferedReader studentBR = new BufferedReader(studentFR);
            data = studentBR.readLine();
            while (!data.equals("end")) {
                String stuArray[] = data.split(",|，");
                Student student = new Student(stuArray[0], stuArray[1], stuArray[2]);
                studentList.add(student);
                data = studentBR.readLine();
            }
            studentBR.close();
            studentFR.close();
            data = "";
            File scoreFile = new File("../score.txt");
            FileReader scoreFR = new FileReader(scoreFile);
            BufferedReader scoreBR = new BufferedReader(scoreFR);
            data = scoreBR.readLine();
            while (!data.equals("end")) {
                String scoreArray[] = data.split(",|，");
                Score score = new Score(scoreArray[1], Double.parseDouble(scoreArray[2]));
                for (Student student : studentList) {
                    if (student.getId().equals(scoreArray[0])) {
                        student.addScore(score);
                    }
                }
                data = scoreBR.readLine();
            }
            scoreBR.close();
            scoreFR.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public ArrayList<Student> studentXlsRead() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        try {
            File xls = new File("src/excel.xls");
            Workbook workbook = Workbook.getWorkbook(xls);
            Sheet studentSheet = workbook.getSheet(0);
            int row = studentSheet.getRows();
            for (int i = 1; i < row; i++) {
                Cell cell0 = studentSheet.getCell(0, i);
                Cell cell1 = studentSheet.getCell(1, i);
                Cell cell2 = studentSheet.getCell(2, i);
                Student student = new Student(cell0.getContents(), cell1.getContents(), cell2.getContents());
                studentList.add(student);
            }
            Sheet scoreSheet = workbook.getSheet(1);
            row = scoreSheet.getRows();
            for (int i = 1; i < row; i++) {
                Cell cell0 = studentSheet.getCell(0, i);
                Cell cell1 = studentSheet.getCell(1, i);
                Cell cell2 = studentSheet.getCell(2, i);
                Score score = new Score(cell1.getContents(), Double.parseDouble(cell2.getContents()));
                for (Student student : studentList) {
                    if (student.getId().equals(cell0.getContents())) {
                        student.addScore(score);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
