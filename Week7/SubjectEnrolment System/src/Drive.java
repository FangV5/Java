import java.util.Scanner;

public class Drive {

    private static Enrolment enrolment = null;

    public static int menu() {
        int choose;
        System.out.println("========WTUѡ��ϵͳ========");
        System.out.println("1.�����γ�");
        System.out.println("2.ѡ��");
        System.out.println("3.��ѡ");
        System.out.println("4.��ӡ����");
        System.out.println("5.�˳�");
        System.out.print("��ѡ��(1-5): ");
        Scanner scan = new Scanner(System.in);
        choose = scan.nextInt();
        return choose;
    }

    public static void createSubject() {
        Scanner scan = new Scanner(System.in);
        if (enrolment != null) {
            System.out.print("�γ��Ѿ��������Ƿ����´���(y/n):");
            String again = scan.next();
            if (again.equalsIgnoreCase("n")) {
                return;
            }
        }
        System.out.println("������γ�ID��");
        Scanner scan2 = new Scanner(System.in);
        String id = scan2.nextLine();
        System.out.println("������γ����ƣ�");
        Scanner scan3 = new Scanner(System.in);
        String name = scan3.nextLine();
        System.out.println("���������ѡ��������");
        Scanner scan4 = new Scanner(System.in);
        int max = scan4.nextInt();
        enrolment = new Enrolment(max, name, id);
        System.out.println("�����ɹ���");
        System.out.println(enrolment.subject.toString());
    }

    public static void subjectEnrolment() {
        if (enrolment == null) {
            System.out.println("���ȴ����γ̣�");
            return;
        }
        System.out.println("������ѧ��ID��");
        Scanner scan2 = new Scanner(System.in);
        String id = scan2.nextLine();
        System.out.println("������ѧ��������");
        Scanner scan3 = new Scanner(System.in);
        String name = scan3.nextLine();
        Student stu = new Student(name, id);
        if (enrolment.add(stu)) {
            System.out.println("ѡ�γɹ���");
        } else {
            System.out.println("�γ�����Ա��ѡ��ʧ�ܣ�");
        }
        System.out.println(enrolment.toString());
    }

    public static void withdrawEnrolment() {
        if (enrolment == null) {
            System.out.println("���ȴ����γ̣�");
            return;
        }
        if (enrolment.size() == 0) {
            System.out.println("Ŀǰ����ѡ�Σ�");
            return;
        }
        System.out.println("������ѧ��ID��");
        Scanner scan2 = new Scanner(System.in);
        String id = scan2.nextLine();
        int index = enrolment.indexOf(id);
        if (enrolment.remove(index)) {
            System.out.println("��ѡ�ɹ���");
        } else {
            System.out.println("δ�ҵ���ѧ����");
        }
        System.out.println(enrolment.toString());
    }

    public static void printEnrolment() {
        if (enrolment == null) {
            System.out.println("���ȴ����γ̣�");
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
                System.out.println("�������������ԣ�");
                break;
            }
            choose = menu();
        }
    }
}
