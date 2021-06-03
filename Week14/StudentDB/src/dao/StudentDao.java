package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import tool.DbConnetion;
import vo.Student;

public class StudentDao {

    // ����ѧ�ţ�����ѧ������
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

    // ��ָ���ֶν��в�ѯ�����ؽ�������ܶ���������ڼ�����
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

    // �Ӽ�������������ѧ����Ϣ�����뼯����
    public ArrayList<Student> readStudentFromKeyBoard() {
        ArrayList<Student> stuList = new ArrayList<>();
        System.out.println("������ѧ��ѧ�ţ����������գ��Ա𣬳ɼ������ŷָ���end������");
        Scanner scan = new Scanner(System.in);
        String aLine = "";
        while (!(aLine = scan.nextLine()).equals("end")) {
            String arr[] = aLine.split(",|��");
            if (get(arr[0]) == null) {
                Student student = new Student(arr[0], arr[1], arr[2], arr[3], Float.parseFloat(arr[4]));
                stuList.add(student);
            } else {
                System.out.println("ѧ��" + arr[0] + "�Ѵ���");
            }
        }
        scan.close();
        return stuList;
    }

    // ��ѧ������������ݿ�,���سɹ�����
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
