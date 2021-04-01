import java.util.Scanner;

public class ClassListDriver {

	private static ClassList list = null;

	public static void main(String[] args) {
		int choose = menu();
		while (choose != 3) {
			switch (choose) {
			case 1:
				createList();
				break;
			case 2:
				printList();
				break;
			default:
				System.out.println("无效的选择！");
			}
			choose = menu();
		}
		System.out.println("欢迎下次使用！");
	}

	public static int menu() {
		int choose = 0;
		System.out.println("========课程管理系统========");
		System.out.println("1.Create List");
		System.out.println("2.Print List");
		System.out.println("3.Exit");
		System.out.print("please choose(1-2):");
		Scanner scan = new Scanner(System.in);
		choose = scan.nextInt();

		return choose;
	}

	public static void createList() {
		Scanner scan = new Scanner(System.in);
		if (list != null) {
			System.out.print("课程已经创建，是否重新创建(y/n):");
			String again = scan.next();
			if (again.equalsIgnoreCase("n")) {
				return;
			}
		}

		System.out.print("请输入学年:");
		int year = scan.nextInt();
		System.out.print("请输入学期(1,2):");
		int semester = scan.nextInt();

		System.out.print("请输入课程代码:");
		String subId = scan.next();
		System.out.print("请输入课程名称:");
		String subName = scan.next();
		Subject subj = new Subject(subId, subName);

		System.out.print("请输入学生1学号:");
		String s1Id = scan.next();
		System.out.print("请输入学生1姓名:");
		String s1Name = scan.next();
		System.out.print("请输入学生2学号:");
		String s2Id = scan.next();
		System.out.print("请输入学生2姓名:");
		String s2Name = scan.next();
		Student s1 = new Student(s1Name, s1Id);
		Student s2 = new Student(s2Name, s2Id);

		list = new ClassList(year, semester, subj, s1, s2);

	}

	public static void printList() {

		if (list == null) {
			System.out.println("请先执行第一步！");
			return;
		}

		System.out.println(list.toString());
	}

}
