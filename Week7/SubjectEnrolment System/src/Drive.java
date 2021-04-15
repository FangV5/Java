import java.util.Scanner;

public class Drive {

    private static Enrolment enrolment = null;

    public static int menu() {
        int choose;
        System.out.println("========WTU选课系统========");
        System.out.println("1.创建课程");
        System.out.println("2.选课");
        System.out.println("3.退选");
        System.out.println("4.打印名单");
        System.out.println("5.退出");
        System.out.print("请选择(1-5): ");
        Scanner scan = new Scanner(System.in);
        choose = scan.nextInt();
        return choose;
    }

    public static void createSubject() {
        Scanner scan = new Scanner(System.in);
        if (enrolment != null) {
            System.out.print("课程已经创建，是否重新创建(y/n):");
            String again = scan.next();
            if (again.equalsIgnoreCase("n")) {
                return;
            }
        }
        System.out.println("请输入课程ID：");
        Scanner scan2 = new Scanner(System.in);
        String id = scan2.nextLine();
        System.out.println("请输入课程名称：");
        Scanner scan3 = new Scanner(System.in);
        String name = scan3.nextLine();
        System.out.println("请输入最大选课人数：");
        Scanner scan4 = new Scanner(System.in);
        int max = scan4.nextInt();
        enrolment = new Enrolment(max, name, id);
        System.out.println("创建成功！");
        System.out.println(enrolment.subject.toString());
    }

    public static void subjectEnrolment() {
        if (enrolment == null) {
            System.out.println("请先创建课程！");
            return;
        }
        System.out.println("请输入学生ID：");
        Scanner scan2 = new Scanner(System.in);
        String id = scan2.nextLine();
        System.out.println("请输入学生姓名：");
        Scanner scan3 = new Scanner(System.in);
        String name = scan3.nextLine();
        Student stu = new Student(name, id);
        if (enrolment.add(stu)) {
            System.out.println("选课成功！");
        } else {
            System.out.println("课程已满员，选课失败！");
        }
        System.out.println(enrolment.toString());
    }

    public static void withdrawEnrolment() {
        if (enrolment == null) {
            System.out.println("请先创建课程！");
            return;
        }
        if (enrolment.size() == 0) {
            System.out.println("目前无人选课！");
            return;
        }
        System.out.println("请输入学生ID：");
        Scanner scan2 = new Scanner(System.in);
        String id = scan2.nextLine();
        int index = enrolment.indexOf(id);
        if (enrolment.remove(index)) {
            System.out.println("退选成功！");
        } else {
            System.out.println("未找到该学生！");
        }
        System.out.println(enrolment.toString());
    }

    public static void printEnrolment() {
        if (enrolment == null) {
            System.out.println("请先创建课程！");
            return;
        }
        System.out.println(enrolment.toString());
    }

    public static void main(String[] args) {
        int choose = menu();
        while (choose != 5) {
            switch (choose) {
            case 1:
                createSubject();
                break;
            case 2:
                subjectEnrolment();
                break;
            case 3:
                withdrawEnrolment();
                break;
            case 4:
                printEnrolment();
                break;
            default:
                System.out.println("输入有误请重试！");
                break;
            }
            choose = menu();
        }
    }
}
