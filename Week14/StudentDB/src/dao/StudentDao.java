package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import tool.DbConnetion;
import vo.Student;

public class StudentDao {

    // 输入学号，返回学生对象
    public Student get(String id) {
        Student stu = null;
        DbConnetion db = new DbConnetion();
        Connection con = db.getCon();
        String sql = "select * from t_student where id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                stu = new Student(rs.getString("id"), rs.getString("name"), rs.getString("birth"),
                        rs.getString("gender"), rs.getFloat("score"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stu;
    }

    // 按指定字段进行查询，返回结果，可能多条，存放在集合中
    public ArrayList<Student> query(String fieldName, String value) {
        ArrayList<Student> stuList = new ArrayList<>();
        DbConnetion db = new DbConnetion();
        Connection con = db.getCon();
        String sql = "select * from t_student where " + fieldName + "= ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Student stu = new Student(rs.getString("id"), rs.getString("name"), rs.getString("birth"),
                        rs.getString("gender"), rs.getFloat("score"));
                stuList.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stuList;
    }

    // 从键盘中输入若干学生信息，存入集合中
    public ArrayList<Student> readStudentFromKeyBoard() {
        ArrayList<Student> stuList = new ArrayList<>();
        System.out.println("请输入学生学号，姓名，生日，性别，成绩（逗号分隔，end结束）");
        Scanner scan = new Scanner(System.in);
        String aLine = "";
        while (!(aLine = scan.nextLine()).equals("end")) {
            String arr[] = aLine.split(",|，");
            if (get(arr[0]) == null) {
                Student student = new Student(arr[0], arr[1], arr[2], arr[3], Float.parseFloat(arr[4]));
                stuList.add(student);
            } else {
                System.out.println("学号" + arr[0] + "已存在");
            }
        }
        scan.close();
        return stuList;
    }

    // 将学生对象插入数据库,返回成功条数
    public int insert(ArrayList<Student> stuList) {
        int iRet = 0;
        DbConnetion db = new DbConnetion();
        Connection con = db.getCon();
        String sql = "insert into t_student(id,name,gender,birth,score) value(?,?,?,?,?)";
        for (Student student : stuList) {
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, student.getId());
                pst.setString(2, student.getName());
                pst.setString(3, student.getGender());
                pst.setString(4, student.getBirth());
                pst.setFloat(5, student.getScore());
                iRet += pst.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return iRet;
    }

    //
    public int delete() {
        int iRet = 0;
        return iRet;
    }
}
